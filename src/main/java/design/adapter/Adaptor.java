package design.adapter;

/**
 * 适配器,基于组合,包装原有的Adaptee
 */
public class Adaptor implements ITarget {
    
    private Adaptee adaptee;
    
    public Adaptor(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
    
    public void f1() {
        adaptee.fa(); //委托给Adaptee
    }
    
    public void f2() {
        System.out.println("重新实现f2()");
        //...重新实现f2()...
    }
    
    public void fc() {
        adaptee.fc();
    }
}