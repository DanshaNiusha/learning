package utils;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.MapUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuxiaokang
 * @date 2021/7/23
 */
public class CommonUtils {
    
    /**
     * map分批
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
    
    public static void main(String[] args) {
        HashMap<Integer, String> map = Maps.newHashMap();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");
        map.put(4,"d");
        map.put(5,"e");
        List<Map<Integer, String>> maps = CommonUtils.partitionMap(map, 2);
        System.out.println(JSON.toJSONString(maps));
    
    
    }
}
