package com.derkach.webstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.derkach.webstore.domain.Category;
import com.derkach.webstore.domain.Product;

/**
 * dao implementation
 * 
 * @author alex
 * 
 */
@Repository
public class ProductsDaoImpl implements ProductsDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

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

		String queryinitial = "select * from products where NAME ='"
				+ product.getName() + "'";

		System.out.println("query formed with all the argument - "
				+ queryinitial);

		RowMapper rm = null;
		List<Product> listcontacct = jdbcTemplate.query(queryinitial,
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

		return listcontacct;
	}

	/**
	 * Find user in db.
	 * 
	 * @return List<Product>
	 */
	public List<Product> findAll() {
		String queryinitial = "select * from products ";

		System.out.println("query formed with all the argument - "
				+ queryinitial);

		RowMapper rm = null;
		List<Product> userList = jdbcTemplate.query(queryinitial,
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

		System.out.println("query formed with all the argument - "
				+ queryinitial);

		jdbcTemplate.update(queryinitial);

	}

	@Override
	public List<Product> editProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> searchProductByCategory(Integer i) {
		String queryinitial = "select * from products where categories_fk ='"
				+ i + "'";

		System.out.println("query formed with all the argument - "
				+ queryinitial);

		RowMapper rm = null;
		List<Product> listcontacct = jdbcTemplate.query(queryinitial,
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

		return listcontacct;
	}



	@Override
	public List<Product> filter(int min, int max, boolean available) {
		String queryinitial = "select * from products where price between "
				+ min + " and " + max + " and " + " available=" + (available?1:0);

		System.out.println("query formed with all the argument - "
				+ queryinitial);

		RowMapper rm = null;
		List<Product> userList = jdbcTemplate.query(queryinitial,
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
