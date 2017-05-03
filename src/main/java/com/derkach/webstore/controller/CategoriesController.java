package com.derkach.webstore.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.derkach.webstore.domain.Categories;
import com.derkach.webstore.domain.Category;
import com.derkach.webstore.service.CategoryService;
//import com.google.gson.Gson;
import com.google.gson.Gson;

@Controller
public class CategoriesController {

	private static final Logger logger = LoggerFactory
			.getLogger(CategoriesController.class);

	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "catalog/getRoot", method = RequestMethod.GET, produces = {"application/json","application/xml"})
	public @ResponseBody Categories getRootCategory() {
//		ModelAndView mav = new ModelAndView("home");
		List<Category> categories = categoryService.findRoot();
		Categories categories2 = new Categories();
		categories2.setCategories((ArrayList<Category>) categories);
//		mav.addObject("categories", categories2);
		return categories2;
	}

	@RequestMapping(value = "catalog/getlist", method = RequestMethod.POST, produces = {"application/json","application/xml"})
	public @ResponseBody
	Categories getCategory(@RequestBody String categoryId) {
		List<Category> categories = categoryService
				.searchCategoriesByParentsId(categoryId.replaceAll(
						String.valueOf('"'), ""));
		Categories categories2 = new Categories();
		categories2.setCategories((ArrayList<Category>) categories);
//		 model.addAttribute("categories", categories2);
		return categories2;
	}	

	@RequestMapping(value = "admin/addCategory", method = RequestMethod.POST)
	public void addProductType(@RequestBody Category value) {
		logger.info("..............add category");
		categoryService.addCategory(value);
	}

	@RequestMapping(value = "admin/addCategory", method = RequestMethod.GET)
	public ModelAndView addProductType() {
		ModelAndView modelAndView = new ModelAndView("category/addCategory");
		Categories categories = getRootCategory();
		Gson gson = new Gson();
		String jsonCategoryRoot = gson.toJson(categories);
		// Root category types
		modelAndView.addObject("jsonCategoryRoot", jsonCategoryRoot);
		logger.info("jsonCategoryRoot " + jsonCategoryRoot);
		return modelAndView;
	}

	@RequestMapping(value = "admin/deleteCategory", method = RequestMethod.POST)
	public void deleteProductType(@RequestBody Category category) {
		logger.info("...............delete category");
		categoryService.deleteCategory(category);
	}

}
