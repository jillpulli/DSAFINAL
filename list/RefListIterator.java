package list;

/**
 *  A ListIterator for LinkedLists
 * @author Jill
 *
 * @param <E>
 */
public class RefListIterator<E> extends RefIterator<E> implements ListIterator<E>{
	
	//cursor is a reference to the 
	//node last returned by next() or previous()
	private boolean forward = true;
	
	RefListIterator(LinkedList<E> list) {
		super(list);
	}

	RefListIterator(LinkedList<E> list, int start) {
		super(list);
		for (int i = 0; i < start; i++) {
			cursor = cursor.next;
		}
	}
	
	public boolean hasNext() {
		if (list.isEmpty()){
			return false;
		}
		if (forward) {
			return cursor.next != list.tail;
		}
		return true;
	}
	
	public E next() {
		if (forward){
			cursor = cursor.next;
		}
		forward = true;
		return cursor.value;
	}
	
	@Override
	public boolean hasPrevious() {
		if (list.isEmpty()) {
			return false;
		}
		if (!forward) {
			return cursor.prev != list.head;
		}
		return cursor != list.head;
	}

	@Override
	public E previous() {
		if (!forward) {
			cursor = cursor.prev;
		}
		forward = false;
		return cursor.value;
	}
	
	public void remove() {
		super.remove();
		if (!forward) {
			cursor = cursor.next;
		}
	}

	
	/**
	 * insert the given value just prior to the implicit cursor position
	 */
	@Override
	public void add(E value) {
		
			Node<E> temp;
			
			if (forward) {
				temp = new Node<E>(value, cursor.next, cursor);
				cursor.next.prev = temp;
				cursor.next = temp;
				cursor = temp;

			}
			else {
				temp = new Node<E>(value, cursor, cursor.prev);
				cursor.prev.next = temp;
				cursor.prev = temp;

			}
		list.size++;
		
	}

}
