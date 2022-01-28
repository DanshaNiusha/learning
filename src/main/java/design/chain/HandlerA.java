package design.chain;

public class HandlerA implements IHandler {
    @Override
    public boolean handle() {
        boolean handled = false;
        System.out.println("HandlerA 执行了");
        //...
        return handled;
    }
}
