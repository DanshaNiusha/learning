package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Model3 {
    private Integer intId;
    private Long id;
    @Builder.Default
    private String name = "123";
    private String idStr;
    private Model2 model2;
    
    
    public static void main(String[] args) {
        System.out.println(Model3.builder().id(1L).build().toString());
    }
}