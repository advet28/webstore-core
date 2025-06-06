package com.hcl.gl.daoimpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.hcl.gl.dao.ProductDao;
import com.hcl.gl.pojo.Product;
import com.hcl.gl.pojo.User;




	     public class ProductDaoImpl implements ProductDao{
	    	Scanner sc=new Scanner(System.in);
	    	int size=0,flag=0;
	     	String username ="root";//username of sql
	     	String password="root";//password of sql
	     	String url = "jdbc:mysql://localhost:3306/info2?useSSL=false";//jdbc connection
	     	Product p = new Product();
			@Override
			
			// To see the all products available by method Getallproduct
			public Product getAllProduct() {
				
				try {
					//select entire table
					
					String query="Select* from items";
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/info2?useSSL=false","root","root");
					Statement st= con.createStatement();
					ResultSet rs=st.executeQuery(query);
					//order should be there
                    while(rs.next()) {
						int pid=rs.getInt(1);
						p.setPid(pid);
						String pname=rs.getString(2);
						p.setPname(pname);
						String productCategory=rs.getString(3);
						p.setProductCategory(productCategory);
				        double buyingprice=rs.getDouble(4);
						p.setBuyingprice(buyingprice);
						double sellingprice = rs.getDouble(5);
						p.setBuyingprice(sellingprice);
						System.out.println("Product id : "+ pid + "Product name " + pname + " Product category " + productCategory + /*" Buyingprice is " + buyingprice*/  " sellingPrice is " + sellingprice );
					    
					}
                    //close all connections
                    
					    rs.close();
					    st.close();
					    con.close();
					}
				   catch(ClassNotFoundException | SQLException e) {
				        e.printStackTrace();	    
				}
				
				//thread-->A thread is a single sequential flow of control within a program
				Thread t= new Thread();
				   t.run(); 
			       //TaskLog.writelog("Successfully upgraded ");    
				   return null;	
			}
			
			
			//search product by using product id
			
			
			public Product getProById( int pid) { 
				try {
					String query="Select* from product where pid=" + pid;
					//load the driver using forName method
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection(url,username,password);
					Statement st= con.createStatement();
					ResultSet rs=st.executeQuery(query);
					while(rs.next()) {
					    pid=rs.getInt(1);
						p.setPid(pid);
						String pname=rs.getString(2);
						p.setPname(pname);
						String productCategory=rs.getString(3);
						p.setProductCategory(productCategory);
				        double buyingprice=rs.getDouble(4);
						p.setBuyingprice(buyingprice);
						double sellingprice = rs.getDouble(5);
						p.setBuyingprice(sellingprice);
						System.out.println("your search Product id : " + pid + " is under  Product name " + pname + " with Product category as " + productCategory + /*"  Sellingprice of " + sellingprice +*/ "having buying Price of " + buyingprice );    
					}
					
					//close all connections
					
					    rs.close();
					    st.close();
					    con.close();
					}
				   catch(ClassNotFoundException | SQLException ex) {
				        ex.printStackTrace();	    
				}
				
				//thread-->A thread is a single sequential flow of control within a program
				
				Thread t= new Thread();
				   t.run(); 
			       //TaskLog.writelog("Successfully upgraded ");    
				   return null;		
			}
			
			//search a product by name
			
			@Override
			public Product searchProduct(String pname) {  
				// TODO Auto-generated method stub
				
				 System.out.println("Enter the name of product once again to confirm : ");
				 pname=sc.next();
				 System.out.println("Enter product category you purchased ");
                 String productCategory = sc.next();
                 if(productCategory.equalsIgnoreCase("Grocery") || productCategory.equalsIgnoreCase("Vegetable") || productCategory.equalsIgnoreCase("Toiletry") || productCategory.equalsIgnoreCase("Stationery"))
					{

						System.out.println("product name searched : Product Name: "+ pname +" \tproduct category: "+ productCategory + " is present in the list with ID as " + p.getPid());
						
					}
					else {
						System.out.println("Please enter the correct category ");
					}
				
				if(flag==1)
				{
					try {
						throw new NegativeArraySizeException("Task Not Present");
					}
					catch(Exception e) {
						System.out.println("Please add the task");
					}
				}
				
				//thread-->A thread is a single sequential flow of control within a program
					Thread t= new Thread();
					   t.run(); 
				       //TaskLog.writelog("Successfully upgraded ");    
					   return null;
			}
			
			
			//delete the product by name	
			
			@Override
			public Product delProduct(String pname) {          
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection(url,username,password);
					PreparedStatement ps=con.prepareStatement("	DELETE FROM product WHERE pname= ?");
					ps.setString(1,pname);
					int i=ps.executeUpdate();
					if(i>0) {
						System.out.println("Product  details deleted successfully");
					}
					//close the connections
					ps.close();
					con.close();
				}
				   catch(ClassNotFoundException | SQLException ez) {
				        ez.printStackTrace();	    
				}
				Thread t= new Thread();
				   t.run(); 
			       //TaskLog.writelog("Successfully upgraded ");    
				   return null;
			
			}		
			
			//search product by the category like grocery//stationary...
			//selecting and searching product using category details
			
			
			public Product searchProductbycategory(String productCategory){                  

				 System.out.println("Enter the name of category once again to confirm : ");
				 productCategory=sc.next();
				 System.out.println("Enter the id of the product name you purchased ");
                 int pid = sc.nextInt();
                 
                 if(productCategory.equalsIgnoreCase("Grocery") || productCategory.equalsIgnoreCase("Vegetable") || productCategory.equalsIgnoreCase("Toiletry") || productCategory.equalsIgnoreCase("Stationery"))
					{

						System.out.println("product name searched : Product Name: "+ productCategory +" \tproduct Id: "+ pid + " is present in the list " + p.getPname() + " as product name");	
					}
					else 
					{
						System.out.println("Please enter the correct category ");
					}
                 
                 if(flag==1)
 				{
                	 try {
  						throw new NegativeArraySizeException("Task Not Present");
  					}
  					catch(Exception e) {
  						System.out.println("Please add the task");
 					}
 				}
                 
                 
				
				
          
			Thread t= new Thread();
			   t.run(); 
		      // TaskLog.writelog("Successfully upgraded ");    
			   return null;
                 
		
				    
			
			}
			//add the product
			public Product addProduct(Product p) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection(url,username,password);
					String sql=("INSERT INTO product VALUES (?,?,?,?,?)");
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setInt(1, p.getPid());
					ps.setString(2,p.getPname());
					ps.setString(3, p.getProductCategory());
					ps.setDouble(4,p.getBuyingprice());
					ps.setDouble(5,p.getSellingprice());
					int i=ps.executeUpdate();
					if(i>0) {
						System.out.println("Product details added successfully in"+ps);
					}
					ps.close();
					con.close();
				}
				   catch(ClassNotFoundException | SQLException ez) {
				        ez.printStackTrace();	    
				}
				Thread t= new Thread();
				   t.run(); 
			       //TaskLog.writelog("Successfully upgraded ");    
				   return null;
			
			}
			
			
			//update the product
			@Override
			public Product updateProduct(int Productid, String productName) {
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection(url, username, password);
					String sql = "UPDATE product SET pname= ? WHERE pid=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, productName);
					ps.setInt(2, Productid);			 
					int i = ps.executeUpdate();
					if (i > 0) {
					    System.out.println("An existing user was updated successfully!");
					}
					else
						System.out.println("Failed to update data..!");
					
					ps.close();
					conn.close();
				}catch (ClassNotFoundException | SQLException ex) {
			        ex.printStackTrace();
			    }
				return null;
					
					
				
				
	}


			@Override
			public void registerUser(User user) {
				// TODO Auto-generated method stub
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection(url, username, password);
					String sql=("INSERT INTO user VALUES (?,?,?,?,?)");
					
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setInt(1, user.getUid());
					ps.setString(2, user.getUsername());
					ps.setString(3, user.getPassword());
					ps.setString(4, user.getEmail());
					ps.setInt(5, user.getSupercoin());
					int i=ps.executeUpdate();
					if(i>0) {
						System.out.println("Registred Successfull"+ps);
					}
					ps.close();
					conn.close();
					
					
				} catch (SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}


			@Override
			public boolean checkUserName(String username1) {
				try {
					String query="Select* from user where username=" + username1;
					//load the driver using forName method
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection(url,username,password);
					Statement st= con.createStatement();
					ResultSet rs=st.executeQuery(query);
//					while(rs.next()) {
						
						if(rs.getString(2).equals(username1)) {
							return true;
						}
					   
//					}
					
					//close all connections
					
					    rs.close();
					    st.close();
					    con.close();
					}
				   catch(ClassNotFoundException | SQLException ex) {
				        ex.printStackTrace();	    
				}
				return false;
			}

			boolean checkLog = false;
			@Override
			public boolean checkLogin() {
				if(checkLog==true) {
					return true;
				}
				return false;
			}

			

			@Override
			public void UserLogin(String username1, String password1) {
				// TODO Auto-generated method stub
				
				try {
					//select entire table
					
					String query="Select * from user";
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/info2?useSSL=false","root","root");
					Statement st= con.createStatement();
					ResultSet rs=st.executeQuery(query);
					//order should be there
					int count=0;
                    while(rs.next()) {
//						int pid=rs.getInt(1);
//						p.setPid(pid);
                    	if(username1.equals(rs.getString(2)) && password1.equals(rs.getString(3))) {
                    		System.out.println("Customer Login Successfully");
                    		count ++;
                    		checkLog=true;
                    		break;
                    	
                    		
                    	}
                    	
                    	
					
					}
                    if(count==0) {
                    	System.out.println("Wrong Cadential !!....");
//                    	checkLog=false;
                    }
                    
  
                    //close all connections
                    
					    rs.close();
					    st.close();
					    con.close();
					}
				   catch(ClassNotFoundException | SQLException e) {
				        e.printStackTrace();	    
				}
				
			}


			@Override
			public Product printbill() {
				// TODO Auto-generated method stub
				
				try {
					//select entire table
					
					String query="Select* from product";
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/info2?useSSL=false","root","root");
					Statement st= con.createStatement();
					ResultSet rs=st.executeQuery(query);
					//order should be there
                    while(rs.next()) {
						int pid=rs.getInt(1);
						p.setPid(pid);
						String pname=rs.getString(2);
						p.setPname(pname);
						String productCategory=rs.getString(3);
						p.setProductCategory(productCategory);
				        double buyingprice=rs.getDouble(4);
						p.setBuyingprice(buyingprice);
						double sellingprice = rs.getDouble(5);
						p.setBuyingprice(sellingprice);
						System.out.println(/*"Product id : "+ pid + */"Product name " + pname /*+ " Product category " + productCategory + " Buyingprice is " + buyingprice+ */ +" sellingPrice is " + sellingprice );
					    
					}
                    //close all connections
                    
					    rs.close();
					    st.close();
					    con.close();
					}
				   catch(ClassNotFoundException | SQLException e) {
				        e.printStackTrace();	    
				}
				
				//thread-->A thread is a single sequential flow of control within a program
				Thread t= new Thread();
				   t.run(); 
			       //TaskLog.writelog("Successfully upgraded ");    
				   return null;
			}



}
