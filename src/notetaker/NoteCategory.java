package notetaker;

/**
 * 
 * Class used to organize objects of type {@link notetaker.Note Note} into lists based on common themes.
 *
 */
public class NoteCategory {
	
	String title;
	
	NoteCategory(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
}
