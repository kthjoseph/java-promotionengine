package com.promotion.model;

import java.util.List;

public class PromotionC implements IPromotion {
    private static final int PromotionPriceDeductionPerGroup = 5;

    @Override
    public double calculateTotalPrice(List<OrderProduct> orderProducts) {
        int iCountC = 0;
        int iCountD = 0;
        double totalPrice = 0;
        for (OrderProduct orderProduct : orderProducts) {
            if ("C".equals(orderProduct.getProductId())) {
                iCountC = orderProduct.getQuantity();
                totalPrice += orderProduct.getTotalPrice();
            } else if ("D".equals(orderProduct.getProductId())) {
                iCountD = orderProduct.getQuantity();
                totalPrice += orderProduct.getTotalPrice();
            }
        }

        if (iCountC > 0 && iCountD > 0) {
            int iNumOfPromotionGroup = iCountC > iCountD ? iCountD : iCountC;
            if (iNumOfPromotionGroup > 0) {
                // deduct the total price with promotion
                totalPrice -= iNumOfPromotionGroup * PromotionPriceDeductionPerGroup;
            }
        }

        return totalPrice;
    }

    @Override
    public String getPromotionDescription() {
        return "SKU product C + D for $35";
    }
}
