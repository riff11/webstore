package com.derkach.webstore.controller;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
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
	@Autowired
	private Jaxb2Marshaller marshaller;

	@RequestMapping(value = "admin/addProducers", method = RequestMethod.POST)
	public void addProductType(@RequestParam(value = "producerName") String name) {
		producerService.addProducer(new Producer(null, name));
	}

	@RequestMapping(value = "admin/addProducers", method = RequestMethod.GET)
	public ModelAndView addProductType() {
		ArrayList<Producer> producers = (ArrayList<Producer>) producerService
				.findAll();
//		marshaller.m
		Producers producersList = new Producers();
//		producersList.setProducers(producers);
		File file = new File("C:\\file.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Producer.class);
		Marshaller jaxbMarshaller = (Marshaller) jaxbContext.createMarshaller();
		// output pretty printed
		// jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

//		jaxbMarshaller.marshal(producersList, file);
//		jaxbMarshaller.marshal(producersList, System.out);
		ModelAndView andView = new ModelAndView("producer/addProducers");
		return andView;
	}

	@RequestMapping(value = "admin/deleteProducers", method = RequestMethod.POST)
	public void deleteProductType(
			@RequestParam(value = "producerName") String name) {
		producerService.deleteProducer(new Producer(null, name));
	}
}
