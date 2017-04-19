package com.derkach.webstore.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.derkach.webstore.domain.Category;
import com.derkach.webstore.service.CategoryService;
import com.derkach.webstore.service.ProductService;
import com.google.gson.Gson;

@Controller
public class EnterController {
	private static final Logger logger = LoggerFactory
			.getLogger(EnterController.class);

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@RequestMapping(method = RequestMethod.GET, value = "/admin")
	public ModelAndView enter(
			@RequestParam(value = "min", required = false) Integer min,
			@RequestParam(value = "max", required = false) Integer max,
			@RequestParam(value = "available", required = false) Boolean available) {
		ModelAndView mav = new ModelAndView("admin");
		Gson gson = new Gson();
		List<Category> categoriesRoot = categoryService.findRoot();
		String jsonCategoryRoot = gson.toJson(categoriesRoot);
		// Root category types
		mav.addObject("jsonCategoryRoot", jsonCategoryRoot);
		logger.info("jsonCategoryRoot " + jsonCategoryRoot);
		// Add products
		if (max == null && max == null && available == null) {
			mav.addObject("list", productService.findAll());
		} else {
			mav.addObject("list",
					productService.filter(mav, null, min, max, available));
		}

		return mav;

	}
}
