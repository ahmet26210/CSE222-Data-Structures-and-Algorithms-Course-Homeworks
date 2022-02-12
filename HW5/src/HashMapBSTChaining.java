package linkedlist;


import java.util.TreeSet;





public class HashMapBSTChaining <K extends Comparable<K>,V> implements KWHashMap<K,V> {
	private TreeSet<Entry<K,V>>[] tableTS;
	private int numKeys;
	private static int CAPACITY = 101;
	private static final double LOAD_THRESHOLD = 3.0;
	private static class Entry<K extends Comparable<K>,V> implements Comparable<Entry<K,V>>{
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
		
		
		@Override
		public int compareTo(Entry<K, V> o) {
			if((this.Key).compareTo(o.Key)>0) {
				return 1;
			}
			else if((this.Key).compareTo(o.Key)<0) {
				return -1;
			}
			return 0;
		}
	}
	@SuppressWarnings("unchecked")
	public HashMapBSTChaining() {
		tableTS=new TreeSet[CAPACITY];
	}
	/**
	 * 
	 * @param get the element over key 
	 */
	@Override
	public V get(Object key) {
		int index=key.hashCode() % tableTS.length;
		if(index<0) {
			index+=tableTS.length;
		}
		if(tableTS[index]==null) {
			return null;
		}
		for(Entry<K, V> nextItem : tableTS[index]) {
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
		int index = key.hashCode() % tableTS.length;
		if(index<0) {
			index+=tableTS.length;
		}
		if(tableTS[index]==null) {
			tableTS[index]= new TreeSet<Entry<K, V>>();
		}
		for(Entry<K, V> nextItem : tableTS[index]) {
			if(nextItem.Key.equals(key)) {
				V oldvalueV=nextItem.Value;
				nextItem.setValue(value);
				return oldvalueV;
			}
		}
		tableTS[index].add(new Entry<K,V>(key,value));
		numKeys++;
		if(numKeys > LOAD_THRESHOLD * tableTS.length) {
			rehash();
		}
		return null;
	}

	/**
	 * 
	 * @param if element does not exist return null otherwise find element using key and hascode and it will be removed if there is one element on tree,
	 * one tree node will be removed also.
	 */
	@Override
	public V remove(Object key) {
		int index = key.hashCode() % tableTS.length;
		if(index<0) {
			index+=tableTS.length;
		}
		if(tableTS[index]==null) {
			return null;
		}
		for(Entry<K, V> nextItem : tableTS[index]) {
			if(nextItem.Key.equals(key)) {
				V valueV=nextItem.Value;
				tableTS[index].remove(nextItem);
				numKeys--;
				if(tableTS[index].isEmpty()) {
					tableTS[index]=null;
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
	public String toString() {
		StringBuilder stringBuilder=new StringBuilder();
		for (int i = 0; i < tableTS.length; i++) {
			if(tableTS[i]!=null) {
				for(Entry<K, V> nextItem : tableTS[i]) {
					if(nextItem.Key!=null)
						stringBuilder.append(nextItem.Value+" ");
				}
				stringBuilder.append("\n");
			}
		}
		return stringBuilder.toString();
	}
	@SuppressWarnings("unchecked")
	private void rehash() {
		 TreeSet<Entry<K,V>>[] new_array =new TreeSet[CAPACITY*2];
		 for(int i=0;i<CAPACITY*2;i++){
			 new_array[i] = new TreeSet<Entry<K,V>>();
	     }
		 for (TreeSet<Entry<K, V>> TS : tableTS) {
	            for (Entry<K, V> el : TS) {
	                int hashVal = el.Key.hashCode();
	                hashVal = hashVal & 0x7FFFFFFF;
	                hashVal = hashVal % CAPACITY*2;
	                new_array[hashVal].add(el);
	            }
	     }
		 tableTS= new_array;
	     CAPACITY = CAPACITY*2;
	}
}
