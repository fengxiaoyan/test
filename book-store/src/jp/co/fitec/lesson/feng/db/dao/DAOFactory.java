package jp.co.fitec.lesson.feng.db.dao;

import jp.co.fitec.lesson.feng.db.dao.dbutils.DbUtilsDAOFactory;



public abstract class DAOFactory {

	
	
	public static DAOFactory getDAOFactory(){

		//return new JdbcDAOFactory();
		return new DbUtilsDAOFactory(); 
		//return null;
	}
	
	
	
	public abstract AuthorDAO getAuthorDAO();	
	public abstract BookDAO getBookDAO();
	public abstract CustomerDAO getCustomerDAO();
	public abstract PublisherDAO getPublisherDAO();
	public abstract BookOrderDAO getBookOrderDAO();
	public abstract OrderDetailsDAO getOrderDetailsDAO();
	
	
}
