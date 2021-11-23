import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import lombok.extern.java.Log;
import model.Model1;
import model.Model2;
import model.Model3;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.commons.lang3.tuple.Pair;
import utils.ThreadPoolUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

/**
 * @author liuxiaokang
 * @date 2021/7/6
 */
public class MainTest {
    public static void main(String[] args) {
        // 一个bus总线可注册多个监听器, 一个监听器也可以监听多个bus总线
        EventBus bus = new EventBus();
        bus.register(new EventListener());
        bus.register(new EventListener2());
        bus.post(1);
        bus.post("lxk");
        
        
    }
    
    static class EventListener {
        /**
         * 监听 Integer 类型的消息
         */
        @Subscribe
        public void listenInteger(Integer param) {
            System.out.println("EventListener#listenInteger ->" + param);
        }
    
        /**
         * 监听 String 类型的消息
         */
        @Subscribe
        public void listenString(String param) {
            System.out.println("EventListener#listenString ->" + param);
        }
    }
    
    static class EventListener2 {
        /**
         * 监听 Integer 类型的消息
         */
        @Subscribe
        public void listenInteger(Integer param) {
            System.out.println("EventListener222#listenInteger ->" + param);
        }
    
        /**
         * 监听 String 类型的消息
         */
        @Subscribe
        public void listenString(String param) {
            System.out.println("EventListener222#listenString ->" + param);
        }
    }
}

