package com.hcl.gl.pojo;

public class User {

	private int uid;
	private String username;
	private String password;
	private String email;
	private int supercoin =100;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSupercoin() {
		return supercoin;
	}
	public void setSupercoin(int supercoin) {
		this.supercoin = supercoin;
	}
	public User(int uid, String username, String password, String email, int supercoin) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.supercoin = supercoin;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int uid, String username, String password, String email) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", supercoin=" + supercoin + "]";
	}

	
}
