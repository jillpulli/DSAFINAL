package set;
import list.Iterator;

/**
 * A collection with no duplicates, no order required
 * @author Jill
 * @versio (14 Nov 2016)
 *
 */
public interface Set<E> {

	/**
	 * Add the given value to this set.
	 * @return true if the value was added
	 */
	boolean add(E value);
	
	/**
	 * @return true if given obj is in this Set
	 */
	boolean contains(Object obj);
	
	/**
	 * Remove the given obj from this set if possible.
	 * @return true if it was removed
	 */
	boolean remove(Object obj);
	
	/**
	 * @return an Iterator for this set.
	 */
	Iterator<E> iterator();
	
	/** @return the number of values in this Set */
	int size();

	/** @return true if this Set is empty  */
	boolean isEmpty();

	/** Make this Set an empty Set */
	void clear();
	
	/** @return the elements of this Set as a String */ 
	String toString(); 
	 
	/** @return true if obj is a Set and all the values in this Set are in the other Set, 
	       and all the values in the other Set are in this Set */ 
	boolean equals (Object obj); 
	
}
