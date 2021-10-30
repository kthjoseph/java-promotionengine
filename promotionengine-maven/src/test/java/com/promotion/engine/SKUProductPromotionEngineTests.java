package com.promotion.engine;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.promotion.config.AppConfig;
import com.promotion.config.TestConfig;
import com.promotion.model.IPromotion;
import com.promotion.model.Order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = { AppConfig.class, TestConfig.class })
class SKUProductPromotionEngineTests {
	@Autowired
	@Qualifier("promotionA")
	private IPromotion promotionA;

	@Autowired
	@Qualifier("promotionB")
	private IPromotion promotionB;

	@Autowired
	@Qualifier("promotionC")
	private IPromotion promotionC;

	@Autowired
	private IPromotionEngine myEngine;

	@Autowired
	@Qualifier("orderA")
	private Order orderA;

	@Autowired
	@Qualifier("orderB")
	private Order orderB;

	@Autowired
	@Qualifier("orderC")
	private Order orderC;

	@Test
	void checkPromotionInit() {
		List<String> descriptions = myEngine.getPromotionDescriptions();
		assertEquals(3, descriptions.size());
		assertEquals(promotionA.getPromotionDescription(), descriptions.get(0));

		assertEquals(promotionB.getPromotionDescription(), descriptions.get(1));

		assertEquals(promotionC.getPromotionDescription(), descriptions.get(2));
	}

	@Test
	void testScenarioA() {
		double totalPrice = myEngine.calculateOrderPrice(orderA);
		assertEquals(100, totalPrice, "Scenario A's total price should be $100");
	}

	@Test
	void testScenarioB() {
		double totalPrice = myEngine.calculateOrderPrice(orderB);
		assertEquals(370, totalPrice, "Scenario B's total price should be $370");
	}

	@Test
	void testScenarioC() {
		double totalPrice = myEngine.calculateOrderPrice(orderC);
		assertEquals(280, totalPrice, "Scenario C's total price should be $280");
	}
}
