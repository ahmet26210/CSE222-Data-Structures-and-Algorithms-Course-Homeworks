//package twes;
import java.util.ListIterator;
import java.util.NoSuchElementException;


	public class DDlist <E> implements Iterable<E>,Cloneable{
		/**
		 * The inner class which holds the data and the reference to the next node
		 * @author Ahmet Furkan Kurban
		 *
		 * @param <E> the type of data
		 */
		
		private int size;
		private Node<E> headNode;
		private Node<E> tailNode;
		private Listiter iterator;
		/**
		 * constructs the node with the specified position and element
		 * @param _element data of node
		 * @param _prevNode previous element of the node
		 * @param _nextNode next element of the node
		 */
		
		private static class Node<E>{
			private Node<E> nextNode;
			private Node<E> prevNode;
			private E element;
			private Node(E element) {
				nextNode=null;
				prevNode=null;
				this.element=element;
			}
		}
		
		/**
		 * constructs a empty LinkedList
		 */
		
		public DDlist() {
			size=0;
			headNode=null;
			tailNode=null;
			iterator=new Listiter();
		}
		public Node<E> getLast(){
			return tailNode;
		}
		public Node<E> getFirst(){
			return headNode;
		}
		public Listiter getIterator() {
			return iterator;
		}
		public class Listiter implements ListIterator<E>{
			private int index=0;
			private Node<E> nextitem;
			private Node<E> lastitemreturned;
			private boolean removecontrol=false;
			public Listiter() {
				nextitem=headNode;
				lastitemreturned=null;
				index=0;
			}
			@Override
			public boolean hasNext() {
				return (nextitem!=null);
			}

			@Override
			public E next() {
				if(!hasNext()) {
					throw new NoSuchElementException();
				}
				lastitemreturned=nextitem;
				nextitem=nextitem.nextNode;
				index++;
				return lastitemreturned.element;
			}

			@Override
			public boolean hasPrevious() {
				return nextitem!=headNode;
			}

			@Override
			public E previous() {
				if(!hasPrevious()) {
					throw new NoSuchElementException();
				}
				if(nextitem==null) {
					nextitem=tailNode;
				}
				else {
					lastitemreturned=nextitem;
					nextitem=nextitem.prevNode;
				}
				index--;
				return lastitemreturned.element;
			}

			@Override
			public int nextIndex() {
				return index;
			}

			@Override
			public int previousIndex() {
				return index-1;
			}
			@Override
			public void set(E e) {
				if(lastitemreturned == null)
					throw new IllegalStateException();
				lastitemreturned.element=e;
			}
			@Override
			public void remove() {
				if(lastitemreturned==null) {
					throw new IllegalStateException();
				}
				if(lastitemreturned==headNode) {
					headNode=nextitem;
					lastitemreturned.nextNode=null;
					headNode.prevNode=null;
				}
				else if(lastitemreturned==tailNode) {
					tailNode=lastitemreturned.prevNode;
					tailNode.nextNode=null;
					lastitemreturned.prevNode=null;
					lastitemreturned=null;
				}
				else {
					lastitemreturned.prevNode.nextNode=nextitem;
					nextitem.prevNode=lastitemreturned.prevNode;
					lastitemreturned=null;
				}
				index--;
				removecontrol=true;
				size--;
			}
			@Override
			public void add(E e) {
				lastitemreturned= null;
				if(headNode==null) {
					headNode=new Node(e);
					tailNode=headNode;
				}
				else if(nextitem==headNode) {
					Node<E> newNode=new Node(e);
					newNode.nextNode=headNode;
					headNode.prevNode=newNode;
					headNode=newNode;
				}
				else if(nextitem==null) {
					Node<E> newNode=new Node(e);
					tailNode.nextNode=newNode;
					newNode.prevNode=tailNode;
					tailNode=newNode;
				}
				else {
					Node<E> newNode=new Node(e);
					newNode.nextNode=nextitem;
					newNode.prevNode=nextitem.prevNode;
					nextitem.prevNode=newNode;
					newNode.prevNode.nextNode=newNode;
				}
				size++;
				index++;
			}
			
		}
		
		/**
		 * Adds the element as the first element
		 * @param _data element to be inserted
		 */
		public void addFirst(E element) {
			Node<E> newNode=new Node(element);
			if(headNode==null) {
				headNode=newNode;
				tailNode=newNode;
			}
			else{
				newNode.nextNode=headNode;
				headNode.prevNode=newNode;
				if(headNode==tailNode) {tailNode.prevNode=newNode;}
				headNode=newNode;
			}
			size++;
		}
		
		/**
		 * returns a deep copy of this DoubleLL
		 */
		@Override
		public Object clone() {
			DDlist<E> temp = new DDlist<E>();
			for(E e:this) {
				temp.add(e);
			}
			return temp;
		}
		
		public void add(E element) {
			Node<E> newNode=new Node(element);
			if(headNode==null) {
				headNode=newNode;
				tailNode=newNode;
			}
			else {
				tailNode.nextNode=newNode;
				newNode.prevNode=tailNode;
				tailNode=newNode;
			}
			size++;
		}
		
		/**
		 * Makes list empty
		 */
		public void clear() {
			Node<E> nextNode;
			for(Node<E> toBeRemoved = headNode;
				toBeRemoved!=null;) 
			{
				nextNode = toBeRemoved.nextNode;
				toBeRemoved.prevNode = null;
				toBeRemoved.nextNode = null;
				toBeRemoved.element = null;
				toBeRemoved = nextNode;
			}
			headNode = tailNode= null;
	        size = 0;
		}
		/**
		 * returns the element at the given index
		 * @param index index of wanted element
		 * @return element at the specified index
		 * @throws IndexOutOfBoundsException
		 */
		public E get(int index) {
			Node<E> node = getNode(index);
			if( node != null) {
				return node.element;
			}
			throw new IndexOutOfBoundsException();
		}
		/**
		 * Inserts the specified element at the specified position in this list.
		 * @param index index at which the specified element is to be inserted
		 * @param _data element to be inserted
		 */
		public void add(int index,E element) {
			if(index==0) {
				addFirst(element);
			}
			else if(index==size) {
				add(element);
			}
			else {
				Node<E> newNode=new Node(element);
				Node<E> tempNode=null;
				if(CloserToHead(index)) {
					tempNode=headNode;
					for(int i=0;i<index-1;i++) {
						tempNode=tempNode.nextNode;
					}
					newNode.nextNode=tempNode.nextNode;
					newNode.prevNode=tempNode;
					newNode.nextNode.prevNode=newNode;
					newNode.prevNode.nextNode=newNode;
				}
				else {
					tempNode=tailNode;
					for(int i=size-1;i>index+1;i--) {
						tempNode=tempNode.prevNode;
					}
					newNode.prevNode=tempNode.prevNode;
					newNode.nextNode=tempNode;
					newNode.prevNode.nextNode=newNode;
					newNode.nextNode.prevNode=newNode;
				}
				size++;
			}
		}
		
		public boolean CloserToHead(int index) {
			return index<size-index;
		}
		
		/**
		 * returns the index of given object
		 * @param o element to search for
		 * @return	index of object
		 */
		public int indexOf(Object o) {
			int i=0;
			if(o == null) {
				for(Node<E> node = headNode;node!=null;node=node.nextNode){
					if(node.element== null) {
						return i;
					}
					i++;
				}	
			}else {
				for(Node<E> node = headNode;node!=null;node=node.nextNode){
					if(node.element.equals(o)) {
						return i;
					}
					i++;
				}
			}
			return -1;	
		}
		
		public boolean contains(Object o) {
			return indexOf(o) != -1;
		}
		
		public Listiter iterator() {
			return new Listiter();
		}
		private void removefirst() {
			if(headNode==null) return;
			if(headNode==tailNode) {
				headNode=null;
				tailNode=null;
			}
			else {
				headNode.nextNode.prevNode=null;
				headNode=headNode.nextNode;
			}
			size--;
		}
		
		private void removeLast() {
			if (tailNode==null) {
				return;
			}
			if(headNode==tailNode) {
				headNode=null;
				tailNode=null;
			}
			else {
				tailNode.prevNode.nextNode=null;
				tailNode=tailNode.prevNode;
			}
			size--;
		}
		
		/**
		 * removes the element at the specified index
		 * @param index index of the element to be removed
		 * @return removed element
		 */
		public E remove(int index)throws IndexOutOfBoundsException {
			if(index<0||index>size) throw new IndexOutOfBoundsException();
			Node<E> tempNode = getNode(index);
			System.out.println(tempNode.element);
			if(index==0) {
				removefirst();
				return tempNode.element;
			}
			if(index==size-1) {
				removeLast();
				return tempNode.element;
			}
			else {
				tempNode.nextNode.prevNode=tempNode.prevNode;
				tempNode.prevNode.nextNode=tempNode.nextNode;
				size--;
				return tempNode.element;
			}
		}
		
		/**
		 * returns the element at the given index
		 * @param index index of wanted element
		 * @return element at the specified index
		 * @throws IndexOutOfBoundsException
		 */
		public Node<E> getNode (int index)throws IndexOutOfBoundsException{
			if(index<0||index>size) throw new IndexOutOfBoundsException();
			Node<E> tempNode=headNode;
			for(int i=0;i<index && tempNode!=null; i++) {
				tempNode=tempNode.nextNode;
			}
			return tempNode;
		}
		public int getSize() {
			return size;
		}
		public String toString() {
			StringBuilder stringBuilder=new StringBuilder();
			Node<E> teNode=headNode;
			while(teNode!=null) {
				stringBuilder.append(teNode.element+" ");
				teNode=teNode.nextNode;
			}
			stringBuilder.append("\n");
			return stringBuilder.toString();
		}
	}
