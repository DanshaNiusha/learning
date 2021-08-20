import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.commons.lang3.tuple.Pair;
import utils.ThreadPoolUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;

/**
 * @author liuxiaokang
 * @date 2021/7/6
 */
public class MainTest {
    
    public static void main(String[] args) throws InterruptedException {
        Object s = "123";
        String ret = Optional.ofNullable(s).map(Object::toString).orElse("");
    
        // Object i1=2;
        // long i11 = Long.parseLong( i1.toString());
        // // int i11 = (int) i1;
        // System.out.println(i11);
        // // set1(i11);
    
        // StopWatch stopWatch = new StopWatch();
        // stopWatch.start();
        // CountDownLatch latch = new CountDownLatch(1000);
        // for (int i = 0; i < 1000; i++) {
        //     ThreadPoolUtils.excute(() -> {
        //         System.out.println("执行了");
        //         try { Thread.sleep(10);} catch (InterruptedException e) {  e.printStackTrace();}
        //         latch.countDown();
        //     },ThreadPoolUtils.getSyncPool());
        // }
        // latch.await();
        // stopWatch.stop();
        // System.out.println(stopWatch);
        //
        
        
        // String s = "1234";
        // String remove = StringUtils.remove(s, "13");
        // System.out.println(s);
        // System.out.println(remove);
    
    
        // HashBasedTable<Integer, String, Object> table = HashBasedTable.create();
        // table.put(11,"aa",true);
        // table.put(2,"bb",false);
        // table.put(3,"cc",true);
        //
        // for (Integer rowkey : table.rowKeySet()) {
        //     Map<String, Object> row = table.row(rowkey);
        // }
        // System.out.println(table);
        //
        // HashMap<Object, Object> map = Maps.newHashMap();
        // map.put("1","a");
        // map.put("2","b");
        // map.entrySet().forEach(a->a.setValue("xxx"));
        //
        // ArrayList<Object> list = Lists.newArrayList(1,2,3);
        // list.forEach(l->list.remove(l));
        // System.out.println(list);
        //
        // List<Integer> objects = Collections.emptyList();
        // objects.add(1);
    
        // List<Integer> list = Lists.newArrayList();
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // // for (Integer i : list) {
        // //     list.add(1);
        // // }
        // // list.forEach(x->list.add(1));
        // for (int i = 0; i < list.size(); i++) {
        //     Integer integer = list.get(i);
        //     integer = 34;
        // }
        // System.out.println(list.toString());
        
        // // list.add(1);
        // list.sort((o1, o2) -> {
        //     if (o1 == null) {
        //         return 1;
        //     }
        //     if (o2 == null) {
        //         return -1;
        //     }
        //     return o2 - o1;
        //
        //     // if (o1 != null && o2 != null) {
        //     //     return o1.compareTo(o2);
        //     // } else {
        //     //     return o1 == null ? 1 : -1;
        //     // }
        // });
        // System.out.println(list.toString());
    
        // // Optional<String> ss = Optional.of("ss");
        // Optional<String> ss = Optional.empty();
        // String s = ss.map(x -> x).orElse("1");
        // System.out.println(s);
        //
        // System.out.println(448&128);
        
    }
    
    private static void set1(int l){
    
    }
    
}
