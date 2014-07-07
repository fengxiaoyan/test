package jp.co.fitec.lesson.feng.db;


public class DAOException extends Exception {
	
	public DAOException(Exception e) {
		super("An exception occured in the DAO layer:", e);
	}
}
