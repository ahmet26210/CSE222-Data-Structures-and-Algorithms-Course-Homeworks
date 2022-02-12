//package twes;
import java.util.ListIterator;
import java.util.NoSuchElementException;
public class HybridList <E>{
		private DDlist<ArrayList<E>> linkedlist;
		private int maxNumber;
		private int counter;
		private int size;
		private int arraylistcounter;
		ArrayList<E> newArraylist;
		public HybridList(int maxnumber) {
			this.maxNumber=maxnumber;
			counter=0;
			size=0;
			arraylistcounter=1;
			linkedlist=new DDlist<ArrayList<E>>();
			newArraylist=new ArrayList<>();
			linkedlist.add(newArraylist);
		}
		public void add(E element) throws NoSuchElementException {
			if(element==null) {
				throw new NoSuchElementException();
			}
			if(counter==maxNumber) {
				linkedlist.get(arraylistcounter-1).setBalanced(true);
				linkedlist.add(new ArrayList<>());
				arraylistcounter++;
				counter=0;
			}
			linkedlist.get(arraylistcounter-1).add(element);
			counter++;
			size++;
		}
		public void add(E element,int index) throws NoSuchElementException {
			if(element==null ||index<0 || index>size) {
				throw new NoSuchElementException();
			}
			if(counter==maxNumber) {
				linkedlist.get(arraylistcounter-1).setBalanced(true);
				linkedlist.add(new ArrayList<>());
				arraylistcounter++;
				counter=0;
			}
			int number1=index/maxNumber;
			int number2=index%maxNumber;
			linkedlist.get(number1).add(number2,element);
			while(linkedlist.get(number1).getBalanced()==true) {
				E data=linkedlist.get(number1).remove(maxNumber);
				number1++;
				linkedlist.get(number1).add(0,data);
			}
			counter++;
			size++;
		}
		public E get(int index) {
			if(index<0 || index>size) {
				throw new ArrayIndexOutOfBoundsException(index);
			}
			int number1=index/maxNumber;
			int number2=index%maxNumber;
			E element=linkedlist.get(number1).get(number2);
			return element;
		}
		public E set(int index , E newValue) {
			if(index<0 || index>size) {
				throw new ArrayIndexOutOfBoundsException(index);
			}
			int number1=index/maxNumber;
			int number2=index%maxNumber;
			E element=linkedlist.get(number1).get(number2);
			linkedlist.get(number1).set(number2,newValue);
			return element;
		}
		public E remove (int index) {
			if(index<0 || index>size) {
				throw new NoSuchElementException();
			}
			int number1=index/maxNumber;
			int number2=index%maxNumber;
			E element=linkedlist.get(number1).get(number2);
			linkedlist.get(number1).remove(number2);
			counter--;
			if(linkedlist.get(number1).size()==0) {
				linkedlist.remove(arraylistcounter-1);
				arraylistcounter--;
				counter=maxNumber;
			}
			
			while(linkedlist.get(number1).getBalanced()==true) {
				E data=linkedlist.get(number1+1).remove(0);
				System.out.print(data);
				linkedlist.get(number1).add(maxNumber-1,data);
				number1++;
			}
			if(linkedlist.get(arraylistcounter-1).size()==0) {
				linkedlist.remove(arraylistcounter-1);
				arraylistcounter--;
				counter=maxNumber;
			}
			size--;
			return element;
		}
		public E remove () {
			E elementeE=linkedlist.get(arraylistcounter-1).get(counter);
			linkedlist.get(arraylistcounter-1).remove(counter);
			counter--;
			if(linkedlist.get(arraylistcounter-1).size()==0) {
				linkedlist.remove(arraylistcounter-1);
				arraylistcounter--;
				counter=maxNumber;
			}
			size--;
			return elementeE;
		}
		public void Print() {
			for (int i = 0; i <arraylistcounter; i++) {
				System.out.print(linkedlist.get(i).toString());
			}
		}
		private class Listiter implements ListIterator<E>{
			private int counter=0;
			private int counter1=0;
			@Override
			public boolean hasNext() {
				if(counter==maxNumber) {
					return linkedlist.getIterator().hasNext();
				}
				else {
					return linkedlist.get(counter1).getIterator().hasNext();
				}
			}

			@SuppressWarnings("unchecked")
			@Override
			public E next() {
				if(counter==maxNumber) {
					if(!linkedlist.getIterator().hasNext()) {
						throw new NoSuchElementException();
					}
					counter=0;
					counter1++;
					return (E) linkedlist.getIterator().next();
				}
				else{
					if(!linkedlist.get(counter1).getIterator().hasNext()) {
						throw new NoSuchElementException();
					}
					counter++;
					return linkedlist.get(counter1).getIterator().next();
				}
			}

			@Override
			public boolean hasPrevious() {
				if(counter==0) {
					return linkedlist.getIterator().hasPrevious();
				}
				else {
					return linkedlist.get(counter1).getIterator().hasPrevious();
				}
			}

			@SuppressWarnings("unchecked")
			@Override
			public E previous() {
				if(counter==0) {
					if(!linkedlist.getIterator().hasPrevious()) {
						throw new NoSuchElementException();
					}
					counter=maxNumber;
					counter1--;
					return (E) linkedlist.getIterator().previous();
				}
				else{
					if(!linkedlist.get(counter1).getIterator().hasPrevious()) {
						throw new NoSuchElementException();
					}
					counter--;
					return linkedlist.get(counter1).getIterator().previous();
				}
			}

			@Override
			public int nextIndex() {
				if(counter==maxNumber) {
					return linkedlist.getIterator().nextIndex();
				}
				else {
					return linkedlist.get(counter1).getIterator().nextIndex();
				}
			}

			@Override
			public int previousIndex() {
				if(counter==0) {
					return linkedlist.getIterator().previousIndex();
				}
				else {
					return linkedlist.get(counter1).getIterator().previousIndex();
				}
			}

			@Override
			public void remove() {
				linkedlist.get(arraylistcounter-1).remove(counter);
				counter--;
				if(linkedlist.get(arraylistcounter-1).size()==0) {
					linkedlist.remove(arraylistcounter-1);
					arraylistcounter--;
					counter=maxNumber;
				}
				size--;
			}

			@Override
			public void set(E e) {
				linkedlist.get(counter1).set(counter,e);
			}

			@Override
			public void add(E e) {
				if(e==null) {
					throw new NoSuchElementException();
				}
				if(counter==maxNumber) {
					linkedlist.get(arraylistcounter-1).setBalanced(true);
					linkedlist.add(new ArrayList<>());
					arraylistcounter++;
					counter=0;
				}
				linkedlist.get(arraylistcounter-1).add(e);
				counter++;
				size++;
			}
			
		}
		public Listiter iterator() {
			return new Listiter();
		}
		public int getSize() {
			return size;
		}
		public int contains(E element){
			for (int i = 0; i <arraylistcounter; i++) {
				for (int j = 0; j <maxNumber; j++) {
					if(linkedlist.get(i).get(j).equals(element)) {
						return i*maxNumber+j;
					}
				}
			}
			return-1;
		}
		/*public static void main (String[] args) {
		HybridList<Integer> hybridList =new HybridList<Integer>(10);
			for (int i = 0; i <50; i++) {
					hybridList.add(i);
			}
			hybridList.add(12,3);
			hybridList.Print();
			System.out.println("\n");
			hybridList.remove(3);
			hybridList.remove();
			hybridList.add(11);
			hybridList.add(11);
			hybridList.add(11);
			hybridList.remove(16);
			hybridList.remove(36);
			System.out.print(hybridList.set(11,12));
			hybridList.add(16,25);
			System.out.println("\n");
			hybridList.Print();
		}*/
	}

