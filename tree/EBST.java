package tree;

import list.Iterator;

/**
 * A BST which has no value, no children
 * @author Jill Pulicicchio
 * @version (31 October 2016)
 *
 */
public class EBST<E extends Comparable> implements BT<E> {
	
	public E getValue() {
		return null;
	}
	
	public BT<E> getLeft() {
		return null;
	}
	
	public BT<E> getRight() {
		return null;
	}
	
	public BT<E> add(E value) {
		return new BST<E> (value);
	}
	
	public boolean containsKey(E value) {
		return false;
	}
	
	public E get(E value) {
		return null;
	}

	@Override
	public BT<E> remove(Object obj) {
		return this;
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	public void setValue(E value) {
	}

	@Override
	public void setLeft(BT<E> left) {
	}

	@Override
	public void setRight(BT<E> right) {
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof EBST)
            return true;        
        return false;
	}

	@Override
	public Iterator<E> iterator() {
		return new EmptyIterator<E>();
	}
	
	public String toString() {
		return "[]";
	}

}
