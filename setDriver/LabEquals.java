package setDriver;
import set.*;
import list.*;


/**
 * Test the implementations of the Set interface.
 * 
 * @author (sdb) 
 * @version (Nov 2016)
 */
public class LabEquals
{
    public static void main(String[] args)
    {   
        Set <String> friends, pals;
        friends = new TreeSet <String> ();
        pals = new HashSet <String> ();
        System.out.println ("Testing equals (Object)");
        
        if (! friends.equals (pals))
            System.err.println ("Error in equals 1");
        if (! pals.equals (friends))
            System.err.println ("Error in equals 2");
            
        friends.add ("joe");
        friends.add ("jim");
        if (friends.equals (pals))
            System.err.println ("Error in equals 3");
        if (pals.equals (friends))
            System.err.println ("Error in equals 4");
            
        friends.add ("joe");
        friends.add ("su" + "sie");
        pals.add ("jim");
        pals.add ("susie");
        pals.add ("jim");
        if (friends.equals (pals))
            System.err.println ("Error in equals 5");
        
        System.out.println (" friends are: " + friends);
        System.out.println (" pals are: " + pals);
        
        if (pals.equals (friends))
            System.err.println ("Error in equals 6");
        pals.add ("joe");
        pals.add ("jimmy");
        friends.add ("jimmy");
        if (friends.equals ("foo"))
            System.err.println ("Error in equals 7");
        if (pals.equals ("foo"))
            System.err.println ("Error in equals 8");
        
         if (! friends.equals (pals))
            System.err.println ("Error in equals 9");
        if (! pals.equals (friends))
            System.err.println ("Error in equals 10");
         

        System.out.println (friends.size() + " friends are: " + friends);
        System.out.println (pals.size() + " pals are: " + pals);
        
        
    }
}