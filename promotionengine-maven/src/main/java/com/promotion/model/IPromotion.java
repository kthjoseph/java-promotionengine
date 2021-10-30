package com.promotion.model;

import java.util.List;

/**
 * Additional promotion should implement this interface and implement the new promotion logic
 * Then add the bean in AppConfig.java for the new promotion object
 * Then the promotion engine will reference to the corresponding list of promotion for calculate the price
 */
public interface IPromotion {
    double calculateTotalPrice(List<OrderProduct> orderProducts);

    String getPromotionDescription();
}
