
package tree;
import list.Iterator;
import queue.*;

public class TreeIterator<E> implements Iterator<E> {

	BT<E> tree;
	QueueADT<E> queue = new Queue<E>();
	
	E lastGotten;
	
	public TreeIterator(BT<E>tree) {
		this.tree = tree;
		buildQ(tree);
	}
	
	//Add all the values in the family of tree to the queue, inOrder
	private void buildQ(BT<E> tree) {
		if (tree.isEmpty()) {
			return;
		}
		buildQ(tree.getLeft());
		queue.add(tree.getValue());
		buildQ(tree.getRight());
	}
	
	/*
	// Add all the values in the family of tree to the queue, postOrder
	private void buildQ(BT<E> tree) {
		if (tree.isEmpty()){
			return;
		}
		buildQ(tree.getLeft());
		buildQ(tree.getRight());
		queue.add(tree.getValue());
	}
	*/
	
	public boolean hasNext(){
		return !queue.isEmpty();
	}
	
	public E next() {
		lastGotten = queue.remove();
		return lastGotten;
	}
	
	/**
	 * Remove last value obtained by next, from the tree
	 */
	public void remove() {
		tree = tree.remove(lastGotten);
	}

	public E getLastGotten(){
		return lastGotten;
	}
	
	
}
