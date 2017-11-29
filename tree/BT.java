package tree;

import list.Iterator;

/**
 * A Binary Tree has a value and at most two children.
 * A BT may be empty
 * @author Jill
 * @version (31 October 2016)
 *
 * @param <E>
 */
public interface BT<E> {
	
	/**
	 * @return the value of this BT, or null if it is empty
	 */
	E getValue();
	
	/**
	 * @return the left child of the BT, or null if empty
	 */
	BT<E> getLeft();
	
	/**
	 * @return the right child of this BT, or null if empty
	 */
	BT<E> getRight();
	
	/**
	 * Add the given value to this BT.
	 * @return the updated tree.
	 */
	BT<E> add(E value);
	
	/**
	 * @return true if given value is in the family of this BT
	 */
	boolean containsKey(E value);
	
	/**
	 * @return the given value from this BT, or null if not found
	 */
	E get(E value);		//search family
	
	/**
	 * Remove BT having the given value from family of this BT, if possible
	 * @return updated tree.
	 */
	BT<E> remove(Object obj);
	
	/** 
	 * @return true if this BinaryTree is empty 
	 */
	boolean isEmpty();
	
	/**  
	 * Change the value of this BinaryTree to the given value 
	 */
	void setValue (E value);

	/** 
	 * Change the left child of this BinaryTree to the given BinaryTree 
	 */
	void setLeft (BT<E> left);

	/** 
	 * Change the right child of this BinaryTree to the given BinaryTree 
	 */
	void setRight (BT<E> right);
	
	/**
	 * @return true only if this BinaryTree is equal to the given obj
	 */
	boolean equals(Object obj);
	
	/**
	 * @return an Iterator which traverses this BT inOrder
	 */
	Iterator<E> iterator();
	
	public String toString();
	
}
