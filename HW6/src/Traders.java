package linkedlist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;


public class Traders extends Person implements TraderInterface{

	boolean checkTrader;
	
	public Traders(String name, String surname, String id, String password) throws IOException {
		super(name, surname, id, password);
		checkTrader=CheckTrader(name,id,password);
	}
	public boolean CheckTrader(String name ,String ID ,String Password)  throws IOException{
		String aString=name;
		
		String filepath1=System.getProperty("user.dir") + File.separator +"Trader.csv";
		BufferedReader csvReader1 = new BufferedReader(new FileReader(filepath1));
		LinkedList<String[]> rowslinkedlist= new LinkedList<>();
		
		String rowString1;
		boolean control=false;
		String head =csvReader1.readLine();
		while((rowString1 = csvReader1.readLine())!=null) {
			String[] dataStrings = rowString1.split(";");
			rowslinkedlist.add(dataStrings);
		}
		for(String[] rStrings : rowslinkedlist) {
			if(rStrings[3].compareTo(aString)==0 && rStrings[1].compareTo(ID)==0 && rStrings[2].compareTo(Password)==0) {
				control=true;
				
				break;
			}
		}
		csvReader1.close();
		rowslinkedlist=null;
		if(control==false) {
			return false;
		}
		else {
			return true;
		}
		
	}
	public boolean CheckCustomer(String name)  throws IOException{
		String filepath=System.getProperty("user.dir") + File.separator +"Trader.csv";
		BufferedReader csvReader = new BufferedReader(new FileReader(filepath));
		HashMap<String,String[]> hashMap=new HashMap<>();
		String head1 =csvReader.readLine();
		String rowString;
		while((rowString = csvReader.readLine())!=null) {
			String[] dataStrings = rowString.split(";");
			hashMap.put(dataStrings[0],dataStrings);
		}
		csvReader.close();
		
		for(String string : hashMap.keySet()) {
			if(string.compareTo("C")==0) {
				String aString=	hashMap.get(string)[3];
				if(aString.compareTo(name)==0) {
					return true;
				}
			}
		}
		hashMap=null;
		return false;
	}
	public boolean addProducts(Product product) throws IOException {
		if(checkTrader==false) {
			return false;
		}
		ArrayList<String[]> rowsArrayList = new ArrayList<>();
		String filepath=System.getProperty("user.dir") + File.separator +"sortedProduct.csv";
		BufferedReader csvReader = new BufferedReader(new FileReader(filepath));
		
		String head1 =csvReader.readLine();
		String rowString;
		while((rowString = csvReader.readLine())!=null) {
			String[] dataStrings = rowString.split(";");
			rowsArrayList.add(dataStrings);
		}
		csvReader.close();
		
		for(String[] rStrings :rowsArrayList) {
			if(rStrings[0].compareTo(product.getId())==0) {
				System.out.println("Product is already in file so you can not add one more time product that with same id");
				return false;
			}
		}
		
		String[] strings=new String[7];
		strings[0]=product.getId();
		strings[1]=product.getProduct_name();
		strings[2]=product.getProduct_category_tree();
		strings[3]=product.getPrice();
		strings[4]=product.getDiscounted_price();
		strings[5]=product.getDescription();
		strings[6]=product.getTrader();
		
		for(String[] rStrings :rowsArrayList) {
			if(rStrings[0].compareTo(product.getId())==0) {
				return false;
			}
		}
		
		rowsArrayList.add(strings);
		
		Collections.sort(rowsArrayList, new Comparator<String[]>(){
			@Override
			public int compare(String[] o1, String[] o2) {
				return o1[6].compareTo(o2[6]);	
			}
		});
		
		FileWriter csWriter = new FileWriter("sortedProduct.csv");
		csWriter.append(String.join(";",head1 +"\n"));

		for(String[] rStrings : rowsArrayList) {
			csWriter.append(rStrings[0]+";" + rStrings[1]+";" + rStrings[2]+";" + rStrings[3]+";" + rStrings[4]+";" + rStrings[5]+";" + rStrings[6]+";" +"\n");
		} 
		rowsArrayList=null;
		csWriter.flush();
		csWriter.close();
		return true;
	}
	public boolean removeProduct(String ID) throws IOException {
		if(checkTrader==false) {
			return false;
		}
		ArrayList<String[]> rowsArrayList = new ArrayList<>();
		String filepath=System.getProperty("user.dir") + File.separator +"sortedProduct.csv";
		BufferedReader csvReader = new BufferedReader(new FileReader(filepath));
		
		String head1 =csvReader.readLine();
		String rowString;
		while((rowString = csvReader.readLine())!=null) {
			String[] dataStrings = rowString.split(";");
			rowsArrayList.add(dataStrings);
		}
		csvReader.close();
	
		
		for(String[] rStrings :rowsArrayList) {
			if(rStrings[0].compareTo(ID)==0) {
				
				rowsArrayList.remove(rStrings);
				break;
			}
		}
		Collections.sort(rowsArrayList, new Comparator<String[]>(){
			@Override
			public int compare(String[] o1, String[] o2) {
				return o1[6].compareTo(o2[6]);	
			}
		});
		FileWriter csWriter = new FileWriter("sortedProduct.csv");
		csWriter.append(String.join(";",head1 +"\n"));

		for(String[] rStrings : rowsArrayList) {
			csWriter.append(rStrings[0]+";" + rStrings[1]+";" + rStrings[2]+";" + rStrings[3]+";" + rStrings[4]+";" + rStrings[5]+";" + rStrings[6]+";" +"\n");
		} 
		
		csWriter.flush();
		csWriter.close();
		rowsArrayList=null;
		return true;
	}
	public boolean editProduct(Product product,String ChangedItem,int i) throws IOException {
		if(checkTrader==false) {
			
			return false;
		}
		ArrayList<String[]> rowsArrayList = new ArrayList<>();
		String filepath=System.getProperty("user.dir") + File.separator +"sortedProduct.csv";
		BufferedReader csvReader = new BufferedReader(new FileReader(filepath));
		
		String head1 =csvReader.readLine();
		String rowString;
		while((rowString = csvReader.readLine())!=null) {
			String[] dataStrings = rowString.split(";");
			rowsArrayList.add(dataStrings);
		}
		csvReader.close();
		
		for(String[] rStrings :rowsArrayList) {
			if(rStrings[0].compareTo(product.getId())==0) {
				
				rStrings[i]=ChangedItem;
				break;
			}
		}
		
		Collections.sort(rowsArrayList, new Comparator<String[]>(){
			@Override
			public int compare(String[] o1, String[] o2) {
				return o1[6].compareTo(o2[6]);	
			}
		});
		FileWriter csWriter = new FileWriter("sortedProduct.csv");
		csWriter.append(String.join(";",head1 +"\n"));

		for(String[] rStrings : rowsArrayList) {
			csWriter.append(rStrings[0]+";" + rStrings[1]+";" + rStrings[2]+";" + rStrings[3]+";" + rStrings[4]+";" + rStrings[5]+";" + rStrings[6]+";" +"\n");
		} 
		rowsArrayList=null;
		csWriter.flush();
		csWriter.close();
		return true;
	}
	public boolean seeCustomerOrder(Customer customer) throws IOException {
		if(checkTrader==false) {
			return false;
		}
		if(!CheckCustomer(customer.getName())) {
			return false;
		}
		String filepath=System.getProperty("user.dir") + File.separator +"Orders.csv";
		BufferedReader csvReader = new BufferedReader(new FileReader(filepath));
		String head1 =csvReader.readLine();
		String rowString;
		while((rowString = csvReader.readLine())!=null) {
			String[] rStrings = rowString.split(";");
			if(rStrings[7].compareTo(customer.getName())==0) {
				Product product = new Product(rStrings[0],rStrings[1],rStrings[2],rStrings[3],rStrings[4],rStrings[5],rStrings[6]);
				System.out.println(product);
			}
		}
		csvReader.close();
		
		
		return true;
	}
	public boolean MeetOrder(Customer customer ,String ID) throws IOException {
		if(checkTrader==false) {
			return false;
		}
		if(!CheckCustomer(customer.getName())) {
			return false;
		}
		ArrayList<String[]> rowsArrayList = new ArrayList<>();
		String filepath=System.getProperty("user.dir") + File.separator +"Orders.csv";
		BufferedReader csvReader = new BufferedReader(new FileReader(filepath));
		String head1 =csvReader.readLine();
		String rowString;
		while((rowString = csvReader.readLine())!=null) {
			String[] dataStrings = rowString.split(";");
			if(dataStrings[7].compareTo(customer.getName())==0) {
				rowsArrayList.add(dataStrings);
			}
		}
		csvReader.close();
		
		ArrayList<String[]> rowsArrayList1 = new ArrayList<>();
		String filepath1=System.getProperty("user.dir") + File.separator +"sortedProduct.csv";
		BufferedReader csvReader1 = new BufferedReader(new FileReader(filepath1));
		String head2 =csvReader1.readLine();
		String rowString2;
		while((rowString2 = csvReader1.readLine())!=null) {
			String[] dataStrings = rowString2.split(";");
			rowsArrayList1.add(dataStrings);
		}
		csvReader1.close();
		
		boolean control= false;
		for(String[] rStrings :rowsArrayList1) {
			if(rStrings[0].compareTo(ID)==0) {
				rowsArrayList1.remove(rStrings);
				control=true;
				break;
			}
		}
		
		if(control==true) {
			for(String[] rStrings :rowsArrayList) {
				if(rStrings[0].compareTo(ID)==0) {
					Product product = new Product(rStrings[0],rStrings[1],rStrings[2],rStrings[3],rStrings[4],rStrings[5],rStrings[6]);
					
					rowsArrayList.remove(rStrings);
					break;
				}
			}
		}
		
		FileWriter csWriter = new FileWriter("Orders.csv");
		csWriter.append(String.join(";",head1 +"\n"));

		for(String[] rStrings : rowsArrayList) {
			csWriter.append(rStrings[0]+";" + rStrings[1]+";" + rStrings[2]+";" + rStrings[3]+";" + rStrings[4]+";" + rStrings[5]+";" + rStrings[6]+";" +rStrings[7]+";"+"\n");
		} 
		
		csWriter.flush();
		csWriter.close();
		
		FileWriter csWriter1 = new FileWriter("sortedProduct.csv");
		csWriter1.append(String.join(";",head2 +"\n"));

		for(String[] rStrings : rowsArrayList1) {
			csWriter1.append(rStrings[0]+";" + rStrings[1]+";" + rStrings[2]+";" + rStrings[3]+";" + rStrings[4]+";" + rStrings[5]+";" + rStrings[6]+";" +"\n");
		} 
		rowsArrayList=null;
		rowsArrayList1=null;
		csWriter1.flush();
		csWriter1.close();
		return true;
	}
	public boolean CancelOrder(Customer customer ,String ID) throws IOException {
		if(checkTrader==false) {
			return false;
		}
		if(!CheckCustomer(customer.getName())) {
			return false;
		}
		TreeSet<Product> rowsTreeSet = new TreeSet<>();
		String filepath=System.getProperty("user.dir") + File.separator +"Orders.csv";
		BufferedReader csvReader = new BufferedReader(new FileReader(filepath));
		String head1 =csvReader.readLine();
		String rowString;
		while((rowString = csvReader.readLine())!=null) {
			String[] rStrings = rowString.split(";");
			if(rStrings[7].compareTo(customer.getName())==0) {
				Product product = new Product(rStrings[0],rStrings[1],rStrings[2],rStrings[3],rStrings[4],rStrings[5],rStrings[6]);
				rowsTreeSet.add(product);
			}
		}
		csvReader.close();
		
		for(Product product :rowsTreeSet) {
			if(product.getId().compareTo(ID)==0) {
				
				rowsTreeSet.remove(product);
				break;
			}
		}
		
		FileWriter csWriter = new FileWriter("Orders.csv");
		csWriter.append(String.join(";",head1 +"\n"));

		for(Product p : rowsTreeSet) {
			csWriter.append(p.getId()+";" + p.getProduct_name()+";" + p.getProduct_category_tree()+";" +p.getPrice()+";" +p.getDiscounted_price()+";" 
					+ p.getDescription()+";" + p.getTrader() +";"+customer.getName()+";"+"\n");
		} 
		rowsTreeSet=null;
		csWriter.flush();
		csWriter.close();
		return true;
	}
	
}
