package design.adapter;

/**
 * @author liuxiaokang
 * @date 2022/2/7
 */
public class Application {
    public static void main(String[] args) {
        ITarget adaptor = new Adaptor(new Adaptee());
        adaptor.f1();
        adaptor.f2();
        adaptor.fc();
    }
}
