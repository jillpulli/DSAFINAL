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
public class HomeworkTestHeapsort
{
    static ArrayList <Integer> grades = new ArrayList <Integer> ();
    static Random rand = new Random();
    
    static ArrayList <String> names = new ArrayList <String> ();
    
    public static void main (String[] args)
    {
    System.out.println ("Test Heap Sort:");
    Sorter <String> sorter = new HeapSort();
     testSort (sorter);
     

    }
    
    private static void testSort (Sorter<String> sorter)
    {   init();
        
        System.out.println ("Before sorting:");
        System.out.println (names);
        System.out.println ("After sorting:");
        sorter.sort(names);
        System.out.println (names + "\n");
        System.out.println ( );
    
    }
    
    private static void init()
    {  // grades.clear(); 
        //for (int i=0; i<20; i++)
             //grades.add (rand.nextInt(150));
    	/*
    	grades.add(2);
    	grades.add(4);
    	grades.add(6);
    	grades.add(8);
    	grades.add(10);
    	grades.add(12);
    	grades.add(14);
    	grades.add(16);
    	grades.add(18);
    	grades.add(20);
    	*/
    	
    	/*
    	grades.add(1);
    	grades.add(4);
    	grades.add(5);
    	grades.add(1);
    	grades.add(4);
    	grades.add(5);
    	grades.add(1);
    	grades.add(4);
    	grades.add(5);
    	grades.add(1);
    	grades.add(4);
    	grades.add(5);
    	*/
    	
    	/*
    	grades.add(1);
    	grades.add(9);
    	grades.add(9);
    	grades.add(9);
    	grades.add(9);
    	grades.add(9);
    	grades.add(9);
    	*/
    	
    	names.add("al");
    	names.add("ben");
    	names.add("joe");
    	names.add("al");
    	names.add("chas");
    	names.add("mary");
    	names.add("ben");

    }
}