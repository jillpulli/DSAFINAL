package stack;

/**
 *  A Last-In First-Out list
 * @author Jill
 *
 * @version (09.26.16)
 */
public interface StackADT<E> {

	/**
	 * Add the given value to the top of this stack.
	 * @return value pushed.
	 */
	E push(E value);
	
	/**
	 * Remove the top element/value.
	 * @return the removed value.
	 */
	E pop();
	
	/**
	 * @return the top value from this stack
	 */
	E peek();
	
	/**
	 * clear this StackADT
	 */
	void clear();
	
	/**
	 * @return true only if this StackADT is empty
	 */
	boolean isEmpty();
	
	/** 
	 * @return true only if this Stack is equal to the parameter, other 
	 */
    boolean equals(Object other);
}
