package map;

/**
 * An Entry consists of a key and a value.
 * @author Jill
 * @version (21 Nov 2016)
 *
 */
public class Entry<K,V> implements Comparable <Entry<K,V>>{

	K key;
    V value;

    Entry(K key, V value)
    {
        this.key = key;
        this.value = value;
    }

    public int compareTo(Entry <K,V> entry)
    {
        Comparable thiskey = (Comparable) key;
        Comparable otherkey = (Comparable) (entry.key);
        return thiskey.compareTo(otherkey);
    }
    
    public boolean equals(Object obj)
    {
    	if(!(obj instanceof Entry))
            return false;
        Entry<K,V> entry = (Entry) obj;
        return this.key.equals(entry.key);
    }
    
    public int hashCode()
    {
        return key.hashCode();
    }
    
    public String toString()
    {
        return key + "(" + value + ")";
    }
}
