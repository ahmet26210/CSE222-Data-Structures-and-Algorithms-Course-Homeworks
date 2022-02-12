package linkedlist;

public interface NavigableSetAvlTree<E extends Comparable<E>> {

	public boolean insert(E e);
	
	 Iterator<E> iterator();
	
	 AVLTree<E> headSet(E e);
	
	 AVLTree<E> tailSet(E e);
	
}
