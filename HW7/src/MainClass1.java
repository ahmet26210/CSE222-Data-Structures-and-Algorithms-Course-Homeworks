package linkedlist;

public class MainClass1 {
	public static void main(String[] args) {
		//PART 1
		System.out.println("//SKIPLIST\\");
		try {
			NavigableSetSkipListClass<Integer> skipList = new NavigableSetSkipListClass<>();
			for (int i = 0; i < 20; i++) {
				int randNum=(int)(Math.random()* 1000);
				skipList.insert(randNum);
			}
			skipList.insert(1005);
			skipList.insert(5);
			/*Before delete*/
			System.out.println("Before Delete");
			System.out.println(skipList);
			skipList.delete(5);
			skipList.delete(1005);
			/*After delete*/
			System.out.println("After Delete");
			System.out.println(skipList);
			/*Descending iterator*/
			System.out.println("Descending Iterator");
			Iterator<Integer> it=skipList.descendingIterator();
			while (it.hasNext()) {
				Integer integer = (Integer) it.next();
				System.out.print(integer+" --> ");
			}
			System.out.println();
			System.out.println("//AVLTree\\");
			NavigableSetAvlTreeClass<Integer> AvlTree = new NavigableSetAvlTreeClass<>();
			
			for (int i = 0; i < 20; i++) {
				int randNum=(int)(Math.random()* 1000);
				AvlTree.insert(randNum);
			}
			AvlTree.insert(400);
			AvlTree.insert(250);
			AvlTree.print();
			
			/*iterator*/
			System.out.println("Iterator");
			Iterator<Integer> itAVL= AvlTree.iterator();
			while (itAVL.hasNext()) {
				Integer integer =itAVL.next();
				System.out.print(integer+" --> ");
			}
			System.out.println();
			/*headSet*/
			System.out.println("HeadSet");
			AVLTree<Integer> HeadSet=AvlTree.headSet(400);
			System.out.println(HeadSet);
			System.out.println();
			/*tailSet*/
			System.out.println("TailSet");
			AVLTree<Integer> tailSet=AvlTree.tailSet(250);
			System.out.println(tailSet);
			
			//PART 2
			
			BinarySearchTree<Integer> bstTree=new BinarySearchTree<>();
			for (int i = 1; i <= 100; i++) {
				bstTree.add(i);
			}
			AVLTree<Integer> avlTree=new AVLTree<>();
			for (int i = 1; i <= 100; i++) {
				avlTree.add(i);
			}
			RedBlackTree<Integer> rbtTree=new RedBlackTree<>();
			for (int i = 1; i <= 100; i++) {
				rbtTree.add(i);
			}
			
			CompareClassAVLorRBT avLorRBT=new CompareClassAVLorRBT<>();
			System.out.println("Avl Tree check (Tree is -> AVL) : "+avLorRBT.checkAvlTree(avlTree));
			System.out.println("RBT tree check (Tree is -> AVL) : "+ avLorRBT.checkAvlTree(rbtTree));
			System.out.println();
			
			System.out.println("RBT tree check (Tree is -> RBT) : "+ avLorRBT.checkRBTTree(rbtTree));
			System.out.println("AVL tree check (Tree is -> RBT) : "+avLorRBT.checkRBTTree(avlTree));
			
			TestClass aClass = new TestClass();
			
			aClass.StartTest();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
