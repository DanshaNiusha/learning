package jdk.guava;

import com.google.common.base.*;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.MoreCollectors;
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
    
        
        
    }
    
    enum PlatformVisitSourceEnum {
        
        //来源定义与网关的映射关系
        MTA("MTA1", "1", 100),
        
        APP("APP2", "2", 300),
        
        APP_IOS("APP_IOS3", "3", 301);
        
        private String id;
        private String name;
        private Integer tenantId;
        
        PlatformVisitSourceEnum(String id, String name, Integer tenantId) {
            this.name = name;
            this.id = id;
            this.tenantId = tenantId;
        }
        
    }
}
