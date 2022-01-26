package design.bridge.notification;

import com.google.common.collect.Lists;
import design.bridge.msgsender.EmailMsgSender;
import design.bridge.msgsender.MsgSender;
import design.bridge.msgsender.TelephoneMsgSender;
import design.bridge.msgsender.WechatMsgSender;

import java.util.List;

/**
 * 通知器工厂
 * 根据不同的业务对不同的人创建通知器
 */
public abstract class NotificationFactory {
    
    public static List<Notification> create(String businessType) {
        List<Notification> notifications = Lists.newArrayList();
        if (businessType.equals("改价")){
            notifications.add(new SevereNotification(new TelephoneMsgSender(),1));
            notifications.add(new SevereNotification(new WechatMsgSender(),1));
        }
        
        if (businessType.equals("审核")){
            notifications.add(new NormalNotification(new WechatMsgSender(),2));
            notifications.add(new NormalNotification(new EmailMsgSender(),2));
        }
        return notifications;
    }
    
}