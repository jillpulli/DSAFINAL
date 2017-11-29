package map;

import list.*;
import set.*;
import tree.*;
import hash.*;

/**
 * Implement Map with a BST
 * @author Jill Pulicicchio
 * @version (29 Nov 2016)
 *
 */
public class TreeMap <K extends Comparable, V> 
								implements Map<K, V>{
	
	BT <Entry<K,V>> tree = new EBST <Entry<K,V>>();
	int size = 0;

    public boolean containsKey(K key)
    {
    	Entry <K, V> entry = new Entry<K, V>(key, null);
        return tree.containsKey(entry);
    }

    public V get(K key)
    {
        Entry<K,V> entry = new Entry<K,V>(key,null);
        entry = tree.get(entry);
        if(entry == null)
            return null;

        return entry.value;
    }

    public V put(K key, V value)
    {
        Entry<K,V> newEntry = new Entry<K,V>(key,value);
        Entry<K,V> oldEntry = tree.get(newEntry);

        if(oldEntry==null)
        {
            tree= tree.add(newEntry);
            size++;
            return null;
        }
        V oldValue = oldEntry.value;
        oldEntry.value = value;
        return oldValue;
    }

    public V remove(K key)
    {
        Entry<K,V> entry = new Entry<K,V>(key,null);

        entry = tree.get(entry);
        if(entry==null)
            return null;

        tree= tree.remove(entry);
        size--;
        return entry.value;
    }

    public boolean isEmpty()
    {
        return tree.isEmpty();
    }
    
    public int size()
    {
        return size;
    }
    
    
    
    
    public String toString()
    {
        return tree.toString();
    }
    
    /**
     * Two maps are equal if all of their entries have the same 
     * key AND the same value
     * 
     * Hints:  If the size of this map is not the same 
     * as the size of the other Map, they could not be equal.
     */
    public boolean equals(Object obj){
    	if (! (obj instanceof Map)){
    		return false;
    	}
    	Map other = (Map) obj;
    	if (other.size() != size) {
    		return false;
    	}
    	
    	Set<K> theseKeys = this.keySet();		//treeset
    	Set<K> otherKeys = other.keySet();		//could be treeset or hashset
    	
    	if (!(theseKeys.equals(otherKeys))){
    		return false;
    	}
    	
    	Iterator<K> itty = theseKeys.iterator();
    	while (itty.hasNext()){
    		K thisKey = itty.next();				//the key in this map
    		if (!(other.containsKey(thisKey))){		//check if other has this key
    			return false;
    		}
    		V thisValue = this.get(thisKey);
    		V otherValue = (V) other.get(thisKey);	//check if this value equals other value
    		if (!(thisValue.equals(otherValue))){
    			return false;
    		}
    	}
    	return true;
    }
    
    /**
     * return a Set of all the keys in this map
     */
    public Set<K> keySet()
    {        
        Set <K> s = new TreeSet<K>();
        Iterator<Entry<K,V>> itty = tree.iterator();
        while(itty.hasNext())
        {
            Entry <K,V> entry = itty.next();
            s.add(entry.key);
        }
        return s;
    }

    /** @return a set of all keys which map to the given value  
     * Hint: use keySet and iterate through all of the keys
     */
	@Override
	public Set<K> getKeys(V value) {
		Set<K> allKeys = this.keySet();			//set of keys in this map
		Set<K> theseKeys = new TreeSet<K>();	
		
		Iterator<K> itty = allKeys.iterator();
		while (itty.hasNext()){
			K thisKey = itty.next();			//current key in set
			V currentValue = this.get(thisKey);	//value from current key
			if (value.equals(currentValue)){
				theseKeys.add(thisKey);			//add to new set if they are equal
			}
		}
		return theseKeys;
	}

}
