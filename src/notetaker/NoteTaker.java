package notetaker;

import java.sql.SQLException;

public interface NoteTaker {

	public void createCategory(String title) throws SQLException;
	
	public NoteCategory getCategory(int id) throws SQLException;
	
	public void deleteCategory(String title);
	
	public void addNote(String title, String body, int Category) throws SQLException;
	
	public Note getNote(int id) throws SQLException;
	
	public void archiveNote(int index);
	
}
