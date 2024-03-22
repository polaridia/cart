package com.example.demo;

import com.example.demo.model.*;
import com.example.demo.repository.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProjectInit implements CommandLineRunner {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CartRepository cartRepository;

	@Override
	public void run(String... args) throws Exception {

//		Product prod1 = new Product("Fish Pie Mix 340G", 13.38, 1,
//				"https://digitalcontent.api.tesco.com/v2/media/ghs/b5ed138f-a103-494e-871c-662b1525a6b5/f0feac39-5da6-46f2-8fea-ba309a802334.jpeg?h=960&w=960",
//				"Excellent", 4.0);
//		Product prod2 = new Product("2 Yellow Fin Tuna Steaks 240G", 34.17, 1,
//				"https://digitalcontent.api.tesco.com/v2/media/ghs/3538699b-3035-4cce-a34b-e0aa9deeec49/4e988a6f-dde0-4bee-a4ff-803d54630a31.jpeg?h=225&w=225",
//				"Alright", 3.0);
//		Product prod3 = new Product("2 Skinless and Boneless Basa 250G", 10.00, 1,
//				"https://digitalcontent.api.tesco.com/v2/media/ghs/b14bdf40-34ca-4ee7-bc43-5b00a2f53ee4/eb4efe6d-4e13-4cca-86a3-917e071944fa.jpeg?h=960&w=960",
//				"Perfect", 5.0);
//
//		Cart cart1 = new Cart();
//		cart1
//		
//		productRepository.save(prod3);

		/*
		 * Produce newProduce = new Produce("Apple");
		 * produceRepository.save(newProduce);
		 */

		/*
		 * ProduceSellerPrice newPSPrice = new ProduceSellerPrice();
		 * newPSPrice.setProduce(newProduce); newPSPrice.setSeller(newUser);
		 * newPSPrice.setPrice(new BigDecimal(1)); priceRepository.save(newPSPrice);
		 */
		/*
		 * Iterable<ProduceSellerPrice> prices= priceRepository.findAll();
		 * prices.forEach((p)->{ System.out.println(p); });
		 */

	}
}
