package com.derkach.webstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.derkach.webstore.controller.AdminController;
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
	private static final Logger logger = LoggerFactory
			.getLogger(AdminController.class);

	/**
	 * Insert category in to the db.
	 */
	public void addCategory(Category category) {

		String query = "insert into categories (`name`, `parent_id`)"
				+ " VALUES (?,?)";

		logger.info("query formed with all the argument - " + query);

		jdbcTemplate.update(query,
				new Object[] { category.getName(), category.getParentId() });

	}

	/**
	 * Delete category from db.
	 */
	public void deleteCategory(Category category) {

		String query = "delete from categories where name='"
				+ category.getName() + "'";

		logger.info("query formed with all the argument - " + query);

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

		logger.info("query formed with all the argument - " + queryinitial);

		RowMapper rm = null;
		List<Category> listcontacct = getlist(queryinitial);

		return listcontacct;
	}

	/**
	 * Find category in db.
	 * 
	 * @return List<Category>
	 */
	public List<Category> findAll() {
		String queryinitial = "select * from categories ";

		logger.info("query formed with all the argument - " + queryinitial);

		RowMapper rm = null;
		List<Category> CategoryList = getlist(queryinitial);

		return CategoryList;
	}

	/**
	 * Find root category in db.
	 * 
	 * @return List<Category>
	 */
	public List<Category> findRoot() {
		String queryinitial = "select * from categories where parent_id is null";

		logger.info("query formed with all the argument - " + queryinitial);

		RowMapper rm = null;
		List<Category> CategoryList = getlist(queryinitial);

		return CategoryList;
	}

	/**
	 * Update category record.
	 */
	public void editCategory(Category category) {
		String queryinitial = "update categories set name='"
				+ category.getName() + "', parent_id='"
				+ category.getParentId() + "' where id='" + category.getId()
				+ "'";

		jdbcTemplate.update(queryinitial);

		logger.info("query formed with all the argument - " + queryinitial);
	}

	@Override
	public List<Category> findSiblings(int i) {
		String queryinitial = "select * from categories where id=" + i;

		RowMapper rm = null;
		List<Category> listCategory = getlist(queryinitial);
		logger.info("query formed with all the argument - " + queryinitial);

		return searchCategoriesByParentsId(String.valueOf(listCategory.get(0)
				.getParentId()));
	}

	protected List<Category> getlist(String queryinitial) {
		return jdbcTemplate.query(queryinitial, new RowMapper() {
			public Object mapRow(ResultSet resultSet, int rowNum)
					throws SQLException {
				return new Category(resultSet.getInt("id"), resultSet
						.getString("name"), resultSet.getInt("parent_id"));
			}
		});
	}
}
