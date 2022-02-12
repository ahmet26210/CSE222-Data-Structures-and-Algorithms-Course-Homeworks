//package twes;

public interface containerInterface<T> {
	public void reCapacity(int capacity);
	public boolean isEmpty();
	public void addElement(T element);
	public int contains(T element);
	public void clear();
	public T at(int index);
	public void removeElement(T element);
}
