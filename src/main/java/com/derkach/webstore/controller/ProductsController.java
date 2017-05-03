package com.derkach.webstore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.derkach.webstore.domain.Categories;
import com.derkach.webstore.domain.Category;
import com.derkach.webstore.domain.Producer;
import com.derkach.webstore.domain.Product;
import com.derkach.webstore.service.CategoryService;
import com.derkach.webstore.service.ProductService;
import com.derkach.webstore.service.ProducerService;
import com.google.gson.Gson;

@Controller
public class ProductsController {

	private static final Logger logger = LoggerFactory
			.getLogger(ProductsController.class);
	@Autowired
	ProductService productService;

	@Autowired
	ProducerService producerService;

	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "admin/deleteProduct", method = { RequestMethod.GET })
	public String delProd(Model model) {
		logger.info("delete product view");
		List list = productService.findAll();
		System.out.println(list);
		model.addAttribute("list", list);
		return "product/deleteProduct";
	}

	@RequestMapping(value = "admin/deleteProduct", method = { RequestMethod.POST })
	public String delProd(@RequestParam("name") String name) {
		logger.info("delete product by name");
		productService.deleteProduct(name);
		return "redirect:/admin/deleteProduct";
	}

	@RequestMapping(value = "admin/editProducts", method = RequestMethod.GET)
	public ModelAndView editProGet(
			@PathVariable(value = "product", required = false) Product product,
			Model model) {
		ModelAndView mav = new ModelAndView("product/edit_products");
		List list = productService.findAll();
		System.out.println(list);
		model.addAttribute("list", list);
		// Root category types
		Gson gson = new Gson();
		List<Category> categoriesRoot = categoryService.findRoot();
		Categories categories = new Categories();
		categories.setCategories((ArrayList<Category>) categoriesRoot);		
		String jsonCategoryRoot = gson.toJson(categories);
		mav.addObject("jsonCategoryRoot", jsonCategoryRoot);
		logger.info("jsonCategoryRoot " + jsonCategoryRoot);

		// Producers
		List<Producer> producersList = producerService.findAll();		
		String jsonProducersList = gson.toJson(producersList);		
		mav.addObject("jsonProducersList", jsonProducersList);
		logger.info("jsonProducersList " + jsonProducersList);

		return mav;
	}

	@RequestMapping(value = "admin/editProducts", method = RequestMethod.POST)
	public ModelAndView editPro(@RequestBody Product product, Model model) {
		logger.info("..................admin/editProducts");
		productService.editProduct(product);
		ModelAndView mav = new ModelAndView("product/edit_products");
		List list = productService.findAll();
		System.out.println(list);
		model.addAttribute("list", list);
		// Root category types
		Gson gson = new Gson();
		List<Category> categoriesRoot = categoryService.findRoot();
		String jsonCategoryRoot = gson.toJson(categoriesRoot);
		mav.addObject("jsonCategoryRoot", jsonCategoryRoot);
		logger.info("jsonCategoryRoot " + jsonCategoryRoot);

		// Producers
		List<Producer> producersList = producerService.findAll();
		String jsonProducersList = gson.toJson(producersList);
		mav.addObject("jsonProducersList", jsonProducersList);
		logger.info("jsonProducersList " + jsonProducersList);

		return mav;
	}

	@RequestMapping(value = "admin/deleteFew", method = RequestMethod.POST)
	public String DeleteFew(@RequestBody ArrayList<Integer> indexList,
			Model model, HttpServletRequest request) {

		logger.info(" delete few products");
		if (indexList != null) {
			for (Integer id : indexList) {
				if (id != null) {
					productService.deleteProduct(id);
				}
			}
		}

		return "redirect:/admin/deleteProduct";
	}


	@RequestMapping(value = "admin/addProduct", method = RequestMethod.POST)
	public void addProduct(@RequestBody Product product) {
		logger.info("................add Product");
		productService.addProduct(product);
	}

	@RequestMapping(value = "admin/addProduct", method = RequestMethod.GET)
	public ModelAndView getProducts() {
		logger.info("Listing Walks");
		ModelAndView mav = new ModelAndView("product/addProduct");
		// Root category types
		Gson gson = new Gson();
		List<Category> categoriesRoot = categoryService.findRoot();
		Categories categories = new Categories();
		categories.setCategories((ArrayList<Category>) categoriesRoot);
		String jsonCategoryRoot = gson.toJson(categories);
		mav.addObject("jsonCategoryRoot", jsonCategoryRoot);
		logger.info("jsonCategoryRoot " + jsonCategoryRoot);

		List<Producer> producersList = producerService.findAll();
		String jsonProducersList = gson.toJson(producersList);
		mav.addObject("jsonProducersList", jsonProducersList);
		logger.info("jsonProducersList " + jsonProducersList);
		return mav;
	}

}
