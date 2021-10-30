package com.promotion.promotionenginemaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PromotionengineMavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(PromotionengineMavenApplication.class, args);

		// -- Test only
		// ApplicationContext ctx = new
		// AnnotationConfigApplicationContext(AppConfig.class);
		// IPromotionEngine myEngine = ctx.getBean(IPromotionEngine.class);
		// System.out.println(myEngine.getPromotionDescriptions());
	}

}
