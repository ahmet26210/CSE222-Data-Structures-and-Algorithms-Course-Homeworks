package linkedlist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class Customer extends Person{

	public Customer(String name, String surname, String id, String password) throws IOException {
		super(name, surname, id, password);
		CheckCustomer(name ,id,password);
	}
	public boolean CheckCustomer(String name ,String ID ,String Password)  throws IOException{
		String filepath=System.getProperty("user.dir") + File.separator +"Trader.csv";
		BufferedReader csvReader = new BufferedReader(new FileReader(filepath));
		ArrayList<String[]> rowsArrayList1 = new ArrayList<>();
		String head1 =csvReader.readLine();
		String rowString;
		while((rowString = csvReader.readLine())!=null) {
			String[] dataStrings = rowString.split(";");
			rowsArrayList1.add(dataStrings);
		}
		csvReader.close();
		
		for(String[] string : rowsArrayList1) {
			if(string[0].compareTo("C")==0) {
				if(string[3].compareTo(name)==0 && string[1].compareTo(ID)==0 && string[2].compareTo(Password)==0) {
					return true;
				}
			}
		}
		rowsArrayList1=null;
		return false;
	}

	public void addOrder(String ID) throws IOException {
		ArrayList<String[]> rowsArrayList = new ArrayList<>();
		String filepath=System.getProperty("user.dir") + File.separator +"sortedProduct.csv";
		BufferedReader csvReader = new BufferedReader(new FileReader(filepath));
		PriorityQueue<Product> orders= new PriorityQueue<Product>();
		String head1 =csvReader.readLine();
		String rowString;
		while((rowString = csvReader.readLine())!=null) {
			String[] dataStrings = rowString.split(";");
			rowsArrayList.add(dataStrings);
		}
		csvReader.close();
		
		String filepath1=System.getProperty("user.dir") + File.separator +"Orders.csv";
		BufferedReader csvReader1 = new BufferedReader(new FileReader(filepath1));
		String head2 =csvReader1.readLine();
		String rowString1;
		while((rowString1 = csvReader1.readLine())!=null) {
			String[] rStrings = rowString1.split(";");
			Product product = new Product(rStrings[0],rStrings[1],rStrings[2],rStrings[3],rStrings[4],rStrings[5],rStrings[6]);
			boolean a = orders.contains(product);
			if(a==false) orders.add(product);
		}
		csvReader1.close();
		
		for(String[] rStrings :rowsArrayList) {
			if(rStrings[0].compareTo(ID)==0) {
				Product product = new Product(rStrings[0],rStrings[1],rStrings[2],rStrings[3],rStrings[4],rStrings[5],rStrings[6]);
				orders.add(product);
				break;
			}
		}
		
		FileWriter csWriter = new FileWriter("Orders.csv");
		csWriter.append(String.join(";",head1 +"\n"));

		for(Product p : orders) {
			csWriter.append(p.getId()+";" + p.getProduct_name()+";" + p.getProduct_category_tree()+";" +p.getPrice()+";" +p.getDiscounted_price()+";" 
		+ p.getDescription()+";" + p.getTrader()+";" +this.getName()+";"+"\n");
		} 
		rowsArrayList=null;
		csWriter.flush();
		csWriter.close();
	}
	private ArrayList<Product> SearchProduct(String text) throws IOException {
		if(text==null) {
			return null;
		}
		ArrayList<Product> rowsArrayList = new ArrayList<>();
		String filepath=System.getProperty("user.dir") + File.separator +"sortedProduct.csv";
		BufferedReader csvReader = new BufferedReader(new FileReader(filepath));
		
		@SuppressWarnings("unused")
		String head1 =csvReader.readLine();
		String rowString;
		int k=0;
		boolean control1=false;
		boolean control2=false;
		int alength=text.length();
		while((rowString = csvReader.readLine())!=null) {
			control1=false;
			control2=false;
			k=0;
			String[] dataStrings = rowString.split(";");
			for(int i=0;i<dataStrings[1].length();i++) {
				if(dataStrings[1].charAt(i)==text.charAt(k)) {
					k++;
					if(k==alength) {
						control1=true;
						break;
					}
				}
				else {
					k=0;
				}
			}
			if(control1==true) {
				Product product = new Product(dataStrings[0],dataStrings[1],dataStrings[2],dataStrings[3],dataStrings[4],dataStrings[5],dataStrings[6]);
				rowsArrayList.add(product);
				continue;
			}
			k=0;
			for(int i=0;i<dataStrings[5].length();i++) {
				if(dataStrings[5].charAt(i)==text.charAt(k)) {
					k++;
					if(k==text.length()) {
						control2=true;
						break;
					}
				}
				else {
					k=0;
				}
			}
			if(control2==true) {
				Product product = new Product(dataStrings[0],dataStrings[1],dataStrings[2],dataStrings[3],dataStrings[4],dataStrings[5],dataStrings[6]);
				rowsArrayList.add(product);
			}
		}
		csvReader.close();
		return rowsArrayList;
	}
	Comparator<Product> comparatorname = new Comparator<Product>()  {
	    
	    public int compare(Product a, Product b)
	    {
	    	if(a.getProduct_name().compareTo(b.getProduct_name())<0) {
				return -1;
			}
			if(a.getProduct_name().compareTo(b.getProduct_name())>0) {
				return 1;
			}
			return 0;
	    }
	};
	Comparator<Product> comparatorTraderName = new Comparator<Product>()  {
	    
	    public int compare(Product a, Product b)
	    {
	    	if(a.getTrader().compareTo(b.getTrader())<0) {
				return -1;
			}
			if(a.getTrader().compareTo(b.getTrader())>0) {
				return 1;
			}
			return 0;
	    }
	};
	Comparator<Product> comparatorPrice = new Comparator<Product>()  {
	    
	    public int compare(Product a, Product b)
	    {
	    	if(a.getPrice().compareTo(b.getPrice())<0) {
				return -1;
			}
			if(a.getPrice().compareTo(b.getPrice())>0) {
				return 1;
			}
			return 0;
	    }
	};	
	Comparator<Product> comparatorPODiscount = new Comparator<Product>()  {
	    
	    public int compare(Product a, Product b)
	    {
	    	int number1= Integer.parseInt(a.getPrice());
	    	int number2= Integer.parseInt(b.getPrice());
	    	int number3= Integer.parseInt(a.getDiscounted_price());
	    	int number4= Integer.parseInt(b.getDiscounted_price());
	    	
	    	int percentageOfa=((number3*100) /number1);
	    	int percentageOfb=((number4*100) /number2);
	    	
	    	
	    	if(percentageOfa<percentageOfb) {
				return -1;
			}
	    	if(percentageOfa>percentageOfb) {
				return 1;
			}
			return 0;
	    }
	};
	public void SortedAccordingProductName(String text) throws IOException {
		if(text==null) {
			throw new NoSuchElementException();
		}
		ArrayList<Product> rowsArrayList =SearchProduct(text);
		sorting<Product> aSorting =new sorting<>();
		
		aSorting.QuickSort(rowsArrayList ,comparatorname);
		for(Product p :rowsArrayList) {
			System.out.println(p.getId()+"  "+p.getProduct_name());
		}
	}
	public void SortedAccordingPrice(String text) throws IOException {
		if(text==null) {
			throw new NoSuchElementException();
		}
		ArrayList<Product> rowsArrayList =SearchProduct(text);
		sorting<Product> aSorting =new sorting<>();
		
		aSorting.HeapSort(rowsArrayList ,comparatorPrice);
		for(Product p :rowsArrayList) {
			System.out.println(p.getId()+"  "+p.getPrice());
		}
	}
	public void SortedAccordingPSO(String text) throws IOException {
		if(text==null) {
			throw new NoSuchElementException();
		}
		ArrayList<Product> rowsArrayList =SearchProduct(text);
		sorting<Product> aSorting =new sorting<>();
		
		aSorting.InsertionSort(rowsArrayList ,comparatorPODiscount);
		for(Product p :rowsArrayList) {
			float number1= Integer.parseInt(p.getPrice());
	    	
	    	float number2= Integer.parseInt(p.getDiscounted_price());
	    	
	    	float percentageOfa=((number2*100) /number1);;
	    	
			System.out.println(p.getId()+"  "+p.getPrice() +" -> "+ p.getDiscounted_price() + " -> " +(100-percentageOfa));
		}
	}
	public void DisplayAllProduct(Traders trader) throws IOException {
		if(trader==null) {
			throw new NoSuchElementException();
		}
		ArrayList<Product> rowsArrayList = new ArrayList<>();
		String filepath=System.getProperty("user.dir") + File.separator +"sortedProduct.csv";
		BufferedReader csvReader = new BufferedReader(new FileReader(filepath));
		
		@SuppressWarnings("unused")
		String head1 =csvReader.readLine();
		String rowString;
		while((rowString = csvReader.readLine())!=null) {
			String[] rStrings = rowString.split(";");
			Product product = new Product(rStrings[0],rStrings[1],rStrings[2],rStrings[3],rStrings[4],rStrings[5],rStrings[6]);
			rowsArrayList.add(product);
		}
		csvReader.close();
		
		for(Product p:rowsArrayList) {
			if(p.getTrader().compareTo(trader.getName())==0) {
				System.out.println(p);
			}
		}
		
		rowsArrayList=null;
	}
	
	public void FilterUpperBoundPrice(String text , int Price) throws IOException {
		if(text==null) {
			throw new NoSuchElementException();
		}
		ArrayList<Product> rowsArrayList =SearchProduct(text);
		ArrayList<Product> rowsArrayList1 =new ArrayList<>();
		sorting<Product> aSorting =new sorting<>();
		aSorting.HeapSort(rowsArrayList ,comparatorPrice);
		for(Product p1:rowsArrayList) {
			int a=Integer.parseInt(p1.getPrice());
			if(a < Price) {
				rowsArrayList1.add(p1);
				
			}
		}
		for(Product p:rowsArrayList1) {
				System.out.println(p);
		}
		rowsArrayList=null;
		rowsArrayList1=null;
	}
	public void FilterLowerBoundPrice(String text , int Price) throws IOException {
		if(text==null) {
			throw new NoSuchElementException();
		}
		ArrayList<Product> rowsArrayList =SearchProduct(text);
		ArrayList<Product> rowsArrayList1 =new ArrayList<>();
		sorting<Product> aSorting =new sorting<>();
		aSorting.ShellSort(rowsArrayList ,comparatorPrice);
		for(Product p1:rowsArrayList) {
			int a=Integer.parseInt(p1.getPrice());
			if(a > Price) {
				rowsArrayList1.add(p1);
			}
		}
		for(Product p:rowsArrayList1) {
				System.out.println(p);
		}
		rowsArrayList=null;
		rowsArrayList1=null;
	}
	public void FilterLowerandUpperBoundPrice(String text , int PriceLowerBound,int PriceUpperBound) throws IOException {
		if(text==null) {
			throw new NoSuchElementException();
		}
		ArrayList<Product> rowsArrayList =SearchProduct(text);
		ArrayList<Product> rowsArrayList1 =new ArrayList<>();
		sorting<Product> aSorting =new sorting<>();
		aSorting.ShellSort(rowsArrayList ,comparatorPrice);
		for(Product p1:rowsArrayList) {
			int a=Integer.parseInt(p1.getPrice());
			if(a > PriceLowerBound && a < PriceUpperBound) {
				rowsArrayList1.add(p1);
			}
		}
		for(Product p:rowsArrayList1) {
				System.out.println(p);
		}
		rowsArrayList=null;
		rowsArrayList1=null;
	}
	public void FilterCatagory(String text,String Catagory) throws IOException{
		if(text==null) {
			throw new NoSuchElementException();
		}
		ArrayList<Product> rowsArrayList =SearchProduct(text);
		ArrayList<Product> rowsArrayList1 =new ArrayList<>();
		for(Product p:rowsArrayList) {
			String[] dataStrings = p.getProduct_category_tree().split(">>");
			
			for(String aString : dataStrings) {
				if(aString.compareTo(Catagory)==0) {
					rowsArrayList1.add(p);
				}
			}
		}
		for(Product p:rowsArrayList1) {
			System.out.println(p);
		}
		rowsArrayList=null;
		rowsArrayList1=null;
	}
}
