package treeDriver;

import tree.*;
import list.*;

/**
 * Test the binary search tree implementation.
 * Test equals (Object) 
 * 
 * @author (sdb) 
 * @version (Oct 31 2016)
 */
public class DriverEquals
{
    
    public static void main(String[] args)
    {
    BT <String> kids = new EBST <String> ();
    BT <String> friends = new EBST <String> ();
    
    if (! kids.equals(friends))
        System.err.println ("Not correct 4");
  
    kids = kids.add ("kimmy");
    kids = kids.add ("jimmy");
    kids = kids.add ("susie");
    kids = kids.add ("joe");
    kids = kids.add ("sue");
  
    if (kids.equals ("kids"))
        System.err.println ("Not correct 5");
        
    
    if (kids.equals (friends))
        System.err.println ("Not correct 6");
     if (friends.equals (kids))
        System.err.println ("Not correct 7");
        
    friends = friends.add ("kimmy");
    friends = friends.add (new String ("jim" + "my"));
    friends = friends.add ("susie");
    friends = friends.add ("joe");
    if (kids.equals (friends))
        System.err.println ("Not correct 8");
     if (friends.equals (kids))
        System.err.println ("Not correct 9");
    
    friends = friends.add ("sue");
    
    if (!kids.equals (friends))
        System.err.println ("Not correct 10");
     if (!friends.equals (kids))
        System.err.println ("Not correct 11");
        
     kids = kids.remove ("kimmy");
     
     if (kids.equals (friends))
        System.err.println ("Not correct 12");
     if (friends.equals (kids))
        System.err.println ("Not correct 13");
     if (kids.containsKey ("kimmy"))
        System.err.println ("Not correct 14");
     System.out.println ("Testing completed");
     }
    
    
}