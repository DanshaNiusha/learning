package design.observer;

import com.google.common.eventbus.Subscribe;

public class RegNotificationObserver {
    
    
    @Subscribe
    public void handleRegSuccess(Long userId) {
        System.out.println("RegNotificationObserver.handleRegSuccess被调用");    }
    
}