package com.derkach.webstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.derkach.webstore.dao.ProductsDaoImpl;
import com.derkach.webstore.domain.Product;

@Service
public class ProductService {

	@Autowired
	ProductsDaoImpl daoImpl;

	public List<Product> searchProduct(Product product) {
		return daoImpl.searchProduct(product);
	}

	public List<Product> editProduct(Product product) {
		return daoImpl.editProduct(product);
	}

	public void deleteProduct(Product product) {
		daoImpl.deleteProduct(product);
	}

	public List<Product> findAll() {
		return daoImpl.findAll();
	}

	public List<Product> searchProductByCategory(Integer i) {
		return daoImpl.searchProductByCategory(i);
	}

	public void updateProduct(Product product) {
		daoImpl.updateProduct(product);
	}

	public List<Product> filter(ModelAndView mav, Integer categories_fk,
			Integer min, Integer max, Boolean available) {
		if (categories_fk != null && (min != null && min != 0)
				&& (max != null && max != 0) && available != null) {
			mav.addObject("min", min);
			mav.addObject("max", max);
			mav.addObject("available", available);
			return daoImpl.filter(categories_fk, min, max, available);

		} else if ((min != null && min != 0) && (max != null && max != 0)
				&& available != null) {
			mav.addObject("min", min);
			mav.addObject("max", max);
			mav.addObject("available", available);
			return daoImpl.filter(min, max, available);

		} else if (categories_fk != null && (min != null && min != 0)
				&& (max != null && max != 0)) {
			mav.addObject("min", min);
			mav.addObject("max", max);
			return daoImpl.filter(categories_fk, min, max);

		} else if ((min != null && min != 0) && (max != null && max != 0)) {
			mav.addObject("min", min);
			mav.addObject("max", max);
			return daoImpl.filter(min, max);

		} else if (categories_fk != null && available != null) {
			mav.addObject("available", available);
			return daoImpl.filter(categories_fk, available);

		} else if (categories_fk != null) {
			return daoImpl.searchProductByCategory(categories_fk);

		} else if (available != null) {
			mav.addObject("available", available);
			return daoImpl.filter(available);

		}

		return null;
	}

}
