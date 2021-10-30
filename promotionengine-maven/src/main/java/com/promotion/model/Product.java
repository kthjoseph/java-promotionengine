package com.promotion.model;

import lombok.Getter;
import lombok.Setter;

public abstract class Product {
    @Getter
    private String id;
    
    @Getter @Setter
    private double price;

    public Product(String id) {
        this.id = id;
    }
}
