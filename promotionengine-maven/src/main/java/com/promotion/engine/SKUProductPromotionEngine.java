package com.promotion.engine;

import java.util.ArrayList;
import java.util.List;

import com.promotion.model.IPromotion;
import com.promotion.model.Order;
import com.promotion.model.OrderProduct;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;

public class SKUProductPromotionEngine implements IPromotionEngine {
    @Getter
    @Autowired
    private List<IPromotion> promotions;
    
    public SKUProductPromotionEngine() {
    }

    @Override
    public List<String> getPromotionDescriptions() {
        System.out.println("Promotions size: " + promotions.size());
        List<String> descriptions = new ArrayList<>();
        for (IPromotion promotion : promotions) {
            System.out.println(promotion.getPromotionDescription());
            descriptions.add(promotion.getPromotionDescription());
        }
        return descriptions;
    }

    @Override
    public double calculateOrderPrice(Order order) {
        double totalPrice = 0;

        List<OrderProduct> orderProducts = order.getOrderProducts();
        for(IPromotion promotion : promotions) {
            totalPrice += promotion.calculateTotalPrice(orderProducts);
        }

        return totalPrice;
    }
}
