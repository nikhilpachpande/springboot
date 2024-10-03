package com.springboot.chapter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.chapter.entity.Product;
import com.springboot.chapter.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public Product save(Product product) throws Exception {
		
		if(product.getName().isBlank() )  throw new Exception("name field can not be blank");
		
		return  productRepository.save(product);
		
	
		
		
	}

}
