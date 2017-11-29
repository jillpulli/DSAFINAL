package tree;
import list.Iterator;

/**
 * An Iterator for Empty Trees
 * @author Jill
 * @version (October 21 2016)
 *
 * @param <E>
 */
public class EmptyIterator<E> implements Iterator<E> {

	public boolean hasNext() {
		return false;
	}
	
	public E next(){
		return null;
	}
	
	public void remove() {}
	
}
