package com.derkach.webstore.dao;

import java.util.List;

import com.derkach.webstore.domain.Producer;

/**
 * Dao interface.
 * 
 * @author alex
 *
 */
public interface ProducersDao {

	List<Producer> searchProducer(Producer producer);

	void editProducer(Producer producer);

	void deleteProducerByName(String name);

	void deleteProducerById(Integer id);

	List<Producer> findAll();

	void addProducer(Producer producer);

}
