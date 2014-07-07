package jp.co.fitec.lesson.feng.db.dao;

import java.util.List;

import jp.co.fitec.lesson.feng.db.DAOException;
import jp.co.fitec.lesson.feng.db.entity.Book;

public interface BookDAO {
	
	public List<Book> findAll() throws DAOException;

}
