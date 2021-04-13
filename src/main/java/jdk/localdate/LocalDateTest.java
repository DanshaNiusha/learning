package jdk.localdate;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

/**
 * @author liuxiaokang
 * @description
 * @date 2020/9/22
 */
public class LocalDateTest {
    public void testLocalDate() {
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.of(2020, 9, 22);
        System.out.println("===>"+localDate.isAfter(localDate1));
        System.out.println("当前时间 ：" + localDate);
        System.out.println("当前年：" + localDate.getYear());
        System.out.println("当前是今年里的第" + localDate.getDayOfYear() + "天");
        System.out.println("当前是这个月里第" + localDate.getDayOfMonth() + "天");
        System.out.println("当前是这个周里的第" + localDate.getDayOfWeek().getValue() + "天");
        System.out.println("现在是周几：" + localDate.getDayOfWeek());
        System.out.println("现在是周几：" + localDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.CHINESE));
        System.out.println(localDate.getChronology());
        System.out.println("现在是几月：" + localDate.getMonth() + "数字表示：" + localDate.getMonthValue() + "也可以用" + localDate.getMonth().getValue());
        System.out.println("这个月最多有" + localDate.getMonth().maxLength() + "天，这个月最少" + localDate.getMonth().minLength());
        LocalDate endOfDec = LocalDate.parse("2017-12-28");
        System.out.println("endOfDec：" + endOfDec);
    }
    
    public void testDateTime() {
        LocalTime localTime = LocalTime.of(13, 12, 11);
        System.out.println("当前时间：" + localTime);
    }
    
    public void testLocalDateTime() {
        System.out.println("-----------test java 8 LocalDateTime-----------");
        //当前时间，以秒为单位。
        long epochSecond = System.currentTimeMillis() / 1000L;
        //默认使用系统时区
        ZoneId zoneId = ZoneOffset.systemDefault();
        //之所以这么初始化，是因为根据传入的时间进行操作
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(epochSecond), zoneId);
        //LocalDateTime.now();//也可以这么获得当前时间
        System.out.println("localDateTime 初始化值：" + localDateTime);
        System.out.println("getYear：" + localDateTime.getYear());
        //方法返回值类型特殊，是枚举类型：Month类型
        System.out.println("getMonth：" + localDateTime.getMonth());
        System.out.println("getDayOfMonth：" + localDateTime.getDayOfMonth());
        System.out.println("getHour：" + localDateTime.getHour());
        System.out.println("getMinute：" + localDateTime.getMinute());
        System.out.println("getSecond：" + localDateTime.getSecond());
        System.out.println("getNano：" + localDateTime.getNano());
        System.out.println("getDayOfWeek：" + localDateTime.getDayOfWeek());
        
        /*
         * 获得传入时间的某一天的凌晨零分零秒的秒数
         */
        long dayStart = localDateTime.withHour(0).withMinute(0).withSecond(0).atZone(zoneId).toEpochSecond();
        LocalDateTime searchBeginTime = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1).minusYears(1).atStartOfDay();
        LocalDateTime localDateTime1 = LocalDate.now().minusDays(1).atStartOfDay();
        System.out.println(searchBeginTime+"___"+localDateTime1);
        System.out.println("dayStart 时间戳，秒数：" + dayStart);
        /*
         * 获得传入时间的周一的凌晨零分零秒的秒数
         */
        localDateTime = LocalDateTime.of(2017, 12, 2, 0, 0, 0);
        System.out.println("localDateTime 设置当前值：" + localDateTime);
        System.out.println("getDayOfWeek：" + localDateTime.getDayOfWeek());
        System.out.println("getDayOfWeek 的 ordinal 值：" + localDateTime.getDayOfWeek().ordinal());
        LocalDateTime weekStart = localDateTime.minusDays(localDateTime.getDayOfWeek().ordinal()).withHour(0).withMinute(0).withSecond(0);
        System.out.println("weekStart：" + weekStart);
        LocalDateTime weekEnd = localDateTime.plusDays(6 - localDateTime.getDayOfWeek().ordinal()).withHour(0).withMinute(0).withSecond(0);
        System.out.println("weekEnd：" + weekEnd);
        /*
         * 获得传入时间的月份的第一天的凌晨零分零秒的秒数
         */
        long monthStart = localDateTime.with(TemporalAdjusters.firstDayOfMonth()).withHour(0).withMinute(0).withSecond(0).atZone(zoneId).toEpochSecond();
        System.out.println("monthStart 时间戳，秒数：" + monthStart);
        
        /*
         * 传入时间的年的第一天
         */
        LocalDateTime firstDayOfYear = localDateTime.with(TemporalAdjusters.firstDayOfYear());
        System.out.println("firstDayOfYear：" + firstDayOfYear);
        
        /*
         * 当前时间，往后推一周的时间。plus   加
         */
        LocalDateTime plusWeeks = localDateTime.plusWeeks(1);
        System.out.println("plus one week：" + plusWeeks);
        /*
         * 当前时间，向前推一周的时间。minus  减
         */
        LocalDateTime minusWeeks = localDateTime.minusWeeks(1);
        System.out.println("minus one week：" + minusWeeks);
        
        //线程安全的日期格式转换
        DateTimeFormatter sf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String startTime = "2016-11-13 23:59";
        localDateTime = LocalDateTime.parse(startTime, sf);
        System.out.println(localDateTime);
        
        
        //  可以通过LocalDate.until 对两个时间的差值进行计算，ChronoUnit.DAYS代表差多少天，ChronoUnit.MONTHS月，ChronoUnit.YEARS
        LocalDate now = LocalDate.parse("2020-05-16");
        LocalDate lastYear = LocalDate.parse("2019-05-16");
        System.out.println(now.until(lastYear, ChronoUnit.DAYS));
    }
    
    public static void main(String[] args) {
        LocalDateTest localDateTest = new LocalDateTest();
        // localDateTest.testLocalDate();
        localDateTest.testDateTime();
        localDateTest.testLocalDateTime();
    }
    
}
