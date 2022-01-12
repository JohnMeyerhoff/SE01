package org.hbrs.se.ws21.composite;

// Dieses Aufgabenblatt ist in Teamarbeit von Klara Golubovic
// und Johannes Meyerhoff bearbeitet worden.
import java.util.ArrayList;
import java.util.List;

public class ComplexDocument extends GeneralDocument  {
	
	private List<Document> content = new ArrayList<>();
	
	public void add( Document doc ) {
		this.content.add(doc);
	}
	
	private void delete(Document doc){
		this.content.remove(doc);
		//remove ist name für delete in ArrayList
	}

	@Override
	public int getSizeInBytes() {
		int sumBytes = 0;
		for ( Document doc : content) {
			sumBytes += doc.getSizeInBytes();
		}
		return sumBytes;
	}

	
	public boolean delete(int id) {
		boolean deleted = false;
		for (Document doc : content) {
			if (doc.getID() == id){
				delete(doc);
				deleted = true;
			}else{
				if(doc instanceof ComplexDocument castedsubtree){
					//use castedsubtree if instanceof is true
					//See JEP 394: Pattern Matching for instanceof
					castedsubtree.delete(id);
					deleted = true;
				}
			}
		}
		return deleted;
	}

}
