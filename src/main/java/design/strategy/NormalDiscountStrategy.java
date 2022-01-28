package design.strategy;

import model.Model1;

/**
 * @author liuxiaokang
 * @date 2022/1/28
 */
public class NormalDiscountStrategy implements DiscountStrategy{
    @Override
    public double calDiscount(Model1 order) {
        return 0;
    }
}
