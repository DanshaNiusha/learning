package jdk.guava;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * @author liuxiaokang
 * @date 2021/7/6
 */
public class EventBusTest {
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

