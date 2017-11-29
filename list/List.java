package list;


/** A collection with ordered items
 * 
 *  @author Jill Pulicicchio
 */


public interface List<E> {
	
	/**
	 *  @return the size of this list
	 */
	public int size();
	
	/** 
	 *  return true only if the size is 0
	 */
	boolean isEmpty();
	
	/**
	 *  Make this list empty
	 */
	void clear();
	
	/** 
	 *  Add the given value at the end of this list
	 */
	void add(E value);
	
	/**
	 *  Insert given value at given index.
	 *  Precondition: ndx >= 0, ndx <= size
	 *  Client is responsible for preconditions  
	 */
	void add(int ndx, E value);
	
	/** 
	 *  @return the value of the given index
	 *  pre: ndx >= 0, ndx < size
	 */
	E get(int ndx);
	
	/** 
	 *  Puts given value at given ndx.
	 *  @return the odd value.
	 *  pre: ndx >= 0, ndx < size
	 */
	E set(int ndx, E value);
	
	/** 
	 *  Remove the value at given index.
	 *  @return the value removed
	 *  pre: ndx >= 0, ndx < size
	 */
	E remove(int ndx);
	
	/**
	 *  @return the position of the first occurrence of the given Object, 
	 *  or -1 if not found
	 */
	int indexOf(E obj);
	
	/**
	 *  @return true only if the given object is contained in this List
	 */
	boolean contains (Object obj);
	
	/**
	 * Remove the first occurrence of the given object from this List, if possible.
	 * @return true only if it was removed.
	 */
	boolean remove (Object obj);
	
	/**
	 * @return true if this List contains at least one null reference.
	 */
	boolean containsNull();
	
	/**
	 *  @return the elements of this List as a String, 
	 *  with elements separated by commas, enclosed in square brackets:
	 *  		[a,b,c]
	 */
	String toString();
	
	/**
	 *  @return true only if this List is equal to the parameter, other
	 */
	boolean equals(Object other);

	Iterator<E> iterator();
	
	/**
	 * Add all elements of other to the end of this List 
	 */
	void addAll(List other);
	
	/**
	 *  @return a ListIterator for this List which starts
	 *  at position 0.
	 */
	public ListIterator<E> listIterator();
	
	/**
	 * @return a ListerIterator for this List which starts
	 * at the given position
	 */
	public ListIterator<E> listIterator(int start);

	 void swap(int i, int j);

		
	
}
