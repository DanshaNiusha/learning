package design.strategy;

import model.Model1;

import java.util.HashMap;
import java.util.Map;

// 策略的定义
public interface DiscountStrategy {
    double calDiscount(Model1 order);
}
// 省略NormalDiscountStrategy、GrouponDiscountStrategy、PromotionDiscountStrategy类代码...



