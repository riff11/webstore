package com.derkach.webstore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.derkach.webstore.domain.Producer;

/**
 * Dao implementation with jdbc.
 * 
 * @author alex
 * 
 */
@Repository
@PropertySource("classpath:web_store.properties")
public class ProducersDaoImpl implements ProducersDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private Environment env;

	@PostConstruct
	void loadClass() {
		try {
			Class.forName(env.getProperty("db.driver"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Insert producer in to the db.
	 */
	public void addProducer(Producer producer) {
		Connection conn = null;
		Statement stmt = null;

		String query = "insert into producers (NAME)" + " VALUES ('"
				+ producer.getName() + "')";
		try {
			conn = DriverManager.getConnection(env.getProperty("db.url"),
					env.getProperty("db.user"), env.getProperty("db.password"));
			stmt = conn.createStatement();
			stmt.execute(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// jdbcTemplate.update(
		// query,
		// new Object[] { producer.getName()});

	}

	/**
	 * Delete producer from db.
	 */
	public void deleteProducerByName(String name) {
		Connection conn = null;
		Statement stmt = null;

		String query = "delete from producers where name='" + name + "'";

		try {
			conn = DriverManager.getConnection(env.getProperty("db.url"),
					env.getProperty("db.user"), env.getProperty("db.password"));
			stmt = conn.createStatement();
			stmt.execute(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// jdbcTemplate.update(query);

	}

	/**
	 * search producer in db
	 * 
	 * @return List<Producer>
	 */
	public List<Producer> searchProducer(Producer producer) {

		Connection conn = null;
		Statement stmt = null;
		List<Producer> listProducers = new ArrayList<Producer>(200);

		String queryinitial = "select * from producers where NAME ='"
				+ producer.getName() + "'";
		System.out.println("query formed with all the argument - "
				+ queryinitial);
		try {
			conn = DriverManager.getConnection(env.getProperty("db.url"),
					env.getProperty("db.user"), env.getProperty("db.password"));
			stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(queryinitial);

			while (resultSet.next()) {
				listProducers.add(new Producer(resultSet.getInt("id"),
						resultSet.getString("name")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// RowMapper rm = null;
		// List<Producer> listcontacct =
		//
		// jdbcTemplate.query(queryinitial,
		// new RowMapper() {
		// public Object mapRow(ResultSet resultSet, int rowNum)
		// throws SQLException {
		// return new Producer(resultSet.getInt("id"), resultSet
		// .getString("name"), resultSet.getString("dob"),
		// resultSet.getString("email"), resultSet
		// .getString("phone"), resultSet
		// .getString("address"), resultSet
		// .getString("PINCODE"), resultSet
		// .getString("country"));
		// }
		// });

		return listProducers;
	}

	/**
	 * find producer in db
	 * 
	 * @return List<Producer>
	 */
	public List<Producer> findAll() {
		Connection conn = null;
		Statement stmt = null;
		List<Producer> listProducers = new ArrayList<Producer>(200);

		String queryinitial = "select * from producers ";

		System.out.println("query formed with all the argument - "
				+ queryinitial);

		try {
			conn = DriverManager.getConnection(env.getProperty("db.url"),
					env.getProperty("db.user"), env.getProperty("db.password"));
			stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(queryinitial);

			while (resultSet.next()) {
				listProducers.add(new Producer(resultSet.getInt("id"),
						resultSet.getString("name")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listProducers;
	}

	@Override
	public void editProducer(Producer producer) {
		Connection conn = null;
		Statement stmt = null;
		String queryinitial = "update producers set name='"
				+ producer.getName() + "' where id='" + producer.getId() + "'";

		// jdbcTemplate.update(queryinitial);

		System.out.println("query formed with all the argument - "
				+ queryinitial);

		try {
			conn = DriverManager.getConnection(env.getProperty("db.url"),
					env.getProperty("db.user"), env.getProperty("db.password"));
			stmt = conn.createStatement();
			stmt.executeQuery(queryinitial);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProducerById(Integer id) {
		Connection conn = null;
		Statement stmt = null;

		String query = "delete from producers where id='" + id + "'";

		try {
			conn = DriverManager.getConnection(env.getProperty("db.url"),
					env.getProperty("db.user"), env.getProperty("db.password"));
			stmt = conn.createStatement();
			stmt.execute(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
