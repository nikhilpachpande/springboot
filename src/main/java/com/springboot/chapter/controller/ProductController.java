package com.springboot.chapter.controller;


import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.chapter.entity.Product;
import com.springboot.chapter.repository.ProductRepository;
import com.springboot.chapter.service.ProductService;







@Controller 
@ResponseBody

//@RestController

@RequestMapping("product/")
public class ProductController {
	
	final Logger logger = LoggerFactory.getLogger(ProductController.class);
	

	
	@Autowired
	ProductService productService ;
	
	@PostMapping("save")
	public Product saveProduct(@RequestBody Product p ) throws Exception {
		
		logger.info("save method invoked by the controller");
		
		return productService.save(p);
	}
	
	
	@Cacheable
	@GetMapping("product-list/{page}")
	public ResponseEntity<?> allProducts( @PathVariable int page){
		
		
		if(page>=0) {
			List<Product> list = productService.getAllProducts(page);
			
			return ResponseEntity.ok().body(list);
			
		}
		
		else  return ResponseEntity.badRequest().body("no page available");
		
		
		
	}
	
	@Scheduled(cron= "0/10 * * ? * *")
	public void printDate() {
		
		logger.info(LocalDateTime.now().toString());
	}

}
