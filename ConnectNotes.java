package Code;
/*ConnectNotes is the main program in which
 * all of the commands go through to connect to the
 * sql database table. It corresponds with the notes
 * database. It does not contain a gui and all of the code written will
 * connect to the database on execution and return the relevant information.
 * */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectNotes {
	public static void main(String args[]){  //main runs through and gets the connection. 
		try{  
		Connection conn=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/notes","username","password");//establishes connection to localhost database.  
         System.out.println("connection established");
		}catch(Exception e){ System.out.println(e);}  
		}
	public static void createNote(String userInput) {
		 String sql = "CREATE TABLE IF NOT EXISTS " + userInput +" (\n"
	                + "Body VARCHAR(1000)\n"
	                + ");";//Creates new table.
	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/notes","username","password");//establishes connection to localhost database.  
	                java.sql.Statement statement = conn.createStatement()) {
	            statement.execute(sql);//sends SQL statement to the corresponding schema and executes statement.
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
	public static void UpdateNote(String Title, String Body) {
		 String sql = "UPDATE " + Title +"\n"
	                + "SET Body = '" + Body + "';";//Updates body text of said note.
	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/notes","username","password");//establishes connection to localhost database.  
	                java.sql.Statement statement = conn.createStatement()) {
	            statement.execute(sql);//sends SQL statement to the corresponding schema and executes statement.
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
	public static void deleteText(String Title, String text) {
		 String sql = "DELETE FROM " + Title +"\n"
				    + "WHERE Body ='"+ text + "';";//Deletes text from specified note.
	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/notes","username","password");//establishes connection to localhost database.  
	            java.sql.Statement statement = conn.createStatement()) {
	            statement.execute(sql);//sends SQL statement to the corresponding schema and executes statement.
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	public static void deleteNote(String Title) {
		 String sql = "DROP TABLE "+ Title +";";//deletes the whole note.
	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/notes","username","password");//establishes connection to localhost database.  
	            java.sql.Statement statement = conn.createStatement()) {
	            statement.execute(sql);//sends SQL statement to the corresponding schema and executes statement.
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	} 
