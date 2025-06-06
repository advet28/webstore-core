package com.hcl.gl.pojo;

public class Admin {
	
	private String adminUserName= "Himawari";
	private String adminPassword= "Advet@2001";
	
	public Admin() {
		super();
	}


	public Admin(String adminUserName, String adminPassword) {
		super();
		this.adminUserName = adminUserName;
		this.adminPassword = adminPassword;
	}


	@Override
	public String toString() {
		return "Admin [adminUserName=" + adminUserName + ", adminPassword=" + adminPassword + "]";
	}
	
	
	public String getAdminUserName() {
		return adminUserName;
	}
	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
}


