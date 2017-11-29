package sortDriver;
import sort.*;
import list.*;
import java.util.Random;

/**
 * Test the Selection Sort algorithm.
 * 
 * @author (sdb) 
 * @version (Nov 2012)
 */
public class HomeworkTestBubbleLinked
{
    static List <Integer> grades = new LinkedList <Integer> ();
    static Random rand = new Random();
    static Sorter <Integer> sorter;
    
    public static void main (String[] args)
    {
      
     System.out.println ("Test Bubble Sort on a LinkedList:");
 //    sorter = new BubbleSortLinked <Integer>  ( );
     testSort (sorter);

    }
    
    private static void testSort (Sorter<Integer> sorter)
    {   init();
        
        System.out.println ("Before sorting:");
        System.out.println (grades);
        System.out.println ("After sorting:");
        sorter.sort(grades);
        System.out.println (grades + "\n");
        System.out.println ( );
    
    }
    
    private static void init()
    {   grades.clear(); 
        for (int i=0; i<100; i++)
             grades.add (rand.nextInt(150));

    }
}