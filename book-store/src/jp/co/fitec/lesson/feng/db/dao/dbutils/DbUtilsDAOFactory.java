package jp.co.fitec.lesson.feng.db.dao.dbutils;

import jp.co.fitec.lesson.feng.db.dao.AuthorDAO;
import jp.co.fitec.lesson.feng.db.dao.BookDAO;
import jp.co.fitec.lesson.feng.db.dao.BookOrderDAO;
import jp.co.fitec.lesson.feng.db.dao.CustomerDAO;
import jp.co.fitec.lesson.feng.db.dao.DAOFactory;
import jp.co.fitec.lesson.feng.db.dao.OrderDetailsDAO;
import jp.co.fitec.lesson.feng.db.dao.PublisherDAO;


public class DbUtilsDAOFactory extends DAOFactory{
	
	
	@Override
	public AuthorDAO getAuthorDAO() {
		return new DbUtilsAuthorDAO();
	}

	
	@Override
	public BookDAO getBookDAO() {

		return new DbUtilsBookDAO();
	}

	@Override
	public CustomerDAO getCustomerDAO() {
		
		return new DbUtilsCustomerDAO();
	}

	@Override
	public PublisherDAO getPublisherDAO() {

		return new DbUtilsPublisherDAO();
	}

	@Override
	public BookOrderDAO getBookOrderDAO() {
		
		return new DbUtilsBookOrderDAO();
		//return null;
	}

	@Override
	public OrderDetailsDAO getOrderDetailsDAO() {
		
		return new DbUtilsOrderDetailsDAO();
		
	}
	
}



//
//import jp.co.fitec.lesson.rodjanawatana.db.dao.DAOFactory;
//import jp.co.fitec.lesson.rodjanawatana.db.dao.EmployeeDAO;


