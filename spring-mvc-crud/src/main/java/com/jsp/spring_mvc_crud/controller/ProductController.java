package com.jsp.spring_mvc_crud.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.spring_mvc_crud.dto.Product;
import com.jsp.spring_mvc_crud.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public ModelAndView getMessage() {

		ModelAndView andView = new ModelAndView("home");

		andView.addObject("product", new Product());

		return andView;
	}

	@RequestMapping(value = "/saveProduct")
	public ModelAndView saveProductController(Product product) {
        
		productService.savProductService(product);
		ModelAndView andView = new ModelAndView("home");
		andView.addObject("message", "one product added successfully");
		return andView;
	}

	@RequestMapping(value = "/getAllProduct")
	public ModelAndView getAllProductController(@ModelAttribute Product product) {
        System.out.println(product);
		ModelAndView andView = new ModelAndView("display");

		andView.addObject("productData", productService.getAllProductService());

		return andView;
	}

	@RequestMapping(value = "/deleteProduct")
	public ModelAndView deleteProductByIdController(int id) {

		productService.deleteProductByIdService(id);

		ModelAndView andView = new ModelAndView("display");

		andView.addObject("productData", productService.getAllProductService());

		return andView;
	}

	@RequestMapping(value = "/updateProduct")
	public ModelAndView openUpdateFormByProductIdController(int id) {

		ModelAndView andView = new ModelAndView("update-form");

		andView.addObject("update", productService.getProductByIdService(id));

		return andView;
	}

	@RequestMapping(value = "/productUpdate")
	public ModelAndView updateProductByIdController(Product product) {

		productService.updateProductByIdService(product);
		
		ModelAndView andView = new ModelAndView("display");

		andView.addObject("productData", productService.getAllProductService());

		return andView;
	}

}
