package design.bridge.notification;

import design.bridge.msgsender.MsgSender;

public class UrgencyNotification extends Notification {
    public UrgencyNotification(MsgSender msgSender) {
        super(msgSender);
    }
    
    @Override
    public void notify(String message) {
    
    }
    // 与SevereNotification代码结构类似，所以省略...
}