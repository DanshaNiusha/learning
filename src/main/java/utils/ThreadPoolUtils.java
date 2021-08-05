package utils;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolUtils {
    
    private ThreadPoolUtils() {
        throw new IllegalAccessError("Utility class");
    }
    
    /**
     * 核心业务
     */
    private static final ExecutorService threadCorePool = new ThreadPoolExecutor(2, 10, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100),
                    new ThreadPoolExecutor.CallerRunsPolicy());
    
    /**
     * 核心流程使用线程池。其他业务禁用
     *
     * @param callable 任务.
     */
    public static <T> Future<T> submit(Callable<T> callable) {
        return threadCorePool.submit(callable);
    }
    
    /**
     * 公用线程池。可用于消息发送等次要服务
     *
     * @param runnable 线程
     */
    public static void excute(Runnable runnable) {
        threadCorePool.execute(runnable);
    }
    
    public static void main(String[] args) {
    
    
       
    }
}
