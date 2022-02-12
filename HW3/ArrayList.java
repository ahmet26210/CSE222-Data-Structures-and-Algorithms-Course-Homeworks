//package twes;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

	@SuppressWarnings("unused")
	public class ArrayList <E> implements Iterable<E>{
		private E[] theData;
		private int size;
		private int capacity;
		private static final int INITIALCAPACITY=20;
		private Listiter iterator;
		private boolean balanced=false;
		@SuppressWarnings("unchecked")
		/**
	     * Constructs an empty list with the specified initial capacity.
	     *
	     * @param  initialCapacity  the initial capacity of the list
	     */
		public ArrayList() {
			theData=(E[]) new Object[INITIALCAPACITY];
			size=0;
			capacity=INITIALCAPACITY;
			iterator=new Listiter();
		}
		
		public Listiter getIterator() {
			return iterator;
		}
		/**
	     * Appends the specified element to the end of this list.
	     *
	     * @param e element to be appended to this list
	     * @return <tt>true</tt>)
	     */
		public boolean add(E element) {
			if(size==capacity) {
				reallocate();
			}
			theData[size++]=element;
			return true;
		}
		public boolean getBalanced() {
			return balanced;
		}
		public void setBalanced(boolean a) {
			balanced=a;
		}
		/**
	     * Insert the specified element at the specified position in this
	     * list. Shifts the element currently at that position (if any) and
	     * any subsequent elements to the right (adds one to their indices).
	     *
	     * @param index index at which the specified element is to be inserted
	     * @param element element to be inserted
	     * @throws IndexOutOfBoundsException
	     */
		public void add(int index,E element) {
			if(index<0 || index>size) {
				throw new ArrayIndexOutOfBoundsException(index);
			}
			if(size==capacity) {
				reallocate();
			}
			for(int i=size;i>index;i--) {
				theData[i]=theData[i-1];
			}
			theData[index]=element;
			size++;
		}
		
		public int getSize() {
			return size;
		}

		

		/**
	     * Returns the element at the specified position in this list.
	     *
	     * @param  index index of the element to return
	     * @return the element at the specified position in this list
	     * @throws IndexOutOfBoundsException {@inheritDoc}
	     */
		public E get(int index) {
			if(index<0 || index>size) {
				throw new ArrayIndexOutOfBoundsException(index);
			}
			return theData[index];
		}
		
		/**
	     * Replaces the element at the specified position in this list with
	     * the specified element.
	     *
	     * @param index index of the element to replace
	     * @param element element to be stored at the specified position
	     * @return the element previously at the specified position
	     * @throws IndexOutOfBoundsException {@inheritDoc}
	     */
		public E set(int index , E newValue) {
			if(index<0 || index>size) {
				throw new ArrayIndexOutOfBoundsException(index);
			}
			E oldValuE=theData[index];
			theData[index]=newValue;
			return oldValuE;
		}
		
		/**
	     * Removes the element at the specified position in this list.
	     * Shifts any subsequent elements to the left (subtracts one from their
	     * indices).
	     *
	     * @param index the index of the element to be removed
	     * @return the element that was removed from the list
	     * @throws IndexOutOfBoundsException
	     */
		public E remove(int index) {
			if(index<0 || index>size) {
				throw new ArrayIndexOutOfBoundsException(index);
			}
			E returnValueE=theData[index];
			for (int i = index+1; i < size; i++) {
				theData[i-1]=theData[i];
			}
			size--;
			return returnValueE;
		}
		
		private void reallocate() {
			capacity*=2;
			theData=Arrays.copyOf(theData, capacity);
		}
		/**
	     * Returns the number of elements in this list.
	     *
	     * @return the number of elements in this list
	     */
	    public int size() {
	        return size;
	    }

	    /**
	     * Returns <tt>true</tt> if this list contains no elements.
	     *
	     * @return <tt>true</tt> if this list contains no elements
	     */
	    public boolean isEmpty() {
	        return size == 0;
	    }
	    
		@Override
		public Listiter iterator(){
			return new Listiter();
		}
		public Listiter iterator(int index){
			if (index < 0 || index > size)
	            throw new IndexOutOfBoundsException("Index: "+index);
			return new Listiter(index);
		}
		public class Listiter implements ListIterator<E>{
			private int cursor;
			private int lastret=-1;
			public Listiter(int index) {
				cursor=index;
			}

			public Listiter() {
				this(0);
			}

			@Override
			public boolean hasNext() {
				return cursor<size;
			}

			@Override
			public E next() {
				if(!hasNext()) {
					throw new NoSuchElementException();
				}
				lastret=cursor;
				cursor+=1;
				return theData[lastret];
			}

			@Override
			public boolean hasPrevious() {
				return cursor!=0;
			}

			@Override
			public E previous() {
				if(!hasPrevious()) {
					throw new NoSuchElementException();
				}
				lastret=cursor;
				cursor-=1;
				return theData[lastret];
			}

			@Override
			public int nextIndex() {
				return cursor;
			}

			@Override
			public int previousIndex() {
				return cursor-1;
			}

			@Override
			public void remove()throws ConcurrentModificationException {
				if (lastret < 0)
	                throw new IllegalStateException();

	            try {
	                ArrayList.this.remove(lastret);
	                cursor = lastret;
	                lastret = -1;
	            } catch (IndexOutOfBoundsException ex) {
	                throw new ConcurrentModificationException();
	            }
			}
			@Override
			public void set(E e) {
				if (lastret < 0)
	                throw new IllegalStateException();
				theData[lastret]=e;
			}

			@Override
			public void add(E e) throws ConcurrentModificationException{
				 try {
		                int i = cursor;
		                ArrayList.this.add(i, e);
		                cursor = i + 1;
		                lastret = -1;
		            } catch (IndexOutOfBoundsException ex) {
		                throw new ConcurrentModificationException();
		            }
			}
			
		}
		public int contains(Object o) {
			if(o ==null) {
				return -1;
			}
			for(int i=0;i<size();i++) {
				if(theData[i].equals(o)) {
					return i;
				}
			}
			return -1;
		}
		public void removeElement(Object element) {
			
			boolean flag = true;
			if(element == null || contains(element) == -1)
	            flag=false;

	        for(int i=0 ; i < size() && flag; ++i)
	            if(get(i).equals(element))
	            {
	                this.getArray()[i] = get(getSize()-1);
	                flag = false;
	            }

	        size--;
		}
		public E[] getArray() {
			return theData;
		}
		public boolean equals(Object o)
	    {
	        if(o == null)
	            return false;
	        if(!(o instanceof Container))
	            return false;

	        @SuppressWarnings("unchecked")
			Container<E> temp = ((Container<E>)o);

	        if(size() != temp.getUsed())
	            return false;

	        for(int i=0 ; i < size() ; ++i)
	            if(theData[i] != temp.getArray()[i])
	                return false;

	        return true;
	    }
		public String toString() {
			StringBuilder stringBuilder=new StringBuilder();
			stringBuilder.append("[");
			for (int i = 0; i <size; i++) {
				stringBuilder.append(theData[i]+" ");
			}
			stringBuilder.append("]");
			return stringBuilder.toString();
		}
	}
