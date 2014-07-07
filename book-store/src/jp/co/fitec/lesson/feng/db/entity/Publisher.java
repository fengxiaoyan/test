package jp.co.fitec.lesson.feng.db.entity;

import java.io.Serializable;

public class Publisher implements Serializable {
	
	
	private String code;
	private String name;
	
	public Publisher(){
		
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

	@Override
	public String toString() {
		return "Publisher [code=" + code + ", name=" + name + "]";
	}
	
	

}
