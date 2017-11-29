package setDriver;
import set.*;
import list.*;


/**
 * Test the implementation of TreeSet.
 * 
 * @author (sdb) 
 * @version (Mar 2016)
 */
public class HwHashSetDriver
{
    public static void main(String[] args)
    {
        Set <Integer> values;
        values = new HashSet <Integer> ();
        
        if (!values.isEmpty())
            System.err.println  ("Error in isEmpty 1");
            
        values.add (3);
        values.add (5);
        values.add (3);
        
        // No news is good news
        
        if (values.size() != 2)
            System.err.println  ("Error in size 2");
         if (values.isEmpty())
            System.err.println  ("Error in isEmpty 3");
            
        for (int j=0; j<5; j++)
             values.add (j * 10);
         
        if (values.contains (15))
            System.err.println ("Error in contains 4");
        if (!values.contains (20))
            System.err.println ("Error in contains 5");  
            
        if (values.remove (2))
            System.err.println ("Error in remove 6");  
        if (!values.remove (0))
            System.err.println ("Error in remove 7");  
        if (values.size() != 6)
            System.err.println  ("Error in size or remove 8");
        
        Iterator<Integer> itty = values.iterator();
        while (itty.hasNext())
            if (itty.next() % 2 == 1)
                itty.remove();              // remove odd numbers
           
        if (values.size() != 4)
            System.err.println  ("Error in size or iterator 9");
        
        values.clear();
        if (!values.isEmpty())
            System.err.println  ("Error in clear or isEmpty 10");
        
        values.add (17);
         if (values.size() != 1)
            System.err.println  ("Error in size or clear 11");
        
        System.out.println ("Testing complete");
        
    }
}