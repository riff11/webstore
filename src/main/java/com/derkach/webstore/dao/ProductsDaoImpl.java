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
	@Override
	public void addProduct(Product product) {

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
	public List findAll() {
		String queryInitial = "select  products.categories_fk, products.id, products.name, products.price, products.image, products.description, products.available, categories.name as category , producers.name as producer from products inner join categories on  products.categories_fk=categories.id    inner join  producers on products.producer_fk = producers.id";

		logger.info("query formed with all the argument - " + queryInitial);

		return jdbcTemplateQueryAll(queryInitial);
	}

	protected List<Product> jdbcTemplateQueryAll(String queryInitial) {
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
								.getBoolean("available"), resultSet
								.getString("producer"), resultSet
								.getString("category"));
					}
				});

		return userList;
	}

	/**
	 * Update user record.
	 */
	@Override
	public void editProduct(Product product) {
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
								.getBoolean("available"), resultSet
								.getInt("producer_fk"), resultSet
								.getInt("categories_fk"));
					}
				});

		return userList;
	}

	@Override
	public void deleteProduct(int id) {
		String query = "delete from products where id='" + id + "'";

		jdbcTemplate.update(query);

	}

	@Override
	public List<Product> searchProduct(int id) {
		String queryInitial = "select * from products where id ='" + id + "'";

		logger.info("query formed with all the argument - " + queryInitial);

		return jdbcTemplateQuery(queryInitial);
	}

	@Override
	public void deleteProduct(String name) {
		String query = "delete from products where name='" + name + "'";
		jdbcTemplate.update(query);

	}

}
