package list;

/**
 *  Traverse a list in either direction
 * @author Jill
 * @version 09.26.16
 * 
 */
public interface ListIterator<E> extends Iterator<E>{

	/**
	 *  @return true if there is a previous value
	 */
	boolean hasPrevious();
	
	/**
	 *  @return the previous value.
	 *  pre: hasPrevious() is true;
	 */
	E previous();
	
	/**
	 * Remove last value obtained by a call to next() or previous().
	 * 
	 * May be called only once after each call to 
	 * next() or previous().
	 */
	void remove();
	
	/**
	 * Insert the given value just prior to the implicit cursor position.
	 */
	public void add(E value);
	
}
