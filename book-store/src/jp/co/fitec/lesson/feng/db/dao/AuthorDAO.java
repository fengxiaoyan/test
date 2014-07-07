package jp.co.fitec.lesson.feng.db.dao;


import java.util.List;

import jp.co.fitec.lesson.feng.db.DAOException;
import jp.co.fitec.lesson.feng.db.entity.Author;


public interface AuthorDAO {


	//public Author findById(Integer id) throws DAOException;
	//public List<Author> findAll() throws DAOException;
	
	public abstract List<Author> findAll();
	public abstract Author findByCode(String code);
	public abstract List<Author> findByName(String name);
	public abstract int insert(Author author);
	public abstract int update(Author author);
	public abstract int delete(Author author);
	
}
