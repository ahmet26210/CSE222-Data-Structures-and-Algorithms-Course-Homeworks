package linkedlist;
import java.io.IOException;
import java.util.Scanner;
public class MainClass {
	@SuppressWarnings("resource")
	public static void main (String[] args) throws IOException {
		
			System.out.println("WELCOME TO E-SHOPPING");
			DataBase aBase = new DataBase();
			aBase.ReadandSort();
			try{
				Traders traders3 =new Traders("1OAK","f","50000001","abcdef");
			}
			catch(Exception e){
				System.out.println(e);
			}
			try{
				Customer customer3 =new Customer("Ahmet1","furkan","50003181","abcfed");
			}
			catch(Exception e){
				System.out.println(e);
			}
			Traders traders =new Traders("1OAK","f","50000000","abcdef");
			
			Product product=new Product("LGTEGZ5HBUJZXHGA","1OAK Women's Plural Print Casual Shirt"
					,"\"[\"\"Clothing >> Women's Clothing >> Western Wear >> Shirts, Tops & Tunics >> Shirts >> 1OAK Shirts >> 1OAK Women's Plural Print Casual Shirt\"\"]\""
					,"899","444","AAAAAAA","1OAK");
			Product product1=new Product("CRTEA7HAZZEFHSGX","1OAK Women's Good Print Casual Shirt"
					,"\"[\"\"Clothing >> Women's Clothing >> Western Wear >> Shirts, Tops & Tunics >> Shirts >> 1OAK Shirts >> 1OAK Women's Good Print Casual Shirt\"\"]\""
					,"895","422","CCCCCC","1OAK");
			traders.addProducts(product);
			
			traders.removeProduct("SHTEHUY4DGTGAYBS");
			
			traders.editProduct(product,"BBBBBBBB",2);
			
			Customer customer =new Customer("Ahmet9","furkan","50003189","abcfed");
			customer.addOrder("CRTEA7HASSJUVUUV");
			customer.addOrder("CRTEA7HAHHCSHCEM");
			customer.addOrder("CRTEA7HAATHHK6EA");
			customer.addOrder("CRTEA7HA7X3CW7YQ");
			customer.addOrder("CRTEA7HAJDHDXA9G");
			customer.addOrder("CRTEA7HAZZEFHSGX");
			
			traders.MeetOrder(customer, "CRTEA7HASSJUVUUV");
			
			traders.CancelOrder(customer, "CRTEA7HAJDHDXA9G");
			
			traders.seeCustomerOrder(customer);
			System.out.println("Sorted According to the name !");
			customer.SortedAccordingProductName("3a AUTOCARE");
			
			System.out.println("Sorted According to the Price !");
			customer.SortedAccordingPrice("3a AUTOCARE");
			
			System.out.println("Sorted According to the Percantege of discounted price!");
			customer.SortedAccordingPSO("3a AUTOCARE");
			
			System.out.println("Displayy all product of traders !");
			customer.DisplayAllProduct(traders);
			
			System.out.println("FilterUpperBoundPrice of text");	
			customer.FilterUpperBoundPrice("3a AUTOCARE",2300);
			
			System.out.println("FilterLowerBoundPrice of text");
			customer.FilterLowerBoundPrice("3a AUTOCARE",2500);
			
			System.out.println("FilterLowerandUpperBoundPrice of text");
			customer.FilterLowerandUpperBoundPrice("3a AUTOCARE",2500,3500);
			
			System.out.println("FilterCatagory of text");
			customer.FilterCatagory("3a AUTOCARE"," Accessories & Spare parts ");
		

		
		System.out.println("Enter User Id and Password for Traders");
		Scanner input = new Scanner(System.in);
		boolean choice1 =true;
	    while(choice1) {
	    	System.out.print("Please Enter a Id for Trader: ");
	 	    String Id = input.nextLine(); 
	 	    System.out.println("Your Id "+Id);
	 	    
	 	    System.out.print("Please Enter a Password for Trader: ");
	 	    String Password = input.nextLine(); 
	 	    System.out.println("Your Password: "+Password);
	 	    Traders traders2 = new Traders("1OAK","", Id, Password);
		    if(CheckIdandPassword(Id,Password) && traders2.CheckTrader("1OAK",Id,Password)) {
		    	choice1=false;
		    	System.out.println("You succesfully login to the system !");
		    	menu1(traders2, customer,product1);
		    }
		    else {
				System.out.println("Id or Password is not applicable. Try Again! ");
			}
	    }
	    System.out.println("-----------------------------------------------------------");
	    
	    System.out.println("Enter User Id and Password for Customers");
		Scanner input1 = new Scanner(System.in); 
		
	    
	    boolean choice2 =true;
	    while(choice2) {
	    	System.out.print("Please Enter a Name for customer : ");
		    String name = input1.nextLine();
	    	System.out.print("Please Enter a Id for Customer : ");
		    String Id1 = input1.nextLine(); 
		    System.out.println("Your Id "+Id1);
		    
		    System.out.print("Please Enter a Password for Customer : ");
		    String Password1 = input1.nextLine(); 
		    System.out.println("Your Password: "+Password1);
		    Customer customer2= new Customer(name,"", Id1, Password1);
		    
		   
		    customer2.addOrder("CRTEA7HASSJUVUUV");
			customer2.addOrder("CRTEA7HAJDHDXA9G");
			customer2.addOrder("CRTEA7HAZZEFHSGX");
		    if(CheckIdandPassword(Id1,Password1) && customer2.CheckCustomer(name, Id1, Password1)) {
		    	choice2=false;
		    	menu2(customer2 , traders);
		    }
		    else {
				System.out.println("Id or Password is not applicable. Try Again! ");
			}
	    }
	}
	@SuppressWarnings("resource")
	public static void menu1(Traders traders,Customer customer ,Product product) throws IOException {
		System.out.println("Menu for Traders ");
		boolean control=true;
		while(control) {
			System.out.println("(1)-> Add Products");
			System.out.println("(2)-> Remove Products");
			System.out.println("(3)-> Edit Products");
			System.out.println("(4)-> See List of Orders ");
			System.out.println("(5)-> Meet Orders");
			System.out.println("(6)-> Cancel Orders");
			System.out.println("(7)-> Customer Login");
			Scanner input = new Scanner(System.in); 
		    System.out.print("Please Choose one of them : ");
		    int Choice = input.nextInt(); 
			switch (Choice) {
			case 1: {
				Scanner input1 = new Scanner(System.in);
				System.out.print("Enter ID : ");
				String Choice1 = input1.nextLine();
			
				System.out.print("Enter Product Name : ");
				String Choice2 = input1.nextLine();
				
				System.out.print("Enter Catagory : ");
				String Choice3 = input1.nextLine();
				
				System.out.print("Enter Price : ");
				String Choice4 = input1.nextLine();
				
				System.out.print("Enter Discounted Price : ");
				String Choice5 = input1.nextLine();
				
				System.out.print("Enter Dscription : ");
				String Choice6 = input1.nextLine();
			
				System.out.print("Enter Trader Name : ");
				String Choice7 = input1.nextLine();
				
				Product pruProduct = new Product(Choice1, Choice2, Choice3, Choice4, Choice5, Choice6, Choice7);
				traders.addProducts(pruProduct);
				System.out.println("You Succesfully add the product to the file !");
				break;
			}
			case 2: {
				Scanner input2 = new Scanner(System.in);
				System.out.print("Please Enter a Id for Trader: ");
			    String Choice1 = input2.nextLine();
			    
				traders.removeProduct(Choice1);
				
				System.out.println("You Succesfully remove the product from the file !");
				break;
			}
			case 3: {
				System.out.println("Please Enter a string to change element and int for index for which features (0 ->ID , 1->Product-Name ...): ");
				Scanner input2 = new Scanner(System.in);
				System.out.print("ENTER STRING: ");
			    String Choice1 = input2.nextLine();
			    System.out.print("ENTER INTEGER : ");
			    int Choice2 = input2.nextInt();
				traders.editProduct(product,Choice1,Choice2);
				System.out.println("You Succesfully Edit the product!");
				break;
			}
			case 4: {
				traders.seeCustomerOrder(customer);
				break;
			}
			case 5: {
				System.out.print("Enter String (ID) for which element do you want to meet: ");
				Scanner input2 = new Scanner(System.in);
			    String Choice1 = input2.nextLine();
				traders.MeetOrder(customer,Choice1);
				System.out.println("You Succesfully meet the product  !");
				break;
			}
			case 6: {
				System.out.print("Enter String (ID) for which element do you want to cancel: ");
				Scanner input2 = new Scanner(System.in);
			    String Choice1 = input2.nextLine();
				traders.CancelOrder(customer,Choice1);
				
				System.out.println("You Succesfully Cancel the product  !");
				break;
			}
			case 7: {
				System.out.println("You Successfully exit !");
				control=false;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + Choice);
			}
		}
	}
	@SuppressWarnings("resource")
	public static void menu2(Customer customer,Traders traders) throws IOException {
		System.out.println("Menu for Customers ");
		boolean control=true;
		while(control) {
			System.out.println("(1)-> Add Order");
			System.out.println("(2)-> Sort Products According to name");
			System.out.println("(3)-> Sort Products According to Price");
			System.out.println("(4)-> Sort Products According to Percentage of discounted price");
			System.out.println("(5)-> Display Products");
			System.out.println("(6)-> FilterUpperBoundPrice");
			System.out.println("(7)-> FilterLowerBoundPrice");
			System.out.println("(8)-> FilterLowerandUpperBoundPrice");
			System.out.println("(9)-> FilterCatagory");
			System.out.println("(10)-> EXIT");
			Scanner input = new Scanner(System.in); 
		    System.out.print("Please choose one of them!: ");
		    int Choice = input.nextInt(); 
			switch (Choice) {
			case 1: {
				Scanner input1 = new Scanner(System.in); 
				System.out.print("Add ID to add Order: ");
				String choiceString =input1.nextLine(); 
				customer.addOrder(choiceString);
				break;
			}
			case 2: {
				Scanner input1 = new Scanner(System.in); 
				System.out.print("Add text to sort name: ");
				String choiceString =input1.nextLine(); 
				customer.SortedAccordingProductName(choiceString);
				break;
			}
			case 3: {
				Scanner input1 = new Scanner(System.in); 
				System.out.print("Add text to sort price: ");
				String choiceString =input1.nextLine(); 
				customer.SortedAccordingPrice(choiceString);
				break;
			}
			case 4: {
				Scanner input1 = new Scanner(System.in); 
				System.out.print("Add text to sort percentage of discounted price: ");
				String choiceString =input1.nextLine(); 
				customer.SortedAccordingPSO(choiceString);
				break;
			}
			
			case 5: {
				customer.DisplayAllProduct(traders);
				break;
			}
			case 6: {
				Scanner input1 = new Scanner(System.in); 
				System.out.print("Add text to search: ");
				String choiceString =input1.nextLine();
				System.out.print("Add upper bound price: ");
				int choice2 =input1.nextInt(); 
				customer.FilterUpperBoundPrice(choiceString,choice2);
				break;
			}
			case 7: {
				Scanner input1 = new Scanner(System.in); 
				System.out.print("Add text to search: ");
				String choiceString =input1.nextLine();
				System.out.print("Add lower bound price: ");
				int choice2 =input1.nextInt(); 
				customer.FilterLowerBoundPrice(choiceString,choice2);
				break;
			}
			case 8: {
				Scanner input1 = new Scanner(System.in); 
				System.out.print("Add text to search: ");
				String choiceString =input1.nextLine();
				System.out.print("Add lower bound price: ");
				int choice2 =input1.nextInt(); 
				System.out.print("Add upper bound price: ");
				int choice3 =input1.nextInt(); 
				customer.FilterLowerandUpperBoundPrice(choiceString,choice2,choice3);
				break;
			}
			case 9: {
				Scanner input1 = new Scanner(System.in); 
				System.out.print("Add text to search: ");
				String choiceString =input1.nextLine();
				System.out.print("Add text for filter catogory: ");
				String choiceString1 =input1.nextLine();
				customer.FilterCatagory(choiceString,choiceString1);
				break;
			}
			case 10: {
				control= false;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + Choice);
			}
		}
	}
	public static boolean CheckIdandPassword(String Id, String Password) {
		int number1=0 ,number2=0 ,maxnumber1=8,maxnumber2=6;
		boolean check1=false,check2=false;
		for (int i = 0; i < Id.length(); i++) {
			if(Character.isDigit(Id.charAt(i))) {
				number1++;
			}
		}
		
		if(number1==maxnumber1) {
			check1=true;
		}
		for (int i = 0; i < Password.length(); i++) {
			if(Character.isLetter(Password.charAt(i))) {
				number2++;
			}
		}
		
		if(number2==maxnumber2) {
			check2=true;
		}
		if(check1==true && check2==true) {
			return true;
		}
		else {
			return false;
		}
	}
}
