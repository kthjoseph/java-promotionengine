package com.promotion.config;

import java.util.Calendar;

import com.promotion.model.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    @Bean(name = "skuProductA")
    public Product getSKUProductA() {
        Product product = new SKUProduct("A");
        product.setPrice(50);
        return product;
    }

    @Bean(name = "skuProductB")
    public Product getSKUProductB() {
        Product product = new SKUProduct("B");
        product.setPrice(30);
        return product;
    }

    @Bean(name = "skuProductC")
    public Product getSKUProductC() {
        Product product = new SKUProduct("C");
        product.setPrice(20);
        return product;
    }

    @Bean(name = "skuProductD")
    public Product getSKUProductD() {
        Product product = new SKUProduct("D");
        product.setPrice(15);
        return product;
    }

    @Bean(name = "orderA")
    public Order getOrderA() {
        Order order = new Order(1);
        order.setDateCreated(Calendar.getInstance().getTime());
        order.setStatus("Active");
        order.addProduct(getSKUProductA(), 1);
        order.addProduct(getSKUProductB(), 1);
        order.addProduct(getSKUProductC(), 1);
        return order;
    }

    @Bean(name = "orderB")
    public Order getOrderB() {
        Order order = new Order(2);
        order.setDateCreated(Calendar.getInstance().getTime());
        order.setStatus("Active");
        order.addProduct(getSKUProductA(), 5);
        order.addProduct(getSKUProductB(), 5);
        order.addProduct(getSKUProductC(), 1);
        return order;
    }

    @Bean(name = "orderC")
    public Order getOrderC() {
        Order order = new Order(3);
        order.setDateCreated(Calendar.getInstance().getTime());
        order.setStatus("Active");
        order.addProduct(getSKUProductA(), 3);
        order.addProduct(getSKUProductB(), 5);
        order.addProduct(getSKUProductC(), 1);
        order.addProduct(getSKUProductD(), 1);
        return order;
    }
}
