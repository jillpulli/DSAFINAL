package recursion;

import list.*;

/**
 *  Every folder is an item.
 *  Every folder has a list of items.
 * @author Jill
 *
 */
public class Folder extends Item {

	List<Item> folder = new ArrayList<Item>();
	
	public Folder() {super();}
	
	public Folder(boolean linkedBased) {
		if (linkedBased) {
			folder = new LinkedList<Item>();
		}
	}
		
	/**
	 * Add the given Item to this Folder.
	 */
	public void addItem(Item item){
		folder.add(item);
	}

	/**
	 * @return A list of all the documents making up this Item 
   *  (and all contained folders)  in any order
	 */
	@Override
	public List<Document> getAllDocs() {
		List<Document> allDocs = new ArrayList<Document>();
		allDocs.addAll(folder);
		return allDocs;
	}

	/**
	 * Display the name of this Item; also display all the
     items which it contains, on separate lines.
	 */
	@Override
	public void show() {
		System.out.println("\n" + this.getName() + ":" );
		for (int i=0; i < folder.size(); i++) {
			System.out.println(folder.get(i));
		}
	}

	@Override
	public void show(int level) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}
