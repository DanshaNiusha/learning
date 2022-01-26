package design.bridge.notification;

import design.bridge.msgsender.MsgSender;

public class NormalNotification extends Notification {
    
    public NormalNotification(MsgSender msgSender,Integer role) {
        super(msgSender,role);
    }
    
    @Override
    public void notify(String message) {
    
    }
    // 与SevereNotification代码结构类似，所以省略...
}