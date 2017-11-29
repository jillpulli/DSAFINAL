package hash;
import list.*;

/**
 * An efficient data structure for quick access,
 * hashCode() and equals(Object) must agree
 * 
 * Rebuild hashtable if longest list is longer
 * 		than MAX
 * 
 * @author Jill
 * @version (7 Nov 2016) updated (12 Dec 2016)
 *
 * @param <K>
 */
public class HashTable<K> {
	
	List<List<K>> lists = new ArrayList<List<K>>();
	int keyCount = 0;
	
	boolean rehash = true;
	
	
	static final int MAX = 10;
	
	public HashTable(int capacity) {
		for (int i=0; i < capacity; i++) {
			lists.add(new LinkedList<K>());
		}
	}
	
	public HashTable() {
		//default capacity is 10
		this(10);
	}
	
	/**
	 * @return true only if obj is in this HashTable
	 */
	public boolean containsKey(Object obj) {
		//K key;
        //try{
           // key = (K) obj;
            int code = getCode(obj);
            return lists.get(code).contains(obj);
       // }
       // catch(ClassCastException cce)
       // {
       // 	return false;
       // }
	}

	/**
	 * Add the given key to this HashTable.
	 * Rebuild the table if the longest list
	 * exceeds MAX.
	 */
	public void put(K key) {
		int code = getCode(key);
		List<K> list = lists.get(code);
		lists.get(code).add(key);
		keyCount++;
		if (list.size() > MAX && rehash){
			rehash(); 	//rebuild table
			if (list.size() > MAX){
				rehash = false;
			}
		}
		
	}
	
	/**
	 * Rebuild the hash table,
	 * 	using an ArrayList.
	 * @param obj
	 * @return
	 */
	private void rehash(){
		List<List<K>> table = new ArrayList<List<K>>();
		for (int i=0; i < lists.size()*2; i++){
			table.add(new LinkedList<K>());
		}
		Iterator<K> itty = iterator();
		while (itty.hasNext()){
			K key = itty.next();
			int code = Math.abs(key.hashCode());
			code = code % table.size();
			List<K> list = table.get(code);
			list.add(key);
		}
		lists = table;
	}
	
	//return an ndx to lists
	private int getCode(Object obj) {
		int code = obj.hashCode();
		code = Math.abs(code);
		return code % lists.size();
	}
	
	/**
	 * @return the given key,
	 * or null if not found
	 */
	public K get(K key) {
		int code = getCode(key);
		List<K> list = lists.get(code);
		int ndx = list.indexOf(key);
		if (ndx < 0) {
			return null;
		}
		return list.get(ndx);
	}
	
	/**
	 * Remove given obj from this HashTable, if possible
	 * @return true if it was removed
	 */
	public boolean remove(Object obj)  {
		if(!containsKey(obj))
            return false;
		K key = (K) obj;
        List <K> list = lists.get(getCode(key));
        list.remove(key);
        keyCount--;
        return true;
	}
	
	public Iterator<K> iterator() {
		return new HashIterator<K>(this);
	}
	
	/** @return the number of keys in this HashTable */
	public int size(){
		return keyCount;
	}

	/** Make this HashTable empty */
	public void clear(){
		lists.clear();
		keyCount = 0;
	}

	/** @return true if this HashTable is empty */
	public boolean isEmpty(){
		return keyCount == 0;
	}
	
	public String toString() {
		Iterator itty = iterator();
		String s = "[";
		while (itty.hasNext()){
			s += itty.next();
			if (itty.hasNext() != false){
				s += ",";
			}
		}
		s += "]";
		return s;
	}
}
