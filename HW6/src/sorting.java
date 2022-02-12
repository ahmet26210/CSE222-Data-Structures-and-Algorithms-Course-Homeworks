package linkedlist;

import java.util.Comparator;
import java.util.List;

public class sorting<T>{
	
	
	
	
	public void SelectionSort(List<T> table, Comparator<T> comparator) { 
 		int n=table.size();
		for(int fill=0;fill< n-1; fill++) {
			int posmin=fill;
			for(int next=fill+1;next<n;next++) {
				if(comparator.compare(table.get(next),table.get(posmin)) < 0) {
					posmin=next;
				}
			}
			
			T temp =table.get(fill);
			table.set(fill,table.get(posmin));
			table.set(posmin,temp);
		}
	}
	
	
	// BUBBLE SORT  exchange = O(n^2) && comparison O(n^2)
	
	public static <T extends Comparable<T>> void BubbleSort(T[] table) {
		int pass=1;
		boolean exchanges = false;
		do {
			exchanges=false;
			for (int i = 0; i < table.length - pass; i++) {
				if(table[i].compareTo(table[i+1]) > 0) {
					T temp = table[i];
					table[i]=table[i+1];
					table[i+1]=temp;
					exchanges=true;
				}
			}
			pass++;
		}
		while(exchanges);
	}
	
	// INSERTION SORT  exchange = O(n^2) && comparison O(n^2)
	
	public void InsertionSort(List<T> table, Comparator<T> comparator) {
		 for(int nextpos=1 ;nextpos<table.size();nextpos++) {
			 insert(table,nextpos,comparator);
		 }
	}
	private void insert(List<T> table,int nextpos ,Comparator<T> comparator ) {
		T nextvalT=table.get(nextpos);
		while(nextpos > 0 && comparator.compare(nextvalT,table.get(nextpos-1)) < 0) {
			table.set(nextpos,table.get(nextpos-1));
			nextpos--;
		}
		table.set(nextpos, nextvalT);
	}
	
	// SHELL SHORT exchange = O(n2)
	
	public void ShellSort(List<T> table, Comparator<T> comparator) {
		int gap = table.size() / 2;
		while(gap > 0) {
			for(int nextpost=gap;nextpost<table.size(); nextpost++) {
				insert(table, nextpost,gap,comparator);
			}
			if(gap==2) { 
				gap=1;
			}
			else {
				gap = (int) (gap / 2.2);
			}
		}
	}
	private void insert(List<T> table,int nextpost,int gap,Comparator<T> comparator) {
		T nextvalT= table.get(nextpost);
		while((nextpost > gap -1 ) && comparator.compare(nextvalT,table.get(nextpost-gap)) < 0) {
			table.set(nextpost,table.get(nextpost-gap));
			nextpost-=gap;
		}
		table.set(nextpost, nextvalT);
	}
	
	//MERGE SORT O(nlogn)
	private static 	<T extends Comparable<T>> void MergeSort(T[] outpuTs , T[] leftSequence, T[] rightSequence) {
		int i =0;
		int k=0;
		int j=0;
		
		while(i <leftSequence.length && j < rightSequence.length) {
			if(leftSequence[i].compareTo(rightSequence[j]) < 0) {
				outpuTs[k++]=leftSequence[i++];
			}
			else {
				outpuTs[k++]=rightSequence[j++];
			}
		}
		
		while(i < leftSequence.length) {
			outpuTs[k++]=leftSequence[i++];
		}
		while(j < rightSequence.length) {
			outpuTs[k++]=rightSequence[j++];
		}
	}
	//MERGE SORT WITH SPLIT  O(nlogn)
	
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> void MergeSort(T[] table) {
		if(table.length > 1) {
			int halfSize = table.length / 2;
			T [] lefttable = (T[]) new Comparable[halfSize];
			T [] righttable = (T[]) new Comparable[table.length-halfSize];
			System.arraycopy(table,0, lefttable,0, halfSize);
			System.arraycopy(table,halfSize, righttable,0,table.length-halfSize);
			MergeSort(lefttable);
			MergeSort(righttable);
			MergeSort(table, lefttable, righttable);
		}
	}
	
	// HEAP SORT O(nlogn) and n extra storage locations
	
	public void HeapSort(List<T> table ,Comparator<T> comparator) {
		buildHeap(table,comparator);
		shrinkHeap(table,comparator);
	}
	private void buildHeap(List<T> table ,Comparator<T> comparator) {
		int n=1;
		while(n < table.size()) {
			n++;
			int child= n-1;
			int parent=(child-1) /2;
			while(parent>=0 && comparator.compare(table.get(parent),table.get(child))<0) {
				swap(table,parent,child);
				child=parent;
				parent=(child-1) / 2;
			}	
		}
	}
	private void shrinkHeap(List<T> table,Comparator<T> comparator) {
		 int n= table.size();
		 while(n>0) {
			 n--;
			 swap(table,0,n);
			 int parent=0;
			 while(true) {
				 int leftchild = 2* parent +1;
				 if(leftchild >=n) {
					 break;
				 }
				 int rightchild= leftchild +1;
				 int maxchild = leftchild;
				 if(rightchild < n && comparator.compare(table.get(leftchild),(table.get(rightchild)))<0) {
					 maxchild=rightchild;
				 }
				 if(comparator.compare(table.get(parent),table.get(maxchild))< 0) {
					 swap(table,parent,maxchild);
					 parent=maxchild;
				 }
				 else {
					break;
				}	
			 }
		 }
	}
	private void swap(List<T> table ,int i , int j) {
		T temp = table.get(i);
		table.set(i,table.get(j));
		table.set(j,temp);
	}
	
	
	// Quick SORT O (nlogn) storage O (n)
	
	public void QuickSort(List<T> table,Comparator<T> comparator) {
		QuickSort(table ,0,table.size()-1,comparator);
	}
	private void QuickSort(List<T> table,int first, int last,Comparator<T> comparator) {
		if(first < last) {
			int pivIndex= partition(table,first,last,comparator);
			QuickSort(table, first,pivIndex-1,comparator);
			QuickSort(table, pivIndex+1, last,comparator);
		}
	}
	protected int partition(List<T> table, int first, int last,Comparator<T> comparator) {
		T pivot = table.get(first);
		int up =first;
		int down =last;
		do {
			while((up < last ) && (comparator.compare(pivot,table.get(up))>=0)) {
				up++;
			}
			while(comparator.compare(pivot,table.get(down)) < 0) {
				down--;
			}
			if(up < down) {
				swap(table,up,down);
			}
		}
		while(up < down);
			
		swap(table, first, down);
		
		return down;
	}
}
