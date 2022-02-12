package linkedlist;

public class Main {
	public static void main(String[] args) {
		System.out.println("----------------------PART 1-------------------");
		System.out.println("--------------PARAMATER ITERATOR-------------------");
		HashMap<Integer ,Integer> hash = new HashMap<Integer ,Integer>();
		for(int i=0;i<45;i++) {
			hash.put(i, i*2);
		}
		HashMap<Integer, Integer>.MAPIterator iter2=hash.iterator().iterator(10);
		for(int i=0;i<hash.size();i++) {
			System.out.print(hash.get(i)+" ");
		}

		System.out.println();
		System.out.println(hash);
		System.out.println();
		
		
		while(iter2.hasNext()) {
			System.out.print(iter2.next()+" ");
		}
		System.out.println();
		for(int i=0;i<50;i++)
			System.out.print(iter2.prev()+" ");
		
		System.out.println();		
		for(int i=0;i<50;i++)
			System.out.print(iter2.next()+" ");
		System.out.println();
		System.out.println("--------------NO PARAMATER ITERATOR-------------------");
		HashMap<Integer ,Integer> hash1 = new HashMap<Integer ,Integer>();
		for(int i=0;i<45;i++) {
			hash1.put(i, i*2);
		}
		HashMap<Integer, Integer>.MAPIterator iter3=hash1.iterator();
		for(int i=0;i<hash1.size();i++) {
			System.out.print(hash1.get(i)+" ");
		}
	
		System.out.println();
		System.out.println(hash1);
		System.out.println();
		
		
		while(iter3.hasNext()) {
			System.out.print(iter3.next()+" ");
		}
		System.out.println();
		for(int i=0;i<50;i++)
			System.out.print(iter3.prev()+" ");
		
		System.out.println();		
		for(int i=0;i<50;i++)
			System.out.print(iter3.next()+" ");
		
		
		
		System.out.print("\n");
		System.out.println("--------------------------------------PART 2 LINKEDLIST----------------------------------");
		HashMapLinkedList<String, String> hash11 = new HashMapLinkedList<String,String>();
		System.out.println("isEmpty should return true : "+hash11.isEmpty());
		long time1 = System.nanoTime();
		for(int i=0;i<60;i++) {
			hash11.put(Integer.toString(i),Integer.toString(i+1000));
		} 
  		long time2 = System.nanoTime(); 
  		long addsonuc1_1=time2-time1;
  		
		System.out.println(hash11+"\n-------");
		int oldSize = hash11.size();
		time1 = System.nanoTime();
		for(int i=-10;i<50;i++) {
			hash11.remove(Integer.toString(i));
		}
		time2 = System.nanoTime();
		long removesonuc1_1=time2-time1;
		int newSize= hash11.size();
		System.out.println(oldSize +" - 50 = "+newSize+"\n"+"hash is not empty, is empty ? : "+hash11.isEmpty());
		System.out.println("--------After removing---------");
		System.out.println(hash11);
		
		time1 = System.nanoTime();
		for(int i = 50;i<70;i++) {
			System.out.println(i+"->"+hash11.get(Integer.toString(i)));
		}
		time2 = System.nanoTime();
		long getsonuc1_1=time2-time1;
		System.out.println("-------------------------------------------------------------------------");
		HashMapLinkedList<String, String> hash2 = new HashMapLinkedList<String,String>();
		System.out.println("isEmpty should return true : "+hash2.isEmpty());
		time1 = System.nanoTime();
		for(int i=0;i<200;i++) {
			hash2.put(Integer.toString(i),Integer.toString(i+1000));
		}
		time2 = System.nanoTime();
		long addsonuc1_2=time2-time1;
		System.out.println(hash2+"\n-------");
		int oldSize1 = hash2.size();
		
		time1 = System.nanoTime();
		for(int i=-10;i<190;i++) {
			hash2.remove(Integer.toString(i));
		}
		time2 = System.nanoTime();
		long removesonuc1_2=time2-time1;
		int newSize1= hash2.size();
		System.out.println(oldSize1 +" - 50 = "+newSize1+"\n"+"hash is not empty, is empty ? : "+hash2.isEmpty());
		System.out.println("--------After removing---------");
		System.out.println(hash2);
		
		time1 = System.nanoTime();
		for(int i = 50;i<70;i++) {
			System.out.println(i+"->"+hash2.get(Integer.toString(i)));
		}
		time2 = System.nanoTime();
		long getsonuc1_2=time2-time1;
		System.out.println("-------------------------------------------------------------------------");
		HashMapLinkedList<String, String> hash3 = new HashMapLinkedList<String,String>();
		System.out.println("isEmpty should return true : "+hash3.isEmpty());
		time1 = System.nanoTime();
		for(int i=0;i<1000;i++) {
			hash3.put(Integer.toString(i),Integer.toString(i+1000));
		}
		time2 = System.nanoTime();
		long addsonuc1_3=time2-time1;
		System.out.println(hash3+"\n-------");
		int oldSize2 = hash3.size();
		
		time1 = System.nanoTime();
		for(int i=-10;i<500;i++) {
			hash3.remove(Integer.toString(i));
		}
		time2 = System.nanoTime();
		long removesonuc1_3=time2-time1;
		int newSize2= hash3.size();
		System.out.println(oldSize2 +" - 50 = "+newSize2+"\n"+"hash is not empty, is empty ? : "+hash3.isEmpty());
		System.out.println("--------After removing---------");
		System.out.println(hash3);
		
		time1 = System.nanoTime();
		for(int i = 550;i<650;i++) {
			System.out.println(i+"->"+hash3.get(Integer.toString(i)));
		}
		time2 = System.nanoTime();
		long getsonuc1_3=time2-time1;
		
		
		
		System.out.println("--------------------------------------PART 2 TREESET----------------------------------");
		
		HashMapBSTChaining<String, String> hash4 = new HashMapBSTChaining<String,String>();
		System.out.println("isEmpty should return true : "+hash4.isEmpty());
		time1 = System.nanoTime();
		for(int i=0;i<60;i++) {
			hash4.put(Integer.toString(i),Integer.toString(i+1000));
		}
		time2 = System.nanoTime();
		long addsonuc2_1=time2-time1;
		System.out.println(hash4+"\n-------");
		int oldSize3 = hash4.size();

		time1 = System.nanoTime();
		for(int i=-10;i<50;i++) {
			hash4.remove(Integer.toString(i));
		}
		time2 = System.nanoTime();
		long removesonuc2_1=time2-time1;

		int newSize3= hash4.size();
		System.out.println(oldSize3 +" - 50 = "+newSize3+"\n"+"hash is not empty, is empty ? : "+hash4.isEmpty());
		System.out.println("--------After removing---------");
		System.out.println(hash4);
		time1 = System.nanoTime();
		for(int i = 50;i<70;i++) {
			System.out.println(i+"->"+hash4.get(Integer.toString(i)));
		}
		time2 = System.nanoTime();
		long getsonuc2_1=time2-time1;
		System.out.println("-------------------------------------------------------------------------");
		HashMapBSTChaining<String, String> hash5 = new HashMapBSTChaining<String,String>();
		System.out.println("isEmpty should return true : "+hash5.isEmpty());
		time1 = System.nanoTime();
		for(int i=0;i<200;i++) {
			hash5.put(Integer.toString(i),Integer.toString(i+1000));
		}
		time2 = System.nanoTime();
		long addsonuc2_2=time2-time1;
		System.out.println(hash5+"\n-------");
		int oldSize4 = hash5.size();
		
		time1 = System.nanoTime();
		for(int i=-10;i<190;i++) {
			hash5.remove(Integer.toString(i));
		}
		time2 = System.nanoTime();
		long removesonuc2_2=time2-time1;
		int newSize4= hash5.size();
		System.out.println(oldSize4 +" - 50 = "+newSize4+"\n"+"hash is not empty, is empty ? : "+hash5.isEmpty());
		System.out.println("--------After removing---------");
		System.out.println(hash5);
		
		time1 = System.nanoTime();
		for(int i = 50;i<70;i++) {
			System.out.println(i+"->"+hash5.get(Integer.toString(i)));
		}
		time2 = System.nanoTime();
		long getsonuc2_2=time2-time1;
		System.out.println("-------------------------------------------------------------------------");
		HashMapBSTChaining<String, String> hash6 = new HashMapBSTChaining<String,String>();
		System.out.println("isEmpty should return true : "+hash6.isEmpty());
		time1 = System.nanoTime();
		for(int i=0;i<1000;i++) {
			hash6.put(Integer.toString(i),Integer.toString(i+1000));
		}
		time2 = System.nanoTime();
		long addsonuc2_3=time2-time1;
		System.out.println(hash6+"\n-------");
		int oldSize5 = hash6.size();
		
		time1 = System.nanoTime();
		for(int i=-10;i<500;i++) {
			hash6.remove(Integer.toString(i));
		}
		time2 = System.nanoTime();
		long removesonuc2_3=time2-time1;
		int newSize5= hash6.size();
		System.out.println(oldSize5 +" - 50 = "+newSize5+"\n"+"hash is not empty, is empty ? : "+hash6.isEmpty());
		System.out.println("--------After removing---------");
		System.out.println(hash6);
		
		time1 = System.nanoTime();
		for(int i = 550;i<650;i++) {
			System.out.println(i+"->"+hash6.get(Integer.toString(i)));
		}
		time2 = System.nanoTime();
		long getsonuc2_3=time2-time1;
		
		
		System.out.println("--------------------------------------PART 2 COALESCEDHASHING----------------------------------");
		
		
		CoalescedHashing<Integer, Integer> hash7 =new CoalescedHashing<>();
		
		hash7.put(3,15);
		System.out.println(3+" Added!");
		System.out.println("----------\n"+hash7+"\n-------");
		hash7.put(12,11);
		System.out.println(12+" Added!");
		System.out.println("----------\n"+hash7+"\n-------");
		hash7.put(13,15);
		System.out.println(13+" Added!");
		System.out.println("----------\n"+hash7+"\n-------");
		hash7.put(25,11);
		System.out.println(25+" Added!");
		System.out.println("----------\n"+hash7+"\n-------");
		hash7.put(23,15);
		System.out.println(23+" Added!");
		System.out.println("----------\n"+hash7+"\n-------");
		hash7.put(51,11);
		System.out.println(51+" Added!");
		System.out.println("----------\n"+hash7+"\n-------");
		hash7.put(42,15);
		System.out.println(42+" Added!");
		System.out.println("----------\n"+hash7+"\n-------");
		hash7.remove(3);
		System.out.println(3+" Removed!");
		System.out.println("----------\n"+hash7+"\n-------");
		hash7.remove(12);
		System.out.println(12+" Removed!");
		System.out.println("----------\n"+hash7+"\n-------");
		System.out.println("isEmpty should return true : "+hash7.isEmpty());
		
		System.out.println("--------------------------SIZE 10 TEST---------------------------------");

		CoalescedHashing<Integer, Integer> hash8 =new CoalescedHashing<>();
		time1 = System.nanoTime();
		for(int i=0;i<10;i++) {
			int sayi = (int)(Math.random()*10);
			hash8.put(sayi,i);
		}
		time2 = System.nanoTime();
		long addsonuc3_1=time2-time1;

		time1 = System.nanoTime();
		for(int i=0;i<5;i++) {
			int sayi = (int)(Math.random()*10);
			hash8.remove(sayi);
		}
		time2 = System.nanoTime();
		long removesonuc3_1=time2-time1;

		time1 = System.nanoTime();
		for(int i=0;i<5;i++) {
			int sayi = (int)(Math.random()*10);
			System.out.println(i+"->"+hash8.get(sayi));
		}
		time2 = System.nanoTime();
		long getsonuc3_1=time2-time1;

		System.out.println("----------\n"+hash8+"\n-------");
		
		System.out.println("--------------------------SIZE 100 TEST---------------------------------");
		CoalescedHashing<Integer, Integer> hash9 =new CoalescedHashing<>();
		time1 = System.nanoTime();
		for(int i=0;i<100;i++) {
			int sayi = (int)(Math.random()*100);
			hash9.put(sayi,i);
		}
		time2 = System.nanoTime();
		long addsonuc3_2=time2-time1;
		System.out.println("----------\n"+hash9+"\n-------");
		
		time1 = System.nanoTime();
		for(int i=0;i<50;i++) {
			int sayi = (int)(Math.random()*100);
			hash9.remove(sayi);
		}
		time2 = System.nanoTime();
		long removesonuc3_2=time2-time1;
		System.out.println("--------------------------AFTER REMOVING---------------------------------");
		System.out.println("----------\n"+hash9+"\n-------");
		time1 = System.nanoTime();
		for(int i=0;i<50;i++) {
			int sayi = (int)(Math.random()*100);
			System.out.println(i+"->"+hash9.get(sayi));
		}
		time2 = System.nanoTime();
		long getsonuc3_2=time2-time1;
		System.out.println("--------------------------SIZE 1000 TEST---------------------------------");
		CoalescedHashing<Integer, Integer> hash10 =new CoalescedHashing<>();
		time1 = System.nanoTime();
		for(int i=0;i<1000;i++) {
			int sayi = (int)(Math.random()*1000);
			hash10.put(sayi,i);
		}
		time2 = System.nanoTime();
		long addsonuc3_3=time2-time1;
		System.out.println("----------\n"+hash10+"\n-------");
		time1 = System.nanoTime();
		for(int i=0;i<600;i++) {
			int sayi = (int)(Math.random()*1000);
			hash10.remove(sayi);
		}
		time2 = System.nanoTime();
		long removesonuc3_3=time2-time1;
		System.out.println("--------------------------AFTER REMOVING---------------------------------");
		System.out.println("----------\n"+hash10+"\n-------");
		time1 = System.nanoTime();
		for(int i=0;i<500;i++) {
			int sayi = (int)(Math.random()*1000);
			System.out.println(i+"->"+hash10.get(sayi));
		}
		time2 = System.nanoTime();
		long getsonuc3_3=time2-time1;
		System.out.println("------------------Time Testing Part------------------");
		System.out.println("------------------SMALL SIZE------------------");
		System.out.println("Put element: "+"hashmap with linkedlist takes this time: "+ addsonuc1_1);
		System.out.println("Put element: "+"hashmap with Treeset takes this time: "+ addsonuc2_1);
		System.out.println("Put element: "+"hashmap with CoalescedHashing takes this time: "+ addsonuc3_1);
		System.out.println("Remove element: "+"hashmap with linkedlist takes this time: "+ removesonuc1_1);
		System.out.println("Remove element: "+"hashmap with Treeset takes this time: "+ removesonuc2_1);
		System.out.println("Remove element: "+"hashmap with CoalescedHashing takes this time: "+ removesonuc3_1);
		System.out.println("Get element: "+"hashmap with linkedlist takes this time: "+ getsonuc1_1);
		System.out.println("Get element: "+"hashmap with Treeset takes this time: "+ getsonuc2_1);
		System.out.println("Get element: "+"hashmap with CoalescedHashing takes this time: "+ getsonuc3_1);
		System.out.println("--------------------------------------------------------");
		System.out.println("------------------MEDIUM SIZE------------------");
		System.out.println("Put element: "+"hashmap with linkedlist takes this time: "+ addsonuc1_2);
		System.out.println("Put element: "+"hashmap with Treeset takes this time: "+ addsonuc2_2);
		System.out.println("Put element: "+"hashmap with CoalescedHashing takes this time: "+ addsonuc3_2);
		System.out.println("Remove element: "+"hashmap with linkedlist takes this time: "+ removesonuc1_2);
		System.out.println("Remove element: "+"hashmap with Treeset takes this time: "+ removesonuc2_2);
		System.out.println("Remove element: "+"hashmap with CoalescedHashing takes this time: "+ removesonuc3_2);
		System.out.println("Get element: "+"hashmap with linkedlist takes this time: "+ getsonuc1_2);
		System.out.println("Get element: "+"hashmap with Treeset takes this time: "+ getsonuc2_2);
		System.out.println("Get element: "+"hashmap with CoalescedHashing takes this time: "+ getsonuc3_2);
		System.out.println("-------------------------------------------------------");
		System.out.println("------------------LARGE SIZE------------------");
		System.out.println("Put element: "+"hashmap with linkedlist takes this time: "+ addsonuc1_3);
		System.out.println("Put element: "+"hashmap with Treeset takes this time: "+ addsonuc2_3);
		System.out.println("Put element: "+"hashmap with CoalescedHashing takes this time: "+ addsonuc3_3);
		System.out.println("Remove element: "+"hashmap with linkedlist takes this time: "+ removesonuc1_3);
		System.out.println("Remove element: "+"hashmap with Treeset takes this time: "+ removesonuc2_3);
		System.out.println("Remove element: "+"hashmap with CoalescedHashing takes this time: "+ removesonuc3_3);
		System.out.println("Get element: "+"hashmap with linkedlist takes this time: "+ getsonuc1_3);
		System.out.println("Get element: "+"hashmap with Treeset takes this time: "+ getsonuc2_3);
		System.out.println("Get element: "+"hashmap with CoalescedHashing takes this time: "+ getsonuc3_3);
	}
}
