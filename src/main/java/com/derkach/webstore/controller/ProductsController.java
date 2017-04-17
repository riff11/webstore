package com.derkach.webstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.derkach.webstore.service.CategoryService;
import com.derkach.webstore.service.ProductService;
import com.google.gson.Gson;

@Controller
public class ProductsController {

	private static final Logger logger = LoggerFactory
			.getLogger(ProductsController.class);
	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "catalog/{id}", method = RequestMethod.POST, produces = "application/json")
	public ModelAndView getProductsByCategory(@PathVariable("id") Integer id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("home");
		String typeSelected = request.getParameter("typeSelected");
		String childSelected = request.getParameter("childSelected");
		Gson gson = new Gson();
		String jsonCategoryRoot = gson.toJson(categoryService.findRoot());
		mav.addObject("productTypesRoot", jsonCategoryRoot);
		mav.addObject("list", productService.searchProductByCategory(id));
		mav.addObject("siblingsCategory", categoryService.findSiblings(id));
		return mav;
	}

}
