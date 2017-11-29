package queueDriver;

import queue.*;

/**
 * A Printer has a speed, in blocks of printing per step, and a priority queue of Docs to be printed
 * The shortest Docs in a PriorityQueue will get top priority
 * 			and will be printed when the Printer is available.
 * 
 * 
 * @author (sdb and Jill Pulicicchio) 
 * @version (10.04.2016)
 */
public class Printer
{
    private int speed;      // speed of this printer, blocks per step
    private QueueADT <Doc> docs;    // Queue of documents waiting to be printed
    private String id;      // name of this Printer
    //int remainder;
	//Doc currentDoc;
    int counter = 0;
    
    /**
     * Constructor for objects of class Printer
     */
    public Printer(int speed, String id)
    {
        this.speed = speed;
        //docs = new Queue <Doc> ();          
        docs = new PriorityQueue<Doc>();
        this.id = id;
        
    }
    
	/** Add a document to this printer's queue */
    public void add (Doc doc)
    {    
        docs.add(doc);
        System.out.println("A Document of size " + doc.size() + " added to " + this.id 
        				+ ", speed: " + this.speed + ", docs in queue: " + docs.size());
        //currentDoc = docs.peek();
        //remainder = currentDoc.size();
    }
    
    
    /** Print several blocks, if necessary, determined by this printer's speed
     *  
     */
    public void print() {
    	/*
        if (docs.peek != null) {  
        	if (remainder <= speed){
        		System.out.println("\tPrint task completed on " + id + " for: Doc of size " + currentDoc.size());
        		docs.remove();
        		currentDoc = docs.peek();
        		if (currentDoc != null) {
        			remainder = currentDoc.size();
        		}
        	}
        	else {
        		remainder -= speed;
        	}
        }
        */
    	
    	if (!(docs.isEmpty())){
    		int remainder = docs.peek().size() - (speed * counter);
    		
    		if (remainder <= speed){
    			System.out.println("\tPrint task completed on " 
    						+ id + " for: Doc of size " + docs.remove().size());
    			counter = 0;
    		}
    		else {
    			counter++;
    		}
    	}
    }
    
    /** @return the number of documents in this Printer's queue */
    public int size()
    {   return docs.size();  }
    
    public String toString()
    {   return id + ", speed: " + speed + ", docs in queue: " + size();  }
    
    
    
}