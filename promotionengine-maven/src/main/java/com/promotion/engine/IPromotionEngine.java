package com.promotion.engine;

import java.util.List;

import com.promotion.model.Order;

public interface IPromotionEngine {
    
    List<String> getPromotionDescriptions();

    double calculateOrderPrice(Order order);
}
