package notetaker;

import java.util.List;

public class NoteTakerImplementation implements NoteTaker {
	
	List<NoteCategory> categories;

	public void createCategory(String title) {
		categories.add(new NoteCategory(title));
	}
	
	public void addNote(String title, String body, String tag, String Category) {
		for (NoteCategory c : categories) {
			if (c.getTitle().equalsIgnoreCase(Category)) {
				c.addNotes(new Note(title, body, tag));
			}
		}
	}

	public void deleteCategory(String title) {
		// TODO create this
		
	}

	public void archiveNote(int index) {
		// TODO create this, too
		
	}
}
