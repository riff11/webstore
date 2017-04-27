package com.derkach.webstore.service;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
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

	/**
	 * 
	 * @param id
	 * @return list result or null if id == null.
	 */
	public List<Product> searchProduct(Integer id) {
		if (id == null)
			return null;
		return daoImpl.searchProduct(id);
	}

	public void addProduct(Product product) {
		System.out.print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + product);
		if (product != null)
			daoImpl.addProduct(product);
	}

	public void editProduct(Product product) {
		daoImpl.editProduct(product);
	}

	/**
	 * Delete product by name.
	 * 
	 * @param name
	 */
	public void deleteProduct(String name) {
		daoImpl.deleteProduct(name);
	}

	public List findAll() {
		return daoImpl.findAll();
	}

	public List<Product> searchProductByCategory(Integer i) {
		return daoImpl.searchProductByCategory(i);
	}

	// public void updateProduct(Product product) {
	// daoImpl.updateProduct(product);
	// }

	public void deleteProduct(Integer id) {
		if (id != null) {
			daoImpl.deleteProduct(id);
		}
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

	/**
	 * 
	 * @param file
	 * @param request
	 * @param session
	 * @param id
	 */
	public void uploadFile(MultipartFile file, HttpServletRequest request,
			HttpSession session, Integer id) {
		String orgName = file.getOriginalFilename();
		if (id == null)
			return;
		if (!orgName.equalsIgnoreCase("")) {
			if ((orgName.substring(orgName.length() - 4, orgName.length())
					.equalsIgnoreCase(".gif"))
					|| ((orgName.substring(orgName.length() - 4,
							orgName.length()).equalsIgnoreCase(".jpg")))
					|| ((orgName.substring(orgName.length() - 4,
							orgName.length()).equalsIgnoreCase(".png")))) {
				Integer y = 0;
				ServletContext context = session.getServletContext();
				String realContextPath = context.getRealPath("/");
				String filePath = realContextPath + "resources\\images\\"
						+ orgName;
				// Collection<Product> t = (Collection<Product>) findAll();
				// if (id == 0) {
				// if (lastId != t.size()) {
				// y = t.size();
				// lastId = y;
				// }
				// } else {
				y = id;
				// }
				// for (Product e : t) {
				// if (e.getId().intValue() == (y)) {
				// e.setImageLink("resources/images/" + orgName);
				// save(e);
				// break;
				// }
				// }
				List<Product> list = searchProduct(id);
				if (list != null && !list.isEmpty()) {
					list.get(0).setImage("resources/images/" + orgName);
					editProduct(list.get(0));
				}
				File dest = new File(filePath);
				try {
					file.transferTo(dest);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
