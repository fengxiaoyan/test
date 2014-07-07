package jp.co.fitec.lesson.feng.db.entity;

import java.io.Serializable;
import java.util.Date;

import jp.co.fitec.lesson.feng.db.dao.CustomerDAO;
import jp.co.fitec.lesson.feng.db.dao.dbutils.DbUtilsCustomerDAO;

public class BookOrder implements Serializable{
	
	private int orderNumber;
	private Date orderDate;
	private String customerCode;
	private int sequenceNumber;
	
	public BookOrder(){
		
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getSequenceNumber(){
		return sequenceNumber;
	}
	public void setSequenceNumber(int sequenceNumber){
		this.sequenceNumber = sequenceNumber;
	}
	
	public String getCustomerCode() {
		return customerCode;
	}

//	public void setCustomerCode(String customerCode) {
//		//this.customerCode = customerCode;
//		DbUtilsCustomerDAO customerDAO = new DbUtilsCustomerDAO();
//		this.customerCode = customerDAO.findById(customerCode);
//	}

	
	@Override
	public String toString() {
		return "BookOrder [orderNumber=" + orderNumber + ", orderDate="
				+ orderDate + ", customerCode=" + customerCode
				+ ", sequenceNumber=" + sequenceNumber + "]";
	}
	

	

	
	
	
}
