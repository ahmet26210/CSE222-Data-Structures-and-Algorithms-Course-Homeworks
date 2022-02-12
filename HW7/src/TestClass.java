package linkedlist;

import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("unused")
public class TestClass {
	private int avarageOfBST10k;
	private int avarageOfBST20k;
	private int avarageOfBST40k;
	private int avarageOfBST80k;
	private int avarageOfRBT10k;
	private int avarageOfRBT20k;
	private int avarageOfRBT40k;
	private int avarageOfRBT80k;
	private int avarageOfTwoThreeTree10k;
	private int avarageOfTwoThreeTree20k;
	private int avarageOfTwoThreeTree40k;
	private int avarageOfTwoThreeTree80k;
	private int avarageOfBTree10k;
	private int avarageOfBTree20k;
	private int avarageOfBTree40k;
	private int avarageOfBTree80k;
	private int avarageOfSkipList10k;
	private int avarageOfSkipList20k;
	private int avarageOfSkipList40k;
	private int avarageOfSkipList80k;
	
	public TestClass() {
		this.avarageOfBST10k = 0;
		this.avarageOfBST20k = 0;
		this.avarageOfBST40k = 0;
		this.avarageOfBST80k = 0;
		this.avarageOfRBT10k = 0;
		this.avarageOfRBT20k = 0;
		this.avarageOfRBT40k = 0;
		this.avarageOfRBT80k = 0;
		this.avarageOfTwoThreeTree10k = 0;
		this.avarageOfTwoThreeTree20k = 0;
		this.avarageOfTwoThreeTree40k = 0;
		this.avarageOfTwoThreeTree80k = 0;
		this.avarageOfBTree10k = 0;
		this.avarageOfBTree20k = 0;
		this.avarageOfBTree40k = 0;
		this.avarageOfBTree80k = 0;
		this.avarageOfSkipList10k = 0;
		this.avarageOfSkipList20k = 0;
		this.avarageOfSkipList40k = 0;
		this.avarageOfSkipList80k = 0;
	}
	
	public void GenerateBST10000() {
		BinarySearchTree<Integer> aBinarySearchTree=new BinarySearchTree<>();
		int randNum;
		
		for (int i = 0; i < 20000; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!aBinarySearchTree.add(randNum)) {
				i--;
			}
		}
		long time1 = System.nanoTime(); 
		for (int i = 0; i < 100; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!aBinarySearchTree.add(randNum)) {
				i--;
			}
		} 
		long time2 = System.nanoTime(); 
		avarageOfBST10k+=time2-time1;
		System.out.print("-> " + (time2-time1) +",");
	}
	public void GenerateBST20000() {
		BinarySearchTree<Integer> aBinarySearchTree=new BinarySearchTree<>();
		int randNum;
		
		for (int i = 0; i < 20000; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!aBinarySearchTree.add(randNum)) {
				i--;
			}
		}
		long time1 = System.nanoTime(); 
		for (int i = 0; i < 100; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!aBinarySearchTree.add(randNum)) {
				i--;
			}
		} 
		long time2 = System.nanoTime(); 
		avarageOfBST20k+=time2-time1;
		System.out.print("-> " + (time2-time1) +",");
	}
	public void GenerateBST40000() {
		BinarySearchTree<Integer> aBinarySearchTree=new BinarySearchTree<>();
		int randNum;
		
		for (int i = 0; i < 20000; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!aBinarySearchTree.add(randNum)) {
				i--;
			}
		}
		long time1 = System.nanoTime(); 
		for (int i = 0; i < 100; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!aBinarySearchTree.add(randNum)) {
				i--;
			}
		} 
		long time2 = System.nanoTime(); 
		avarageOfBST40k+=time2-time1;
		System.out.print("-> " + (time2-time1) +",");
	}
	public void GenerateBST80000() {
		BinarySearchTree<Integer> aBinarySearchTree=new BinarySearchTree<>();
		int randNum;
		
		for (int i = 0; i < 20000; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!aBinarySearchTree.add(randNum)) {
				i--;
			}
		}
		long time1 = System.nanoTime(); 
		for (int i = 0; i < 100; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!aBinarySearchTree.add(randNum)) {
				i--;
			}
		} 
		long time2 = System.nanoTime(); 
		avarageOfBST80k+=time2-time1;
		System.out.print("-> " + (time2-time1) +",");
	}
	public void GenerateBSTTenTimes() {
		for(int i=0;i<10;i++) {
			System.out.print(" For 10000 items ->");
			GenerateBST10000();
		}
		System.out.println();
		System.out.println("Avarage of 10000 items -> "+avarageOfBST10k/10);
		System.out.println();
		for(int i=0;i<10;i++) {
			System.out.print(" For 20000 items ->");
			GenerateBST20000();
		}
		System.out.println();
		System.out.println("Avarage of 20000 items -> "+avarageOfBST20k/10);
		System.out.println();
		for(int i=0;i<10;i++) {
			System.out.print(" For 40000 items ->");
			GenerateBST40000();
		}
		System.out.println();
		System.out.println("Avarage of 40000 items -> "+avarageOfBST40k/10);
		System.out.println();
		for(int i=0;i<10;i++) {
			System.out.print(" For 80000 items ->");
			GenerateBST80000();
		}
		System.out.println();
		System.out.println("Avarage of 80000 items -> "+avarageOfBST80k/10);
		System.out.println();
	}
	
	//**************************************************************************************************************************************************
	public void GenerateRBT10000() {
		RedBlackTree<Integer> aRedBlackTree=new RedBlackTree<>();
		int randNum;
		for (int i = 0; i < 10000; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!aRedBlackTree.add(randNum)) {
				i--;
			}
		
		}
		long time1 = System.nanoTime(); 
		for (int i = 0; i < 100; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!aRedBlackTree.add(randNum)) {
				i--;
			}
		} 
		long time2 = System.nanoTime(); 
		avarageOfRBT10k+=time2-time1;
		System.out.print("-> " + (time2-time1) +",");
	}
	public void GenerateRBT20000() {
		RedBlackTree<Integer> aRedBlackTree=new RedBlackTree<>();
		int randNum;
		for (int i = 0; i < 20000; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!aRedBlackTree.add(randNum)) {
				i--;
			}
		
		}
		long time1 = System.nanoTime(); 
		for (int i = 0; i < 100; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!aRedBlackTree.add(randNum)) {
				i--;
			}
		} 
		long time2 = System.nanoTime(); 
		avarageOfRBT20k+=time2-time1;
		System.out.print("-> " + (time2-time1) +",");
	}
	public void GenerateRBT40000() {
		RedBlackTree<Integer> aRedBlackTree=new RedBlackTree<>();
		int randNum;
		for (int i = 0; i < 40000; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!aRedBlackTree.add(randNum)) {
				i--;
			}
		
		}
		long time1 = System.nanoTime(); 
		for (int i = 0; i < 100; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!aRedBlackTree.add(randNum)) {
				i--;
			}
		} 
		long time2 = System.nanoTime(); 
		avarageOfRBT40k+=time2-time1;
		System.out.print("-> " + (time2-time1) +",");
	}
	public void GenerateRBT80000() {
		RedBlackTree<Integer> aRedBlackTree=new RedBlackTree<>();
		int randNum;
		for (int i = 0; i < 80000; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!aRedBlackTree.add(randNum)) {
				i--;
			}
		
		}
		long time1 = System.nanoTime(); 
		for (int i = 0; i < 100; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!aRedBlackTree.add(randNum)) {
				i--;
			}
		} 
		long time2 = System.nanoTime(); 
		avarageOfRBT80k+=time2-time1;
		System.out.print("-> " + (time2-time1) +","); 
	}
	public void GenerateRBTTenTimes() {
		for(int i=0;i<10;i++) {
			System.out.print(" For 10000 items ->");
			GenerateRBT10000();
		}
		System.out.println();
		System.out.println("Avarage of 10000 items -> "+avarageOfRBT10k/10);
		System.out.println();
		for(int i=0;i<10;i++) {
			System.out.print(" For 20000 items ->");
			GenerateRBT20000();
		}
		System.out.println();
		System.out.println("Avarage of 20000 items -> "+avarageOfRBT20k/10);
		System.out.println();
		for(int i=0;i<10;i++) {
			System.out.print(" For 40000 items ->");
			GenerateRBT40000();
		}
		System.out.println();
		System.out.println("Avarage of 40000 items -> "+avarageOfRBT40k/10);
		System.out.println();
		for(int i=0;i<10;i++) {
			System.out.print(" For 80000 items ->");
			GenerateRBT80000();
		}
		System.out.println();
		System.out.println("Avarage of 80000 items -> "+avarageOfRBT80k/10);
		System.out.println();
	}
	//*********************************************************************************************************************************
	public void GenerateTwoTree10000() {
		BTree<Integer> TwoTreeTree=new BTree<>(3);
		int randNum;	
		for (int i = 0; i < 10000; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!TwoTreeTree.add(randNum)) {
				i--;
			}
		}
		long time1 = System.nanoTime(); 
		
		for (int i = 0; i < 100; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!TwoTreeTree.add(randNum)) {
				i--;
			}
		}
		long time2 = System.nanoTime(); 
		avarageOfTwoThreeTree10k+=time2-time1;
		System.out.print("-> " + (time2-time1) +",");
	}
	public void GenerateTwoTree20000() {
		BTree<Integer> TwoTreeTree=new BTree<>(3);
		int randNum;	
		for (int i = 0; i < 20000; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!TwoTreeTree.add(randNum)) {
				i--;
			}
		}
		long time1 = System.nanoTime(); 
		
		for (int i = 0; i < 100; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!TwoTreeTree.add(randNum)) {
				i--;
			}
		}
		long time2 = System.nanoTime(); 
		avarageOfTwoThreeTree20k+=time2-time1;
		System.out.print("-> " + (time2-time1) +",");
	}
	public void GenerateTwoTree40000() {
		BTree<Integer> TwoTreeTree=new BTree<>(3);
		int randNum;	
		for (int i = 0; i < 40000; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!TwoTreeTree.add(randNum)) {
				i--;
			}
		}
		long time1 = System.nanoTime(); 
		
		for (int i = 0; i < 100; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!TwoTreeTree.add(randNum)) {
				i--;
			}
		}
		long time2 = System.nanoTime(); 
		avarageOfTwoThreeTree40k+=time2-time1;
		System.out.print("-> " + (time2-time1) +","); 
	}
	public void GenerateTwoTree80000() {
		BTree<Integer> TwoTreeTree=new BTree<>(3);
		int randNum;	
		for (int i = 0; i < 80000; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!TwoTreeTree.add(randNum)) {
				i--;
			}
		}
		long time1 = System.nanoTime(); 
		
		for (int i = 0; i < 100; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!TwoTreeTree.add(randNum)) {
				i--;
			}
		}
		long time2 = System.nanoTime(); 
		avarageOfTwoThreeTree80k+=time2-time1;
		System.out.print("-> " + (time2-time1) +","); 
	}
	public void GenerateTwoTreeTenTimes() {
		for(int i=0;i<10;i++) {
			System.out.print(" For 10000 items ->");
			GenerateTwoTree10000();
		}
		System.out.println();
		System.out.println("Avarage of 10000 items -> "+avarageOfTwoThreeTree10k/10);
		System.out.println();
		for(int i=0;i<10;i++) {
			System.out.print(" For 20000 items ->");
			GenerateTwoTree20000();
		}
		System.out.println();
		System.out.println("Avarage of 20000 items -> "+avarageOfTwoThreeTree20k/10);
		System.out.println();
		for(int i=0;i<10;i++) {
			System.out.print(" For 40000 items ->");
			GenerateTwoTree40000();
		}
		System.out.println();
		System.out.println("Avarage of 40000 items -> "+avarageOfTwoThreeTree40k/10);
		System.out.println();
		for(int i=0;i<10;i++) {
			System.out.print(" For 80000 items ->");
			GenerateTwoTree80000();
		}
		System.out.println();
		System.out.println("Avarage of 80000 items -> "+avarageOfTwoThreeTree80k/10);
		System.out.println();
	}
	//********************************************************************************************************************************
	 
	public void GenerateBTree10000() {
		BTree<Integer> aBTree=new BTree<>(50);
		int randNum;
		for (int i = 0; i < 10000; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!aBTree.add(randNum)) {
				i--;
			}
		}
		
		long time1 = System.nanoTime();
		for (int i = 0; i < 100; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!aBTree.add(randNum)) {
				i--;
			}
		} 
		long time2 = System.nanoTime();
		avarageOfBTree10k+=time2-time1;
		System.out.print("-> " + (time2-time1) +","); 
	}
	public void GenerateBTree20000() {
		BTree<Integer> aBTree=new BTree<>(50);
		int randNum;
		for (int i = 0; i < 20000; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!aBTree.add(randNum)) {
				i--;
			}
		}
		
		long time1 = System.nanoTime();
		for (int i = 0; i < 100; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!aBTree.add(randNum)) {
				i--;
			}
		} 
		long time2 = System.nanoTime();
		avarageOfBTree20k+=time2-time1;
		System.out.print("-> " + (time2-time1) +",");
	}
	public void GenerateBTree40000() {
		BTree<Integer> aBTree=new BTree<>(50);
		int randNum;
		for (int i = 0; i < 40000; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!aBTree.add(randNum)) {
				i--;
			}
		}
		
		long time1 = System.nanoTime();
		for (int i = 0; i < 100; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!aBTree.add(randNum)) {
				i--;
			}
		} 
		long time2 = System.nanoTime();
		avarageOfBTree40k+=time2-time1;
		System.out.print("-> " + (time2-time1) +","); 
	}
	public void GenerateBTree80000() {
		BTree<Integer> aBTree=new BTree<>(50);
		int randNum;
		for (int i = 0; i < 80000; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!aBTree.add(randNum)) {
				i--;
			}
		}
		
		long time1 = System.nanoTime();
		for (int i = 0; i < 100; i++) {
			randNum=(int)(Math.random()* 1000000);
			if(!aBTree.add(randNum)) {
				i--;
			}
		} 
		long time2 = System.nanoTime();
		avarageOfBTree80k+=time2-time1;
		System.out.print("-> " + (time2-time1) +",");
	}
	public void GenerateBTreeTenTimes() {
		for(int i=0;i<10;i++) {
			System.out.print(" For 10000 items ->");
			GenerateBTree10000();
		}
		System.out.println();
		System.out.println("Avarage of 10000 items -> "+avarageOfBTree10k/10);
		System.out.println();
		for(int i=0;i<10;i++) {
			System.out.print(" For 20000 items ->");
			GenerateBTree20000();
		}
		System.out.println();
		System.out.println("Avarage of 20000 items -> "+avarageOfBTree20k/10);
		System.out.println();
		for(int i=0;i<10;i++) {
			System.out.print(" For 40000 items ->");
			GenerateBTree40000();
		}
		System.out.println();
		System.out.println("Avarage of 40000 items -> "+avarageOfBTree40k/10);
		System.out.println();
		for(int i=0;i<10;i++) {
			System.out.print(" For 80000 items ->");
			GenerateBTree80000();
		}
		System.out.println();
		System.out.println("Avarage of 80000 items -> "+avarageOfBTree80k/10);
		System.out.println();
	}
	//*****************************************************************************************************************
	public void GenerateSkipList10000() {
		SkipList<Integer> skipList=new SkipList<>();
		int randNum;
		for (int i = 0; i < 10000; i++) {
			randNum=(int)(Math.random()* 1000000);
			skipList.insert(randNum);
			
		}
		long time1 = System.nanoTime();
		
		for (int i = 0; i < 100; i++) {
			randNum=(int)(Math.random()* 1000000);
			skipList.insert(randNum);
		} 
		long time2 = System.nanoTime();
		avarageOfSkipList10k+=time2-time1;
		System.out.print("-> " + (time2-time1) +",");
	}
	public void GenerateSkipList20000() {
		SkipList<Integer> skipList=new SkipList<>();
		int randNum;
		for (int i = 0; i < 20000; i++) {
			randNum=(int)(Math.random()* 1000000);
			skipList.insert(randNum);	
		}
		long time1 = System.nanoTime();
		
		for (int i = 0; i < 100; i++) {
			randNum=(int)(Math.random()* 1000000);
			skipList.insert(randNum);
		}
		long time2 = System.nanoTime();
		avarageOfSkipList20k+=time2-time1;
		System.out.print("-> " + (time2-time1) +",");
	}
	public void GenerateSkipList40000() {
		SkipList<Integer> skipList=new SkipList<>();
		int randNum;
		for (int i = 0; i < 40000; i++) {
			randNum=(int)(Math.random()* 1000000);
			skipList.insert(randNum);
		}
		long time1 = System.nanoTime();
		
		for (int i = 0; i < 100; i++) {
			randNum=(int)(Math.random()* 1000000);
			skipList.insert(randNum);
		} 
		long time2 = System.nanoTime();
		avarageOfSkipList40k+=time2-time1;
		System.out.print("-> " + (time2-time1) +",");
	}
	public void GenerateSkipList80000() {
		SkipList<Integer> skipList=new SkipList<>();
		int randNum;
		for (int i = 0; i < 80000; i++) {
			randNum=(int)(Math.random()* 1000000);
			skipList.insert(randNum);
		}
		long time1 = System.nanoTime();
		
		for (int i = 0; i < 100; i++) {
			randNum=(int)(Math.random()* 1000000);
			skipList.insert(randNum);
		} 
		long time2 = System.nanoTime();
		avarageOfSkipList80k+=time2-time1;
		System.out.print("-> " + (time2-time1) +",");
	}
	public void GenerateSkipListTenTimes() {
		for(int i=0;i<10;i++) {
			System.out.print(" For 10000 items ->");
			GenerateSkipList10000();
		}
		System.out.println();
		System.out.println("Avarage of 10000 items -> "+avarageOfSkipList10k/10);
		System.out.println();
		for(int i=0;i<10;i++) {
			System.out.print(" For 20000 items ->");
			GenerateSkipList20000();
		}
		System.out.println();
		System.out.println("Avarage of 20000 items -> "+avarageOfSkipList20k/10);
		System.out.println();
		for(int i=0;i<10;i++) {
			System.out.print(" For 40000 items ->");
			GenerateSkipList40000();
		}
		System.out.println();
		System.out.println("Avarage of 40000 items -> "+avarageOfSkipList40k/10);
		System.out.println();
		for(int i=0;i<10;i++) {
			System.out.print(" For 80000 items ->");
			GenerateSkipList80000();
		}
		System.out.println();
		System.out.println("Avarage of 80000 items -> "+avarageOfSkipList80k/10);
		System.out.println();
	}
	public void StartTest() {
		System.out.println("\n For BST items ");
		GenerateBSTTenTimes();
		System.out.println("\n For RBT items ");
		GenerateRBTTenTimes();
		System.out.println("\n For TwoThreeTree items ");
		GenerateTwoTreeTenTimes();
		System.out.println("\n For Btree items ");
		GenerateBTreeTenTimes();
		System.out.println("\n For SkipList items ");
		GenerateSkipListTenTimes();
		sort();
	}
	public void sort() {
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(avarageOfBST80k/10);
		arrayList.add(avarageOfRBT80k/10);
		arrayList.add(avarageOfTwoThreeTree80k/10);
		arrayList.add(avarageOfBTree80k/10);
		arrayList.add(avarageOfSkipList80k/10);
		
		Collections.sort(arrayList);
		
		System.out.println(arrayList);
		for (int i = 0; i < arrayList.size(); i++) {
			if(arrayList.get(i)==avarageOfBST80k/10) {
				System.out.print("BST <");
			}
			if(arrayList.get(i)==avarageOfRBT80k/10) {
				System.out.print("RBT <");
			}
			if(arrayList.get(i)==avarageOfTwoThreeTree80k/10) {
				System.out.print("TwoThreeTree <");
			}
			if(arrayList.get(i)==avarageOfBTree80k/10) {
				System.out.print("BTree <");
			}
			if(arrayList.get(i)==avarageOfSkipList80k/10) {
				System.out.print("SkipList ");
			}
		}
	}
}
