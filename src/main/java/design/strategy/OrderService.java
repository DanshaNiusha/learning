package design.strategy;

import model.Model1;

public class OrderService {
    
    public double discount(Model1 order) {
        Integer type = order.getId111();
        DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(type.toString());
        double discount = discountStrategy.calDiscount(order);
        return discount;
    }
}

