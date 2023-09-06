package notetaker;
import java.time.*;

/**
 * Object for storing notes that includes a title, body, tag, and timestamp.
 */
public class Note {
	
	String title;
	String body;
	String tag;
	LocalDateTime timestamp;
	
	Note(String title, String body, String tag) {
		timestamp = LocalDateTime.now();
		this.title = title;
		this.body = body;
		this.tag = tag;
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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public LocalDateTime getTimeStamp() {
		return timestamp;
	}
	
	
}
