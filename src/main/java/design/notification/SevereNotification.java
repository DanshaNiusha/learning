package design.notification;

import design.msgsender.MsgSender;

import java.util.List;

/**
 * 程度A
 */
public class SevereNotification extends Notification {
    
    public SevereNotification(MsgSender msgSender,Integer role) {
        super(msgSender,role);
    }
    
    @Override
    public void notify(String message) {
        // List<String> userList = getUserByRole(role);
        // for (String user : userList) {
        //     msgSender.send(message + user);
        // }
       
    }
}