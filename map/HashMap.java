package map;
import hash.*;
import set.*;
import list.*;

/**
 * An implementation of Map using a HashTable
 * @author Jill
 *
 * @version (21 Nov 2016)
 */
public class HashMap<K, V> implements Map<K,V> {
	
	HashTable <Entry<K,V>> table = new HashTable <Entry<K,V>>();
	
	public HashMap(int capacity) {
		table = new HashTable<Entry<K,V>>(capacity);
	}
	public HashMap(){	}

    public boolean containsKey(K key)
    {
    	Entry <K,V> entry = new Entry<K,V>(key,null);
        return table.containsKey(entry);
    }

    public V get(K key)
    {
        Entry<K,V> entry = new Entry<K,V>(key,null);
        entry = table.get(entry);
        if(entry == null)
            return null;

        return entry.value;
    }

    public V put(K key, V value)
    {
        Entry<K,V> newEntry = new Entry<K,V>(key,value);
        Entry<K,V> oldEntry = table.get(newEntry);

        if(oldEntry==null)
        {
            table.put(newEntry);
            return null;
        }
        V oldValue = oldEntry.value;
        oldEntry.value = value;
        return oldValue;
    }

    public V remove(K key)
    {
        Entry<K,V> entry = new Entry<K,V>(key,null);
        entry = table.get(entry);
        if(table.remove(entry))
        	return entry.value;
        return null;
        
    }
    
    public boolean isEmpty()
    {
        return table.isEmpty();
    }
    
    public int size()
    {
        return table.size();
    }
    
    /**
     * return a Set of all the keys in this Map
     */
    public Set<K> keySet()
    {        
        Set <K> s = new HashSet<K>();
        Iterator<Entry<K,V>> itty = table.iterator();
        while(itty.hasNext())
        {
            Entry <K,V> entry = itty.next();
            s.add(entry.key);
        }
        return s;
    }
    
    
    public String toString()
    {
        return table.toString();
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
    	if (other.size() != size()) {
    		return false;
    	}
    	
    	Set<K> theseKeys = this.keySet();		//hashset
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
	@Override
	public Set<K> getKeys(V value) {
		// TODO Auto-generated method stub
		return null;
	}
}
