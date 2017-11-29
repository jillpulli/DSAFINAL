package stack;
import list.*;

/**
 * An implementation of StackADT using a List
 * @author Jill
 *
 * @version (09.26.16)
 */

public class Stack<E> implements StackADT<E>{

	List<E> values = new LinkedList<E>();
	
	public Stack() {}
	
	public Stack(boolean arrayBased) {
		if (arrayBased) {
			values = new ArrayList<E>();
		}
	}
	
	public E push(E value) {
		values.add(value);
		return value;
	}

	@Override
	public E pop() {
		E result = values.get(values.size()-1);
		values.remove(values.size()-1);
		return result;
	}

	@Override
	public E peek() {
		return values.get(values.size()-1);
	}

	@Override
	public void clear() {
		values.clear();
	}

	@Override
	public boolean isEmpty() {
		return values.size() == 0;
	}
	
	public String toString() {
		String result = "";
		if(isEmpty()){
			return "[]";
		}
		for(int i = 0; i < values.size(); i++){
			result += values.get(i);
			if (i != values.size()-1) {
				result += ",";
			}
		}
		return "[" + result + "]";
	}
	
	public boolean equals(Object other) {
		if (other instanceof Stack) {
			Stack local = (Stack) other;
			return values.equals(local.values);
		}
		return false;
	}
	
}
