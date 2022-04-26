package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Model5 {
    
    private int id;
    private String name;
    
    public Model5() {
    }
    
    public Model5(int id, String name) {
        this.id = id;
        this.name = name;
    }
}