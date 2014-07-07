package jp.co.fitec.lesson.feng.db.entity;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable{

	private String isbn;
	private String title;
	private double price;
	private Date releaseDate;
	
	private String publisherCode;
	private String authorCode;
	
	public Book(){
		
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	
	public String getPublisherCode(){
		return publisherCode;
	}
	public void setPublisherCode(String publisherCode){
		this.publisherCode = publisherCode;
	}
	
	public String getAuthorCode(){
		return authorCode;
	}
	
	public void setAuthorCode(String authorCode){
		this.authorCode = authorCode;
	}

	
	
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", price=" + price
				+ ", releaseDate=" + releaseDate + ", publisherCode="
				+ publisherCode + ", authorCode=" + authorCode + "]";
	}
	
	

	
	
	
	
}
