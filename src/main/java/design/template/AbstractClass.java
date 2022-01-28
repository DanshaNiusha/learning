package design.template;

public abstract class AbstractClass {
    // 核心流程 防止子类重写
    public final void templateMethod() {
        //...
        method1();
        //...
        method2();
        //...
    }
    
    // 个性流程,强迫子类重写
    protected abstract void method1();
    
    protected abstract void method2();
}