package com.derkach.webstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.derkach.webstore.domain.Product;

/**
 * dao implementation
 * 
 * @author alex
 * 
 */
public class ProducersDaoImpl implements ProductsDao {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

//	/**
//	 * insert user in to the db
//	 */
//	public void insertUser(User user) {
//
//		String query = "insert into USERS (NAME,DOB,EMAIL,PHONE,ADDRESS,PINCODE,COUNTRY)"
//				+ " VALUES (?,?,?,?,?,?,?)";
//
//		jdbcTemplate.update(query,
//				new Object[] { user.getName(), user.getDate(), user.getEmail(),
//						user.getPhone(), user.getAddress(), user.getPincode(),
//						user.getCountry() });
//
//	}

//	/**
//	 * delete user from db
//	 */
//	public void deleteUser(User user) {
//
//		String query = "delete from USERS where ID='" + user.getId() + "'";
//
//		jdbcTemplate.update(query);
//
//	}

//	/**
//	 * search user in db
//	 * 
//	 * @return List<User>
//	 */
//	public List<User> searchUser(User user) {
//
//		String queryinitial = "select * from USERS where NAME ='"
//				+ user.getName() + "'";
//
//		System.out.println("query formed with all the argument - "
//				+ queryinitial);
//
//		RowMapper rm = null;
//		List<User> listcontacct = jdbcTemplate.query(queryinitial,
//				new RowMapper() {
//					public Object mapRow(ResultSet resultSet, int rowNum)
//							throws SQLException {
//						return new User(resultSet.getInt("id"), resultSet
//								.getString("name"), resultSet.getString("dob"),
//								resultSet.getString("email"), resultSet
//										.getString("phone"), resultSet
//										.getString("address"), resultSet
//										.getString("PINCODE"), resultSet
//										.getString("country"));
//					}
//				});
//
//		return listcontacct;
//	}

//	/**
//	 * find user in db
//	 * 
//	 * @return List<User>
//	 */
//	public List<User> findAll() {
//		String queryinitial = "select * from USERS ";
//
//		System.out.println("query formed with all the argument - "
//				+ queryinitial);
//
//		RowMapper rm = null;
//		List<User> userList = jdbcTemplate.query(queryinitial, new RowMapper() {
//			public Object mapRow(ResultSet resultSet, int rowNum)
//					throws SQLException {
//				return new User(resultSet.getInt("id"), resultSet
//						.getString("name"), resultSet.getString("dob"),
//						resultSet.getString("email"), resultSet
//								.getString("phone"), resultSet
//								.getString("address"), resultSet
//								.getString("PINCODE"), resultSet
//								.getString("country"));
//			}
//		});
//
//		return userList;
//	}
///**
// * update user record
// */
//	public void updateUser(User user) {
//		String queryinitial = "update USERS set name='" + user.getName()
//				+ "', email='" + user.getEmail() + "', dob='" + user.getDate()
//				+ "',phone='" + user.getPhone() + "', address='"
//				+ user.getAddress() + "' , pincode='" + user.getPincode()
//				+ "', country='" + user.getCountry() + "' where id='"
//				+ user.getId() + "'";
//
//		jdbcTemplate.update(queryinitial);
//
//		System.out.println("query formed with all the argument - "
//				+ queryinitial);
//	}

@Override
public void searchCategory(Product Product) {
	// TODO Auto-generated method stub
	
}

@Override
public List<Product> editCategory(Product Product) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void deleteCategory(Product Product) {
	// TODO Auto-generated method stub
	
}

@Override
public void updateCategory(Product Product) {
	// TODO Auto-generated method stub
	
}

@Override
public List<Product> findAll() {
	// TODO Auto-generated method stub
	return null;
}
}
