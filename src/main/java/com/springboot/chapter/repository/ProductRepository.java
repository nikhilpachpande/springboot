package com.springboot.chapter.repository;


import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.springboot.chapter.entity.Product;

import ch.qos.logback.classic.Logger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Repository
@Transactional
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRepository {
	
	
	
	
	@PersistenceContext
	EntityManager entityManager;
	
	
	public Product save(Product product) {
		

		entityManager.persist(product);
		

		
		TypedQuery<Product> t = entityManager.createQuery("select p from Product p where name =:name",Product.class);
		t.setParameter("name", product.getName());
		
		
      
		return t.getSingleResult();
	}
	
	public void save1 (Product product) {
		
		entityManager.persist(product);
		
	}
	
	public List<Product> getProducts(int page) {
		
		TypedQuery<Product> t = entityManager.createQuery("select p from Product p order by p.price desc ",Product.class);
		
		 int pagesize=5;
		 
		 t.setFirstResult(pagesize* page);
		 t.setMaxResults(pagesize);
		 
		 return t.getResultList();
		
		
		
		
	}

}
