package design;

import design.msgsender.EmailMsgSender;
import design.msgsender.TelephoneMsgSender;
import design.notification.NormalNotification;
import design.notification.Notification;
import design.notification.SevereNotification;

/**
 * @author liuxiaokang
 * @date 2022/1/26
 */
public class DesignTest {
    
    public static void main(String[] args) {
        // Notification notification = new NormalNotification(new EmailMsgSender());
        // notification.notify("消息内容");
    
        Notification notification = new SevereNotification(new TelephoneMsgSender(),1);
        notification.notify("消息内容");
    }
    
    
}
