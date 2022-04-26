package design.strategy;

import model.Model1;

public class OrderService {
    
    public double discount(Model1 order) {
        Long type = order.getId();
        DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(type.toString());
        double discount = discountStrategy.calDiscount(order);
        return discount;
    }
}

