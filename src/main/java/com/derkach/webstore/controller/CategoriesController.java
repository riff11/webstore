package com.derkach.webstore.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.derkach.webstore.domain.Category;
import com.derkach.webstore.service.CategoryService;
import com.google.gson.Gson;

@Controller
public class CategoriesController {

	private static final Logger logger = LoggerFactory
			.getLogger(CategoriesController.class);

	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "catalog/getRoot.json", method = RequestMethod.GET, produces = "application/json")
	public ModelAndView getRootCategory() {
		ModelAndView mav = new ModelAndView("home");
		List<Category> categories = categoryService.findRoot();
		mav.addObject("categories", categories);
		return mav;
	}

	@RequestMapping(value = "catalog/getlist.json", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody
	List getCategory(@RequestBody String categoryId) {
		List<Category> categories = categoryService
				.searchCategoriesByParentsId(categoryId.replaceAll(
						String.valueOf('"'), ""));
		// mav.addObject("categories", categories);
		return categories;
	}

	@RequestMapping(value = "admin/addCategory.json", method = RequestMethod.POST)
	public void addProductType(@RequestBody Category value) {
		System.out.println("!!!!!!!!!!addCategory");
		System.out.println(value.getName() + " " + value.getParentId());
		categoryService.addCategory(value);
	}

	@RequestMapping(value = "admin/addCategory", method = RequestMethod.GET)
	public ModelAndView addProductType() {
		ModelAndView modelAndView = new ModelAndView("category/addCategory");
		List<Category> categoriesRoot = categoryService.findRoot();
		Gson gson = new Gson();
		String jsonCategoryRoot = gson.toJson(categoriesRoot);
		// Root category types
		modelAndView.addObject("jsonCategoryRoot", jsonCategoryRoot);
		logger.info("jsonCategoryRoot " + jsonCategoryRoot);
		return modelAndView;
	}

	@RequestMapping(value = "admin/deleteCategory.json", method = RequestMethod.POST)
	public void deleteProductType(@RequestBody Category category) {
		System.out.println("!!!!!!!!!!deleteCategory");
		categoryService.deleteCategory(category);
	}

}
