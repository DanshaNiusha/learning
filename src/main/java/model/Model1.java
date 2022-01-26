package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class Model1<T> {
    private Long id111;
    private boolean man;
    private T value;
    // private String name;
    
}