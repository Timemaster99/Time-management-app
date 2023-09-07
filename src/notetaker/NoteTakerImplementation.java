package notetaker;

import java.util.LinkedList;
import java.util.List;

public class NoteTakerImplementation implements NoteTaker {
	
	List<NoteCategory> categories = new LinkedList<NoteCategory>();

	public void createCategory(String title) {
		categories.add(new NoteCategory(title));
	}
	
	public void addNote(String title, String body, String tag, String category) {
		for (NoteCategory c : categories) { // Linear search for the specified category
			if (c.getTitle().equalsIgnoreCase(category)) { // If a match for our category is found
				c.addNotes(new Note(title, body, tag)); // Create a note
			}
		}
	}

	public void deleteCategory(String title) {
		// TODO create this
		
	
	}

	public void archiveNote(int index) {
		// TODO create this, too
		
	}


	public Note getNote(String title, String category) {
		for (NoteCategory c : categories) { // Linear search for the specified category
			if (c.getTitle().equalsIgnoreCase(category)) { 
				for (Note note : c.getNotes()) { // Linear search for specified title in specified category
					if (note.getTitle().equalsIgnoreCase(title)) {
						return note;
					}
				}
			}
		}
		return new Note("Invalid Note", "Could not find category or title", "Invalid"); // If all else fails, return invalid
	}
}
