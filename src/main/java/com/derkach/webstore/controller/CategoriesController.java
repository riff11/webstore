package com.derkach.webstore.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.derkach.webstore.domain.Category;
import com.derkach.webstore.service.CategoryService;

@Controller
public class CategoriesController {
	
	private static final Logger logger = LoggerFactory.getLogger(CategoriesController.class);
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "/categories/getRoot.json", method = RequestMethod.GET, produces= "application/json")
	public ModelAndView getRootCategory(){
		ModelAndView mav = new ModelAndView("home");
		List<Category> categories = categoryService.findRoot();
		mav.addObject("categories", categories);		
		return mav;		
	}
	
	@RequestMapping(value = "/categories/getlist.json", method = RequestMethod.POST, produces="application/json")
	public  @ResponseBody List getCategory(@RequestBody String categoryId){
		List<Category> categories = categoryService.searchCategoriesByParentsId(categoryId.replaceAll(String.valueOf('"'), ""));
//		mav.addObject("categories", categories);
		return categories;		
	}

}
