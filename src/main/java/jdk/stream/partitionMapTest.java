package jdk.stream;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * map切分 返回不可更改的list
 * @author liuxiaokang
 * @date 2021/8/2
 */
public class partitionMapTest {
    // Driver code
    public static void main(String[] args)
    {
        HashMap<Object, Object> map = Maps.newHashMap();
        map.put(1,1);
        map.put(2,1);
        map.put(3,1);
        map.put(4,1);
        map.put(5,1);
        List<Map<Object, Object>> split = split(map, 2);
        System.out.println(JSON.toJSONString(split));
    
    }
    
    public static <K, V> List<Map<K, V>> split(Map<K, V> map, int size) {
        List<List<Map.Entry<K, V>>> list = Lists.newArrayList(Iterables.partition(map.entrySet(), size));
        return list.stream().map(entries -> entries.stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)))
                .collect(Collectors.toList());
    }
}
