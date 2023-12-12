package com.jsp.spring_mvc_crud.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jsp.spring_mvc_crud.dto.Product;

@Repository
public class ProductDao {

	EntityManager entityManager =
			Persistence.createEntityManagerFactory("satyam").createEntityManager();
	EntityTransaction  entityTransaction = entityManager.getTransaction();
	
	public Product savProductDao(Product product) {
		
		
		entityTransaction.begin();
		entityManager.persist(product);
		entityTransaction.commit();
		
		return product;
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getAllProductDao(){
		
		return entityManager.createQuery("From Product").getResultList();
	}
	
	public void deleteProductByIdDao(int productId) {
		
		Product product=entityManager.find(Product.class, productId);
		
		if(product!=null) {
			entityTransaction.begin();
			entityManager.remove(product);
			entityTransaction.commit();
		}
	}
	
	public Product getProductByIdDao(int productId) {
		return entityManager.find(Product.class, productId);
		
	}
	
	public Product updateProductByIdDao(Product product) {
		
			entityTransaction.begin();
			entityManager.merge(product);
			entityTransaction.commit();
			
			return product;
	}
	
}
