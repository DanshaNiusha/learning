package jdk.guava;

import com.google.common.base.*;
import com.google.common.collect.*;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author liuxiaokang
 * @date 2021/4/9
 */
public class GuavaTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = Lists.newArrayList(1, 2, 3, 4);
        
        StringBuilder sb = new StringBuilder("脑袋");
        ImmutableMap<String, String> map = ImmutableMap.of("a", "liuxiaokang", "n", "sndia");
        Joiner.on(";").appendTo(sb, list);
        sb.append("尾巴");
        System.out.println(sb);
        
        // Preconditions.checkArgument(1==2,"dsadsa");
        // Preconditions.checkState(1==2,"dsa%sdasc%s","打","打1");
        // Preconditions.checkNotNull(null,"dsadas");
        
        Splitter splitter = Splitter.on(';').omitEmptyStrings().trimResults();
        System.out.println(splitter.splitToList(sb));
    
        Collection<Object> transform = Collections2.transform(list, new Function<Integer, Object>() {
            @Override
            public @Nullable Object apply(@Nullable Integer input) {
                return input + 1;
            }
        });
        System.out.println(transform);
    
    
        /**
         * 一种key 多个value 相同的value会去重 代替Map<Integer,Set<Integer>>
         */
        Multimap<Integer, Integer> multimap = HashMultimap.create();
        multimap.put(1, 2);
        multimap.put(1, 2);
        multimap.put(1, 3);
        multimap.put(2, 3);
        multimap.put(3, 3);
        multimap.put(4, 3);
        System.out.println(multimap);
        //判断集合中是否存在key-value为指定值得元素
        System.out.println(multimap.containsEntry(1, 2));
        //获取key为1的value集合
        Collection<Integer> list1 = multimap.get(1);
        System.out.println(list1);
        //返回集合中所有key的集合，重复的key将会用key * num的方式来表示
        Multiset<Integer> set = multimap.keys();
        System.out.println(set);
        // 返回集合中所有不重复的key的集合
        System.out.println(multimap.keySet());
    
    
    }
    
}
