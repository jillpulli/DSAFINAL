package sort;
import list.*;

/**
 * Binary search of a sorted ArrayList
 * @author Jill
 *
 */
public class BinarySearch<E extends Comparable> {
	List<E> list;
	E target;
	
	public BinarySearch(List<E> list) {
		this.list = list;
	}
	
	/**
	 * @return position of target in list, 
	 * or -1 if not found
	 */
	public int search(E target) {
		this.target = target;
		//return binSrch(0, list.size()-1);
		
		
		int lo = 0;
		int hi = list.size()-1;
		
		while (lo<=hi) {
			int mid = (hi+lo) / 2;		//find midpoint of list
			
			int cmp = list.get(mid).compareTo(target);
			
			if (cmp==0) {				
				return mid;				//if value at mid is target, done
			}
			else if (cmp <0) {
				lo = mid+1;				//if target is < value at mid, search right
			}
			else {						//search left side
				hi = mid-1;
			}
		}
		return -1;
	}
	
	private int binSrch(int lo, int hi) {
		if (lo>hi) {
			return -1;	//target not found
		}
		int mid = (hi+lo) / 2;
		int cmp = list.get(mid).compareTo(target);
		if (cmp==0) {
			return mid;
		}
		if (cmp <0) {
			return binSrch(mid+1, hi);
		}
		return binSrch(lo, mid-1);
	}
	
	
	
}
