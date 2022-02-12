package linkedlist;



import linkedlist.HashMap.MAPIterator;

public interface MapIterable<K,V> {
	@SuppressWarnings("rawtypes")
	MAPIterator iterator();
}
