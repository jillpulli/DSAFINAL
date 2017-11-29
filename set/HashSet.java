package set;
import hash.*;
import list.*;

/**
 * Implementation of Set using HashTables
 * @author Jill
 * @version (21 Nov 2016)
 *
 */
public class HashSet<E> implements Set<E> {
	
	HashTable<E> table = new HashTable<E>();
	
	public boolean add(E value){
		if (contains(value)){
			return false;
		}
		table.put(value);
		return true;
	}
	
	public boolean contains(Object obj) {
		return table.containsKey(obj);
	}
	
	public boolean remove(Object obj) {
		return table.remove(obj);
	}

	public Iterator<E> iterator() {
		return table.iterator();
	}

	@Override
	public int size() {
		return table.size();
	}

	@Override
	public boolean isEmpty() {
		return table.isEmpty();
	}

	@Override
	public void clear() {
		table.clear();
	}
	
	/** @return the elements of this Set as a String */ 
	public String toString() {
		Iterator itty = table.iterator();
        String s = "[";
        while(itty.hasNext())
        {
            s+= itty.next().toString();
            if(itty.hasNext())
            {
                s+= ", ";
            }
        }
        return s + "]";
	}
	
	/** @return true if obj is a Set and all the values in this Set are in the other Set, 
			and all the values in the other Set are in this Set */ 
	public boolean equals (Object obj) {
		
		if(!(obj instanceof Set))
            return false;
		
        Set other = (Set) obj;
        
        if(other.size()!= table.size())
            return false;
        
        Iterator itty = this.iterator();
        
        while(itty.hasNext())
        {
            if(!(other.contains(itty.next())))
                return false;
        }
        return true;
	}


}
