package memory;
import list.*;

/**
 * A memory manager.
 * Allocate and free blocks of memory
 * @author Jill
 *
 */
public class Memory {

	static final int MAX = 4096;	//size of memory
	
	List<Block> free = new LinkedList<Block>();
	List<Block> alloc = new LinkedList<Block>();
	
	public Memory(){
		free.add(new Block(0, MAX));
	}
	
	/**
	 * Allocate a block of memory with a given size,
	 * if possible.
	 * @return the start address of the allocated block,
	 * or -1 if not possible.
	 * 
	 * First-fit algorithm
	 *  
	 */
	public int allocate(int size){
		Block b, newBlock;
		Iterator<Block> itty = free.iterator();
		while (itty.hasNext()){
			b = itty.next();
			if (b.size >= size){
				newBlock = new Block(b.start, size);
				alloc.add(0, newBlock);
				b.start = b.start+size;
				b.size = b.size-size;
				if (b.size == 0){
					itty.remove();
				}
				return newBlock.start;
			}
		}
		return -1;		//space not available
	}
	
	/**
	 * Return the block at the given start address to the free storage list.
	 * @return true if possible, or false if there is no such Block
	 * 		on allocated list
	 */
	public boolean free(int start){
		Block b;
		Iterator<Block> itty = alloc.iterator();
		while (itty.hasNext()){
			b = itty.next();
			if (b.start == start){
				free.add(0, b);
				itty.remove();
				return true;
			}
		}
		return false;
	}
	
	public String toString(){
		return "free: \t" + free.toString()
			+ "\nalloc: \t" + alloc.toString();
	}
	
}
