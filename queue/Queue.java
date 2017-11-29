package queue;
import list.*;

/**
 *  Uses linked list
 * @author Jill
 *
 * @param <E>
 */
public class Queue<E> implements QueueADT<E>{

	List<E> values = new LinkedList<E>();
	
	@Override
	public void add(E value) {
		values.add(value);
	}

	@Override
	public E remove() {
		return values.remove(0);
	}

	@Override
	public E peek() {
		if (values.isEmpty()){
			return null;
		}
		return values.get(0);
	}

	@Override
	public int size() {
		return values.size();
	}

	@Override
	public boolean isEmpty() {
		return values.size() == 0;
	}

	@Override
	public void clear() {
		values.clear();
	}
	
	public String toString() {

		if (isEmpty()){
			return "[]";
		}
		
		String result = "";
		for (int i = 0; i < values.size(); i++){
			if (i != values.size()-1){
				result = result + values.get(i) + ",";
			}
			else {
				result = result + values.get(i);
			}
		}
		return "[" + result + "]";
	}

	
}
