package sort;
import list.*;

/**
 * Bubble sort O(n^2) on any kind of List
 * @author Jill
 *
 * @param <E>
 */
public class BubbleSortLinked <E extends Comparable> 
									implements Sorter<E>
{
	List<E> list;
	
	public void sort(List<E> list) {
		
		this.list = list;
		E left, right; 		//neighbors
		
		ListIterator<E> itty;
		for (int i=0; i <list.size()-1; i++){
			itty = list.listIterator();
			left = itty.next();
			right = itty.next();
			for (int j=0; j < list.size()-i-1; j++) {
				if (left.compareTo(right) <= 0) {
					left = right;
				}
				else {
					itty.remove();
					itty.previous();
					itty.add(right);;
					itty.next();
				}
				right = itty.next();
			}
		}
	}
	
	
}
