package com.springboot.chapter.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.chapter.entity.Product;
import com.springboot.chapter.repository.ProductRepository;
import com.springboot.chapter.service.ProductService;

import ch.qos.logback.classic.Logger;

@Controller 
@ResponseBody

//@RestController

@RequestMapping("product/")
public class ProductController {
	
	Logger logger = (Logger) LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService productService ;
	
	@PostMapping("save")
	public Product saveProduct(@RequestBody Product p ) throws Exception {
		
		logger.info("transaction start ");
		
		return productService.save(p);
	}

}
