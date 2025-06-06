package com.hcl.gl.pojo;


//public means all the classes can use it
//private means only the class which contains it can use it


public class Product {
	
	private int pid;//productid
	private String pname;//productname
	private double sellingprice;//sellingprice
	private String productCategory;//productcategory
	public double buyingprice;//buyingprice
//	private String username;//username
//	private String EmailId;//emailid
//	private String password;//password
	
	//geterate getters and setters
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getSellingprice() {
		return sellingprice;
	}
	public void setSellingprice(double sellingprice) {
		this.sellingprice = sellingprice;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public double getBuyingprice() {
		return buyingprice;
	}
	public void setBuyingprice(double buyingprice) {
		this.buyingprice = buyingprice;
	}
	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", sellingprice=" + sellingprice + ", productCategory="
				+ productCategory + ", buyingprice=" + buyingprice + "]";
	}
	//default constructor
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//constructor with fileds
	public Product(int pid, String pname, String productCategory, double buyingprice, double sellingprice) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.productCategory = productCategory;
		this.buyingprice = buyingprice;
		this.sellingprice = sellingprice;
	}	
}
