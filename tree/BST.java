package tree;
import list.*;
import list.Iterator;

/**
 * A Binary Search Tree which is not empty.
 * @author Jill
 * @version (31 October 2016)
 *
 */
public class BST<E extends Comparable> implements BT<E> {

	E value;
	BT<E> left = new EBST<E>();
	BT<E> right = new EBST<E>();
	
	public BST(E value) {
		this.value = value;
	}
	
	public E getValue() {
		return value;
	}
	
	public BT<E> getLeft() {
		return left;
	}
	
	public BT<E> getRight() {
		return right;
	}
	
	public BT<E> add(E value) {
		int cmp = value.compareTo(this.value);
		if (cmp < 0) {
			left = left.add(value);
		}
		if (cmp > 0) {
			right = right.add(value);
		}
		return this;
	}
	
	public boolean containsKey(E value) {
		
		BST<E> temp = this;
		int cmp = value.compareTo(temp.value);
		while (!(temp.isEmpty())) {
			if (cmp == 0){
				return true;
			}
			if (cmp < 0) {
				if (temp.left.isEmpty()) {
					return false;
				}
				temp = (BST<E>) temp.left;
				cmp = value.compareTo(temp.value);
			}
			if (cmp > 0) {
				if (temp.right.isEmpty()) {
					return false;
				}
				temp = (BST<E>) temp.right;
				cmp = value.compareTo(temp.value);
			}
		}
		return false;
		
		/*
		int cmp = value.compareTo(this.value);
		if (cmp < 0) {
			return left.containsKey(value);
		}
		if (cmp > 0) {
			return right.containsKey(value);
		}
		return true;
		*/
	
	}
	
	public E get(E value) {
		int cmp = value.compareTo(this.value);
		if (cmp < 0) {
			return left.get(value);
		}
		if (cmp > 0) {
			return right.get(value);
		}
		return this.value;
	}
	
	public BT<E> remove(Object obj) {
		try {
			
			E value = (E) obj;
			int cmp = value.compareTo(this.value);
			if (cmp == 0) {
				List <BT<E>> kids = children();
				if (kids.size() == 0) {
					return new EBST<E>();
				}
				if (kids.size()==1) {
					return kids.get(0);
				}
				//two children
				BT<E> successor = ((BST<E>) right).smallest();
				BT<E> result = remove(successor.getValue());
				result.setValue(successor.getValue());
				return result;		
			}
			if (cmp < 0) {
				left = left.remove(value);
			}
			if (cmp > 0) {
				right = right.remove(value);
			}
		}	//end try
		catch (ClassCastException cce) {}
		return this;
	}
	
	/**
	 * @return a list of all children of this BST
	 */
	private List<BT<E>> children() {
		List <BT<E>> result = new ArrayList<BT<E>>();
		if (!left.isEmpty()) {
			result.add(left);
		}
		if (!right.isEmpty()) {
			result.add(right);
		}
		return result;
	}
	
	/**
	 * @return the BT with smallest value in the family of this BT
	 */
	private BT<E> smallest() {
		if (left.isEmpty()) {
			return this;
		}
		return ((BST<E>)left).smallest();
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public void setValue(E value) {
		this.value = value;
	}

	@Override
	public void setLeft(BT<E> left) {
		this.left = left;
	}

	@Override
	public void setRight(BT<E> right) {
		this.right = right;
	}
	
	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof BST)) {
			return false;
		}
		BST<E> temp = (BST<E>) obj;
		if (temp.isEmpty()) {
			return false;
		}
		if (!(value.equals(temp.value))) {
			return false;
		}
		if (!(left.equals(temp.left))){
			return false;
		}
		if (!(right.equals(temp.right))){
			return false;
		}
		return true;
	}

	@Override
	public Iterator<E> iterator() {
		return new TreeIterator<E>(this);
	}
	
	public String toString() {
		String result = "[";
		Iterator<E> itty = iterator();
		while (itty.hasNext()) {
			result += itty.next();
			if (itty.hasNext()) {
				result += ",";
			}
		}
		result += "]";
		return result;
		
	}
	
	
}
