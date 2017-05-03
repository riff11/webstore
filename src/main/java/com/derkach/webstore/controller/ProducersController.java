package com.derkach.webstore.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.derkach.webstore.domain.Producer;
import com.derkach.webstore.domain.Producers;
import com.derkach.webstore.service.ProducerService;

@Controller
public class ProducersController {
	@Autowired
	ProducerService producerService;
	private static final Logger logger = LoggerFactory
			.getLogger(ProducersController.class);


	@RequestMapping(value = "admin/addProducers", method = RequestMethod.POST)
	public void addProducer(@RequestBody String name) {
		producerService.addProducer(new Producer(null, name));
	}

	@RequestMapping(value = "admin/addProducers", method = RequestMethod.GET)
	public ModelAndView addProducer() {
		ArrayList<Producer> producers = (ArrayList<Producer>) producerService
				.findAll();
		Producers producersList = new Producers();
		producersList.setProducers(producers);
		ModelAndView andView = new ModelAndView("producer/addProducers");
		andView.addObject("list", producers);
		return andView;
	}

	@RequestMapping(value = "admin/deleteProducers", method = RequestMethod.POST)
	public String deleteProducers(
			@RequestBody String name) {
		producerService.deleteProducerByName(name);
		return "redirect:/admin/addProducers";
	}

	@RequestMapping(value = "admin/deleteFewProducers", method = RequestMethod.POST)
	public String deleteProducersList(
			@RequestBody ArrayList<Integer> indexList, Model model,
			HttpServletRequest request) {
		logger.info(" delete few products");
		if (indexList != null) {
			for (Integer id : indexList) {
				if (id != null) {
					producerService.deleteProducerById(id);
				}
			}
		}
		return "redirect:/admin/addProducers";
	}

}
