package jp.co.fitec.lesson.feng.db.dao.dbutils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import jp.co.fitec.lesson.feng.db.ConnectionUtils;
import jp.co.fitec.lesson.feng.db.DAOException;
import jp.co.fitec.lesson.feng.db.dao.AuthorDAO;
import jp.co.fitec.lesson.feng.db.entity.Author;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class DbUtilsAuthorDAO implements AuthorDAO {
	

	
	
	public List<Author> find(String code, String name){
		try{
			Connection conn = ConnectionUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "";
			
			if (code == null && name == null){
				sql = "SELECT * FROM author";
				return runner.query(conn, sql, new BeanListHandler<>(Author.class));
			} 
			
			if (code == null && name != null){
				sql = "SELECT * FROM author WHERE name LIKE ?";
				return runner.query(conn, sql, new BeanListHandler<>(Author.class),"%"+name+"%");
			}
			
			if (code != null && name == null){
				sql = "SELECT * FROM author WHERE code = ?";
				return runner.query(conn, sql, new BeanListHandler<>(Author.class),code);
			}
			
			else {
				sql = "SELECT * FROM author WHERE code = ? AND name LIKE ?";
				return runner.query(conn, sql, new BeanListHandler<>(Author.class),code,"%"+name+"%");
			}
		}catch(SQLException | IOException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public List<Author> findAll(){
		return find(null,null);
	}
	
	@Override
	public Author findByCode(String code){
		return find(code,null).get(0);
	}
	
	@Override
	public List<Author> findByName(String name){
		return find(null,name);
	}
	
	
	
	enum UpdateType {
		INSERT, UPDATE, DELETE
	}
	
	
	public int update(Author author, UpdateType updateType){
		
		try{
			Connection conn = ConnectionUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			
			String sql = "";
			
			switch(updateType){
			
			case UPDATE:
				sql = "UPDATE author SET name = ? WHERE code = ?";
				return runner.update(conn, sql, author.getName(), author.getCode());
				
				
			case INSERT:
				sql = "INSERT INTO author VALUES(?,?)";
				return runner.update(conn, sql, author.getName(), author.getCode());
				
			case DELETE:
				sql = "DELETE FROM author WHERE id = ?";
				return runner.update(conn, sql, author.getCode());
				
			default:
				break;
			}
		}catch(SQLException | IOException e){
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	
	@Override
	public int insert(Author author){
		return update(author, UpdateType.INSERT);
	}
	
	@Override
	public int update(Author author){
		return update(author, UpdateType.UPDATE);
	}
	
	@Override
	public int delete(Author author){
		return update(author, UpdateType.DELETE);
	}
	

}
