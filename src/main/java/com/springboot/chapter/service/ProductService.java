package com.springboot.chapter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.chapter.entity.Product;
import com.springboot.chapter.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public Product save(Product product) throws Exception {
		

//		for (int i = 1; i <= 1000; i++) {
//            Product product1 = new Product();
////            product.setId((long) i); // Set ID (assuming this is done manually)
//            product1.setName("Product " + i);
//            product1.setPrice(i * 10.0); // Example: Price is 10, 20, 30, ...
//            product1.setOffer(i % 2 == 0 ? "10% off" : "No offer"); // Alternate offers
//
//            productRepository.save1(product1);
//		}
		if(product.getName().isBlank() )  throw new Exception("name field can not be blank");
		
		return  productRepository.save(product);
		
	
		
		
	}
	
	public List<Product> getAllProducts(int page) {
		
		
		return productRepository.getProducts(page);
		
	}

}
