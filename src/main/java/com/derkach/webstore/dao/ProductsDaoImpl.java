package com.derkach.webstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.derkach.webstore.domain.Product;

/**
 * dao product implementation
 * 
 * @author alex
 * 
 */
@Repository
public class ProductsDaoImpl implements ProductsDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final Logger logger = LoggerFactory
			.getLogger(ProductsDaoImpl.class);

	/**
	 * Insert user in to the db.
	 */
	public void insertProduct(Product product) {

		String query = "insert into products (`name`, `price`, `producer_fk`, `categories_fk`, `image`, `description`, `available`)"
				+ " VALUES (?,?,?,?,?,?,?)";

		jdbcTemplate.update(
				query,
				new Object[] { product.getName(), product.getPrice(),
						product.getProducer_fk(), product.getCategories_fk(),
						product.getImage(), product.getDescription(),
						product.getAvailable() });

	}

	/**
	 * Delete user from db.
	 */
	public void deleteProduct(Product product) {

		String query = "delete from products where ID='" + product.getId()
				+ "'";

		jdbcTemplate.update(query);

	}

	/**
	 * Search user in db.
	 * 
	 * @return List<User>
	 */
	public List<Product> searchProduct(Product product) {

		String queryInitial = "select * from products where NAME ='"
				+ product.getName() + "'";

		logger.info("query formed with all the argument - " + queryInitial);

		return jdbcTemplateQuery(queryInitial);
	}

	/**
	 * Find user in db.
	 * 
	 * @return List<Product>
	 */
	public List<Product> findAll() {
		String queryInitial = "select * from products ";

		logger.info("query formed with all the argument - " + queryInitial);

		return jdbcTemplateQuery(queryInitial);
	}

	/**
	 * Update user record.
	 */
	public void updateProduct(Product product) {
		String queryinitial = "update products set name='" + product.getName()
				+ "', price='" + product.getPrice() + "', description='"
				+ product.getDescription() + "',image='" + product.getImage()
				+ "', available='" + product.getAvailable()
				+ "' , producer_fk='" + product.getProducer_fk()
				+ "', categories_fk='" + product.getCategories_fk()
				+ "' where id='" + product.getId() + "'";

		logger.info("query formed with all the argument - " + queryinitial);

		jdbcTemplate.update(queryinitial);

	}

	@Override
	public List<Product> editProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> searchProductByCategory(int i) {
		String queryInitial = "select * from products where categories_fk ='"
				+ i + "'";

		logger.info("query formed with all the argument - " + queryInitial);

		return jdbcTemplateQuery(queryInitial);
	}

	@Override
	public List<Product> filter(int min, int max, boolean available) {
		String queryInitial = "select * from products where price between "
				+ min + " and " + max + " and " + " available="
				+ (available ? 1 : 0);

		logger.info("query formed with all the argument - " + queryInitial);

		return jdbcTemplateQuery(queryInitial);
	}

	@Override
	public List<Product> filter(boolean available) {

		String queryInitial = "select * from products where  available="
				+ (available ? 1 : 0);

		logger.info("query formed with all the argument - " + queryInitial);

		return jdbcTemplateQuery(queryInitial);
	}

	@Override
	public List<Product> filter(int min, int max) {
		String queryInitial = "select * from products where price between "
				+ min + " and " + max;

		logger.info("query formed with all the argument - " + queryInitial);

		return jdbcTemplateQuery(queryInitial);
	}

	@Override
	public List<Product> filter(int category_fk, int min, int max) {
		String queryInitial = "select * from products where categories_fk="
				+ category_fk + " and price between " + min + " and " + max;

		logger.info("query formed with all the argument - " + queryInitial);

		return jdbcTemplateQuery(queryInitial);
	}

	@Override
	public List<Product> filter(int category_fk, int min, int max,
			boolean available) {
		String queryInitial = "select * from products where categories_fk="
				+ category_fk + " and price between " + min + " and " + max
				+ " and " + " available=" + (available ? 1 : 0);

		logger.info("query formed with all the argument - " + queryInitial);

		return jdbcTemplateQuery(queryInitial);
	}

	@Override
	public List<Product> filter(int category_fk, boolean available) {
		String queryInitial = "select * from products where categories_fk="
				+ category_fk + " and " + " available=" + (available ? 1 : 0);

		logger.info("query formed with all the argument - " + queryInitial);

		return jdbcTemplateQuery(queryInitial);
	}

	protected List<Product> jdbcTemplateQuery(String queryInitial) {
		RowMapper rm = null;
		List<Product> userList = jdbcTemplate.query(queryInitial,
				new RowMapper() {
					public Object mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return new Product(resultSet.getInt("id"), resultSet
								.getString("name"), resultSet
								.getString("price"), resultSet
								.getString("description"), resultSet
								.getString("image"), resultSet
								.getString("available"), resultSet
								.getInt("producer_fk"), resultSet
								.getInt("categories_fk"));
					}
				});

		return userList;
	}

}
