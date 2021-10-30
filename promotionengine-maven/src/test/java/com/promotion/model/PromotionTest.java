package com.promotion.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.promotion.config.AppConfig;
import com.promotion.config.TestConfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {AppConfig.class, TestConfig.class})
class PromotionTest {
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
	@Qualifier("skuProductA")
	private Product skuProductA;

	@Autowired
	@Qualifier("skuProductB")
	private Product skuProductB;

	@Autowired
	@Qualifier("skuProductC")
	private Product skuProductC;

	@Autowired
	@Qualifier("skuProductD")
	private Product skuProductD;

	@Test
	void checkPromotionDescription() {
		assertEquals("3 of SKU product A's for $130", promotionA.getPromotionDescription());

		assertEquals("2 of SKU product B's for $45", promotionB.getPromotionDescription());

		assertEquals("SKU product C + D for $35", promotionC.getPromotionDescription());
	}

	@Test
	void checkPromotionA() {
		List<OrderProduct> orderProducts = new ArrayList<>();
		OrderProduct orderProduct = new OrderProduct(skuProductA);
		orderProduct.setQuantity(5);
		orderProducts.add(orderProduct);	
		assertEquals(230, promotionA.calculateTotalPrice(orderProducts));
	}

	@Test
	void checkPromotionALessThan3() {
		List<OrderProduct> orderProducts = new ArrayList<>();
		OrderProduct orderProduct = new OrderProduct(skuProductA);
		orderProduct.setQuantity(2);
		orderProducts.add(orderProduct);	
		assertEquals(100, promotionA.calculateTotalPrice(orderProducts));
	}

	@Test
	void checkPromotionAWithoutProductA() {
		List<OrderProduct> orderProducts = new ArrayList<>();
		OrderProduct orderProduct = new OrderProduct(skuProductB);
		orderProduct.setQuantity(5);
		orderProducts.add(orderProduct);	
		assertEquals(0, promotionA.calculateTotalPrice(orderProducts));
	}

	@Test
	void checkPromotionB() {
		List<OrderProduct> orderProducts = new ArrayList<>();
		OrderProduct orderProduct = new OrderProduct(skuProductB);
		orderProduct.setQuantity(5);
		orderProducts.add(orderProduct);	
		assertEquals(120, promotionB.calculateTotalPrice(orderProducts));
	}

	@Test
	void checkPromotionBLessThan2() {
		List<OrderProduct> orderProducts = new ArrayList<>();
		OrderProduct orderProduct = new OrderProduct(skuProductB);
		orderProduct.setQuantity(1);
		orderProducts.add(orderProduct);	
		assertEquals(30, promotionB.calculateTotalPrice(orderProducts));
	}

	@Test
	void checkPromotionBWithoutProductB() {
		List<OrderProduct> orderProducts = new ArrayList<>();
		OrderProduct orderProduct = new OrderProduct(skuProductA);
		orderProduct.setQuantity(5);
		orderProducts.add(orderProduct);	
		assertEquals(0, promotionB.calculateTotalPrice(orderProducts));
	}

	@Test
	void checkPromotionC() {
		List<OrderProduct> orderProducts = new ArrayList<>();
		OrderProduct orderProduct = new OrderProduct(skuProductC);
		orderProduct.setQuantity(4);
		orderProducts.add(orderProduct);
		orderProduct = new OrderProduct(skuProductD);
		orderProduct.setQuantity(5);
		orderProducts.add(orderProduct);
		assertEquals(135, promotionC.calculateTotalPrice(orderProducts));
	}

	@Test
	void checkPromotionCWithoutProductC() {
		List<OrderProduct> orderProducts = new ArrayList<>();
		OrderProduct orderProduct = new OrderProduct(skuProductD);
		orderProduct.setQuantity(5);
		orderProducts.add(orderProduct);
		assertEquals(75, promotionC.calculateTotalPrice(orderProducts));
	}

	@Test
	void checkPromotionCWithoutProductD() {
		List<OrderProduct> orderProducts = new ArrayList<>();
		OrderProduct orderProduct = new OrderProduct(skuProductC);
		orderProduct.setQuantity(4);
		orderProducts.add(orderProduct);
		assertEquals(80, promotionC.calculateTotalPrice(orderProducts));
	}
}
