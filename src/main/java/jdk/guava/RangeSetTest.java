package jdk.guava;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

/**
 * @author liuxiaokang
 * @date 2021/7/27
 */
public class RangeSetTest {
    
    public static void main(String[] args) {
        RangeSet<Integer> rangeSet = TreeRangeSet.create();
        rangeSet.add(Range.closed(1, 10)); // {[1, 10]}
        rangeSet.add(Range.closedOpen(11, 15)); // disconnected range; {[1, 10], [11, 15)}
        rangeSet.add(Range.closedOpen(15, 20)); // connected range; {[1, 10], [11, 20)}
        rangeSet.add(Range.openClosed(0, 0)); // empty range; {[1, 10], [11, 20)}
        rangeSet.remove(Range.open(5, 10)); // splits [1, 10]; {[1, 5], [10, 10], [11, 20)}
    
        System.out.println("rangeA:"+rangeSet);
        System.out.println("rangeA的补集:"+rangeSet.complement());
        System.out.println("rangeA是否相交:"+rangeSet.intersects(Range.closed(1, 3)));
        System.out.println("17在哪个范围里:"+rangeSet.rangeContaining(17));
    
    }
}
