package jdk.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author liuxiaokang
 * @date 2021/8/2
 */
public class partitionByTest {
    // Driver code
    public static void main(String[] args)
    {
        // creating an Integer stream
        Stream<Integer> s = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // using Collectors partitioningBy()
        // method to split the stream of elements into
        // 2 parts, greater than 3 and less than 3.
        Map<Boolean, List<Integer>>
                map = s.collect(
                Collectors.partitioningBy(num -> num > 3));
        // Displaying the result as a map
        // true if greater than 3, false otherwise
        System.out.println("Elements in stream "
                + "partitioned by "
                + "less than equal to 3:\n"
                + map);
    }
}
