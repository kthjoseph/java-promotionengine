package com.promotion.model;

import java.util.List;

public class PromotionA implements IPromotion {
    private static final int PromotionItemGroupCount = 3;
    private static final int PromotionPriceDeductionPerGroup = 20;

    @Override
    public double calculateTotalPrice(List<OrderProduct> orderProducts) {
        int iCount = 0;
        double totalPrice = 0;
        for (OrderProduct orderProduct : orderProducts) {
            if ("A".equals(orderProduct.getProductId())) {
                iCount = orderProduct.getQuantity();
                totalPrice = orderProduct.getTotalPrice();
            }
        }

        if (iCount > 0) {
            int iNumOfPromotionGroup = iCount / PromotionItemGroupCount;
            if (iNumOfPromotionGroup > 0) {
                // deduct the total price with promotion
                totalPrice -= iNumOfPromotionGroup * PromotionPriceDeductionPerGroup;
            }
        }

        return totalPrice;
    }

    @Override
    public String getPromotionDescription() {
        return "3 of SKU product A's for $130";
    }
}
