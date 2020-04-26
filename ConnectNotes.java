package Code;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectNotes {
	public static void main(String args[]){  
		try{  
		Connection conn=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/projects","root","!Crs12345");  
         System.out.println("connection established");
		}catch(Exception e){ System.out.println(e);}  
		}
	public static void createNote(String userInput) {
		 String sql = "CREATE TABLE IF NOT EXISTS " + userInput +" (\n"
	                + "Body VARCHAR(500)\n"
	                + ");";
	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","!Crs12345");
	                java.sql.Statement statement = conn.createStatement()) {
	            statement.execute(sql);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
	public static void UpdateNote(String Title, String Body) {
		 String sql = "UPDATE " + Title +"\n"
	                + "SET Body = '" + Body + "';";
	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/notes","root","!Crs12345");
	                java.sql.Statement statement = conn.createStatement()) {
	            statement.execute(sql);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
		} 
