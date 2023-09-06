package notetaker;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Class used to organize objects of type {@link notetaker.Note Note} into lists based on common themes.
 *
 */
public class NoteCategory {
	
	String title;
	List<Note> notes = new LinkedList<Note>();
	
	NoteCategory(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void addNotes(Note notes) {
		this.notes.add(notes);
	}

}
