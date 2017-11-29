package list;

/**
 * A list using references.
 * 
 * Doubly Linked List
 * 
 * With each item, store not only its value,
 * but also a ref to the next and previous item.
 * @author Jill Pulicicchio
 * @version 09.27.16
 *
 */
public class LinkedList<E> implements List<E> {
	
	int size;
	Node<E> head = new Node<E> (null, null, null);
	Node<E> tail = new Node<E> (null, null, null);
	private Node<E> ref;
	
	/**
	 *  must have dummy head reference to tail 
	 */
	public LinkedList() {
		head.next = tail;
		tail.prev = head;
	}
	
	
	public LinkedList(List<E> copy){
		head.next = tail;
		tail.prev = head;
        Iterator <E> itty = copy.iterator();
        while (itty.hasNext()){
        	add(itty.next());
        }
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	
	/**
	 *  set head and tail to dummy,
	 *  make size 0.
	 */
	@Override
	public void clear() {
		head.next = tail;
		tail.prev = head;
		ref = null;
		size = 0;
	}

	@Override
	public void add(E value) {
		Node <E> temp = new Node<E> (value, tail, tail.prev);
		tail.prev.next = temp;
		tail.prev = temp;
		size++;
	}
	
	private void setRef(int ndx) {
		//Post: ref refers to the node at given ndx
		ref = head.next;
		for (int i=0; i < ndx; i++) {
			ref = ref.next;
		}
	}

	@Override
	public void add(int ndx, E value) {
		if (ndx == size) {
			add(value);
		}
		else {
			setRef(ndx);
			Node <E> temp = new Node<E>(value, ref, ref.prev);
			ref.prev = temp;
			temp.prev.next = temp;
			size++;
		}
		
	}

	@Override
	public E get(int ndx) {
		setRef(ndx);
		return ref.value;
	}

	@Override
	public E set(int ndx, E value) {
		setRef(ndx);
		E result = ref.value;
		ref.value = value;
		return result;
	}

	@Override
	public E remove(int ndx) {
		setRef(ndx);
		ref.next.prev = ref.prev;
		ref.prev.next = ref.next;
		size--;
		return ref.value;
	}
	
	void print(List<String>names) {
		for (int i = 0; i < names.size(); i++){
			System.out.println(names.get(i));
		}
	}
 
	/**
	 *  @return the position of the first occurrence of the given Object, 
	 *  or -1 if not found
	 */
	@Override
	public int indexOf(Object obj) {
		ref = head.next;
		for (int i = 0; i < size; i++) {
			if(obj.equals(ref.value)){
				return i;
			}
			ref = ref.next;
		}
		
		return -1;
	}

	
	
	@Override
	public boolean contains(Object obj) {
		return indexOf(obj) >= 0;
	}

	@Override
	public boolean remove(Object obj) {
		int ndx = indexOf(obj);
		if (ndx != -1) {
			remove(ndx);
			return true;
		}
		return false;
		
	}
	
	public void swap(int i, int j)
	   {
		E temp = get(i);
	    this.set(i, get(j));
	    this.set(j, temp);
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
	
	/**
	 * @return true only if this List is equal to the parameter.
	 * 
	 * Note that a LinkedList can be equal to an ArrayList
	 * 
	 * Hint: Check to see whether other is a List, 
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
		
		for (int i = 0; i <this.size; i++){
			if (!(this.get(i).equals(local.get(i)))) {
						return false;
			}
		}
		return true;
	}

	public Iterator<E> iterator() {
		return new RefIterator<E>(this);
	}
	
	@Override
	public ListIterator<E> listIterator() {
		return new RefListIterator<E>(this);
	}

	@Override
	public ListIterator<E> listIterator(int start) {
		return new RefListIterator<E>(this, start);
	}

	@Override
	public boolean containsNull() {
		for (int i = 1; i < size-1; i++) {
			if (this.get(i) == null) {
				return true;
			}
		}
		return false;
	}


}
;