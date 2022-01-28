package design.chain;

public class HandlerB implements IHandler {
    @Override
    public boolean handle() {
        boolean handled = false;
        System.out.println("HandlerB 执行了");
        return handled;
    }
}