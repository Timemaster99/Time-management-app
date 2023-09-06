package notetaker;

public interface NoteTaker {

	public void createCategory(String title);
	
	public void deleteCategory(String title);
	
	public void addNote(String title, String body, String tag, String Category);
	
	public void archiveNote(int index);
	
}
