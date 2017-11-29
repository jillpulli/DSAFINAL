package list;

/** 
 * permit the client acces to items in a collection,
 * one at a time
 * @author Jill
 *
 * @param <E>
 */
public interface Iterator<E> {
	
	/** 
	 *  @return true if there is a next item.
	 */
	boolean hasNext();
	
	/**
	 *  @return the next item.
	 *  pre: hasNext() is true
	 */
	E next();
	
	/**
	 * remove the lat item obtained
	 * pre: may only be called after a call to next()
	 */
	void remove();

	

}
