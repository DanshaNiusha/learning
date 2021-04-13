package juc.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxiaokang
 * @date 2020/12/14
 */
public class GCOverHeadDemo {
    public static void main(String[] args) throws InterruptedException {
        int i=0;
        ArrayList<String> strings = new ArrayList<>();
        while (true){
            strings.add(String.valueOf(++i).intern());
        }
    
    }
}
