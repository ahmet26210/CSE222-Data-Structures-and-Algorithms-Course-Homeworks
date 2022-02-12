package linkedlist;

import java.util.HashMap;

import linkedlist.BinaryTree.Node;


public class CompareClassAVLorRBT<E extends Comparable<E>> {
		public boolean checkAvlTree(BinarySearchTree<E> tree){
			return isBalanced(tree.root);
		}
	
		
		private boolean isBalanced(Node<E> root){
	        int lh; /* for height of left subtree */
	 
	        int rh; /* for height of right subtree */
	 
	        /* If tree is empty then return true */
	        if (root== null)
	            return true;
	 
	        /* Get the height of left and right sub trees */
	        lh = height(root.left);
	        rh = height(root.right);
	 
	        if (Math.abs(lh - rh) <= 1
	            && isBalanced(root.left)
	            && isBalanced(root.right))
	            return true;
	 
	        /* If we reach here then tree is not height-balanced */
	        return false;
	    }
	 
	    /* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */
	    /*  The function Compute the "height" of a tree. Height is the
	        number of nodes along the longest path from the root node
	        down to the farthest leaf node.*/
	    public int height(linkedlist.BinaryTree.Node<E> right){
	        /* base case tree is empty */
	        if (right == null)
	            return 0;
	 
	        /* If tree is not empty then height = 1 + max of left
	         height and right heights */
	        return 1 + Math.max(height(right.left), height(right.right));
	    }
	    
	    
	    public boolean checkRBTTree(BinarySearchTree<E> tree){
	    	
	    	if(tree==null) {
	    		return true;
	    	}
	    	if(tree.root!=null) {
		    	if(tree.root.isRed()) {
		    		return false;
		    	}
	    	}
	    	return helperfunction(tree.root);
	    	 	
		}
	    private boolean helperfunction(linkedlist.BinaryTree.Node<E> node) {
	    	if(node==null) {
	    		return true;
	    	}
	    	if(node.isRed()) {
	    		if(node.left!=null && node.right!=null) {
	    			if(node.left.isRed() || node.right.isRed()) {
		    			return false;
		    		}
	    		}
	    	}
	    	int a=BlackHeight(node);
	    	if(a==0) {
	    		return false;
	    	}
	    	return helperfunction(node.left) && helperfunction(node.right);
	    }
	    private int BlackHeight(linkedlist.BinaryTree.Node<E> root) {
	    	if (root == null) 
	    		return 1;

	        int leftBlackHeight = BlackHeight(root.left);
	        if (leftBlackHeight == 0)
	        	return leftBlackHeight;

	        int rightBlackHeight = BlackHeight(root.right);
	        if (rightBlackHeight == 0)
	        	return rightBlackHeight;

	        if (leftBlackHeight != rightBlackHeight)
	        	return 0;
	        else
	            return leftBlackHeight + (!root.isRed ? 1 : 0);
	    }
	    	
}
