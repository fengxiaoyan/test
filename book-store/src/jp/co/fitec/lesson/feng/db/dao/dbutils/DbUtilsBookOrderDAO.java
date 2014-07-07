package jp.co.fitec.lesson.feng.db.dao.dbutils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import jp.co.fitec.lesson.feng.db.ConnectionUtils;
import jp.co.fitec.lesson.feng.db.DAOException;
import jp.co.fitec.lesson.feng.db.dao.BookOrderDAO;
import jp.co.fitec.lesson.feng.db.entity.BookOrder;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class DbUtilsBookOrderDAO implements BookOrderDAO {

	private final static Logger LOGGER = Logger.getGlobal();
	private QueryRunner runner = new QueryRunner();
	
	enum UpdateType {
		INSERT, UPDATE, DELETE
	}
	
	public DbUtilsBookOrderDAO() {
		LOGGER.info("[DbUtilsBookOrderDAO]");
	}
	
	public List<BookOrder> findAll() throws DAOException {
		
		return findAny(null);
	}
	

	public BookOrder findById(Integer id) throws DAOException {
				
		return findAny("order_number = " + id).get(0);
	}

	
	public BookOrder findByCustId(String name) throws DAOException {
				
		return findAny("customer_code" + name).get(0);
	}
	

	
//==============================================================================================	
// 内部処理用メソッド
	
	/*
	 * <p>検索用</P>
	 * @param restriction
	 * @return
	 * @throws DAOException
	 */
	private List<BookOrder> findAny(String restriction) throws DAOException {
		
		List<BookOrder> bookOrderList = new ArrayList<>();
		StringBuilder sql = new StringBuilder("SELECT * FROM book_order");
		
		if(restriction != null) {
			sql.append(" WHERE ").append(restriction);
		}

		try {
			
			Connection conn = ConnectionUtils.getConnection();	
			bookOrderList = runner.query(conn, sql.toString(), new BeanListHandler<>(BookOrder.class));
			
		} catch (SQLException | IOException e) {
			throw new DAOException(e);
		}
		
		return bookOrderList;
	}
	

	
}
