package map;

import set.*;

/**
 * Eaach entry consists of a ket and a value.
 * No duplicate keys.
 * Access is fast, for keys
 * 
 * @author Jill
 * @version (21 Nov 2016)
 *
 */
public interface Map<K, V> {
	
	 /**@return true if there is an entry with the given key*/
    boolean containsKey(K key);

    /**
     * @return the value for the given key, or null if not in this map
     */
    V get(K key);

    /** put an entry into this map formed from given key and value
     *  @return the old value for that key, or null if key is not in this map
     */
    V put(K key, V value);

    /**
     * remove the entry which has the given key
     * @param key
     * @return value of that entry, or null if not in this map
     */
    V remove(K key);
    
    /** @return a Set of all keys in this Map */
    Set<K> keySet( );

	boolean isEmpty();

	int size();
	
	boolean equals(Object obj);
	
	/** @return a set of all keys which map to the given value  */    
	Set <K> getKeys (V value);

}
