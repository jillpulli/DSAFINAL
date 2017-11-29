package list;

/**
 * Store a value and a reference to the next 
 *  AND previous nodes
 * @author Jill
 *
 */

class Node<E> {
	
	E value;
	Node<E> next, prev;
	
	Node(E v, Node<E> n, Node<E> p) {
		value = v;
		next = n;
		prev = p;
	}

}
