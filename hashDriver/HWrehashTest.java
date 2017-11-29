package hashDriver;
import hash.*;

/**
 * Test the HashTable class, with rehashing
 * 
 * @author (sdb) 
 * @version (Apr 2016)
 */
public class HWrehashTest
{
    
    public static void main(String[] args)
    {   HashTable <Integer> numbers = new HashTable <Integer> (4);
        
        for (int i=0; i<2000; i++)
            numbers.put (i); 
            
        
        System.out.println(numbers);
        }
    
}