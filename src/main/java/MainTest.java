import cn.hutool.core.date.DateUtil;
import cn.hutool.core.thread.ThreadUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import model.Model2;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author liuxiaokang
 * @date 2021/7/6
 */
public class MainTest {
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
        // Long id = model2 == null ? 0L : model2.getId();
        
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
    
        // int weekOfDate = getWeekOfDate("2021-12-15", "yyyy-MM-dd");
    
        // boolean weekEnd = isWeekEnd("2022-01-01", "yyyy-MM-dd", "6,7");
        // System.out.println(weekEnd);
    
        // Date firstDayOfMonth = getFirstDayOfMonth(11);
        // Date lastDayOfMonth = getLastDayOfMonth(11);
        // System.out.println(firstDayOfMonth);
        // System.out.println(fillMonths(1,4));
        // System.out.println(fillMonths(7,2));
    
        // System.out.println(fillMonths(LocalDate.now(), LocalDate.now().plusMonths(2)));
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            ThreadUtil.execute(()->{
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
           
        }
        boolean await = countDownLatch.await(1, TimeUnit.SECONDS);
        System.out.println(await);
        System.out.println(11);
    }
    
    private static List<LocalDate> fillMonths(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> months = Lists.newArrayList();
        int startMonth = startDate.getMonthOfYear();
        int endMonth = endDate.getMonthOfYear();
        for (int i = startMonth; i <= (startMonth > endMonth ? endMonth + 12 : endMonth); i++) {
            if (i > 12) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, endDate.getYear());
                calendar.set(Calendar.MONTH, (i % 12) - 1);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                months.add(LocalDate.fromCalendarFields(calendar));
            } else {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, startDate.getYear());
                calendar.set(Calendar.MONTH, i - 1);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                months.add(LocalDate.fromCalendarFields(calendar));
            }
        }
        return months;
    }
    
    
    /**
     * 获取某月的最后一天
     */
    public static Date getFirstDayOfMonth(int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }
    
    /**
     * 获取某月的最后一天
     */
    public static Date getLastDayOfMonth(int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }
    
    
    public static boolean isWeekEnd(String date, String pattern, String weekendDefinition) {
        int week =getWeekOfDate(date, pattern);
        boolean isWeekEnd = weekendDefinition.contains(String.valueOf(week == 0 ? 7 : week));
        return isWeekEnd;
    }
    
    /**
     * 获取周几
     *
     * @param date
     * @param pattern
     * @return
     */
    public static int getWeekOfDate(String date, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date1 = null;
        try {
            date1 = simpleDateFormat.parse(String.valueOf(date));
        } catch (ParseException e) {
            // log.error("获取周几异常", e);
        }
        Calendar aCalendar = Calendar.getInstance();
        aCalendar.setTime(date1);
        return aCalendar.get(Calendar.DAY_OF_WEEK) - 1;
    }
    
    
    private static List<Integer> fillMonths(int startMonth, int endMonth) {
        List<Integer> months = Lists.newArrayList();
        for (int i = startMonth; i <= (startMonth > endMonth ? endMonth + 12 : endMonth); i++) {
            months.add(i > 12 ? i % 12 : i);
        }
        return months;
    }
    
    @NotNull
    private static void test(Model2 model2 ){
    }
}

