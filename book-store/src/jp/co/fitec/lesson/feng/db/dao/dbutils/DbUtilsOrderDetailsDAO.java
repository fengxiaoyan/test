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
import jp.co.fitec.lesson.feng.db.dao.OrderDetailsDAO;
import jp.co.fitec.lesson.feng.db.entity.OrderDetails;

public class DbUtilsOrderDetailsDAO implements OrderDetailsDAO {

	private final static Logger LOGGER = Logger.getGlobal();
	private QueryRunner runner = new QueryRunner();
	
	enum UpdateType {
		INSERT, UPDATE, DELETE
	}
	
	public DbUtilsOrderDetailsDAO() {
		LOGGER.info("[DbUtilsOrderDetailsDAO]");
	}
	
	public List<OrderDetails> findAll() throws DAOException {
		
		return findAny(null);
	}
	

	public OrderDetails findById(Integer id) throws DAOException {
				
		return findAny("order_number = " + id).get(0);
	}

	
//	public List<Author> findByName(String name) throws DAOException {
//				
//		return findAny("name LIKE '%" + name + "%'");
//	}
	

	
//==============================================================================================	
// 内部処理用メソッド
	
	/*
	 * <p>検索用</P>
	 * @param restriction
	 * @return
	 * @throws DAOException
	 */
	private List<OrderDetails> findAny(String restriction) throws DAOException {
		
		List<OrderDetails> orderDetailsList = new ArrayList<>();
		StringBuilder sql = new StringBuilder("SELECT * FROM order_details");
		
		if(restriction != null) {
			sql.append(" WHERE ").append(restriction);
		}

		try {
			
			Connection conn = ConnectionUtils.getConnection();	
			orderDetailsList = runner.query(conn, sql.toString(), new BeanListHandler<>(OrderDetails.class));
			
		} catch (SQLException | IOException e) {
			throw new DAOException(e);
		}
		
		return orderDetailsList;
	}
	




	
}
