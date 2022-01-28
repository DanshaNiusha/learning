package design.strategy;

import java.util.HashMap;
import java.util.Map;

// 策略的创建
public class DiscountStrategyFactory {
  private static final Map<String, DiscountStrategy> strategies = new HashMap<>();
  
  static {
    strategies.put("normal", new NormalDiscountStrategy());
    // strategies.put("GROUPON", new GrouponDiscountStrategy());
    // strategies.put(OrderType.PROMOTION, new PromotionDiscountStrategy());
  }
  
  /**
   * 根据类型获取策略
   * @param type
   * @return
   */
  public static DiscountStrategy getDiscountStrategy(String type) {
    return strategies.get(type);
  }
}