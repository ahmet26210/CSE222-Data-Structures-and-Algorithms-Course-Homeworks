//package twes;

public class Container<T> implements containerInterface<T> {
	private T array[];
	private int used=0;
	private int capacity=0;
	public Container() {
		this(1);
	}
	public Container(int _capacity) {
		setCapacity(_capacity);
		setUsed(0);
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getUsed() {
		return used;
	}
	public void setUsed(int used) {
		this.used = used;
	}
	public int getCapacity() {
		return capacity;
	}
	public void reCapacity(int capacity){ 
		if(capacity<0) {
			setCapacity(1);
		}
		@SuppressWarnings("unchecked")
		T[] temp=(T[])new Object[capacity];
		for(int i=0;i<used;i++) {
			temp[i]=array[i];
		}
		setCapacity(capacity);
		array=temp;
	}
	public boolean isEmpty(){
		if(used==0) return true;
		else{return false;}
	}
	public void addElement(T element) {
		int k=0;
		if(isEmpty()){
			setUsed(used+1);
			T[] temp=(T[])new Object[used];
			temp[0]=element;
			array=temp;//same referance
		}
		else{
			setUsed(used+1);
			T[] temp=(T[])new Object[used];
			for(int i=0;i<getUsed()-1;i++){
				temp[k]=array[i];
				k++;
			}
			temp[used-1]=element;
			array=temp;
		}
	}
	public void removeElement(T element) {
		
		boolean flag = true;
		if(element == null || contains(element) == -1)
            flag=false;

        for(int i=0 ; i < getUsed() && flag; ++i)
            if(at(i).equals(element))
            {
                this.array[i] = at(getUsed()-1);
                flag = false;
            }

        setUsed(getUsed()-1);
	}
	public int contains(Object o) {
		if(o ==null) {
			return -1;
		}
		for(int i=0;i<getUsed();i++) {
			if(array[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}
	public boolean equals(Object o)
    {
        if(o == null)
            return false;
        if(!(o instanceof Container))
            return false;

        Container<T> temp = ((Container<T>)o);

        if(getUsed() != temp.getUsed())
            return false;

        for(int i=0 ; i < getUsed() ; ++i)
            if(array[i] != temp.array[i])
                return false;

        return true;
    }
	public void clear() {
		array=null;
		setUsed(0);
		setCapacity(1);
	}
	 public T at(int index) throws ArrayIndexOutOfBoundsException
	    {
	        if(index < 0 || index >= getUsed())
	            throw new ArrayIndexOutOfBoundsException("Invalid index!");

	        return array[index];
	    }
	@Override
    public String toString()
    {
        String string = "";
        	for(int i=0;i<getUsed();i++) {
        		string += array[i].toString() + "\n";
        	}
       
        return string;
    }
}
