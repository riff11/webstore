package com.derkach.webstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.derkach.webstore.domain.Category;

/**
 * dao implementation
 * 
 * @author alex
 * 
 */
public class CategoriesDaoImpl implements CategoriesDao {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * insert category in to the db
	 */
	public void insertCategory(Category category) {

		String query = "insert into CategoryS (NAME,DOB,EMAIL,PHONE,ADDRESS,PINCODE,COUNTRY)"
				+ " VALUES (?,?,?,?,?,?,?)";

//		jdbcTemplate.update(query,
//				new Object[] { category.getName(), category.getDate(), category.getEmail(),
//						category.getPhone(), category.getAddress(), category.getPincode(),
//						category.getCountry() });

	}

	/**
	 * delete category from db
	 */
	public void deleteCategory1(Category Category) {

		String query = "delete from CategoryS where ID='" + Category.getId() + "'";

		jdbcTemplate.update(query);

	}

//	/**
//	 * search category in db
//	 * 
//	 * @return List<Category>
//	 */
//	public List<Category> searchCategory1(Category Category) {
//
//		String queryinitial = "select * from CategoryS where NAME ='"
//				+ Category.getName() + "'";
//
//		System.out.println("query formed with all the argument - "
//				+ queryinitial);
//
//		RowMapper rm = null;
////		List<Category> listcontacct = jdbcTemplate.query(queryinitial,
////				new RowMapper() {
////					public Object mapRow(ResultSet resultSet, int rowNum)
////							throws SQLException {
////						return new Category(resultSet.getInt("id"), resultSet
////								.getString("name"), resultSet.getString("dob"),
////								resultSet.getString("email"), resultSet
////										.getString("phone"), resultSet
////										.getString("address"), resultSet
////										.getString("PINCODE"), resultSet
////										.getString("country"));
////					}
////				});
//
//		return listcontacct;
//	}

//	/**
//	 * find category in db
//	 * 
//	 * @return List<Category>
//	 */
//	public List<Category> findAll() {
//		String queryinitial = "select * from CategoryS ";
//
//		System.out.println("query formed with all the argument - "
//				+ queryinitial);
//
//		RowMapper rm = null;
//		List<Category> CategoryList = jdbcTemplate.query(queryinitial, new RowMapper() {
//			public Object mapRow(ResultSet resultSet, int rowNum)
//					throws SQLException {
//				return new Category(resultSet.getInt("id"), resultSet
//						.getString("name"), resultSet.getString("dob"),
//						resultSet.getString("email"), resultSet
//								.getString("phone"), resultSet
//								.getString("address"), resultSet
//								.getString("PINCODE"), resultSet
//								.getString("country"));
//			}
//		});
//
//		return CategoryList;
//	}

//	/**
//	 * update category record
//	 */
//	public void updateCategory1(Category Category) {
//		String queryinitial = "update CategoryS set name='" + Category.getName()
//				+ "', email='" + Category.getEmail() + "', dob='" + Category.getDate()
//				+ "',phone='" + Category.getPhone() + "', address='"
//				+ Category.getAddress() + "' , pincode='" + Category.getPincode()
//				+ "', country='" + Category.getCountry() + "' where id='"
//				+ Category.getId() + "'";
//
//		jdbcTemplate.update(queryinitial);
//
//		System.out.println("query formed with all the argument - "
//				+ queryinitial);
//	}

	@Override
	public void searchCategory(Category category) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Category> editCategory(Category Category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCategory(Category category) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
