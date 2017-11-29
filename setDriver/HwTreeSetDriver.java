package setDriver;
import set.*;
import list.*;


/**
 * Test the implementations of Set.
 * 
 * @author (sdb) 
 * @version (Mar 2012)
 */
public class HwTreeSetDriver
{
    public static void main(String[] args)
    {
        Set <Integer> values;
        values = new TreeSet <Integer> ();
        
        System.out.println (values);
        System.out.println ("removing from empty tree: " + values.remove(3));
        
        values.add (3);
        values.add (5);
        values.add (3);
        for (int j=0; j<200; j++)
        for (int i=0; i<20; i++)
            values.add (i/3);
        
        System.out.println ("size is " + values.size());   // should be 7
        System.out.println ("set is " + values);
        
        Set <String> names = new TreeSet <String> ();
      
        names.add ("joseph");
        names.add ("jim");
        names.add ("jack");
        names.add ("mary");
        names.add ("jimmy");
        names.add ("sue");
        names.add ("mary");
        
        System.out.println (names.size() + " names");   // should be 7
        System.out.println ("set of Strings is " + names);
        
        // Selectively remove long names
        Iterator <String> itty;
        itty = names.iterator();
        while (itty.hasNext())
            {   if (itty.next().length() > 3)
                    itty.remove();
                }
     
        System.out.println ("size is " + names.size());  // Should be 2
        System.out.println ("set is " + names);
        
    }
}