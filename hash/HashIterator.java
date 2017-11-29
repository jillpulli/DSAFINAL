package hash;
import list.*;

class HashIterator<K> implements Iterator {
	
	HashTable<K> table;
	
	//For a LinkedList:
	Iterator<K> itty;
	
	//which LinkedList:
	int ndx;

	HashIterator(HashTable<K> table) {
		this.table = table;
		itty = table.lists.get(0).iterator();
	}
	
	public boolean hasNext(){
		if (itty.hasNext())
			return true;
		for (ndx++; ndx < table.lists.size(); ndx++) {
			if (!(table.lists.get(ndx).isEmpty())){
				setItty(ndx);
				return true;
			}
		}
		return false;
	}
	
	private void setItty(int ndx) {
		itty = table.lists.get(ndx).iterator();
	}
	
	public K next() {
		hasNext();
		return itty.next();
	}
	
	public void remove() {
		itty.remove();
		table.keyCount--;
	}
}
