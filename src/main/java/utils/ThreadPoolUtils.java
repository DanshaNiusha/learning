package utils;


import java.util.concurrent.*;

public class ThreadPoolUtils {
    
    private ThreadPoolUtils() {
        throw new IllegalAccessError("Utility class");
    }
    
    private static final ExecutorService commonPool = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1),
                    new ThreadPoolExecutor.CallerRunsPolicy());
    
    private static final ExecutorService syncPool = new ThreadPoolExecutor(1, 2, 10, TimeUnit.SECONDS, new SynchronousQueue<>(),
                    // new ThreadPoolExecutor.AbortPolicy());
                    new ThreadPoolExecutor.CallerRunsPolicy());
    
    /**
     * 核心流程使用线程池。其他业务禁用
     *
     * @param callable 任务.
     */
    public static <T> Future<T> submit(Callable<T> callable) {
        return commonPool.submit(callable);
    }
    
    public static void excute(Runnable runnable) {
        commonPool.execute(runnable);
    }
    
    public static void excute(Runnable runnable, ExecutorService pool) {
        commonPool.execute(runnable);
    }
    
    public static ExecutorService getCommonPool() {
        return commonPool;
    }
    
    public static ExecutorService getSyncPool() {
        return syncPool;
    }
}
