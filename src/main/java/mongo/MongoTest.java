package mongo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * @author liuxiaokang
 * @description
 * @date 2020/10/9
 */
public class MongoTest {
    public static void main(String[] args) throws ParseException {
        String s = "2020-10-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(s);
        System.out.println(parse);
        // LocalDate.now().
        // Period.between(d1,d2).getDays()
        // ChronoUnit.DAYS.getDuration().toDays()
        // LocalDate sDate = LocalDate.of(2020, 10, 1);
        // LocalDate eDate = LocalDate.of(2020, 10, 15);
        // List<TemporalUnit> units = Period.between(d1, d2).getUnits();
        // for (TemporalUnit unit : units) {
        //
        //
        // }
    
    
    }
}
