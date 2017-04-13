package com.derkach.webstore.dao;


import java.util.List;

import com.derkach.webstore.domain.Producer;


/**
 * Dao interface.
 * @author alex
 *
 */
public interface ProducersDao {

	List<Producer> searchProducer(Producer producer);

	List<Producer> editProducer(Producer producer);
	
	void deleteProducer(Producer producer);
	
	List<Producer> findAll();
	
	void updateProducer(Producer producer);

}
