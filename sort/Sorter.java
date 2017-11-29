package sort;
import list.*;

/**
 * sort a given list
 * 
 * @author Jill
 *
 * @param <E>
 */
public interface Sorter<E extends Comparable> {

	void sort(List<E> list);
	
}
