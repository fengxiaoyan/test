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
import jp.co.fitec.lesson.feng.db.dao.PublisherDAO;
import jp.co.fitec.lesson.feng.db.entity.Publisher;

public class DbUtilsPublisherDAO implements PublisherDAO {
	
	private final static Logger LOGGER = Logger.getGlobal();
	private QueryRunner runner = new QueryRunner();
	
	enum UpdateType {
		INSERT, UPDATE, DELETE
	}
	
	public DbUtilsPublisherDAO() {
		LOGGER.info("[DbUtilsAuthorDAO]");
	}
	
	public List<Publisher> findAll() throws DAOException {
		
		return findAny(null);
	}
	

	public Publisher findById(Integer id) throws DAOException {
				
		return findAny("code = " + id).get(0);
	}

	
	public List<Publisher> findByName(String name) throws DAOException {
				
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
	private List<Publisher> findAny(String restriction) throws DAOException {
		
		List<Publisher> publisherList = new ArrayList<>();
		StringBuilder sql = new StringBuilder("SELECT * FROM publisher");
		
		if(restriction != null) {
			sql.append(" WHERE ").append(restriction);
		}

		try {
			
			Connection conn = ConnectionUtils.getConnection();	
			publisherList = runner.query(conn, sql.toString(), new BeanListHandler<>(Publisher.class));
			
		} catch (SQLException | IOException e) {
			throw new DAOException(e);
		}
		
		return publisherList;
	}
	





}
