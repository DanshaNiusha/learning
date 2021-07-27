package jdk.guava;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * @author liuxiaokang
 * @date 2021/7/27
 */
public class LimiterTest {
    
    static final RateLimiter rateLimiter = RateLimiter.create(2);
    
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            rateLimiter.acquire();
            System.out.println("exceut:"+i);
        }
    }
}
