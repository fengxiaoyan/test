package jp.co.fitec.lesson.feng.db.dao;

import java.util.List;

import jp.co.fitec.lesson.feng.db.DAOException;
import jp.co.fitec.lesson.feng.db.entity.Customer;

public interface CustomerDAO {

	//public String findById(String id) throws DAOException;
	//public Customer findById(String id) throws DAOException;
	public List<Customer> findAll() throws DAOException;
	
}
