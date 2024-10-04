package com.springboot.chapter.repository;


import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.springboot.chapter.entity.Product;

import ch.qos.logback.classic.Logger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.Data;

@Repository
@Transactional
@Data
public class ProductRepository {
	
	
	
	
	@PersistenceContext
	EntityManager entityManager;
	
	
	public Product save(Product product) {
		

		entityManager.persist(product);
		

		
		TypedQuery<Product> t = entityManager.createQuery("select p from Product p where name =:name",Product.class);
		t.setParameter("name", product.getName());
		
		
      
		return t.getSingleResult();
	}

}
