import kafka.producer.KeyedMessage;

/**
 * @author liuxiaokang
 * @description
 * @date 2019/7/2 17:19
 */
public class MyTest {
    public enum Bussiness{
        em1("我是1"),
        em2("我是2");
    
        private String name;
    
        public String getName() {
            return name;
        }
    
        Bussiness() {
        }
    
        Bussiness(String name) {
            this.name = name;
        }
    }
    public static void send(Bussiness bussiness){
        System.out.println(bussiness.getName());
    }
}
