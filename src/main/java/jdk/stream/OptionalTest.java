package jdk.stream;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author liuxiaokang
 * @date 2021/4/13
 */
public class OptionalTest {
   
    @Test
    public void test01() throws Exception{
        // User user1 = User.builder().id(1L).name("zhangsan").build();
        User user = null;
        Integer x= null;
        // String username = Optional.ofNullable(x).filter(item->).orElse(0).filter(item->item.getId()>0)..orElse("dsadas");
        
        x = x == null ? 0 : x;
    
        x = Optional.ofNullable(x).filter(item -> item > 0).orElse(0);
    
        
    }
    
    
}

@Builder
@ToString
@Getter
@Setter
class User{
    private Long id;
    private String name;
}
