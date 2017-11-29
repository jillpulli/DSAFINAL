package list;


/**
 *  Iterate through an ArrayList
 * @author Jill
 *
 * @param <E>
 */
class ArrayIterator<E> implements Iterator<E> {
	
	List<E> list;
	int cursor = -1; //indx of last item obtained
	
	ArrayIterator(List<E> list) {
		this.list = list;
	}
	
	public boolean hasNext() {
		if(cursor == list.size()-1) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public E next() {
		cursor ++;
		return list.get(cursor);
	}
	
	public void remove() {
		list.remove(cursor);
		cursor--;
	}

	
	
	
}
