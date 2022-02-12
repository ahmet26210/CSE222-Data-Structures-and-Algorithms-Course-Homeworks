package linkedlist;

public class NavigableSetAvlTreeClass<E extends Comparable<E>> implements NavigableSetAvlTree<E>{
	AVLTree<E> sl = new AVLTree<>();
	
	@Override
	public boolean insert(E e) {
		return sl.add(e);
	}

	@Override
	public Iterator<E> iterator() {
		return  sl.iterator();
	}

	@Override
	public AVLTree<E> headSet(E e) {
		return sl.headSet(e);
	}

	@Override
	public AVLTree<E> tailSet(E e) {
		return sl.tailSet(e);
	}

	
	public void print(){
		sl.print();
	}
	
}
