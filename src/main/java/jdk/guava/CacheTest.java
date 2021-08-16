package jdk.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import javax.validation.constraints.NotNull;
import java.util.concurrent.TimeUnit;

/**
 * @author liuxiaokang
 * @date 2021/8/16
 */
public class CacheTest {
    
    private final LoadingCache<String, Integer> cache =
            CacheBuilder.newBuilder()
                    .maximumSize(1)
                    .expireAfterWrite(5, TimeUnit.SECONDS)
                    .build(new CacheLoader<String, Integer>() {
                        @Override
                        public Integer load(@NotNull String name) {
                            System.out.println("reload");
                            return name.length();
                        }
                    });
    
    @Test
    public void test01() throws Exception{
        while (true) {
            String key = "dan";
            Thread.sleep(1000);
            Integer danAge = cache.get(key);
            Integer danAge1 = cache.get("xxx");
            System.out.println(danAge);
            System.out.println(danAge1);
        }
        
        //reload
        // 3
        // 3
        // 3
        // 3
        // 3
        // reload
    }
}
