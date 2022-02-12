package linkedlist;

public class NavigableSetSkipListClass<E extends Comparable<E>> implements NavigableSetSkipList<E> {
	SkipList<E> sl = new SkipList<>();
	
	@Override
	public boolean insert(E e) {
		return sl.insert(e);
	}

	@Override
	public E delete(E e) {
		return sl.delete(e);
	}

	@Override
	public Iterator<E> descendingIterator() {
		return sl.descendingIterator();
	}

	@Override
	public String toString() {
		return sl.toString();
	}
	
}
