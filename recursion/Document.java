package recursion;

import list.*;

public class Document extends Item {
	
	DocType doctype;
	
	public Document(){
		super();
	}

	public DocType getDocType() {
		return doctype;
	}
	
	/**
	 * return list of documents making up this item
	 */
	@Override
	public List<Document> getAllDocs() {
		List<Document> allDocs = new ArrayList<Document>();
		allDocs.add(this);
		return allDocs;
	}

	/**
	 * display name of this item and items it contains
	 */
	@Override
	public void show() {
		System.out.println("\n" + this.getName());
	}

	@Override
	public void show(int level) {
		// TODO Auto-generated method stub
		
	}

	
	
}
