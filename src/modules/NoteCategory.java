package modules;

import java.util.List;

public class NoteCategory {
	
	String title;
	List<Note> notes;
	
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
