package juc.thread.test;


import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import juc.thread.concurrency.BizPlatformException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Long> goodsIds = Lists.newArrayList();
        goodsIds.add(1L);
        for (int i = 0; i < 10; i++) {
            // new Thread(()->{
                ArrayList<Long> list1 = Lists.newArrayList();
                list1.add(2L);
                goodsIds.addAll(null);
            // }).start();
        }
        
        System.out.println(goodsIds.get(goodsIds.size() - 1));
    }
    
    public static void xx(String str){
        str = "22";
    }
}
