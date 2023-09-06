import notetaker.NoteTaker;
import notetaker.NoteTakerImplementation;

public class Driver {

	public static void main(String[] args) {
		NoteTaker NoteTakerObject = new NoteTakerImplementation();
		
		NoteTakerObject.createCategory("Test");
		NoteTakerObject.addNote("Testing", "Test note", "Test", "Test");
		System.out.println(NoteTakerObject.getNote("Testing", "Test").getTitle());
		

	}

}
