package recursion;

import list.*;

public abstract class Item {

	private String name;
	
	public String getName() {
		return name;
	}
	/**
	 * @return A list of all the documents making up this Item
	 * (and all contained folders) in any order
	 */
	public abstract List<Document> getAllDocs();
	
	/**
	 * Display the name of this Item, and all the items
	 * it contains on separate lines.
	 */
	public abstract void show();
	
	/**
	 * Modified show method so that the structure
	 * of the folder is shown, by indentation
	 * (shown in demo).
	 * 
	 * intended to show the item with the desired indentation.
	 */
	public abstract void show(int level);
	
	
}
