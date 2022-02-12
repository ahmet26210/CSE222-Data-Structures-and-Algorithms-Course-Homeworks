package linkedlist;

import java.util.Random;

public class CoalescedHashing <K,V> implements KWHashMap<K,V>{
	
	private Entry<K,V>[] tableArray;
	private int numKeys;
	private static int CAPACITY = 10;
	private static final double LOAD_THRESHOLD = 0.75;
	private int numDeletes;
	private final Entry<K, V> DELETED =new Entry<K,V>(null,null);
	@SuppressWarnings("unchecked")
	public CoalescedHashing() {
		tableArray=new Entry[CAPACITY];
	}
	private static class Entry<K,V>{
		private K Key;
		private V Value;
		int index=-1;
		private Entry<K, V> nextEntry;
		public Entry(K key,V value) {
			Key=key;
			Value=value;
			this.nextEntry=null;
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
		public Entry<K, V> getNextEntry() {
			return nextEntry;
		}
		public void setNextEntry(Entry<K, V> nextEntry) {
			this.nextEntry = nextEntry;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		
	}
	/**
	 * 
	 * @param get the element over key 
	 */
	@Override
	public V get(Object key) {
		int index=find(key);
		if(tableArray[index]!=null)
			return tableArray[index].Value;
		else
			return null;
	}
	@Override
	public boolean isEmpty() {
		return	tableArray.length==0;
	}
	/**
	 * 
	 * @param put new element to the array if index already full new element will be added to the next of already exist element.
	 * @param if this elements was full also new element will be added of this element . 
	 */
	@Override
	public V put(K key, V value) {
		int probeNum=0;
		int index=0;
		int startindex=find(key);
		if(tableArray[startindex]==null) {
			tableArray[startindex]= new Entry<K,V>(key, value);
			numKeys++;
			double loadFactor=(double) (numDeletes+numKeys) / tableArray.length;
			if(loadFactor> LOAD_THRESHOLD) {
				rehash();
			}
			return null;
		}
		
		index=startindex;
		while(tableArray[index]!=null) {
			probeNum++;
			index=(startindex+probeNum*probeNum) % tableArray.length;
			if(index <0 || index > tableArray.length) {
				return	null;
			}
		}
		tableArray[index]= new Entry<K,V>(key, value);
		numKeys++;
		while(tableArray[startindex].getNextEntry()!=null) {
			startindex=tableArray[startindex].getNextEntry().getIndex();
		}
		tableArray[startindex].setNextEntry(new Entry<K,V>(key, value));
		tableArray[startindex].getNextEntry().setIndex(index);
		
		double loadFactor=(double) (numDeletes+numKeys) / tableArray.length;
		if(loadFactor> LOAD_THRESHOLD) {
			rehash();
		}
		return null;
	}
	/**
	 * 
	 * @param if one element removed it has no next element i change it with deleted entry
	 *  then it is deleted after rehash function obviously. if removed one element that
	 *  has next element the next element will be added this
	 *  first element and next element index removed after all next element will be in deleted element index
	 */
	@Override
	public V remove(Object key) {
		V vaV=null;
		int startindex=findelement(key);
		int index3=startindex;
		if(startindex==-1) {
			return null;
		}
		if(tableArray[startindex]==null) {
			return null;
		}
		else if(tableArray[startindex]!=null) {
			if(tableArray[startindex].getNextEntry()==null) {
				vaV=tableArray[startindex].Value;
				tableArray[startindex]=DELETED;
			}
			else if(tableArray[tableArray[startindex].getNextEntry().getIndex()].getNextEntry()==null) {
				int index=tableArray[startindex].getNextEntry().getIndex();
				tableArray[startindex]=tableArray[index];
				tableArray[index]=DELETED;
			}
			else {
				int index=0;
				while(tableArray[startindex].getNextEntry()!=null) {
					index=tableArray[startindex].getNextEntry().getIndex();
					tableArray[startindex]=tableArray[index];
					tableArray[index]=tableArray[index].getNextEntry();
					startindex=index;
				}
				tableArray[tableArray[index3].getNextEntry().getIndex()]=DELETED;
				tableArray[index3].nextEntry=null;
			}
			numKeys--;
			numDeletes++;
		}
		return vaV;
	}
	@Override
	public int size() {
		return tableArray.length;
	}
	private int find (Object key) {
		int index = key.hashCode() % tableArray.length;
		if(index < 0) {
			index+=tableArray.length;
		}
		return index;
	}
	private int findelement (Object key) {
		for(int i=0;i<tableArray.length;i++) {
			if(tableArray[i]!=null) {
				if(key==tableArray[i].Key) {
					return i;
				}
			}
		}
		return -1;
	}
	@SuppressWarnings("unchecked")
	private void rehash() {
		Entry<K, V>[] oldtable	=tableArray;
		tableArray = new Entry[2* oldtable.length ];
		numDeletes=0;
		numKeys=0;
		for (int i = 0; i < oldtable.length; i++) {
			if(oldtable[i] != null &&  oldtable[i]!=DELETED) {
				put(oldtable[i].Key ,oldtable[i].Value);
			}
		}
	}
	public String toString() {
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("Hash Value    Key   Next \n");
		for (int i = 0; i < tableArray.length; i++) {
			stringBuilder.append("    "+i);
			if(tableArray[i]==DELETED) {
				stringBuilder.append("               null");
			}
			else if(tableArray[i]!=null) {
				if(tableArray[i].Key!=null)
					stringBuilder.append("         "+tableArray[i].Key +"    ");
				else {
					stringBuilder.append("     ");
				}
			
				if(tableArray[i].getNextEntry()!=null)
					stringBuilder.append("  "+tableArray[i].getNextEntry().getIndex());
				else {
					stringBuilder.append("null");
				}
			}
			
			else {
				stringBuilder.append("               null");
			}
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
}
