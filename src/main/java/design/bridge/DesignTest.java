package design.bridge;

import design.bridge.msgsender.TelephoneMsgSender;
import design.bridge.notification.Notification;
import design.bridge.notification.NotificationFactory;
import design.bridge.notification.SevereNotification;

import java.util.List;

/**
 * 结构型:桥接模式 (组合优于继承)
 * 一个功能有多个变化的维度,通过组合的方式让每个维度可以独立的扩展
 *
 * @author liuxiaokang
 * @date 2022/1/26
 */
public class DesignTest {
    
    public static void main(String[] args) {
        List<Notification> notifications = NotificationFactory.create("改价");
        for (Notification notification : notifications) {
            notification.notify("消息内容");
        }
    }
    
    
}
