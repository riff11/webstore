package com.derkach.webstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derkach.webstore.dao.ProducersDaoImpl;
import com.derkach.webstore.domain.Producer;

@Service
public class ProducerService {

	@Autowired
	ProducersDaoImpl daoImpl;

	public List<Producer> searchProducer(Producer producer) {
		return daoImpl.searchProducer(producer);
	}

	public void editProducer(Producer producer) {
		daoImpl.editProducer(producer);
	}

	public void addProducer(Producer producer) {
		daoImpl.addProducer(producer);
	}

	public void deleteProducer(Producer producer) {
		daoImpl.deleteProducer(producer);
	}

	public List<Producer> findAll() {
		return daoImpl.findAll();
	}
}
