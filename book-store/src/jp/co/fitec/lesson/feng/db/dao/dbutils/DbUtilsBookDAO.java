package jp.co.fitec.lesson.feng.db.dao.dbutils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import jp.co.fitec.lesson.feng.db.ConnectionUtils;
import jp.co.fitec.lesson.feng.db.DAOException;
import jp.co.fitec.lesson.feng.db.dao.BookDAO;
import jp.co.fitec.lesson.feng.db.entity.Book;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class DbUtilsBookDAO implements BookDAO{

	private final static Logger LOGGER = Logger.getGlobal();
	private QueryRunner runner = new QueryRunner();
	
	enum UpdateType {
		INSERT, UPDATE, DELETE
	}
	
	public DbUtilsBookDAO() {
		LOGGER.info("[DbUtilsBookDAO]");
	}
	
	public List<Book> findAll() throws DAOException {
		
		return findAny(null);
	}
	

	public Book findById(Integer id) throws DAOException {
				
		return findAny("isbn = " + id).get(0);
	}

	
	public List<Book> findByName(String name) throws DAOException {
				
		return findAny("title LIKE '%" + name + "%'");
	}
	

	
//==============================================================================================	
// 内部処理用メソッド
	
	/*
	 * <p>検索用</P>
	 * @param restriction
	 * @return
	 * @throws DAOException
	 */
	private List<Book> findAny(String restriction) throws DAOException {
		
		List<Book> bookList = new ArrayList<>();
		StringBuilder sql = new StringBuilder("SELECT * FROM book");
		
		if(restriction != null) {
			sql.append(" WHERE ").append(restriction);
		}

		try {
			
			Connection conn = ConnectionUtils.getConnection();	
			bookList = runner.query(conn, sql.toString(), new BeanListHandler<>(Book.class));
			
		} catch (SQLException | IOException e) {
			throw new DAOException(e);
		}
		
		return bookList;
	}
	

}
