package model;

import algorithms.sort.MergePeiord;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author liuxiaokang
 * @date 2022/3/3
 */
@Data
@AllArgsConstructor
public class Peiord implements MergePeiord.MergeDateAbility {
    private int startDate;
    
    private int endDate;
    
    /**
     * 联动日期类型，0:普通联动日期，1:节假日，2:不参与日期，3：手动改价日期
     * 节假日被废除
     */
    private Integer linkDateType;
    
    @Override
    public Integer getLower() {
        return startDate;
    }
    
    @Override
    public Integer getUpper() {
        return endDate;
    }
    
    @Override
    public void setLower(Integer lower) {
        this.startDate = lower;
    }
    
    @Override
    public void setUpper(Integer upper) {
        this.endDate = upper;
    }
}
