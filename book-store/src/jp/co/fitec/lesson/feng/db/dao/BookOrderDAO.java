package jp.co.fitec.lesson.feng.db.dao;

import java.util.List;

import jp.co.fitec.lesson.feng.db.DAOException;
import jp.co.fitec.lesson.feng.db.entity.BookOrder;

public interface BookOrderDAO {
	
	public BookOrder findById(Integer id) throws DAOException;
	//public List<BookOrder> findAll() throws DAOException;

}
