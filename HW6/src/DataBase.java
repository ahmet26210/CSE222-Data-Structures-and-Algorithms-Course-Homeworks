package linkedlist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import linkedlist.sorting;
public class DataBase{
	public void ReadandSort() throws IOException{
		LinkedList<String> Traders =new LinkedList<>();
		ArrayList<String[]> rowsArrayList = new ArrayList<>();
		String filepath=System.getProperty("user.dir") + File.separator +"e-commerce-samples.csv";
		BufferedReader csvReader = new BufferedReader(new FileReader(filepath));
		String head =csvReader.readLine();
		String rowString;
		while((rowString = csvReader.readLine())!=null) {
			String[] dataStrings = rowString.split(";");
			rowsArrayList.add(dataStrings);
		}
		csvReader.close();
		
		System.out.println("All datas is added to the file ! ");
		System.out.println("Sorting ...");
		
		
		Collections.sort(rowsArrayList, new Comparator<String[]>(){
			@Override
			public int compare(String[] o1, String[] o2) {
				return o1[6].compareTo(o2[6]);	
			}
		});
		
		FileWriter csWriter = new FileWriter("sortedProduct.csv");
		csWriter.append(String.join(";",head +"\n"));

		for(String[] rStrings : rowsArrayList) {
			csWriter.append(rStrings[0]+";" + rStrings[1]+";" + rStrings[2]+";" + rStrings[3]+";" + rStrings[4]+";" + rStrings[5]+";" + rStrings[6]+";" +"\n");
		} 
		
		csWriter.flush();
		csWriter.close();
		
		FileWriter TraderWriter = new FileWriter("Trader.csv");
		TraderWriter.append("User Role "+ "ID " + "Password " + "Name " + "\n");
		
		for(String[] a : rowsArrayList) {
			Traders.add(a[6]);	
		}
		
		Collections.sort(Traders, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);	
			}
		});
		
		int a=50000000;

		String aString2="";
		for(int i =0 ;i< Traders.size();i++) {
			if(aString2.compareTo(Traders.get(i))!=0) {
				TraderWriter.append("T"+";"+ a + ";"+ "abcdef" +";" +Traders.get(i)+";" + "\n");
				aString2=Traders.get(i);
				a++;
			}
		} 
		for(int i=0;i<10 ; i++) {
			TraderWriter.append("C"+";"+ a + ";"+ "abcfed" +";" +"Ahmet"+i+";" + "\n");
			a++;
		}
		TraderWriter.flush();
		TraderWriter.close();
		rowsArrayList=null;
		Traders=null;
	}
	
}
