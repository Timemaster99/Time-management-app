package notetaker;

/**
 * 
 * Class used to organize objects of type {@link notetaker.Note Note} into lists based on common themes.
 *
 */
public class NoteCategory {
	
	int id;
	String title;
	
	NoteCategory(int id, String title) {
		this.id = id;
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
}
