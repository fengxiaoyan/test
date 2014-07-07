package jp.co.fitec.lesson.feng.db.entity;

import java.io.Serializable;

public class Customer implements Serializable{

	
	private String code;
	private String name;
	private String address;
	
	public Customer(){
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [code=" + code + ", name="
				+ name + ", address=" + address + "]";
	}
	
	
	
}
