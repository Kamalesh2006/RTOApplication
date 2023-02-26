package com.rtoapplication.dto;

public class User {
	private String userid;
	private String email;
	private String name;
	private String dob;
	private long phoneno;
	public User(String userid, String email, String name, String dob, long phoneno) {
		super();
		this.userid = userid;
		this.email = email;
		this.name = name;
		this.dob = dob;
		this.phoneno = phoneno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	
}
