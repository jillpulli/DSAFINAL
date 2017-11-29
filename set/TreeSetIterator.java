package set;

import tree.TreeIterator;

/**
 * An Iterator for TreeSets
 * @author Jill
 * @version (14 Nov 2016)
 *
 */
public class TreeSetIterator<E extends Comparable> extends TreeIterator<E> {

	TreeSet<E> set;
	
	TreeSetIterator(TreeSet<E> set){
		super(set.tree);
		this.set = set;
	}
	
	public void remove() {
		set.tree = set.tree.remove(getLastGotten());
		set.size--;
	}
	
}
