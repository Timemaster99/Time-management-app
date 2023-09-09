package notetaker;
import java.time.*;

/**
 * Object for storing notes that includes a title, body, tag, and timestamp.
 */
public class Note {
	
	int id;
	String title;
	String body;
	NoteCategory category;
	LocalDateTime timestamp;
	
	Note(String title, String body, NoteCategory category) {
		timestamp = LocalDateTime.now();
		this.title = title;
		this.body = body;
		this.category = category;
	}
	
	public int getID() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public NoteCategory getTag() {
		return category;
	}
	
	public LocalDateTime getTimeStamp() {
		return timestamp;
	}
	
	
}
