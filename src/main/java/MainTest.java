import com.google.common.base.Joiner;
import com.google.common.base.Stopwatch;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import model.Model1;
import org.apache.commons.lang3.time.StopWatch;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author liuxiaokang
 * @date 2021/7/6
 */
public class MainTest {
    public static final String DATE_INT_FORMAT = "yyyyMMdd";
    private static final org.joda.time.format.DateTimeFormatter JODA_FORMAT = DateTimeFormat.forPattern(DATE_INT_FORMAT);
    private static final Joiner joiner = Joiner.on(",").useForNull("-1");
    
    public static void main(String[] args) throws InterruptedException {
        // Model2 model2 =  Model2.builder().id(null).name("111").build();
        // model2.setName(null);
        // System.out.println(model2.toString());
        // test(null);
        // List<Model2> list = Lists.newArrayList();
        // ImmutableMap<String, Model2> mtaRealRoomTypeModelMapTemp = Maps
        //         .uniqueIndex(list, Model2::getName);
        // mtaRealRoomTypeModelMapTemp.get(null);
        //
        // Model2 model2 = Model2.builder().id(null).name("111").build();
        // Integer id = model2 == null ? 0 : model2.getId();
        // Long operatorId = Optional.ofNullable(model2).map(Model2::getId).orElse(0L);
        // Long customerId=null;
        // Long l = model2 == null ? 0L : customerId;
        // System.out.println(customerId);
        // ArrayList<Integer> list = Lists.newArrayList(1, 2, 3, 1, 1, 2);
        // HashMap<Integer, Integer> map = Maps.newHashMap();
        // for (Integer num : list) {
        //     Integer compute = map.compute(num, (k, oldValue) -> {
        //        return oldValue == null? 1:++oldValue;
        //     });
        //     // System.out.println(compute);
        // }
        //
        // List<Integer> integers = fillMonths(2, 8);
        // System.out.println(JSON.toJSONString(new GoodsQueryByPoiParam()));
        // int weekOfDate = getWeekOfDate("2021-12-15", "yyyy-MM-dd");
    
        // boolean weekEnd = isWeekEnd("2022-01-01", "yyyy-MM-dd", "6,7");
        // System.out.println(weekEnd);
    
        // Date firstDayOfMonth = getFirstDayOfMonth(11);
        // Date lastDayOfMonth = getLastDayOfMonth(11);
        // System.out.println(firstDayOfMonth);
        // System.out.println(fillMonths(1,4));
        // System.out.println(fillMonths(7,2));
    
        // System.out.println(fillMonths(LocalDate.now(), LocalDate.now().plusMonths(2)));
        // CountDownLatch countDownLatch = new CountDownLatch(10);
        // for (int i = 0; i < 10; i++) {
        //     ThreadUtil.execute(()->{
        //         try {
        //             TimeUnit.MICROSECONDS.sleep(1);
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         }
        //         countDownLatch.countDown();
        //     });
        //
        // }
        // List<Integer> activityCodeList = Lists.newArrayList(33);
        //
        // for (int i = 0; i < 3; i++) {
        //     String join = joiner.join(activityCodeList);
        //     System.out.println(join);
        // }
        // Integer a = 1;
        //
        // Model1<Long> model1 = new Model1<>();
        // Model1<Integer> model2 = new Model1<>();
        // Object s= model2;
        // Model1<Long>  mm =  s;
        //
        //
        // model1.setValue(s);
        //
        // Long b = Long.parseLong(s.toString());
        // Byte b = Byte.valueOf("-126.5");
        // System.out.println(b);
    
        // List<Integer> list = Lists.newCopyOnWriteArrayList();
        // list.add(1);
        // for (Integer integer : list) {
        //     list.add(2);
        //     System.out.println(list);
        //     list.remove((Integer) 2);
        //     list.add(3);
        // }
        // System.out.println(list);
        // HashSet<Integer> set1 = Sets.newHashSet(1, 2, 3);
        // HashSet<Integer> set2 = Sets.newHashSet(2, 4, 6);
        // Sets.SetView<Integer> intersection = Sets.intersection(set1, set2);
        // // intersection
        // Set<Integer> collect = new HashSet<>(intersection);
        // System.out.println(intersection);
        // String s = LocalDate.now().toString(DateTimeFormat.forPattern("MM/dd"));
        Date date = LocalDate.now().toDate();
        System.out.println(     org.joda.time.LocalDate.now().toDate()

        );
    
    }
    public static List<Integer> splitToDateList(int startDate, int endDate) {
        List<Integer> list = new ArrayList<>();
        
        DateTime startDateTime = parseIntToDateTime(startDate);
        DateTime endDateTime = parseIntToDateTime(endDate);
        
        //  判断开始时间是否大于结束时间
        if (startDateTime.isAfter(endDateTime)) {
            return list;
        }
        
        for (; startDateTime.isBefore(endDateTime); ) {
            list.add(Integer.parseInt(startDateTime.toString(JODA_FORMAT)));
            startDateTime = startDateTime.plusDays(1);
        }
        list.add(Integer.parseInt(startDateTime.toString(JODA_FORMAT)));
        return list;
    }
    
    
    public static DateTime parseIntToDateTime(int dateInt) {
        return stringDateParseDateTime(String.valueOf(dateInt));
    }
    
    
    public static DateTime stringDateParseDateTime(String strDate) {
        return DateTime.parse(strDate, JODA_FORMAT);
    }
}

