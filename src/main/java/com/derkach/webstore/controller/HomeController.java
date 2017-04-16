package com.derkach.webstore.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! the client locale is " + locale.toString());
		// model.addAttribute("ltype", "&lt=0");
		// Date date = new Date();
		// DateFormat dateFormat =
		// DateFormat.getDateTimeInstance(DateFormat.LONG,
		// DateFormat.LONG, locale);
		//
		// String formattedDate = dateFormat.format(date);
		//
		// model.addAttribute("link", "n=productName&s=asc");
		//
		// Page<Product> page = productService.findAllA(1, "productName");
		// if (!(request.getQueryString() == null)) {
		//
		// if (request.getParameter("s").equals("asc")) {
		// model.addAttribute("link", "n=" + request.getParameter("n")
		// + "&s=asc");
		// page = productService.findAllA(1, request.getParameter("n"));
		// } else {
		// page = productService.findAllD(1, "productName");
		// model.addAttribute("link", "n=" + request.getParameter("n")
		// + "&s=desc");
		// }
		//
		// }
		//
		// try {
		// Double l = new Double(request.getParameter("l"));
		// Double m = new Double(request.getParameter("m"));
		// model.addAttribute("ltype", "&lt=" + request.getParameter("lt"));
		// if (l > m) {
		// Double t;
		// t = l;
		// l = m;
		// m = t;
		// }
		// if (request.getParameter("s").equals("asc")) {
		// page = productService.findByPriceA(1,
		// request.getParameter("n"), l, m);
		// } else {
		// page = productService.findByPriceD(1,
		// request.getParameter("n"), l, m);
		// }
		// model.addAttribute("ltype", "&lt="
		// + request.getParameter("lt").toString());
		// model.addAttribute("price",
		// "&l=" + l.toString() + "&m=" + m.toString());
		//
		// } catch (Exception e) {
		// // TODO: handle exception
		// }

		// try {
		// Long l = new Long(request.getParameter("lt"));
		// model.addAttribute("ltype", "&lt=" + l.toString());
		// if (l != 0) {
		// ProductType pr = productTypeService.findOne(l);
		// page = productService.findByTypeA(1, "productName", pr);
		//
		// if (request.getParameter("s").equals("asc")) {
		// model.addAttribute("link", "n=" + request.getParameter("n")
		// + "&s=asc");
		// page = productService.findByTypeA(1,
		// request.getParameter("n"), pr);
		// } else {
		// page = productService.findByTypeD(1,
		// request.getParameter("n"), pr);
		// model.addAttribute("link", "n=" + request.getParameter("n")
		// + "&s=desc");
		// }
		// try {
		// Double l1 = new Double(request.getParameter("l"));
		// Double m = new Double(request.getParameter("m"));
		// model.addAttribute("ltype",
		// "&lt=" + request.getParameter("lt"));
		// if (l1 > m) {
		// Double t;
		// t = l1;
		// l1 = m;
		// m = t;
		// }
		// if (request.getParameter("s").equals("asc")) {
		// page = productService.findByTypePriceASC(1,
		// request.getParameter("n"), pr, l1, m);
		// } else {
		// page = productService.findByTypePriceDESC(1,
		// request.getParameter("n"), pr, l1, m);
		// }
		// model.addAttribute("ltype",
		// "&lt=" + request.getParameter("lt").toString());
		// model.addAttribute("price", "&l=" + l1.toString() + "&m="
		// + m.toString());
		//
		// } catch (Exception e) {
		// // TODO: handle exception
		// }
		//
		// }
		// } catch (Exception e) {
		// // TODO: handle exception
		// }

		// int current = page.getNumber() + 1;
		// int begin = Math.max(1, current - 5);
		// int end = Math.min(begin + 10, page.getTotalPages());
		// model.addAttribute("page", page);

		model.addAttribute("list", productService.findAll());
		// model.addAttribute("beginIndex", begin);
		// model.addAttribute("endIndex", end);
		// model.addAttribute("currentIndex", current);
		Gson gson = new Gson();
		String jsonCategoryRoot = gson.toJson(categoryService.findRoot());
		model.addAttribute("productTypesRoot", jsonCategoryRoot);
		// cart.setSumQuantity();
		// model.addAttribute("sumQuant", cart.getSumQuantity());
		return "home";

	}

}
