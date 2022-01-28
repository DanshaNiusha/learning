package design.observer;

import com.google.common.collect.Lists;
import design.bridge.notification.Notification;
import design.bridge.notification.NotificationFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 行为性:基于eventbus的观察者模式
 *
 * @author liuxiaokang
 * @date 2022/1/26
 */
public class ObserverTest {
    
    public static void main(String[] args) {
        UserController userController = new UserController();
        // 注册观察者
        List<Object> obs = Lists.newArrayList();
        obs.add(new RegNotificationObserver());
        obs.add(new RegPromotionObserver());
        userController.setRegObservers(obs);
    
        String ret = userController.register(123L);
        System.out.println(ret);
    }
    
    
}
