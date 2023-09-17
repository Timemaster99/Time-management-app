package notetaker;

import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+     This class is under construction for database implementation     +
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

public class NoteTakerImplementation implements NoteTaker {
	
	String jdbcUrl;
	String username;
	String password;
	
	List<NoteCategory> categories = new LinkedList<NoteCategory>();
	
	public NoteTakerImplementation() {
		try {
		    BufferedReader reader = new BufferedReader(new FileReader("resources/config.txt"));
		    jdbcUrl = reader.readLine();
		    username = reader.readLine();
		    password = reader.readLine();
		    reader.close(); // Close the file when done.
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

	public void createCategory(String title) throws SQLException {
		try {
		    Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		}
		Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
		System.out.println("Connection established");

		// String for query
		String sqlQuery = "INSERT INTO categories (title) VALUES (?)";
		// Prepare statement
		PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1, title);
		
		
		
		// Check if insertion is successful
		int rowsAffected = preparedStatement.executeUpdate();
		if (rowsAffected > 0) {
			System.out.println("Insertion successful!");
		} else {
			System.out.println("Insertion failed!");
		}
		
		// Closing connection
		if (connection != null) {
		    try {
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		
	}
	
	
	public void addNote(String title, String body, int category) throws SQLException {
		try {
		    Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		}
		// Attempt connection
		Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
		System.out.println("Connection established");

		// String for query
		String sqlQuery = "INSERT INTO notes (title, body, category_id) VALUES (?, ?, ?)";
		// Prepare statement
		PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setString(1, title);
		preparedStatement.setString(2, body);
		preparedStatement.setInt(3, category);
		
		// Check if insertion is successful
		int rowsAffected = preparedStatement.executeUpdate();
		if (rowsAffected > 0) {
			System.out.println("Insertion successful!");
		} else {
			System.out.println("Insertion failed!");
		}
		
		// Closing connection
		if (connection != null) {
		    try {
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		
	}

	public void deleteCategory(String title) {
		// TODO create this
		
	
	}

	public void archiveNote(int index) {
		// TODO create this, too
		
	}


	public Note getNote(int id) throws SQLException {
		try {
		    Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		}
		// Attempt connection
		Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
		System.out.println("Connection established");

		// String for query
		String sqlQuery = "SELECT * FROM notes WHERE id = ?";
		// Prepare statement
		PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setInt(1, id);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		Note note = null;
		
	    while (resultSet.next()) {
	        // Process the results
	        int tempid = resultSet.getInt("id");
	        String title = resultSet.getString("title");
	        String body = resultSet.getString("body");
	        int category_id = resultSet.getInt("category_id");
	        Timestamp createdTime = resultSet.getTimestamp("createdTime");
	        // Do something with the retrieved data
	        
	        // TODO: Find a way to feed this a category object
	        //Note retrievedNote = new Note(tempid, title, body, category_id, createdTime);
	        note = new Note(tempid, title, body, getCategory(category_id), createdTime);
	    }
		
		// Closing connection
		if (connection != null) {
		    try {
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		
		return note;
	}

	@Override
	public NoteCategory getCategory(int id) throws SQLException {
		try {
		    Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		}
		// Attempt connection
		Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
		System.out.println("Connection established");

		// String for query
		String sqlQuery = "SELECT * FROM categories WHERE id = ?";
		// Prepare statement
		PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
		preparedStatement.setInt(1, id);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		NoteCategory category = null;
		
	    while (resultSet.next()) {
	        // Process the results
	        int tempid = resultSet.getInt("id");
	        String title = resultSet.getString("title");
	        // Do something with the retrieved data
	        
	        // TODO: create category object to return
	        category = new NoteCategory(tempid, title);
	    }
		
		// Closing connection
		if (connection != null) {
		    try {
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		
		return category;
		
	}
	
}
