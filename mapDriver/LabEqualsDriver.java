package mapDriver;
import map.*;
import set.*;
import list.Iterator;

/**
 * Test the Map classes
 * 
 * @author (sdb) 
 * @version (Nov 2016)
 */
public class LabEqualsDriver
{
    public static void main(String[] args)
    {   Map <String, String> friends = new TreeMap <String, String> ();
        Map <String, String> pals = new HashMap <String, String> ();
 
        init (friends);
        if (friends.equals(pals))
            System.err.println ("error 1");
         if (pals.equals(friends))
            System.err.println ("error 2");
        init (pals);
        if (!friends.equals(pals))
            System.err.println ("error 3");
         if (!pals.equals(friends))
            System.err.println ("error 4");

         System.out.println ("jim is not a pal: " + pals.remove("jim"));
         if (friends.equals(pals))
            System.err.println ("error 5");
         if (pals.equals(friends))
            System.err.println ("error 6");
         System.out.println ("jim is not a friend: " + friends.remove("jim"));
          if (!friends.equals(pals))
            System.err.println ("error 7");
         if (!pals.equals(friends))
            System.err.println ("error 8");
         System.out.println ("friends are " + friends);
         System.out.println ("pals are " + pals);
         
    }
    
    private static void init (Map<String, String> friends)
    {        
        friends.put ("sue", "609");
        friends.put ("jim", "856");
        friends.put ("sarah", "215");
        friends.put ("will", "856");
        friends.put ("stu", "609");
        friends.put ("van", "856");
        friends.put (new String ("jim"), "215");
    }
    
  
}