package com.promotion.config;

import java.util.ArrayList;
import java.util.List;

import com.promotion.engine.*;
import com.promotion.model.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name = "promotionA")
    public IPromotion getPromotionA() {
        return new PromotionA();
    }

    @Bean(name = "promotionB")
    public IPromotion getPromotionB() {
        return new PromotionB();
    }

    @Bean(name = "promotionC")
    public IPromotion getPromotionC() {
        return new PromotionC();
    }

    @Bean
    public IPromotionEngine getEngine() {
        return new SKUProductPromotionEngine();
    }

    @Bean
    public List<IPromotion> getPromotions() {
        // -- should be retrieve from database to know which promotion is active when application initialize
        List<IPromotion> promotions = new ArrayList<>();
        promotions.add(getPromotionA());
        promotions.add(getPromotionB());
        promotions.add(getPromotionC());
        return promotions;
    }
}
