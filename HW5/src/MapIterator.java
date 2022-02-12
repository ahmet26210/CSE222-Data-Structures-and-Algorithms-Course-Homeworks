package linkedlist;

import linkedlist.HashMap.MAPIterator;

public interface MapIterator <K,V> {
	public K next();
	public K prev();
	public boolean hasNext();
	@SuppressWarnings("rawtypes")
	MAPIterator iterator(K key);
}
