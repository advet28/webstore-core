package com.hcl.gl.main;
import java.util.Scanner;
import com.hcl.gl.dao.ProductDao;
import com.hcl.gl.daoimpl.ProductDaoImpl;
import com.hcl.gl.pojo.Admin;
import com.hcl.gl.pojo.Product;
import com.hcl.gl.pojo.User;




public class MainApplication {
	
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		int choice;
		double amount = 0;
		int num;
		ProductDao dao = new ProductDaoImpl();//create an object
		Product p = null;
		boolean flagforCus =true;
		
		while(flagforCus) {
			
			System.out.println("#######[  Wecome to online store  ]#######");
			System.out.println("");
			System.out.println("           1.to register as Customer");
			System.out.println("           2.to login as Customer");
			System.out.println("           3.to login as Admin");
			System.out.println("           4.to Exit ");
			
			int opt =sc.nextInt();
//			int opt = sc.nextInt();
			switch (opt){
			case 4 : System.out.println("Thanks for choosing our mark.....");
			
			System.out.println("Visit Again");
			flagforCus =false;
			break;
			case 1:
				System.out.println("Register as Customer : ");
				System.out.println("For Register New Customer Follow the Instructions");
				
				System.out.println("Enter UserId");
				int uid = sc.nextInt();
				
				System.out.println("Enter UserName");
				String username = sc.next();
				
				System.out.println("Enter Paasword");
				String pass = sc.next();
				System.out.println("Enter E-Mail");
				String email = sc.next();
				
				User user = new User();
				user.setUid(uid);
				user.setUsername(username);
				user.setPassword(pass);
				user.setEmail(email);
				
				dao.registerUser(user);
				
			       break; 
			
			
			case 2:
				System.out.println("Please Login First !!");
				System.out.println("");
				System.out.println("Enter Customer Username");
				String userName1 = sc.next();
				System.out.println("Enter Customer Passwprd");
				String password1  = sc.next();
				dao.UserLogin(userName1, password1);
				
				if(dao.checkLogin()==true) {
					boolean ch=true;
					while(ch) {
						
						System.out.println("           1.Get All products available in store");
						System.out.println("           2.Add Product");
						System.out.println("           3.Get Product by ID");
						System.out.println("           4.Search Product Category ");
						System.out.println("           5.Search product by name ");
						System.out.println("           6.delete product from your cart ");
						System.out.println("           7.update product by id ");
						System.out.println("           8.to print the bill ");
						System.out.println("           0.EXit from Menu ");
						
						int opto = sc.nextInt();
						switch(opto) {
						case 1: System.out.println("Product Data");
							    //System.out.println("Enter OPTION 2 once");
							    //int pid=sc.nextInt();
							    dao.getAllProduct();
						        break;
						
						case 2: System.out.println("Enter Product Details: ");
								System.out.println("Enter Product ID: ");
								int pid = sc.nextInt();
								System.out.println("Enter Product Name: ");
								String pname = sc.next();
								System.out.println("Enter Product Category : ");
								String productCategory = sc.next();
								System.out.println("Enter product buying Price");
								double buyingprice=sc.nextDouble();
								double sellingprice=(buyingprice*0.5)+buyingprice;
								System.out.println("The selling price is " + sellingprice);
								System.out.println("Enter the available quantity ");
								int availableQuantity = sc.nextInt();
								amount=sellingprice*availableQuantity;
								System.out.println("The amount spend here is " + amount );
								double profit= sellingprice-buyingprice;
								System.out.println("The profit earned is " + profit);
								if(sellingprice<100) {
								System.out.println("\n Your price is less than hundrad rupees ");
								}
								
								else {
									System.out.println("Your Selling Price is greater than 100 ");
								}
								
								Product p1 = new Product(pid,pname,productCategory,buyingprice,sellingprice);
								p = dao.addProduct(p1);
							    break;
							    
							    
						case 3: System.out.println("Enter the ID of Product: ");
								pid = sc.nextInt();
								p = dao.getProById(pid);
							    break;
							    
						case 4:	System.out.println("Enter the Category to search : ");
							    productCategory = sc.next();
								p = dao.searchProductbycategory(productCategory);
							    break;	
							    
						case 5: System.out.println("Enter the product name to be searched :");
							    pname = sc.next();
							    p = dao.searchProduct(pname);
							    break;
							   
						case 6: System.out.println("Enter the name to delete record:");
						        pname = sc.next();
						        p = dao.delProduct(pname);
						        break;
						        
						case 7: System.out.println("Enter the id to update:");
						        int id3 = sc.nextInt();
					            System.out.println("Enter the new Product Name: ");
					            String name1 = sc.next();
					            p = dao.updateProduct(id3, name1);
					            break;
					       
						        
						case 8: System.out.println("Your bill is ready");
						        dao.printbill();
						        break;
						
						
						case 0:
							    ch =false;
							    System.out.println("Exited from Customer Menu ...");
					
						}
					}
				}
				break;
				
			case 3:
				System.out.println("Hello Princy Please Verify Yourself......");
				System.out.println("Enter Username");
				String userName = sc.next();
				System.out.println("Enter the Password");
				String password  = sc.next();
				
				Admin ad = new Admin();
			if(ad.getAdminUserName().equals(userName) && ad.getAdminPassword().equals(password)) {
				System.out.println("Hello Princy");
				System.out.println("Welcome to Admin Menu");
				
				
				boolean flag =true;
					while(flag){

						System.out.println("");
						System.out.println("           1.Get all items available in store ");
						System.out.println("           2.Get products available in customer cart ");
						System.out.println("           3.Get copy of bill of customer ");
						
						System.out.println("           Enter 0 to exit ");
						
						//input from keyboard
						choice = sc.nextInt();
					switch(choice)
					{
					
					case 0:
						flag = false;
						System.out.println("Exited Successsfully Thank you for using this app");
						break; 					       
					
					       
					case 1: System.out.println("Product Data");
							//System.out.println("Enter OPTION 2 once");
							//int pid=sc.nextInt();
							dao.getAllProduct();
							break;
							
					case 2: System.out.println("Products available in customers carts are"); 
					        dao.printbill();
					        break;
					   
      
					case 3: System.out.println("Copy Of BILL is"); 
						    dao.printbill();
						    break;
//						   
//					case 10:
//						System.out.println("for login ENter CUstomers SUername ");
//						String userName = sc.next();
//						System.out.println("Enter the Passwprd");
//						String password  = sc.next();
//						dao.UserLogin(userName, password);
//						break;
						    
					}
					
					}
			}
			else {
				System.out.println("wrong Credintial");
			}
				break;
			}
			
			
		}

	}
}