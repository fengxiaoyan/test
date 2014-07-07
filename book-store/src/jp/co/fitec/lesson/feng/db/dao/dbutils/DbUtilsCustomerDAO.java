package jp.co.fitec.lesson.feng.db.dao.dbutils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import jp.co.fitec.lesson.feng.db.ConnectionUtils;
import jp.co.fitec.lesson.feng.db.DAOException;
import jp.co.fitec.lesson.feng.db.dao.CustomerDAO;
import jp.co.fitec.lesson.feng.db.entity.Customer;

public class DbUtilsCustomerDAO implements CustomerDAO{

	private final static Logger LOGGER = Logger.getGlobal();
	private QueryRunner runner = new QueryRunner();
	
	enum UpdateType {
		INSERT, UPDATE, DELETE
	}
	
	public DbUtilsCustomerDAO() {
		LOGGER.info("[DbUtilsCustomerDAO]");
	}
	
	public List<Customer> findAll() throws DAOException {
		
		return findAny(null);
	}
	

	public List<Customer> findById(String id) throws DAOException {
				
		return findAny("code = " + id);
		//return null;
	}

	
	public List<Customer> findByName(String name) throws DAOException {
				
		return findAny("name LIKE '%" + name + "%'");
	}
	

	
//==============================================================================================	
// 内部処理用メソッド
	
	/*
	 * <p>検索用</P>
	 * @param restriction
	 * @return
	 * @throws DAOException
	 */
	private List<Customer> findAny(String restriction) throws DAOException {
		
		List<Customer> customerList = new ArrayList<>();
		StringBuilder sql = new StringBuilder("SELECT * FROM customer");
		
		if(restriction != null) {
			sql.append(" WHERE ").append(restriction);
		}

		try {
			
			Connection conn = ConnectionUtils.getConnection();	
			customerList = runner.query(conn, sql.toString(), new BeanListHandler<>(Customer.class));
			
		} catch (SQLException | IOException e) {
			throw new DAOException(e);
		}
		
		return customerList;
	}
	




}
