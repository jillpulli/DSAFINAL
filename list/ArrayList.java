package list;

import sort.Student;

/**
 *  An implementation of List, which stores values in an array
 * @author Jill Pulicicchio
 * @param <E>
 * @version 09.27.16
 */
public class ArrayList<E> implements List<E> {
	
	int size = 0;
	E[] values;		//array of E
	
	public ArrayList(int cap) {
		values = (E[]) new Object[cap];
	}
	
	public ArrayList() {
		this(10);	//calls other constructor
	}
	
	public ArrayList(List copy) {
		values = (E[]) new Object[10];
		this.addAll(copy);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		for(int i = 0; i < size; i++) {
			values[i] = null;
		}
		size = 0;
	}

	@Override
	public void add(E value) {
		add(size, value);		//eliminates duplicate code
	}

	@Override
	public void add(int ndx, E value) {
		if (size == values.length) {
			alloc(); 		
		}
		for(int i = size; i > ndx; i--)	{	//move each value to right
			values[i] = values[i-1];
		}
		values[ndx] = value;
		size++;
		
		
	}

	@Override
	public E get(int ndx) {
		return values[ndx];
	}

	@Override
	public E set(int ndx, E value) {
		E result = values[ndx];
		values[ndx] = value;
		return result;
	}

	@Override
	public E remove(int ndx) {
		E result = values[ndx];
		for(int i = ndx; i < size-1; i++) {
			values[i] = values[i + 1];
		}
		size--;
		return result;
	}
	
	/**
	 * if not enough room, 
	 * make new & bigger array and copy old one into it
	 */
	private void alloc() {
		E[] temp = (E[]) new Object[2*values.length];
		for (int i = 0; i < values.length; i++) {
			temp[i] = values[i];
		}
		values = temp;
		
	}

	
	/**
	 *  @return the position of the first occurrence of the given Object, 
	 *  or -1 if not found
	 */
	@Override
	public int indexOf(Object obj) {
		for (int i = 0; i < size; i++) {
			if (obj.equals(values[i])){		
				return i;					
			}
		}
		return -1;
	}

	
	/**
	 * @return true only if the given object is contained in this list.
	 */
	@Override
	public boolean contains(Object obj) {
		return indexOf(obj)>=0;
	}
	

	/**
	 * Remove the first occurrence of the given object from this List, if possible.
	 * @return true only if it was removed.
	 */
	@Override
	public boolean remove(Object obj) {
		int ndx = indexOf(obj);
		if (ndx != -1) {
			remove(ndx);
			return true;
		}
		return false;
	}
	
	
	/**
	 *  @return the elements of this List as a String, 
	 *  with the elements separated by commas,
	 *  and enclosed in square brackets.
	 */
	public String toString() {
		String result = "";
		if (isEmpty()) {
			return "[]";
		}
		for (int i = 0; i < size; i++) {
			if (i != size-1){
				result = result + this.get(i) + ",";
			}
			else {
				result = result + this.get(i);
			}
			
		}
		return "[" + result + "]";
		
	}
	

	/**
	 *  @return true only if this List is equal to the parameter, other.
	 *  
	 *  Note: ArrayList and LinkedList can equal each other.
	 *   
	 *  Hint: Check to see whether other is a List, 
	 *  using the instanceof operator. If so, cast it to a local variable 
	 *  as a List. Then compare the sizes of the two lists; 
	 *  if the sizes are equal, compare each element of this List with
	 *  the corresponding element of other.
	 */
	@Override
	public boolean equals(Object other) {
		
		if (!(other instanceof List)){
			return false;
		}
		
		List local = (List) other;
		if (this.size != local.size()) {		//if this list = other list
			return false;
		}
		
		for (int i = 0; i < size; i++){
			if (!(this.get(i).equals(local.get(i)))) {
						return false;
			}
		}
		return true;
	}
	

	
	/**
	 * Add all elements of other to the end of this List
	 */
	@Override
	public void addAll(List other) {
		
		Iterator<List> itty = other.iterator();
		while (itty.hasNext()) {
			E l = (E) itty.next();
			this.add((E) l);
		}
	}
	
	public void swap(int i, int j)
    {
        E temp = values[i];
        this.set(i, values[j]);
        this.set(j, temp);
    }
	
	public Iterator<E> iterator() {
		return new ArrayIterator<E>(this);
	}
	
	public ListIterator<E> listIterator() {
		return new ArrayListIterator<E>(this);
	}
	
	public ListIterator<E> listIterator(int start) {
		return new ArrayListIterator<E>(this, start);
	}

	@Override
	public boolean containsNull() {
		for (int i = 0; i < size; i++) {
			if (this.get(i) == null) {
				return true;
			}
		}
		return false;
	}
	

	
}
