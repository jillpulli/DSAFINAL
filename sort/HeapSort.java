package sort;
import list.*;

/**
 * HeapSort of a List Ascending. 
 * Should be an ArrayList.
 * @author Jill
 * @version (04 Nov 2016)
 *
 */
public class HeapSort <E extends Comparable> implements Sorter<E> {
	List<E> list;
	
	public void sort(List<E> list) {
		this.list = list;
		heapify(0);
		System.out.println(list);
		/*
		int last = list.size()-1;
		while (last >0) {
			swap(0, last);
			last--;
			percDown(0, last);
		}
		*/
	}
	
	private void heapify(int root){
		int max = list.size()-1;
		if ((2*root +1) > max) {
			return;
		}
		heapify(2*root+1);
		heapify(2*root+2);
		percDown(root,max);
	}
	
	private void percDown(int root, int max) {
		int bc = biggerChildPos(root, max);
		while (((2* root +1) <= max) && greater(bc, root)) {
			swap(root, bc);
			root = bc;
			bc = biggerChildPos(root, max);
		}
	}
	
	
	/**
	 * @return true if value at pos i > value at pos j
	 */
	private boolean greater(int i, int j) {
		return list.get(i).compareTo(list.get(j)) > 0;
	}
	
	
	/**
	 * @return the position of the bigger child of root,
	 * Don't go beyond max
	 */
	private int biggerChildPos(int root, int max) {
		int left = 2*root+1;
		int right = 2*root +2;
		if (right > max) {
			return left;
		}
		if (greater(right, left)) {
			return right;
		}
		return left;
	}
	
	
	public void swap(int i, int j) {
		list.swap(i, j);
	}
	
	

}
