package jdk.type;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxiaokang
 * @date 2022/3/14
 */
public class TypeDemo {
    public static void main(String[] args) {
        List catList = new ArrayList<>();
        List animalList = catList;
        System.out.println(1);
    }
}
