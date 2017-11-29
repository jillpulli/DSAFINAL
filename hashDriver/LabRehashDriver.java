package hashDriver;
import hash.*;

/**
 * Test the rehashing HashTable class
 * 
 * @author (sdb) 
 * @version (Dec 2016)
 */
public class LabRehashDriver
{
    
    public static void main(String[] args)
    {   HashTable <String> people = new HashTable <String> (10);
        HashTable <UnderConstruction> stuff = new HashTable <UnderConstruction> (4);
        
        System.out.println ("Testing problem 2(a)");
        for (int i=0; i<2000; i++)
            people.put ("person" + i); 
            
        // Uncomment the following when ready for problem 2 (b)
         System.out.println ("\nTesting problem 2(b)");
         for (int i=0; i<2000; i++)
             stuff.put (new UnderConstruction (i));
         
         System.out.println ("Testing complete");
    }
}