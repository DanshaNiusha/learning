package jdk.localdate.joda;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.junit.Test;

import java.util.Date;
import java.util.Locale;

/**
 * api https://www.joda.org/joda-time/apidocs/index.html
 * @author liuxiaokang
 * @date 2021/12/15
 */
public class JodaTest {
    
    public static void main(String[] args) {
        int monthOfYear = LocalDate.fromDateFields(new Date()).plusMonths(1).getMonthOfYear();
        System.out.println(monthOfYear);
    }
    
    
    @Test
    public void testDateTime(){
        System.out.println("-------------构造DateTime----------------");
        DateTime dateTime1 = new DateTime();
        System.out.println(dateTime1); // out: 2016-02-26T16:02:57.582+08:00
        DateTime dateTime2 = new DateTime(2016,2,14,0,0,0);
        System.out.println(dateTime2); // out: 2016-02-14T00:00:00.000+08:00
        DateTime dateTime3 = new DateTime(System.currentTimeMillis());
        System.out.println(dateTime3); // out: 2016-02-26T16:05:17.004+08:00
        DateTime dateTime4 = new DateTime(new Date());
        System.out.println(dateTime4); // out: 2016-02-26T16:07:59.970+08:00
        DateTime dateTime5 = new DateTime("2016-02-15T00:00:00.000+08:00");
        System.out.println(dateTime5); // out: 2016-02-15T00:00:00.000+08:00
    }
    
    @Test
    public void testWithYear(){
        // 设置年月日
        System.out.println("--------------设置年月日----------------");
        DateTime dateTime2000Year = new DateTime(2021,12,29,0,0,0);
        System.out.println(dateTime2000Year); // out: 2000-02-29T00:00:00.000+08:00
        DateTime dateTime1997Year = dateTime2000Year.withYear(1997).withMonthOfYear(11).withDayOfMonth(1);
        System.out.println(dateTime1997Year);
    }
    
    @Test
    public void testProperty() {
        DateTime now = new DateTime(); // 2016-02-26T16:51:28.749+08:00
        System.out.println(now.monthOfYear().getAsText());
        System.out.println(now.monthOfYear().getAsText(Locale.KOREAN)); // 2월
        System.out.println(now.dayOfWeek().getAsShortText()); // Fri
        System.out.println(now.dayOfWeek().getAsShortText(Locale.CHINESE)); // 星期五
        System.out.println("----------测试置零-----------");
        System.out.println(now.dayOfWeek().roundCeilingCopy()); // 2016-02-27T00:00:00.000+08:00
        System.out.println(now.dayOfWeek().roundFloorCopy()); // 2016-02-26T00:00:00.000+08:00
        System.out.println(now.minuteOfDay().roundFloorCopy()); // 2016-02-26T16:51:00.000+08:00
        System.out.println(now.secondOfMinute().roundFloorCopy()); // 2016-02-26T16:51:28.000+08:00
    }
    
    @Test
    public void testPeriod() {
        DateTime dt = new DateTime(2005, 3, 26, 12, 0, 0, 0);
        DateTime plusPeriod = dt.plus(Period.days(1));
        System.out.println(plusPeriod);
        DateTime plusDuration = dt.plus(new Duration(24L * 60L * 60L * 1000L));
        System.out.println(plusDuration);
    }
}
