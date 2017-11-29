package list;


/**
 * Iterate through a LinkedList
 * @author Jill
 *
 * @param <E>
 */
public class RefIterator<E> implements Iterator<E> {

	LinkedList<E> list;
	Node<E> cursor;		//ref to last item obtained
	
	
	RefIterator(LinkedList<E> list){
		this.list = list;
		cursor = list.head;
	}
	
	@Override
	public boolean hasNext() {
		return cursor.next != list.tail && cursor.next != null;
	}
	
	@Override
	public E next(){
		cursor = cursor.next;
		E temp = cursor.value;
		return temp;
	}

	@Override
	public void remove() {
		cursor.prev.next = cursor.next;
		cursor.next.prev = cursor.prev;
		cursor = cursor.prev;
		list.size--;
	}



}
