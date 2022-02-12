package linkedlist;


public interface NavigableSetSkipList<E>{

	
	public boolean insert(E e);
	
	public E delete(E e);
	
	Iterator<E> descendingIterator();
	
}
