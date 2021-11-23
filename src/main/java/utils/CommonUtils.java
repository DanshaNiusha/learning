package utils;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;
import model.Model1;
import model.Model2;
import model.Model3;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuxiaokang
 * @date 2021/7/23
 */
public class CommonUtils {
    
    /**
     * map分批s
     * @param size 每批次大小
     * @author liuxiaokang
     * @date 2021/7/23
     */
    public static <k, v> List<Map<k, v>> partitionMap(Map<k, v> map, int size) {
        if (MapUtils.isEmpty(map) || map.size() <= size) {
            return Lists.newArrayList(map);
        }
        List<Map<k, v>> list = Lists.newArrayList();
        Map<k, v> perMap = Maps.newHashMapWithExpectedSize(size);
    
        for (Map.Entry<k, v> entry : map.entrySet()) {
            perMap.put(entry.getKey(), entry.getValue());
            if (perMap.size() == size) {
                list.add(perMap);
                perMap = Maps.newHashMapWithExpectedSize(size);
            }
        }
        // 剩余部分
        if(MapUtils.isNotEmpty(perMap)){
            list.add(perMap);
        }
        return list;
    }
    
    /**
     * 深拷贝Json方式实现
     */
    public static <T> T deepClone(T origin, Class<T> clazz) {
        return JSON.parseObject(JSON.toJSONString(origin), clazz);
    }
    
    
    
    /**
     * 判断接待时间段是否有交集
     * @return true: 有交集  false: 无交集
     */
    private static boolean judgeIntersect() throws ParseException {
        List<Range<Date>> ranges = Lists.newArrayList();
        Date startDate = DateUtils.parseDate("10:00", "HH:mm");
        Date endDate = DateUtils.parseDate("12:01", "HH:mm");
        ranges.add(Range.closed(startDate, endDate));
        Date startDate1 = DateUtils.parseDate("12:00", "HH:mm");
        Date endDate1 = DateUtils.parseDate("15:00", "HH:mm");
        ranges.add(Range.closed(startDate1, endDate1));
        return judgeDateIntersect(ranges);
    }
    
    
    /**
     * 日期段是否有重叠 例如闭区间[10:00,13:00]与[11:00,15:00]为重叠
     * @param ranges 日期范围集合
     * @return 是否有交集
     */
    public static boolean judgeDateIntersect(List<Range<Date>> ranges) {
        RangeSet<Date> rangeSet = TreeRangeSet.create();
        for (Range<Date> range : ranges) {
            if (rangeSet.intersects(range)) {
                // 有交集
                return true;
            }
            rangeSet.add(range);
        }
        // 无交集
        return false;
        
    }
    
    
    public static void main(String[] args) throws Exception {
        /////////////////////test clone////////////////////
        // Model3 model3 = new Model3(1L, "dansha");
        // Model2 model2 = new Model2(1L, model3);
        // Model1 model1 = new Model1(1L, model2);
        // List<Model1> list = Lists.newArrayList();
        // list.add(model1);
        // // mapstruct的深拷贝只能拷一层 不要用
        // // list.add(ModelMapStruct.INSTANCE.convert2Model1(model1));
        // list.add(deepClone(model1, Model1.class));
        // System.out.println("before: "+list);
        // model3.setName("niusha");
        // System.out.println("after: "+list);
        
        
        //////////////////////test map /////////////////
        // HashMap<Integer, String> map = Maps.newHashMap();
        // map.put(1,"a");
        // map.put(2,"b");
        // map.put(3,"c");
        // map.put(4,"d");
        // map.put(5,"e");
        // List<Map<Integer, String>> maps = CommonUtils.partitionMap(map, 2);
        // System.out.println(JSON.toJSONString(maps));
        System.out.println(judgeIntersect());
    }
}
