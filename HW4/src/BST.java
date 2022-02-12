package linkedlist;



public class BST <E extends Comparable<E>>{
	static class Node<E>{
		private int size;
		private E data;
		private Node<E> leftNode;
		private Node<E> rightNode;
		public Node(E data) {
			leftNode=null;
			rightNode=null;
			size=0;
			this.data=data;
		}
		public String toString() {
			return data.toString();
		}
		public Node<E> getLeft(){
			return this.leftNode;
		}
		public Node<E> getRight(){
			return this.rightNode;
		}
		public E getData() {
			return data;
		}
	}
	private Node<E> rootNode;
	private boolean addCompleted=false;
	private boolean isRemoved=false;
	/**
     * Constructs root
     *
     * @param  rootnode null
     */
	public BST() {
		rootNode=null;
	}
	/**
     * Appends the specified element to the appropriate place.
     *Add element if element is bigger than current node , 
     *node will change with right node otherwise it change 
     *with left node so every element will be add suitable place.
     * @param e element to be appended to this list
     * @return <tt>true</tt>)
     */
	public boolean add (E element) {
		rootNode=addElement(rootNode,element);
		return addCompleted;
	}
	private Node<E> addElement(Node<E> roNode,E element){
		if (roNode==null) {
			roNode=new Node<E>(element);
			addCompleted=true;
		}
		else if(element.compareTo(roNode.data)==0) {
			addCompleted=false;
		}
		else if(element.compareTo(roNode.data)<0) {
			roNode.leftNode=addElement(roNode.leftNode, element);
		}
		else {
			roNode.rightNode=addElement(roNode.rightNode, element);
		}
		return roNode;
	}
	/**
     * Traverse the tree (inordertraverse)
     *
     * @param Reach the all element of tree and printed
     * Recursion
     */
	public void inOrderTraverse() {
		inOrderTraverse(rootNode);
	}
	private void inOrderTraverse(Node<E> rNode) {
		if(rNode==null) return;
		inOrderTraverse(rNode.leftNode);
		System.out.print(rootNode.data+ " ");
		inOrderTraverse(rNode.rightNode);
		if (rNode==rootNode) {
			System.out.println("Reaching The Ancestor Rooté!!");
		}
	}
	/**
     * Traverse the tree to find the element
     *
     * @param Reach the element and find suitable element
     * @return Suitable element is returned
     * Recursion
     */
	public E find(E element) {
	   return find(rootNode,element);
	}
	private E find(Node<E> rNode,E element) {
		if(rNode==null) {
			return null;
		}
		else if(element.compareTo(rNode.data)>0) {
			System.out.println(rNode.data+ " is smaller than " + element + " going to the right");
			return	find(rNode.rightNode,element);
		}
		else if(element.compareTo(rNode.data)==0) {
			System.out.println(rNode.data+ " is equal to the " + element);
			return rNode.data;
		}
		else {
			System.out.println(rNode.data+ " is greater than " + element + " going to the left");
			return find(rNode.leftNode,element);
		}
	}
	/**
     * To find the children of given element
     *
     * @param Find the children of element
     * @return number of children of given element
     */
	private int numberOfChildren(Node<E> rNode) {
		if(rNode==null) return -1;
		int x=(rNode.rightNode==null) ? 0:1;
		int y=(rNode.leftNode==null) ? 0:1;
		return x+y;
	}
	/**
     * To delete of given element
     *
     * @param Find the element and delete it 
     * @return deleted element is returned
     * Recursion 
     */
	public E delete (E target) {
		Node<E> tempNode=delete(rootNode,target);
		return (tempNode==null) ? null : tempNode.data;
	}
	private Node<E> delete(Node<E> rNode,E target){
		if(rNode==null) return null;
		else if (target.compareTo(rNode.data)==0) {
			if(isLeaf(rNode))
    		{
    			isRemoved = true;
    			if(rNode == rootNode)
    				rootNode = null;
    			return null;
    		}
    		else if(numberOfChildren(rNode) == 1) {
    			Node<E> child = (rNode.leftNode!=null) ? rNode.leftNode : rNode.rightNode;
    			if(rNode == rootNode) {
    				rootNode = child;
    			}
    			isRemoved = true;
    			return child;
    		}
    		else {
    			Node<E> leftChild = rNode.leftNode;
    			if(leftChild.rightNode == null) {
    				rNode.data = leftChild.data;
    				rNode.leftNode = leftChild.leftNode;
    				return rNode;
    			}else {
    				E biggestOfSmallers=  findBiggestEndDelete(leftChild);
    				rNode.data = biggestOfSmallers;
    				return rNode;
    			}
    		}
		}
		else if(target.compareTo(rNode.data)>0) {
			rNode.rightNode=delete(rNode.rightNode, target);
			return rNode;
		}
		else {
			rNode.leftNode=delete(rNode.leftNode, target);
			return rNode;
		}
	}
	 private E findBiggestEndDelete(Node<E> rNode) {
	    	if(rNode.rightNode.rightNode == null) {
	    		E temp = rNode.rightNode.data;
	    		rNode.rightNode = rNode.rightNode.leftNode;
	    		return temp;
	    	}
	    	return findBiggestEndDelete(rNode.rightNode);
	    }
	public boolean contains(E element) {
		return find(element)!=null;
	}
	public boolean isEmpty() {
		return rootNode==null;
	}
	private boolean isLeaf(Node<E> rNode) {
		return (rNode!=null &&rNode.leftNode==null && rNode.rightNode==null); 
 	}
	public void preOrderTraverse(Node<E> rNode ,int depth , StringBuilder s) {
		for(int i=0;i<depth;i++) {
			s.append(" ");
		}
		if(rNode==null) {
			s.append("null\n");
		}
		else {
			s.append(rNode.toString());
			s.append("\n");
			preOrderTraverse(rNode.leftNode, depth+1, s);
			preOrderTraverse(rNode.rightNode, depth+1, s);
		}
	}
	public String toString() {
		StringBuilder aBuilder=new StringBuilder();
		preOrderTraverse(rootNode,1,aBuilder);
		return aBuilder.toString();
 	}
	public Node<E> root() {
		return (rootNode==null) ? null : rootNode;
	}
	public E rootValue() {
		return (rootNode==null) ? null : rootNode.data;
	}
	/*public static void main(String[] args) {
		BST<Integer> t=new BST<Integer>();
		t.add(6);
    	t.add(5);
    	t.add(1);
    	t.add(7);
    	t.add(60);
    	t.add(51);
    	t.add(123);
    	t.add(73);
    	t.add(7);
    	t.add(98);
    	t.add(72);
    	System.out.println(t);
    	t.inOrderTraverse();
    	//t.delete(51);
    	t.delete(123);
    	System.out.println(t);
    	t.inOrderTraverse();
    	t.delete(1);
    	System.out.println(t);
    	t.inOrderTraverse();
    	t.delete(7);
    	System.out.println(t);
    	t.inOrderTraverse();
    	t.delete(60);
    	System.out.println(t);
    	t.inOrderTraverse();
    	
    	System.out.println(t.find(61));
    	System.out.println(t.find(73));
    	System.out.println(t.contains(7));
    	System.out.println(t.contains(1234));
    	
    	System.out.println(t);
    	t.inOrderTraverse();
    	System.out.println(t+" "+t.isEmpty());
    	while(!t.isEmpty()) {
    		System.out.println("rooot: "+t.rootValue());
    		t.delete(t.rootValue());

    		System.out.println(t);
        	t.inOrderTraverse();
    		
    	}
	}*/
} 
