package design.observer;

import com.google.common.eventbus.Subscribe;

public class RegPromotionObserver {
    
    //   @Subscribe的方法并且类型与post的参数相同会被执行
    @Subscribe
    public void handleRegSuccess(Long userId) {
        System.out.println("RegPromotionObserver.handleRegSuccess被调用"+userId);
    }
    
    @Subscribe
    public void handleRegSuccess1(String userId) {
        System.out.println("RegPromotionObserver.handleRegSuccess1被调用"+userId);
    }
    
}

