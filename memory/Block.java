package memory;

/**
 * A Block consists of a start address
 * 		and a size.
 * @author Jill
 * @version (5 Dec 2016)
 *
 */
public class Block {
	
	int start, size;
	
	public Block(int start, int size){
		this.start = start;
		this.size = size;
	}
	
	public String toString(){
		return "(" + start + "." + size + ")";
	}

}
