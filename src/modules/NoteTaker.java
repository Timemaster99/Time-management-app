package modules;

import java.util.List;

public class NoteTaker implements Module {
	
	List<NoteCategory> categories;

	public void createCategory(String title) {
		categories.add(new NoteCategory(title));
	}
	
	public void addNote(String title, String body, String tag, String Category) {
		for (NoteCategory c : categories) {
			if (c.getTitle().equalsIgnoreCase(Category)) {
				
			}
		}
	}
	
}
