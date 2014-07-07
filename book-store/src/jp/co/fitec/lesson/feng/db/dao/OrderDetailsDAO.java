package jp.co.fitec.lesson.feng.db.dao;

import java.util.List;

import jp.co.fitec.lesson.feng.db.DAOException;
import jp.co.fitec.lesson.feng.db.entity.OrderDetails;

public interface OrderDetailsDAO {

	public List<OrderDetails> findAll() throws DAOException;
	
}
