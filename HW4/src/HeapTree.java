package linkedlist;



import java.util.ConcurrentModificationException;
import java.util.Iterator;

import java.util.NoSuchElementException;



public class HeapTree<E extends Comparable<E>> implements Comparable<HeapTree<E>>, Iterable<E>{
	private ArrayList<E> arr;
	private int[] storage;
	private int Maxnumber;
	/**
     * Constructs an empty list.
     *
     * @param  Storage Array for Occurrences
     */
	public HeapTree() {
		arr=new ArrayList<E>();
		storage= new int[7];
		for(int i =0;i<7;i++) {
			storage[i]=0;
		}
		Maxnumber=0;
	}
	/**
     * Appends the specified element to the appropriate place.
     *
     * @param e element to be appended to this list
     * @return <tt>true</tt>)
     */
	public boolean add(E element) {
		arr.add(element);
		int indexOfAdded =arr.size()-1;
		int parent=(indexOfAdded-1)/2;
		while(indexOfAdded>0 && parent>=0 && arr.get(parent).compareTo(arr.get(indexOfAdded))<0) {
			swap(parent,indexOfAdded);
			indexOfAdded=parent;
			parent=(indexOfAdded-1)/2;
		}
		System.out.print(arr);
		return true;
	}
	/**
     * Swap the given element using array list
     *
     * @param Swap elements
     * 
     */
	private void swap (int parent,int indexOfAdded) {
		E e =arr.get(parent);
		arr.set(parent,arr.get(indexOfAdded));
		arr.set(indexOfAdded, e);
		int a =storage[parent];
		storage[parent]=storage[indexOfAdded];
		storage[indexOfAdded]=a;
	}
	/**
     * 
     *
     * @param find occurrences of given index and return it
     * @return return occurrences of given index
     */
	public int getStorage(int index) {
		if(index<0 || index>arr.size()) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return storage[index];
	}
	
	public ArrayList<E> getArr() {
		return arr;
	}
	/**
     * 
     *
     * @param find occurrences of given index and change it
     * 
     */
	public void setStorage(int index ,int newValue) {
		if(index<0 || index>arr.size()) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		storage[index]=newValue;
	}
	/**
     * Remove the element that in the first element of tree 
     * First we change it with last element and remove it 
     * After Removing arrange tree suitable way of heap
     * @param Remove the element that in the First element of tree 
     * 
     */
	public E remove() {
		int left,right,currentIndex=0,smallerChild;
		if(arr.size()==0) {
			return null;
		}
		if(arr.size()==1) {
			E e =arr.get(0);
			arr.remove(0);
			return e;
		}
		E e =arr.get(0);
		arr.set(0,arr.get(arr.size()-1));
		arr.remove(arr.size()-1);
		while(true) {
			left=getLeft(currentIndex);
			right=getRight(currentIndex);
			if(left >=arr.size()) {
				break;
			}
			smallerChild=left;
			if(right<arr.size() && arr.get(right).compareTo(arr.get(left)) > 0) {
				smallerChild=right;
			}
			if(arr.get(currentIndex).compareTo(arr.get(smallerChild))<0) {
				E tempE =arr.get(currentIndex);
				arr.set(currentIndex, arr.get(smallerChild));
				arr.set(smallerChild,tempE);
				currentIndex=smallerChild;
			}
			else {
				break;
			}
		}
		System.out.print(arr);
		return e;
	}
	public E remove(E element) {
		int left,right,currentIndex=0,smallerChild;
		if(arr.size()==0) {
			return null;
		}
		if(arr.size()==1) {
			E e =arr.get(0);
			arr.remove(0);
			return e;
		}
		int index=SearchElement1(element);
		E e =arr.get(index);
		arr.set(index,arr.get(arr.size()-1));
		arr.remove(arr.size()-1);
		while(true) {
			left=getLeft(currentIndex);
			right=getRight(currentIndex);
			if(left >=arr.size()) {
				break;
			}
			smallerChild=left;
			if(right<arr.size() && arr.get(right).compareTo(arr.get(left)) > 0) {
				smallerChild=right;
			}
			if(arr.get(currentIndex).compareTo(arr.get(smallerChild))<0) {
				E tempE =arr.get(currentIndex);
				arr.set(currentIndex, arr.get(smallerChild));
				arr.set(smallerChild,tempE);
				currentIndex=smallerChild;
			}
			else {
				break;
			}
		}
		System.out.print(arr);
		return e;
	}
	/**
     * 
     *
     * @param search element using array
     * 
     */
	public E SearchElement(E element) {
		E e=SearchElement(0,element);
		if(e==null) {
			System.out.println("Element is not founded! ");
			return null;
		}
		else {
			System.out.println("Element founded! " +e);
			return e;
		}
	}
	
	public int getMaxnumber() {
		return Maxnumber;
	}
	public void setMaxnumber(int maxnumber) {
		Maxnumber = maxnumber;
	}
	private E SearchElement(int index, E element) {
		if(arr.size()==0) {
			return null;
		}
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i).equals(element)) {
				return arr.get(i);
			}
		}
		return null;
	}
	public int SearchElement1(E element) {
		if(arr.size()==0) {
			return -1;
		}
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i).equals(element)) {
				return i;
			}
		}
		return -1;
	}
	public void MergeAnotherHeap(HeapTree<E> heap) {
		if(heap.arr.size()==0) {
			return;
		}
		for(int i=0;i<heap.arr.size();i++) {
			this.add(heap.arr.get(i));
		}
	}
	
	public E removeithLargestElement(int index) {
		int left,right,currentIndex=0,smallerChild;
		ArrayList<E> newList=new ArrayList<>();
		for(int i=0;i<arr.size();i++) {
			newList.add(arr.get(i));
		}
		for(int i=0;i<newList.size();i++) {
			for(int j=i+1;j<newList.size();j++) {
				if(newList.get(i).compareTo(newList.get(j))<0){
					E e=newList.get(i);
					newList.set(i, newList.get(j));
					newList.set(j, e);
				}
			}
		}
		System.out.println(newList);
		int index1=this.SearchElement1(newList.get(index-1));
		if(index1==arr.size()-1) {
			E e =arr.get(arr.size()-1);
			arr.remove(arr.size()-1);
			return e;
		}
		E e =arr.get(index1);
		arr.set(index1,arr.get(arr.size()-1));
		arr.remove(arr.size()-1);
		
		
		int parent=(index1-1)/2;
		if(arr.get(index1).compareTo(arr.get(parent))>0) {
			while(index1>0 && parent>=0 && arr.get(parent).compareTo(arr.get(index1))<0) {
				swap(parent,index1);
				index1=parent;
				parent=(index1-1)/2;
			}
		}
		else {
			currentIndex=index1;
			while(true) {
				left=getLeft(currentIndex);
				right=getRight(currentIndex);
				if(left >=arr.size()) {
					break;
				}
				smallerChild=left;
				if(right<arr.size() && arr.get(right).compareTo(arr.get(left)) > 0) {
					smallerChild=right;
				}
				if(arr.get(currentIndex).compareTo(arr.get(smallerChild))<0) {
					E tempE =arr.get(currentIndex);
					arr.set(currentIndex, arr.get(smallerChild));
					arr.set(smallerChild,tempE);
					currentIndex=smallerChild;
				}
				else {
					break;
				}
			}
		}
		return e;
	}
	private class Iter implements Iterator<E>{
		private int cursor;
		private int lastret=-1;
		public Iter(int index) {
			cursor=index;
		}

		public Iter() {
			this(0);
		}
		public int getLastret() {
			return lastret;
		}
		@Override
		public boolean hasNext() {
			return cursor<arr.size();
		}

		@Override
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			lastret=cursor;
			cursor+=1;
			return (E) arr.get(lastret);
		}
		@Override
		public void remove()throws ConcurrentModificationException {
			int left,right,currentIndex,smallerChild;
			if (lastret < 0)
                throw new IllegalStateException();
            try {
            	E e = arr.get(lastret);
        		arr.set(lastret,arr.get(arr.size()-1));
        		arr.remove(arr.size()-1);
        		currentIndex=lastret;
        		while(true) {
        			left=getLeft(currentIndex);
        			right=getRight(currentIndex);
        			if(left >=arr.size()) {
        				break;
        			}
        			smallerChild=left;
        			if(right<arr.size() && arr.get(right).compareTo(arr.get(left)) > 0) {
        				smallerChild=right;
        			}
        			if(arr.get(currentIndex).compareTo(arr.get(smallerChild))<0) {
        				E tempE =(E) arr.get(currentIndex);
        				arr.set(currentIndex, arr.get(smallerChild));
        				arr.set(smallerChild,(E) tempE);
        				currentIndex=smallerChild;
        			}
        			else {
        				break;
        			}
        		}
                cursor = lastret;
                lastret = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
		}
		public void set(E element) {
			int currentIndex,left,right,smallerChild;
			if (getLastret() < 0)
                throw new IllegalStateException();
			
			arr.set(getLastret(), (E) element);
			int index1=getLastret();
			int parent=(index1-1)/2;
			if(arr.get(index1).compareTo(arr.get(parent))>0) {
				while(index1>0 && parent>=0 && arr.get(parent).compareTo(arr.get(index1))<0) {
					swap(parent,index1);
					index1=parent;
					parent=(index1-1)/2;
				}
			}
			else {
				currentIndex=index1;
				while(true) {
					left=getLeft(currentIndex);
					right=getRight(currentIndex);
					if(left >=arr.size()) {
						break;
					}
					smallerChild=left;
					if(right<arr.size() && arr.get(right).compareTo(arr.get(left)) > 0) {
						smallerChild=right;
					}
					if(arr.get(currentIndex).compareTo(arr.get(smallerChild))<0) {
						E tempE =(E) arr.get(currentIndex);
						arr.set(currentIndex, arr.get(smallerChild));
						arr.set(smallerChild,tempE);
						currentIndex=smallerChild;
					}
					else {
						break;
					}
				}
			}
		}
	}
	public Iter iterator(){
		return new Iter();
	}
	@Override
	public int compareTo(HeapTree<E> o) {
		if(this.arr.get(0).compareTo(o.arr.get(0))>0) {
			return 1;
		}
		else if(this.arr.get(0).compareTo(o.arr.get(0))==0) {
			return 0;
		}
		return -1;
	}
	public Iter iterator(int index){
		if (index < 0 || index > arr.size())
            throw new IndexOutOfBoundsException("Index: "+index);
		return new Iter(index);
	}
	
	public int getLeft(int i) {
		return i*2+1;
	}
	public int getRight(int i) {
		return i*2+2;
 	}
	public String toString() {
		StringBuilder stringBuilder=new StringBuilder();
		if(arr.size()!=0)
			stringBuilder.append("[");
		for (int i = 0; i <arr.size(); i++) {
			if(arr.size()-1==i) {
				stringBuilder.append(arr.get(i)+","+storage[i]);
			}
			else {
				stringBuilder.append(arr.get(i)+","+storage[i]+","+" ");
			}
		}
		if(arr.size()!=0)
			stringBuilder.append("]\n");
		return stringBuilder.toString();
	}
	/*public static void main(String[] args) {
		HeapTree<Integer> h = new HeapTree<Integer>();
		HeapTree<Integer> h1 = new HeapTree<Integer>();
		for(int i=0;i<10;i++) {
			h.add(20-i);
		}
		for(int i=0;i<10;i++) {
			System.out.print(h.remove() + " ");
		}
		h.add(15);
		h.add(14);
		h.add(16);
		h.add(20);
		h.add(18);
		h.add(14);
		h.add(17);
		h.add(13);
		h.add(4);
		h.add(23);
		System.out.println("\n\n\n");
		h1.add(7);
		h1.add(11);
		h1.add(8);
		h1.add(28);
		System.out.println(h.SearchElement(15));
		System.out.println("remove");
		h.remove();
		System.out.println(h.arr);
		System.out.println(h.SearchElement(20));
		System.out.println("-----------------------");
		h.MergeAnotherHeap(h1);
		System.out.print(h.arr);
		h.SearchElement(7);
		System.out.println(h.arr);
		System.out.println("removed "+h.removeithLargestElement(3));
		System.out.println(h.arr);
		System.out.println("removed "+h.removeithLargestElement(4));
		System.out.print(h.arr);
		System.out.println("ITERATOR BASLADI");
		
		HeapTree.Iter i=h.iterator();
		i.next();
		i.next();
		i.next();
		i.remove();
		i.next();
		i.next();
		i.set(15);
		System.out.println("\n");
		System.out.println(h.arr);
		System.out.println("\n");
		System.out.println("ITERATOR BITTI");
	}*/
}

