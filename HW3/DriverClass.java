//package twes;
public class DriverClass {
	public static void main(String[] args) {
		try {
			Company company=new Company("Kurban Holding","Adem","Catal",10);
			menu(company);
		}
		catch(addAdminException e) {
			e.fillInStackTrace();
		}
		
	}
	public static void menu(Company company){
		int index=0,index1=0;
		try{
			System.out.println("--------------------TEST PART IS STARTING ---------------------");
			Administrator admin = company.getAdministrator();
			System.out.println(company);
			admin.addBranch(1);
			admin.addBranch(1);
			admin.addBranch(2);
			admin.addBranch(3);
			admin.addBranch(4);
			admin.addBranch(5);
			admin.removeBranch(5);
			admin.removeBranch(5);
		
			System.out.println("--------------------------------------------------");
			for(int i=0 ; i < company.getBranch().getSize() ; ++i)
				System.out.println(company.getBranch().get(i));
			System.out.println("--------------------------------------------------");
			
	        Branch branch = new Branch(company,1);
	         if(company.getBranch().contains(branch) != false)//-------
	         {
	             if(admin.addBranchEmployee(1,"Mehmet","kurban",1234))
	                System.out.println("Adding branch employee is successful.");
	             if(admin.addBranchEmployee(1,"Ahmet","kurban",123))
	            	 System.out.println("Adding branch employee is successful.");
	             if(admin.addBranchEmployee(1,"Ali","kurban",12345))
	            	 System.out.println("Adding branch employee is successful.");
	             else
	                 System.out.println("The branch already has this employee!");
	         }
	         else
	             System.out.println("Branch could not found!");
	         
	         branch = new Branch(company,2);
	         if(company.getBranch().contains(branch) != false)//---------
	         {
	             if(admin.addBranchEmployee(2,"Mehmet","kurban",1234))
	                System.out.println("Adding branch employee is successful.");
	             else
	                 System.out.println("The branch already has this employee!");
	             if(admin.addBranchEmployee(2,"Ahmet","kurban",123))
	            	 System.out.println("Adding branch employee is successful.");
	             else
	                 System.out.println("The branch already has this employee!");
	             if(admin.addBranchEmployee(2,"Ali","kurban",12345))
	            	 System.out.println("Adding branch employee is successful.");
	             else
	                 System.out.println("The branch already has this employee!");
	         }
	         else
	             System.out.println("Branch could not found!");
	         
	         branch = new Branch(company,3);
	         if(company.getBranch().contains(branch) !=false)//----------
	         {
	             if(admin.addBranchEmployee(3,"Mehmet","kurban",1234))
	                System.out.println("Adding branch employee is successful.");
	             else
	                 System.out.println("The branch already has this employee!");
	             if(admin.addBranchEmployee(3,"Ahmet","kurban",123))
	            	 System.out.println("Adding branch employee is successful.");
	             else
	                 System.out.println("The branch already has this employee!");
	             if(admin.addBranchEmployee(3,"Ali","kurban",12345))
	            	 System.out.println("Adding branch employee is successful.");
	             else
	                 System.out.println("The branch already has this employee!");
	         }
	         else
	             System.out.println("Branch could not found!");
	         
	         System.out.println("--------------------------------------------------");
	         branch = new Branch(company,2);
	         if(company.getBranch().contains(branch) != false) {//------------
	        	 index = company.getBranch().indexOf(branch);
	             printAllBranchEmployees(company.getBranch().get(index));
	         }
	         else
	             System.out.println("Branch could not found!");
	
	         System.out.println("--------------------------------------------------");
	         branch = new Branch(company,2);
	         if(company.getBranch().contains(branch) != false)
	         {
	             if(admin.removeBranchEmployee(2,"Ali","kurban",12345))
	                 System.out.println("Removing branch employee is successful.");
	             else
	                 System.out.println("The branch does not have this employee!");
	         }
	         else
	             System.out.println("Branch could not found!");
	         
	  
	         branch = new Branch(company,2);
	         if(company.getBranch().contains(branch) != false) {
	        	 index = company.getBranch().indexOf(branch);
	             printAllBranchEmployees(company.getBranch().get(index));
	         }
	         else
	             System.out.println("Branch could not found!");
	         System.out.println("--------------------------------------------------");
	         branch = new Branch(company,2);
	         BranchEmployee employee=company.getBranch().get(2).getBranchEmployee().get(1);
	         employee = company.getBranch().get(index).getBranchEmployee().get(index1);
	         if((company.getBranch().contains(branch)) != false) {//------------
	        	 index = company.getBranch().indexOf(branch);
		         employee.addCustomer("Elon","Musk",1234567,"ElonMusk@gmail.com","231212312","1");
		         System.out.println("Adding customer operation is successful.");
		         employee.addCustomer("Ali","Baba",123457,"alibaba@gmail.com","21323512321","2");
		         System.out.println("Adding customer operation is successful.");
		         employee.addCustomer("Alis","Qurtua",123456,"AlisQurtua@gmail.com","13235123212","3");
	             System.out.println("Adding customer operation is successful.");
	         }
	         else
	             System.out.println("Branch could not found!");
	         System.out.println("--------------------------------------------------");
	        
	             
	         branch = new Branch(company,2);
	         if(company.getBranch().contains(branch) !=false) {//----------
	        	 index = company.getBranch().indexOf(branch);
	        	 printAllCustomer(company);
	         }
	         else
	        	 System.out.println("Branch could not found!");   
	         System.out.println("--------------------------------------------------");
	         
	         employee.removeCustomer("Ali","Baba",123457,"alibaba@gmail.com","21323512321","2");
	         System.out.println("Removing customer operation is successful.");
	         
	         branch = new Branch(company,2);
	         if(company.getBranch().contains(branch) !=false)
	             printAllCustomer(company);
	         else
	             System.out.println("Branch could not found!");
	         System.out.println("--------------------------------------------------");
	         Customer customer=company.getBranch().get(2).getCompany().getCustomer().get(1);
	         customer.listofProducts();
	         Desks desks=new Desks(1,1);
	         Chairs chair=new Chairs(1,1);
	         
	         System.out.println("Customer Search the product...");
	         index=customer.searchProducts(branch,desks,1,1);
	         System.out.println("Product is founded at that branch "+(index+1));
	         System.out.println("--------------------------------------------------");
	         
	         System.out.println("Employee is deleting the product");
	         if((index=branch.getDesks().contains(desks)) !=-1)
	        	 employee.removeProducts(desks,3,3);
	         System.out.println("--------------------------------------------------");
	         
	         System.out.println("Employee is adding the product");
	         employee.addProducts(desks, 3, 3);
	         
	         System.out.println("--------------------------------------------------");
	         customer.listofProducts();
	         
	         System.out.println("Orders succesfully Added");
	         employee.addNewOrder("Alis","Qurtua",123456,"AlisQurtua@gmail.com","13235123212","3",desks,1,1);
	         employee.addNewOrder("Alis","Qurtua",123456,"AlisQurtua@gmail.com","13235123212","3",desks,1,2);
	         employee.addNewOrder("Alis","Qurtua",123456,"AlisQurtua@gmail.com","13235123212","3",desks,1,3);
	         
	         employee.addNewOrder("Elon","Musk",1234567,"ElonMusk@gmail.com","231212312","1",chair,1,1);
	         employee.addNewOrder("Elon","Musk",1234567,"ElonMusk@gmail.com","231212312","1",chair,2,2);
	         employee.addNewOrder("Elon","Musk",1234567,"ElonMusk@gmail.com","231212312","1",chair,3,3);
	         employee.accesPreviousOrders("Alis","Qurtua",123456,"AlisQurtua@gmail.com","13235123212","3");
	         System.out.println("----------------------------------------------------------------");
	         System.out.println("Orders succesfully Added");
	         employee.accesPreviousOrders("Elon","Musk",1234567,"ElonMusk@gmail.com","231212312","1");
	         System.out.println("----------------------------------------------------------------");
	      
	         
	         employee.accesPreviousOrders("Alis","Qurtua",123456,"AlisQurtua@gmail.com","13235123212","3");
	         System.out.println("----------------------------------------------------------------");
	         
	         employee.updateOrders("Alis","Qurtua",123456,"AlisQurtua@gmail.com","13235123212","3",desks,1,3);//desk 1,3 sale here
	         System.out.println("Orders succesfully Updated after make sales");
	         employee.accesPreviousOrders("Alis","Qurtua",123456,"AlisQurtua@gmail.com","13235123212","3");
	         System.out.println("----------------------------------------------------------------");
	         
	         
	         branch = new Branch(company,2);
	         //customer.listofProducts();
	         Desks desk=new Desks(3,3);
	         
	         System.out.println("Customer is searching the product...");
	         index=customer.searchProducts(branch,desk,3,3);
	         if(index!=-1) {
	        	 System.out.println("Products is founded index :" +index);
	         }
	         System.out.println("----------------------------------------------------------------");
	         System.out.println("Customer is looking the his/her previous orders...");
	         customer.previousOrders();
	         System.out.println("----------------------------------------------------------------");
	         System.out.println("Customer is searching the product is which Branch...");
	         index=customer.findProductWhichBranch(company, desk,3, 3);
	         if(index!=-1) {
	        	 System.out.println("Products is founded at that branch index :" +(index+1));
	         }
	         System.out.println("----------------------------------------------------------------");
	         System.out.println("Customer is buying product...");
	         customer.BuyProduct("Elon","Musk",1234567,"ElonMusk@gmail.com","231212312","1",desk,4,4);
	         System.out.println("----------------------------------------------------------------");
	         
	         System.out.println("After buying product customer is looking his/her previous orders...");
	         customer.previousOrders();
	         
	         boolean control=false;
	         employee.addNewOrder("Alis","Qurtua",123456,"AlisQurtua@gmail.com","13235123212","3",desks,1,3);//there is no desk 1,3 because saled before to show findproduct function
	         control=employee.findProduct(company,desks,1,3,1,1);
	        		         
	         employee.addNewOrder("Alis","Qurtua",123456,"AlisQurtua@gmail.com","13235123212","3",desks,1,3);
	         control=false;
	         if(control==true)
	        	 employee.makeSales("Alis","Qurtua",123456,"AlisQurtua@gmail.com","13235123212","3",desks,1,3);
	      
	         System.out.println("----------------------------------------------------------------");
	         Customer customer3=new Customer(branch,"Burak","Koca",12331,"burakKoca@gmail.com","1323512","4");
	         customer3.BuyProduct("Burak","Koca",12331,"burakKoca@gmail.com","1323512","4",desks,1,1);//if customer's first shopping we subscribe him/her.
	         printAllCustomer(company);
	         //INVALID SITUATION
	         employee.addCustomer("Elon","Musk",1234567,"ElonMusk@gmail.com","231212312","1");
	         System.out.println("----------------------------------------------------------------");
	         employee.removeCustomer("Memati","Musk",12345672,"MematiMusk@gmail.com","2312123122","5");
	         System.out.println("----------------------------------------------------------------");
	         employee.accesPreviousOrders("Memati","Musk",12345672,"MematiMusk@gmail.com","2312123122","5");
	         System.out.println("----------------------------------------------------------------");
	         employee.addNewOrder("Memati","Musk",12345672,"MematiMusk@gmail.com","2312123122","5", desks, 1,1);
	         System.out.println("----------------------------------------------------------------");
	         employee.updateOrders("Memati","Musk",12345672,"MematiMusk@gmail.com","2312123122","5", desks, 1,1);
	         System.out.println("----------------------------------------------------------------");
	         System.out.println("-----------TEST PART IS DONE SUCCESFULLY EXCEPTION PART IS STARTING--------------");
		}
		
		catch(ThereIsNoEmployee e) {
			e.fillInStackTrace();
		}
		catch(ThereIsNoBranch e) {
			e.fillInStackTrace();
		}
		catch(Exception e) {
			System.out.println("There is wrong index");
		}
		finally {
		    System.out.println("The 'try catch' is finished.");
		}
	}
	public static void printCompanyFeatures(Company company) {
		System.out.println(company);
	}
	public static void printAllBranchEmployees(Branch branch){
		System.out.println(branch.getBranchEmployee().getSize()+"-------------------------");
	    for(int i=0 ; i < branch.getBranchEmployee().getSize() ; ++i)
	       System.out.println(branch.getBranchEmployee().get(i));
	}
	public static void printAllCustomer(Company company){
	    for(int i=0 ; i < company.getCustomer().getSize() ; ++i)
	        System.out.println(company.getCustomer().get(i));
	}
}
