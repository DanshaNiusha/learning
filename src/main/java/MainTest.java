import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.commons.lang3.tuple.Pair;
import utils.ThreadPoolUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

/**
 * @author liuxiaokang
 * @date 2021/7/6
 */
public class MainTest {
    
    public static void main(String[] args) throws InterruptedException {
        // List<model.Mode3> emptyList = Lists.newArrayList();
        // emptyList.add(new model.Mode3());
        // Optional.ofNullable(new model.Mode3()).map(x->{
        //     System.out.println(x.name);
        //     return x.name;
        // }).orElse(null);
        // Map<String, String> collect = emptyList.stream().filter(x->x.getSex()!=null).collect(Collectors.toMap(model.Mode3::getName, model.Mode3::getSex));
        // System.out.println(11);
        //
    
        // List<Integer> list = Lists.newArrayList();
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // try {
        //     for (int i = 0; i < 10; i++) {
        //         ThreadPoolUtils.getSyncPool().execute(()->{
        //             System.out.println(Thread.currentThread().getName());
        //             try {
        //                 Thread.sleep(100);
        //             } catch (InterruptedException e) {
        //                 e.printStackTrace();
        //             }
        //         });
        //     }
        //     System.out.println("end");
        // }catch (Exception e){
        //     System.out.println("eeeeeee");
        // }
    
        new ThreadTester("T1").start();
        new ThreadTester("T2").start();
        System.out.println("结束------------");
    
    }
    
    private static void set1(int l){
    
    }
    
}

class ThreadTester extends Thread{
    public ThreadTester(String name) {
        super(name);
    }
    
    @Override
    public void run(){
        System.out.println(this.getName()+"start");
        System.out.println(this.getName()+"end");
    }
}
