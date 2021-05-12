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
        String username = Optional.ofNullable(user).map(u -> u.getName()).orElse("dsadas");
        System.out.println(username);
        // Object o = new ArrayList<>().stream().findFirst().orElse(null);
    
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
