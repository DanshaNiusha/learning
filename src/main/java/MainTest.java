import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuxiaokang
 * @date 2021/7/6
 */
public class MainTest {
    
    public static void main(String[] args) {
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
    
        List<Integer> list = Lists.newArrayList();
        list.add(null);
        list.add(1);
        list.add(null);
        list.add(null);
        list.add(2);
        list.add(null);
        // list.add(1);
        list.sort((o1, o2) -> {
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            return o2 - o1;
            
            // if (o1 != null && o2 != null) {
            //     return o1.compareTo(o2);
            // } else {
            //     return o1 == null ? 1 : -1;
            // }
        });
        System.out.println(list.toString());
    }
    
}
