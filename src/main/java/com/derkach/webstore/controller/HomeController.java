package com.derkach.webstore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.derkach.webstore.domain.Categories;
import com.derkach.webstore.domain.Category;
import com.derkach.webstore.service.CategoryService;
import com.derkach.webstore.service.ProductService;
import com.google.gson.Gson;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(
			@RequestParam(value = "min", required = false) Integer min,
			@RequestParam(value = "max", required = false) Integer max,
			@RequestParam(value = "available", required = false) Boolean available,
			Locale locale) {
		logger.info("Welcome home! the client locale is " + locale.toString());
		ModelAndView mav = new ModelAndView("home");
		Gson gson = new Gson();
		List<Category> categoriesRoot = categoryService.findRoot();
		
		Categories categories = new Categories();
		categories.setCategories((ArrayList<Category>) categoriesRoot);
		String jsonCategoryRoot = gson.toJson(categories);
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

	@RequestMapping(value = "catalog/{id}", method = RequestMethod.GET)
	public ModelAndView catalogId(
			Locale locale,
			@PathVariable("id") Integer id,
			@RequestParam(value = "min", required = false) Integer min,
			@RequestParam(value = "max", required = false) Integer max,
			@RequestParam(value = "available", required = false) Boolean available,
			Model model) {
		ModelAndView mav = new ModelAndView("home");
		Gson gson = new Gson();
		List<Category> categoriesRoot = categoryService.findRoot();
		Categories categories = new Categories();
		categories.setCategories((ArrayList<Category>) categoriesRoot);
		String jsonCategoryRoot = gson.toJson(categories);
		logger.info("jsonCategoryRoot " + jsonCategoryRoot);
		// Root category types
		mav.addObject("jsonCategoryRoot", jsonCategoryRoot);
		// looking for products
		mav.addObject("list",
				productService.filter(mav, id, min, max, available));
		// Child category products
		List<Category> categoriesSibling = categoryService.findSiblings(id);
		categories = new Categories();
		categories.setCategories((ArrayList<Category>) categoriesSibling);
		int i = categoriesSibling.get(0).getParentId();
		int rootSelected = 0;
		for (Category category : categoriesRoot) {
			rootSelected++;
			if (category.getId().equals(i)) {
				break;
			}
		}
		int childSelected = 0;
		for (Category category : categoriesSibling) {
			childSelected++;
			if (category.getId().equals(id)) {
				break;
			}
		}
		String jsonSibling = gson.toJson(categories);
		mav.addObject("jsonSiblingsCategory", jsonSibling);
		logger.info("siblingsCategory " + jsonSibling);
		// selected root category
		mav.addObject("rootSelected", rootSelected);
		logger.info("rootSelected " + rootSelected);
		// selected child category
		mav.addObject("childSelected", childSelected);
		logger.info("selected child category " + childSelected);

		return mav;
	}

}
