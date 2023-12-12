package com.jsp.spring_mvc_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.spring_mvc_crud.dao.ProductDao;
import com.jsp.spring_mvc_crud.dto.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao dao;

	public Product savProductService(Product product) {
		return dao.savProductDao(product);
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAllProductService() {
		return dao.getAllProductDao();
	}

	public void deleteProductByIdService(int productId) {
		dao.deleteProductByIdDao(productId);
	}

	public Product getProductByIdService(int productId) {
		return dao.getProductByIdDao(productId);
	}

	public Product updateProductByIdService(Product product) {

		return dao.updateProductByIdDao(product);
	}
}
