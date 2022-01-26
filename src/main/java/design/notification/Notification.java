package design.notification;

import design.msgsender.MsgSender;

public abstract class Notification {
  
  protected MsgSender msgSender;
  
  protected Integer role;

  public Notification(MsgSender msgSender) {
    this.msgSender = msgSender;
  }
  public Notification(MsgSender msgSender,Integer role) {
    this.msgSender = msgSender;
    this.role = role;
  }

  public abstract void notify(String message);
}