package linkedlist;


import java.util.NoSuchElementException;
import java.util.Set;

@SuppressWarnings("serial")
/**
 * 
 * @author Ahmet Furkan Kurban
 *
 * @param <K,V> the type of data
 * @param MapIterable is a interface <K,V>.
 */
public class HashMap<K,V> extends java.util.HashMap<K, V> implements MapIterable<K,V> {
	public class MAPIterator  implements MapIterator<K,V>{
		int index=0;
		int moveindex=1;
		/**
		 * 
		 * @param every next function iterator will start from begin and it reach current index.
		 * if index is equal with size index will be 0.
		 */
		@Override
		public K next() throws NoSuchElementException{
			Set<K> set=keySet();
			java.util.Iterator<K> it= set.iterator();
			if(index==size() && moveindex==size()) {
				throw new NoSuchElementException();
			}
			if(index==size()) {
				index=0;
			}
			for(int i=0;i<index && it.hasNext();i++) {
				it.next();
			}
			K element=it.next();
			index++;
			moveindex++;
			return element;
		}
		/**
		 * 
		 * @param every prev function iterator will start from begin and it reach current index-1 so i reach prev element
		 * if index is equal with zero index will be size.
		 */
		@Override
		public K prev() throws NoSuchElementException{
			Set<K> set=keySet();
			if(index==size() && moveindex==size()) {
				throw new NoSuchElementException();
			}
			java.util.Iterator<K> it= set.iterator();
			if(index==0) {
				index=size();
			}
			for(int i=0;i<index-1 && it.hasNext();i++) {
				it.next();
			}
			K element=it.next();
			moveindex++;
			index--;
			return element;
		}
		/**
		 * 
		 * @param every next and prev function move index will increase one if we reached all the elements move index will  be equal with size so there is no has next element.
		 */
		@Override
		public boolean hasNext() {
			return moveindex!=size();
		}
		/**
		 * 
		 * @param parameter iterator to start with wanted element.
		 */
		@Override
		public MAPIterator iterator(K key) {
			MAPIterator iterator=new MAPIterator();
			Set<K> set=keySet();
			boolean control=false;
			java.util.Iterator<K> it= set.iterator();
			for (int i = 0; i < size(); i++) {
				if(key.equals(it.next())) {
					iterator.index=i;
					control=true;
				}
			}
			if(control==false) {
				
			}
			return iterator;
		}
	}
	/**
	 * 
	 * @param no parameter iterator it will start from beginner.
	 */
	@Override
	public MAPIterator iterator() {
		return new MAPIterator();
	}
	
}
