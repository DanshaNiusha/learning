package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Model1 {
    private Long id;
    private Model2 model2;
    
    // public Model1() {
    // }
    
}