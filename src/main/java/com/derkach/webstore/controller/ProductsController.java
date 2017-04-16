package com.derkach.webstore.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.derkach.webstore.domain.Category;
import com.derkach.webstore.domain.Product;
import com.derkach.webstore.service.ProductService;

@Controller
public class ProductsController {

	private static final Logger logger = LoggerFactory
			.getLogger(ProductsController.class);

	@Autowired
	ProductService productService;

	@RequestMapping(value = "categories/getProducts.json", method = RequestMethod.POST, produces="application/json")
	public  @ResponseBody List  getProductsByCategory(@RequestBody String string) {
//		ModelAndView mav = new ModelAndView("home");
		List<Product> products = productService
				.searchProductByCategory(string.replaceAll(String.valueOf('"'), ""));
//		mav.addObject("list", products);
		return products;

	}

}
