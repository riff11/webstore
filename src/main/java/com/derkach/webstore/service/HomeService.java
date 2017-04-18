package com.derkach.webstore.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.derkach.webstore.controller.HomeController;

@Service
public class HomeService {
	@Autowired
	ProductService productService;
	private static final Logger logger = LoggerFactory
			.getLogger(HomeService.class);

	public boolean filter(ModelAndView mav, Integer min, Integer max,
			Boolean available) {
		if (min != null && min != 0 || max != null && max != 0) {
			mav.addObject("list", productService.filter(min, max, available));
			mav.addObject("min", min);
			mav.addObject("max", max);
			mav.addObject("max", available);
			logger.info("price filter min=" + min + "max=" + max + "available"
					+ available);
			return true;
		}

		return false;
	}

}
