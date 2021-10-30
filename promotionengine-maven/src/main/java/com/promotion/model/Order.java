package com.promotion.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class Order {
    @Getter
    private int orderId;

    @Getter @Setter
    private Date dateCreated;

    @Getter @Setter
    private String status;

    @Getter 
    private List<OrderProduct> orderProducts = new ArrayList<>();

    public Order(int orderId) {
        this.orderId = orderId;
    }

    public void addProduct(Product product, int quantity) {
        OrderProduct orderProduct = new OrderProduct(product);
        orderProduct.setQuantity(quantity);
        orderProducts.add(orderProduct);
    }

    public void removeProduct(Product product, int quantity) {
        for (OrderProduct orderProduct : orderProducts) {
            if (orderProduct.getProductId().equals(product.getId())) {
                int diff = orderProduct.getQuantity() - quantity;
                if (diff <= 0) {
                    orderProducts.remove(orderProduct);
                } else {
                    orderProduct.setQuantity(diff);
                }
            }
        }
    }
}
