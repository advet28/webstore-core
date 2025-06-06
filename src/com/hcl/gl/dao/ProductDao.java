package com.hcl.gl.dao;
import com.hcl.gl.pojo.Product;
import com.hcl.gl.pojo.User;


public interface ProductDao{
    public Product getAllProduct();//to display all the products
    public Product delProduct(String pname );//to delete a particular record or data
    public Product searchProductbycategory(String productCategory);//to display the product category
    public Product searchProduct(String pname);//to search the product by name
    Product addProduct(Product p);// add product for Admin
	Product getProById(int pid);// search product by id
	
	public void registerUser(User user);// for registration of customer
	public boolean checkUserName(String username1);
	public void UserLogin(String username1, String password1);//login method 
	Product updateProduct(int Productid, String productName);//update the existing product
	
	public boolean checkLogin();
	public Product printbill();
	
}
