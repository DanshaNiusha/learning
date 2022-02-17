package juc.thread.concurrency;

import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 计算1亿个整数的和
 *
 * @author liuxiaokang
 * @date 2021/1/15
 */
public class ForkJoinPoolDemo1 {
    
    public static void main(String[] args) throws Exception {
        // 创建随机数组成的数组:
        long[] array = new long[100];
        fillRandom(array);
        // fork/join task:
        ForkJoinPool fjp = new ForkJoinPool(4); // 最大并发数4
        ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
        long startTime = System.currentTimeMillis();
        Long result = fjp.invoke(task);
        long endTime = System.currentTimeMillis();
        System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");
    }
    
    static void fillRandom(long[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // array[i] = RandomUtils.nextInt(0, 1000);
            array[i] = i+1;
        }
    }
    
    static class SumTask extends RecursiveTask<Long> {
        
        static final int THRESHOLD = 50;
        long[] array;
        int start;
        int end;
        
        SumTask(long[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }
        
        @Override
        protected Long compute() {
            if (end - start <= THRESHOLD) {
                // 如果任务足够小,直接计算:
                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                System.out.println(String.format("compute %d~%d = %d", start, end, sum));
                return sum;
            }
            // 任务太大,一分为二:
            int middle = (end + start) / 2;
            System.out.println(String.format("split %d~%d ==> %d~%d, %d~%d", start, end, start, middle, middle, end));
            // 递归
            SumTask subtask1 = new SumTask(this.array, start, middle);
            SumTask subtask2 = new SumTask(this.array, middle, end);
            // 这种方法主线程会(递归几次有几个主线程)浪费
            // subtask1.fork();
            // subtask2.fork();
            invokeAll(subtask1, subtask2);
            Long subresult1 = subtask1.join();
            Long subresult2 = subtask2.join();
            Long result = subresult1 + subresult2;
            System.out.println("result = " + subresult1 + " + " + subresult2 + " ==> " + result);
            return result;
        }
    }
    
}

