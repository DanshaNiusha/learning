package algorithms.sort;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import model.Peiord;
import org.apache.commons.collections.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @author liuxiaokang
 * @date 2022/3/3
 */
public class MergePeiord {
    public static void main(String[] args) {
        Peiord temp1 = new Peiord(20220101, 20220105,2);
        Peiord temp2 = new Peiord(20220101, 20220102,1);
        Peiord temp3 = new Peiord(20220105, 20220106,3);
        Peiord temp4 = new Peiord(20220106, 20220110,4);
        List<Peiord> peiords = Lists.newArrayList(temp1, temp2,temp3,temp4);
        List<Peiord> merge = mergePeriods(peiords, Peiord.class);
        System.out.println(JSON.toJSONString(peiords));
        System.out.println(JSON.toJSONString(merge));
    }
    
    
    public static <T extends MergeDateAbility> List<T> mergePeriods(List<T> periods, Class<T> clazz) {
        List<T> result = Lists.newArrayList();
        if (CollectionUtils.isEmpty(periods))
            return result;
        
        // 按开始日期降序
        periods.sort(Comparator.comparing(MergeDateAbility::getLower));
        
        // 临时指针存储构merge后的元素
        T prev = periods.get(0);
        for (T curr : periods) {
            // 前元素end+1天 >= 后元素的start +1要替换为plusdayxx
            if (prev.getUpper()+ 1 >= curr.getLower()) {
                // 临时指针元素end设为 前后元素中较大的end
                T cloned = JSON.parseObject(JSON.toJSONString(prev, SerializerFeature.DisableCircularReferenceDetect), clazz);
                cloned.setLower(prev.getLower());
                cloned.setUpper(Math.max(prev.getUpper(), curr.getUpper()));
                prev = cloned;
            } else {
                // 没有交集
                result.add(prev);
                prev = curr;
            }
        }
        // 合并后的区间
        result.add(prev);
        return result;
    }
    
    public static interface MergeDateAbility {
        /**
         * 获取开始时间
         */
        Integer getLower();
        
        /**
         * 获取结束时间
         */
        Integer getUpper();
        
        /**
         * 设置开始时间
         */
        void setLower(Integer lower);
        
        /**
         * 设置结束时间
         */
        void setUpper(Integer upper);
    }
    
}
