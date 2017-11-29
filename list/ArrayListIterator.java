package list;

/**
 * A ListIterator for ArrayList
 * @author Jill
 * @version 09.26.16
 */
public class ArrayListIterator<E> extends ArrayIterator<E> implements ListIterator<E> {

	private boolean forward = true;
	
	ArrayListIterator(List<E> list) {
		super(list);
		cursor = 0;
	}

	ArrayListIterator(List<E>list, int start) {
		super(list);
		cursor = start;
	}
	
	public boolean hasNext() {
		return cursor < list.size();
	}
	
	public E next() {
		forward = true;
		cursor ++;
		return list.get(cursor-1);
	}
	
	@Override
	public boolean hasPrevious() {
		return cursor > 0;
	}

	@Override
	public E previous() {
		forward = false;
		cursor --;
		return list.get(cursor);
	}
	
	public void remove() {
		if (forward) {
			cursor --;
		}
		list.remove(cursor);
	}

	
	/**
	 * insert given value just prior to the implicit cursor position.
	 */
	@Override
	public void add(E value) {
		list.add(cursor, value);
		cursor ++;
	}

	
}
