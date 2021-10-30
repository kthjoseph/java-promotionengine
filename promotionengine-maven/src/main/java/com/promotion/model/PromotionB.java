package com.promotion.model;

import java.util.List;

public class PromotionB implements IPromotion {
    private static final int PromotionItemGroupCount = 2;
    private static final int PromotionPriceDeductionPerGroup = 15;

    @Override
    public double calculateTotalPrice(List<OrderProduct> orderProducts) {
        int iCount = 0;
        double totalPrice = 0;
        for (OrderProduct orderProduct : orderProducts) {
            if ("B".equals(orderProduct.getProductId())) {
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
        return "2 of SKU product B's for $45";
    }
}
