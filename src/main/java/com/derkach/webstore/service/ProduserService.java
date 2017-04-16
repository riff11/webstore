package com.derkach.webstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derkach.webstore.dao.ProducersDaoImpl;
import com.derkach.webstore.domain.Producer;

@Service
public class ProduserService {
	
	@Autowired
	ProducersDaoImpl daoImpl;
	
	List<Producer> searchProducer(Producer producer){
		return daoImpl.searchProducer(producer);
	}

	List<Producer> editProducer(Producer producer){
		return daoImpl.editProducer(producer);
	}
	
	void deleteProducer(Producer producer){
		daoImpl.deleteProducer(producer);
	}
	
	List<Producer> findAll(){
		return daoImpl.findAll();
	}
	
	void updateProducer(Producer producer){
		daoImpl.updateProducer(producer);
	}

}
