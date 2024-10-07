package com.springboot.chapter.DummyData;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.chapter.entity.Product;
import com.springboot.chapter.repository.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;



@Data
@Component
@RequiredArgsConstructor
public class ProductData {
	
	
	 ProductRepository  productRepository;
	
	Logger logger = LoggerFactory.getLogger(ProductData.class);
	
	
	
	public   void createHunderedProducts() {
		
		
		
		for (int i = 1; i <= 1000; i++) {
            Product product = new Product();
//            product.setId((long) i); // Set ID (assuming this is done manually)
            product.setName("Product " + i);
            product.setPrice(i * 10.0); // Example: Price is 10, 20, 30, ...
            product.setOffer(i % 2 == 0 ? "10% off" : "No offer"); // Alternate offers

            productRepository.save1(product);
            
            
            
           
        }

		
		
	}
	
	

}
