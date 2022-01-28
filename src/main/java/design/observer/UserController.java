package design.observer;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.List;
import java.util.concurrent.Executors;

public class UserController {
    
    private EventBus eventBus;
    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;
    
    public UserController() {
        //eventBus = new EventBus(); // 同步阻塞模式
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE)); // 异步非阻塞模式
    }
    
    public void setRegObservers(List observers) {
        for (Object observer : observers) {
            eventBus.register(observer);
        }
    }
    
    /**
     * 业务方法 用户注册
     * @return
     */
    public String register(Long userId) {
        eventBus.post(userId);
        eventBus.post("2222");
        return "success!";
    }
}
