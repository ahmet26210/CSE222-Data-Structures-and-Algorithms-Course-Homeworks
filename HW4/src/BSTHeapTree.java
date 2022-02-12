package linkedlist;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import java.util.NoSuchElementException;

import linkedlist.BST.Node;



public class BSTHeapTree<E extends Comparable<E>> {
	private BST<HeapTree<E>> dataBst;
	private E maxNumber;
	private E Modeis;
	private int Modenumber;
	private boolean check=false;
	private ArrayList<Integer> ARRAY;
	private HeapTree<E> newHeapTree;
	/**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param  initialCapacity  the initial capacity of the list
     */
	public BSTHeapTree() {
		dataBst=new BST<HeapTree<E>>();
		ARRAY=new ArrayList<Integer>(3000);
	}
	/**
     * Appends the specified element to the appropriate place.
     *
     * @param e element to be appended to this Tree suitable way one node has only 7 element in it
     * @return Number of Occurrences after added element
     */
	public int add(E element) {
		return add(dataBst.root(),element);
	}
	private int add(Node<HeapTree<E>> node1,E element) throws NoSuchElementException {
		if(element==null) {
			throw new NoSuchElementException();
		}
		if(dataBst.rootValue()==null || node1==null) {
			newHeapTree=new HeapTree<>();
			newHeapTree.add(element);
			newHeapTree.setMaxnumber(1);
			newHeapTree.setStorage(0,1);
			dataBst.add(newHeapTree);
			return 1;
		}
		int index=node1.getData().SearchElement1(element);
		if(index!=-1) {
			node1.getData().setStorage(index,node1.getData().getStorage(index)+1);
			return node1.getData().getStorage(index);
		}
		else if(index==-1 && node1.getData().getMaxnumber()!=7){
			node1.getData().add(element);
			node1.getData().setStorage(node1.getData().getArr().size()-1,1);
			node1.getData().setMaxnumber(node1.getData().getMaxnumber()+1);
			return 1;
		}
		else {
			if(element.compareTo(node1.getData().getArr().get(0))>0) {
				
				add(node1.getRight(),element);
			}
			else {
		
				add(node1.getLeft(),element);
			}
		}
		return -1;
	}
	
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	/**
     * To delete of given element
     *
     * @param Find the element and delete it 
     * @return Number of Occurrences is returned after deleting item
     * Recursion 
     */
	public int remove(E element) {
		return remove(dataBst.root(),element);
	}
	private int remove(Node<HeapTree<E>> node1,E element) throws NoSuchElementException {
		if(element==null) {
			throw new NoSuchElementException();
		}
		if(node1!=null) {
			int index=node1.getData().SearchElement1(element);
			if(index==0) {
				if(node1.getData().getArr().size()==1) {
					if(node1.getData().getStorage(index)!=1) {
						node1.getData().setStorage(index,node1.getData().getStorage(index)-1);
						return node1.getData().getStorage(index);
					}
					else {
						node1.getData().remove();
						dataBst.delete(node1.getData());
						return 0;
					}
				}
				else {
					if(node1.getData().getStorage(index)!=1) {
						node1.getData().setStorage(index,node1.getData().getStorage(index)-1);
						return node1.getData().getStorage(index);
					}
					else {
						node1.getData().remove();
						deleterec(node1);
						return 0;
					}
				}
			}
			else if(index==-1) {
				if(element.compareTo(node1.getData().getArr().get(0))>0) {
					
					remove(node1.getRight(),element);
				}
				else {
			
					remove(node1.getLeft(),element);
				}
			}
			else{
				if(node1.getData().getStorage(index)!=1) {
					node1.getData().setStorage(index,node1.getData().getStorage(index)-1);
					return node1.getData().getStorage(index);
				}
				else if(node1.getData().getStorage(index)==1) {
					if(node1.getData().getLeft(index) > node1.getData().getArr().size() && node1.getData().getRight(index)>node1.getData().getArr().size()) {
						node1.getData().getArr().remove(index);
						if(node1.getData().getArr().size()==0) {
							dataBst.delete(node1.getData());
							return 0;
						}
					}
					else {
						node1.getData().remove(element);
						deleterec(node1);
						return 0;
					}
				}
			}
		}
		return -1;
	}
	private void deleterec(Node<HeapTree<E>> node1) {
		if(node1==null) {
			return;
		}
		if(node1.getLeft()!=null) {
			Node<HeapTree<E>> teNode=node1;
			teNode=teNode.getLeft();
			while (teNode.getRight()!=null) {
				teNode=teNode.getRight();
			}
			E e=teNode.getData().getArr().get(0);
			teNode.getData().remove();
			node1.getData().add(e);
			node1=teNode;
			deleterec(node1);
		}
		else if(node1.getRight()!=null){
			Node<HeapTree<E>> teNode=node1;
			teNode=teNode.getRight();
			while (teNode.getLeft()!=null) {
				teNode=teNode.getLeft();
			}
			E e=teNode.getData().getArr().get(0);
			node1.getData().add(e);
			teNode.getData().remove();
			node1=teNode;
			deleterec(node1);
		}
	}
	public ArrayList<Integer> getARRAY() {
		return ARRAY;
	}
	public void setARRAY(ArrayList<Integer> aRRAY) {
		ARRAY = aRRAY;
	}
	public void sortNumber() {
		for(int i=0;i<getARRAY().size();i++) {
			for(int j=i+1;j<getARRAY().size();j++) {
				if(getARRAY().get(i)<getARRAY().get(j)){
					int e=getARRAY().get(i);
					getARRAY().set(i, getARRAY().get(j));
					getARRAY().set(j, e);
				}
			}
		}
	}
	/**
     * Traverse the tree to find the element
     *
     * @param Reach the element and find suitable element
     * @return Suitable element is returned
     * Recursion
     */
	public int find(E element) {
		return	find(dataBst.root(),element);
	}
	private int find(Node<HeapTree<E>> node1,E element) {
		if(node1==null) {
			return -1;
		}
		else if(element.compareTo(node1.getData().getArr().get(0))>0) {
			return	find(node1.getRight(),element);
		}
		else if(element.compareTo(node1.getData().getArr().get(0))<0) {
			int	index=node1.getData().SearchElement1(element);
			if(index!=-1) {
				return node1.getData().getStorage(index);
			}
			return	find(node1.getLeft(),element);
		}
		else {
			return node1.getData().getStorage(0);
		}
	}
	/**
     * Traverse the tree to find the element and mode
     *
     * @param Reach the element and find Mode
     * @return Suitable element occurrences is returned 
     * Recursion
     */
	public int findMode(){
		Modenumber=0;
		findMode1(dataBst.root(),0);
		return Modenumber;
	}
	
	public E getModeis() {
		return Modeis;
	}
	public E getMaxNumber() {
		return maxNumber;
	}
	private void findMode1(Node<HeapTree<E>> node1,int lastMode) {
		if(node1==null) {
			if(lastMode>Modenumber)
				Modenumber=lastMode;
				Modeis=maxNumber;
		}
		else {
			for(int i=0;i<node1.getData().getArr().size();i++) {
				if(node1.getData().getStorage(i)>lastMode) {
					lastMode=node1.getData().getStorage(i);
					maxNumber=node1.getData().getArr().get(i);
				}
			}
			findMode1(node1.getRight(),lastMode);
			findMode1(node1.getLeft(),lastMode);
		}
	}
	public String toString() {
		StringBuilder aBuilder=new StringBuilder();
		dataBst.preOrderTraverse(dataBst.root(),1,aBuilder);
		return aBuilder.toString();
 	}
	public static void main(String[] args) {
		try  {
			BSTHeapTree<Integer> aBstHeapTree=new BSTHeapTree<>();
			System.out.println("--------------------------------------TEST PART1 START-----------------------------------------");
			for(int i=0;i<3000;i++) {
				int sayi = (int)(Math.random()*5000);
				aBstHeapTree.getARRAY().add(sayi);
				aBstHeapTree.add(sayi);
			}
			System.out.print(aBstHeapTree);
			for(int i=0;i<3000;i++) {
				System.out.print(aBstHeapTree.getARRAY().get(i)+",");
			}
			aBstHeapTree.sortNumber();
			int Occurrences=0;
			boolean control1=false;
			for (int i = 0; i < aBstHeapTree.getARRAY().size(); i++) {
				int a=aBstHeapTree.find(i);
				Occurrences=0;
				control1=false;
				if(a!=-1) {
					for (int j = 0; j <aBstHeapTree.getARRAY().size(); j++) {
						if(i==aBstHeapTree.getARRAY().get(j)) {
							Occurrences++;
						}
					}
					if(Occurrences!=a) {
						control1=true;
					}
				}
			}
			if(control1==false) {
				System.out.println("All Occurrences is true after adding");
			}
			
			System.out.println("--------------------------------------TEST PART1 END  -----------------------------------------");
			
			System.out.println("--------------------------------------TEST PART2 START -----------------------------------------");
			for(int i=0;i<100;i++) {
				int sayi = (int)(Math.random()*5000);
				Occurrences=0;
				for(int k=0;k<aBstHeapTree.getARRAY().size();k++) {
					if(aBstHeapTree.getARRAY().get(k)==sayi) {
						Occurrences++;
					}
				}
				int index=aBstHeapTree.find(sayi);
				if(index!=-1 && Occurrences==index) {
					System.out.println("The element is founded! -> Element: "+sayi+" and element has occurrences :" +index);
				}
				else {
					System.out.println("The element is not founded! -> Element: "+sayi);
				}
			}

			System.out.println("--------------------------------------TEST PART2 END  -----------------------------------------");
			
			System.out.println("--------------------------------------TEST PART3 START  -----------------------------------------");
			
			int index1 = aBstHeapTree.findMode();
			System.out.println("Mode is "+aBstHeapTree.getModeis()+" Occurrences is " +"-"+index1+"-");
			int b=0;
			for(int i=0;i<aBstHeapTree.getARRAY().size();i++) {
				if((int)aBstHeapTree.getARRAY().get(i)==(int)aBstHeapTree.getModeis()) {
					b++;
				}
			}
			if(b==index1) {
				System.out.println("Mode is true!");
			}
			//for(int i=0;i<aBstHeapTree.getARRAY().size();i++) {
				//System.out.println(aBstHeapTree.getARRAY().get(i)+",");
			//}
			System.out.println("Sorted Array is printed");
			for(int i=0;i<3000;i++) {
				System.out.print(aBstHeapTree.getARRAY().get(i)+",");
			}
			System.out.println("--------------------------------------TEST PART3 END  -----------------------------------------");
			
			System.out.println("--------------------------------------TEST PART4 START  -----------------------------------------");
			
			for(int i=0;i<100;i++) {
				int sayi = (int)(Math.random()*5000);
				aBstHeapTree.remove(sayi);
				for (int j = 0; j <aBstHeapTree.getARRAY().size(); j++) {
					if(sayi==aBstHeapTree.getARRAY().get(j)) {
						aBstHeapTree.getARRAY().remove(j);
						break;
					}
				}
			}
			System.out.print(aBstHeapTree);
			aBstHeapTree.sortNumber();
			boolean control=false;
			for (int i = 0; i < aBstHeapTree.getARRAY().size(); i++) {
				int a=aBstHeapTree.find(i);
				Occurrences=0;
				control=false;
				if(a!=-1) {
					for (int j = 0; j <aBstHeapTree.getARRAY().size(); j++) {
						if(i==aBstHeapTree.getARRAY().get(j)) {
							Occurrences++;
						}
					}
					if(Occurrences!=a) {
						control=true;
					}
				}
			}
			if(control==false) {
				System.out.println("All Occurrences is true after removing");
			}
			System.out.println("After removing array is printed");
			for(int i=0;i<aBstHeapTree.getARRAY().size();i++) {
				System.out.print(aBstHeapTree.getARRAY().get(i)+",");
			}
			
			System.out.println("--------------------------------------TEST PART4 END  -----------------------------------------");
			System.out.println("--------------------------------------SUCCESFULL -----------------------------------------");
		}
		catch (Exception e) {
			e.addSuppressed(e);
		}
	}	
}
