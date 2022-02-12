package linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

public class HashMapLinkedList <K,V> implements KWHashMap<K,V>{
	private LinkedList<Entry<K,V>>[] tablelLinkedLists;
	private int numKeys;
	private static int CAPACITY = 101;
	private static final double LOAD_THRESHOLD = 3.0;
	private static class Entry<K,V>{
		private K Key;
		private V Value;
		public Entry(K key,V value) {
			Key=key;
			Value=value;
		}
		public K getKey() {
			return Key;
		}
		public V getValue() {
			return Value;
		}
		public V setValue(V value) {
			V oldValue=Value;
			Value=value;
			return oldValue;
		}
	}
	@SuppressWarnings("unchecked")
	public HashMapLinkedList() {
		tablelLinkedLists=new LinkedList[CAPACITY];
	}
	/**
	 * 
	 * @param get the element over key 
	 */
	@Override
	public V get(Object key) {
		int index=key.hashCode() % tablelLinkedLists.length;
		if(index<0) {
			index+=tablelLinkedLists.length;
		}
		if(tablelLinkedLists[index]==null) {
			return null;
		}
		for(Entry<K, V> nextItem : tablelLinkedLists[index]) {
			if(nextItem.Key.equals(key)) {
				return nextItem.Value;
			}
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return numKeys==0;
	}
	/**
	 * 
	 * @param put new element to the if key already exist it's value will be changed otherwise new element will be added.
	 */
	@Override
	public V put(K key, V value) {
		int index = key.hashCode() % tablelLinkedLists.length;
		if(index<0) {
			index+=tablelLinkedLists.length;
		}
		if(tablelLinkedLists[index]==null) {
			tablelLinkedLists[index]= new LinkedList<Entry<K, V>>();
		}
		for(Entry<K, V> nextItem : tablelLinkedLists[index]) {
			if(nextItem.Key.equals(key)) {
				V oldvalueV=nextItem.Value;
				nextItem.setValue(value);
				return oldvalueV;
			}
		}
		tablelLinkedLists[index].addFirst(new Entry<K,V>(key,value));
		numKeys++;
		if(numKeys > LOAD_THRESHOLD * tablelLinkedLists.length) {
			rehash();
		}
		return null;
	}
	/**
	 * 
	 * @param if element does not exist return null otherwise find element using key and hascode and it will be removed if there is one element on linkedlist,
	 * one linkedlist node will be removed also.
	 */
	@Override
	public V remove(Object key) {
		int index = key.hashCode() % tablelLinkedLists.length;
		if(index<0) {
			index+=tablelLinkedLists.length;
		}
		if(tablelLinkedLists[index]==null) {
			return null;
		}
		for(Entry<K, V> nextItem : tablelLinkedLists[index]) {
			if(nextItem.Key.equals(key)) {
				V valueV=nextItem.Value;
				tablelLinkedLists[index].remove(nextItem);
				numKeys--;
				if(tablelLinkedLists[index].size()==0) {
					tablelLinkedLists[index]=null;
				}
				return valueV;
			}
		}
		return null;
	}
	@Override
	public int size() {
		return numKeys;
	}
	@SuppressWarnings("unchecked")
	private void rehash() {
		 LinkedList<Entry<K,V>>[] new_array =new LinkedList[CAPACITY*2];
		 for(int i=0;i<CAPACITY*2;i++){
			 new_array[i] = new LinkedList<Entry<K,V>>();
	     }
		 for (LinkedList<Entry<K, V>> linkedList : tablelLinkedLists) {
	            for (Entry<K, V> el : linkedList) {
	                int hashVal = el.Key.hashCode();
	                hashVal = hashVal & 0x7FFFFFFF;
	                hashVal = hashVal % CAPACITY*2;
	                new_array[hashVal].add(el);
	            }
	     }
		 tablelLinkedLists= new_array;
	     CAPACITY = CAPACITY*2;
	}
	public String toString() {
		StringBuilder stringBuilder=new StringBuilder();
		for (int i = 0; i < tablelLinkedLists.length; i++) {
			if(tablelLinkedLists[i]!=null) {
				for(Entry<K, V> nextItem : tablelLinkedLists[i]) {
					if(nextItem.Key!=null)
						stringBuilder.append(nextItem.Value+" ");
				}
				stringBuilder.append("\n");
			}
		}
		return stringBuilder.toString();
	}
}

