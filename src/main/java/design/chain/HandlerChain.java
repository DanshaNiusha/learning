package design.chain;

import java.util.ArrayList;
import java.util.List;

public class HandlerChain {
    private final List<IHandler> handlers = new ArrayList<>();
    
    public void addHandler(IHandler handler) {
        this.handlers.add(handler);
    }
    
    public void handle() {
        for (IHandler handler : handlers) {
            boolean handled = handler.handle();
            if (handled) {
                // 这里可以控制是命中执行器后中断还是继续执行
                break;
            }
        }
    }
}
