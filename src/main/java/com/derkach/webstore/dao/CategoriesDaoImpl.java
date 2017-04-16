package com.derkach.webstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.derkach.webstore.domain.Category;

/**
 * Dao implementation.
 * 
 * @author alex
 * 
 */
@Repository 
public class CategoriesDaoImpl implements CategoriesDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Insert category in to the db.
	 */
	public void insertCategory(Category category) {

		String query = "insert into categories (`name`, `parent_id`)"
				+ " VALUES (?,?)";

		jdbcTemplate.update(query,
				new Object[] { category.getName(), category.getParentId() });

	}

	/**
	 * Delete category from db.
	 */
	public void deleteCategory(Category category) {

		String query = "delete from categories where ID='" + category.getId()
				+ "'";

		System.out.println("query formed with all the argument - " + query);

		jdbcTemplate.update(query);

	}

	/**
	 * Search category in db.
	 * 
	 * @return List<Category>
	 */
	public List<Category> searchCategoriesByParentsId(String categoryId) {

		String queryinitial = "select * from categories where parent_id ='"
				+ categoryId + "'";

		System.out.println("query formed with all the argument - "
				+ queryinitial);

		RowMapper rm = null;
		List<Category> listcontacct = jdbcTemplate.query(queryinitial,
				new RowMapper() {
					public Object mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return new Category(resultSet.getInt("id"), resultSet
								.getString("name"), resultSet
								.getInt("parent_id"));
					}
				});

		return listcontacct;
	}

	/**
	 * Find category in db.
	 * 
	 * @return List<Category>
	 */
	public List<Category> findAll() {
		String queryinitial = "select * from categories ";

		System.out.println("query formed with all the argument - "
				+ queryinitial);

		RowMapper rm = null;
		List<Category> CategoryList = jdbcTemplate.query(queryinitial,
				new RowMapper() {
					public Object mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return new Category(resultSet.getInt("id"), resultSet
								.getString("name"), resultSet
								.getInt("parent_id"));
					}
				});

		return CategoryList;
	}

	/**
	 * Find root category in db.
	 * 
	 * @return List<Category>
	 */
	public List<Category> findRoot() {
		String queryinitial = "select * from categories where parent_id is null";

		System.out.println("query formed with all the argument - "
				+ queryinitial);

		RowMapper rm = null;
		List<Category> CategoryList = jdbcTemplate.query(queryinitial,
				new RowMapper() {
					public Object mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return new Category(resultSet.getInt("id"), resultSet
								.getString("name"), resultSet
								.getInt("parent_id"));
					}
				});

		return CategoryList;
	}
	
	/**
	 * Update category record.
	 */
	public void updateCategory(Category category) {
		String queryinitial = "update categories set name='"
				+ category.getName() + "', parent_id='"
				+ category.getParentId() + "' where id='" + category.getId()
				+ "'";

		jdbcTemplate.update(queryinitial);

		System.out.println("query formed with all the argument - "
				+ queryinitial);
	}

	@Override
	public List<Category> editCategory(Category Category) {
		// TODO Auto-generated method stub
		return null;
	}


}
