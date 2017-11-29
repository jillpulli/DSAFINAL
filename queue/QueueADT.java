package queue;

/**
 * A first-in first-out list
 * @author Jill
 * @version (10.03.2016)
 * @param <E>
 */
public interface QueueADT<E> {

	/**
	 * add a value at the back of this Queue.
	 */
	void add(E value);
	
	/**
	 * Remove the value from the front of this queue.
	 * @return the value removed.
	 * pre: this Q is not empty.
	 */
	E remove();
	
	/**
	 *  @return the value at the front of this Q, or null if this Q is empty.
	 */
	E peek();
	
	public int size();
	
	boolean isEmpty();
	
	void clear();
	
	String toString();
}
