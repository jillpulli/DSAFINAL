package queueDriver;

/**
 * A Doc has a size, in blocks, to be printed.
 * 
 * @author (sdb) 
 * @version (Feb 2012)
 * @param <E>
 */
public class Doc implements Comparable<Doc>
{
    private int size;      // size of this Doc, in blocks

    /**
     * Constructor for objects of class Printer
     */
    public Doc(int size)
    {
        this.size = size;
    }
    
    public int size()
    {   return size;  }

	@Override
	public int compareTo(Doc o) {
		/*
		int result = size - o.size;
		if (result > 0){	//this size is smaller
			return -1;
		}
		if (result < 0){	//other size is smaller
			return 1;
		}
		return 0;			//they have same size
		*/
		return o.size - size;
	}

    


   
    
}