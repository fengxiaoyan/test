package jp.co.fitec.lesson.feng.db.entity;

import java.io.Serializable;

public class OrderDetails implements Serializable{
	
	private int sequenceNumber;
	private int quantity;
	
	private int orderNumber;
	private String isbn;
	
	public OrderDetails(){
	
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public int getOrderNumber(){
		return orderNumber;
	}
	
	public void setOrderNumber(int orderNumber){
		this.orderNumber = orderNumber;
	}
	
	public String getIsbn(){
		return isbn;
	}
	
	public void setIsbn(String isbn){
		this.isbn = isbn;
	}

	
	
	@Override
	public String toString() {
		return "OrderDetails [sequenceNumber=" + sequenceNumber + ", quantity="
				+ quantity + ", orderNumber=" + orderNumber + ", isbn=" + isbn
				+ "]";
	}

	
	

}
