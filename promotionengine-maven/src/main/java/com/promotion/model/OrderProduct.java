package com.promotion.model;

import lombok.Getter;
import lombok.Setter;

public class OrderProduct {
    @Getter
    private String productId;

    @Getter
    private Product product;
    
    @Getter @Setter
    private int quantity;

    public OrderProduct(Product product) {
        this.productId = product.getId();
        this.product = product;
    }

    public double getTotalPrice() {
        return quantity * product.getPrice();
    }
}
