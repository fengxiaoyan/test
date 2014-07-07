package jp.co.fitec.lesson.feng.db;

import java.util.List;

import jp.co.fitec.lesson.feng.db.dao.AuthorDAO;
import jp.co.fitec.lesson.feng.db.dao.DAOFactory;
import jp.co.fitec.lesson.feng.db.dao.dbutils.DbUtilsAuthorDAO;
import jp.co.fitec.lesson.feng.db.entity.Author;

public class Client {

	public static void main(String[] args) {

//		DAOFactory factory = DAOFactory.getDAOFactory();
//		AuthorDAO authorDao = factory.getAuthorDAO();
//
//		try {
//			//List<Author> authorList = authorDao.findAll();
//			Author authorList = authorDao.findById(001);
//			//for (Author author : authorList) {
//				System.out.println(authorList.getName());
//			//}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		DbUtilsAuthorDAO dao = new DbUtilsAuthorDAO();
		List<Author> list = dao.findByName("e");
		for (Author i : list) {
			System.out.println(i);
		}

	}
}
