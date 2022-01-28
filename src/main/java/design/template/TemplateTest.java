package design.template;

import com.google.common.collect.Lists;
import design.observer.RegNotificationObserver;
import design.observer.RegPromotionObserver;
import design.observer.UserController;

import java.util.List;

/**
 * 行为性:基于eventbus的观察者模式
 *
 * @author liuxiaokang
 * @date 2022/1/26
 */
public class TemplateTest {
    
    public static void main(String[] args) {
        AbstractClass class1 = new ConcreteClass1();
        class1.templateMethod();
        
    }
    
    
}
