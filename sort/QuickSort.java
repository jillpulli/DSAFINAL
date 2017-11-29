package sort;
import list.*;

/**
 * Quickort algorithm List should be an ArrayList
 * @author Jill
 *
 * @param <E>
 */
public class QuickSort <E extends Comparable> implements Sorter<E>{

		List<E> list;
		public void sort(List<E> list) {
			this.list = list;
			qSort(0, list.size()-1);
		}
		
		private void qSort(int start, int end) {
			if (end-start <1) {
				return;
			}
			int p = partition(start, end);
			qSort(start, p-1);		//left side
			qSort(p+1, end);		//right side
		}
		
		/**
		 * partition the part of the list from start ... end
		 * so that values smaller than pivot are to the left,
		 * others to the right.
		 * @return position of the pivot value
		 */
		private int partition(int start, int end) {
			int p = start;
			E pivotValue = list.get(start);
			for (int i =start+1; i < end; i++) {
				if (list.get(i).compareTo(pivotValue) < 0) {
					list.set(p,  list.get(i));
					p++;
					list.set(i,  list.get(p));
				}
				
			}
			list.set(p, pivotValue);
			return p;
		}
		
		
}
