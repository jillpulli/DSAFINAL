package queue;

import list.*;

/**
 * Queue in which value have priority
 * @author Jill
 *
 * @param <E>
 */
public class PriorityQueue<E extends Comparable<E>> implements QueueADT<E> {
	
	List<E> list = new ArrayList<E>();
	

	/**
	 * Remove value with highest priority
	 * @return the value removed
	 */
	@Override
	public E remove() {
		E result = list.get(0);
		int avail = 0;		//available
		int bc = biggerChild(0);
		int last = list.size()-1;
		while((2*avail+1 < last) && greater(bc, last)){
			list.set(avail, list.get(bc));
			avail = bc;
			bc = biggerChild(avail);
		}
		list.set(avail, list.get(last));
		list.remove(last);
		return result;
	}
	
	/**
	 * Add the given value to this priority queue
	 */
	@Override
	public void add(E value) {
		list.add(value);
		int added = list.size()-1;
		int parent = (added-1) / 2;
		while(added > 0 && greater(added, parent)) {
			swap(added, parent);
			added = parent;
			parent = (added-1) / 2;
		}
	}
	
	/**
	 * @return position of biggerChild of given position
	 */
	private int biggerChild(int parent) {
		int left = 2*parent +1;
		int right = left+1;
		if (right >= list.size()) {
			return left;
		}
		if (greater(right, left)) {
			return right;
		}
		return left;
	}
	
	/**
	 * @return true if value at pos x > value at pos y
	 */
	private boolean greater(int x, int y) {
		return list.get(x).compareTo(list.get(y)) > 0;
	}
	
	private void swap(int p1, int p2)
    {
        list.swap(p1,p2);
    }

	@Override
	public E peek() {
		return list.get(0);
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void clear() {
		list.clear();
	}
	
	public Iterator<E> iterator() {
		return list.iterator();
	}

	public String toString(){
		return list.toString();
	}
}
