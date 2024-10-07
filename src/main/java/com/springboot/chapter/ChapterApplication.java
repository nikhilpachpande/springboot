package com.springboot.chapter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.springboot.chapter.DummyData.ProductData;
import com.springboot.chapter.repository.ProductRepository;



@SpringBootApplication
@EnableScheduling 
public class ChapterApplication implements CommandLineRunner {
	
	

	public static void main(String[] args) {
		SpringApplication.run(ChapterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		ProductData pd = new ProductData();
		
//	   pd.createHunderedProducts();
		
	}
	
	


}
