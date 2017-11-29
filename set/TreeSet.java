package set;
import list.*;
import tree.*;

/**
 * An implementation of set using BT
 * @author Jill
 * @version (21 Nov 2016)
 *
 */
public class TreeSet<E extends Comparable> implements Set<E> {
	BT<E> tree = new EBST();
	int size = 0;
	
	public boolean add(E value) {
		if (tree.containsKey(value)){
			return false;
		}
		tree = tree.add(value);
		size++;
		return true;
	}
	
	public boolean contains(Object obj){
		E value;
		try { value = (E) obj;
			return tree.containsKey(value);
		}
		catch (ClassCastException cce) {
			return false;
		}
	}
	
	public boolean remove(Object obj) {
		if (!contains(obj)) {
			return false;
		}
		tree = tree.remove(obj);
		size--;
		return true;
	}
	
	public Iterator<E> iterator() {
		if (size == 0) {
			return new EmptyIterator();
		}
		return new TreeSetIterator(this);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return tree.isEmpty();
	}

	@Override
	public void clear() {
		tree = new EBST<E>();
		size = 0;
	}
	
	/** @return the elements of this Set as a String */ 
	public String toString() {
		String s = "[";
        String treeString = tree.toString();
        s+= treeString.substring(1,treeString.length()-1);
        return s + "]";
	}
	
	/** @return true if obj is a Set and all the values in this Set are in the other Set, 
    		and all the values in the other Set are in this Set */ 
	public boolean equals (Object obj) {
		if(!(obj instanceof Set))
            return false;
		
        Set other = (Set) obj;
        
        if(other.size()!=size)
            return false;
        
        Iterator itty = this.iterator();
        
        while(itty.hasNext())
        {
            if(!(other.contains(itty.next())))
                return false;
        }
        return true;
	}

}
