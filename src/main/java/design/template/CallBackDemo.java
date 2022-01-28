package design.template;

/**
 * 回调示例
 *
 * @author liuxiaokang
 * @date 2022/1/28
 */
public class CallBackDemo {
    
    public static void main(String[] args) {
        
        BButton b = new BButton();
        //回调对象
        b.addListener(buttonName -> System.out.println("按钮" + buttonName + "回调执行"));
        
        b.click("AA");
    }
    
}

interface ICallback {
    void methodToCallback(String buttonName);
}


class BButton {
    private ICallback clickListener;
    
    public void addListener(ICallback listener) {
        clickListener = listener;
    }
    
    public void click(String buttonName) {
        System.out.println(buttonName + "被点击");
        clickListener.methodToCallback(buttonName);
    }
}