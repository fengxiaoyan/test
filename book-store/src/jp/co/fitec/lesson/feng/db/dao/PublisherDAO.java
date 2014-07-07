package jp.co.fitec.lesson.feng.db.dao;

import java.util.List;

import jp.co.fitec.lesson.feng.db.DAOException;
import jp.co.fitec.lesson.feng.db.entity.Publisher;

public interface PublisherDAO {

	public List<Publisher> findAll() throws DAOException;
	
	
}
