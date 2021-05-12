package juc.thread.concurrency;

import javax.sound.midi.Soundbank;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.stream.IntStream;

/**
 * @author liuxiaokang
 * @description
 * @date 2020/11/23
 */
public class FutureTaskDemo {
    
    
    static class Task implements Callable<Integer>{
    
        @Override
        public Integer call() throws Exception {
            Thread.sleep(1000);
            return 2;
        }
    
        public static void main(String[] args) throws ExecutionException, InterruptedException {
            ExecutorService executorService = Executors.newCachedThreadPool();
            FutureTask<Integer> futureTask = new FutureTask<>(new Task());
            executorService.submit(futureTask);
            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
            Thread thread = new Thread();
            System.out.println(futureTask.get());
    
            int sum = IntStream.range(1, 10).parallel().sum();
            System.out.println(sum);
            
        }
    }
    
    
      class TreeNode {
         // int val;
         TreeNode left;
         TreeNode right;
         // TreeNode(int x) { val = x; }
     }
    class Solution {
        
        public int countNodes(TreeNode root) {
            if (root == null){
                return 0;
            }
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
    
    
    
}
