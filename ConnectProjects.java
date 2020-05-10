package Code;
/*ConnectProjects is the main program in which
 * all of the commands go through to connect to the
 * sql database table. It corresponds with the projects
 * database. It does not contain a gui and all of the code written will
 * connect to the database on execution and return the relevant information.
 * */
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
public class ConnectProjects {
	public static void main(String args[]){//main runs through and gets the connection.
		try{  
		Connection conn=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/projects","username","password");//establishes connection to localhost database.
         System.out.println("connection established");
		}catch(Exception e){ System.out.println(e);}  
		}
	
	public static void createProject(String userInput) {
		 String sql = "CREATE TABLE IF NOT EXISTS " + userInput +" (\n"
	                + "ProductName VARCHAR(30),\n"
	                + "Idea VARCHAR(50),\n"
	                + "Price DOUBLE\n"
	                + ");";//Creates new table.
	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","username","password");//establishes connection to localhost database.  
	            java.sql.Statement statement = conn.createStatement()) {
	            statement.execute(sql);//sends SQL statement to the corresponding schema and executes statement.
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	public static void addToTable(String Title, String Name, String Idea, String Price) {
		 String sql = "Insert into " + Title +" (ProductName, Idea, Price)\n"
				    + "Values ('" + Name + "', '" + Idea + "', '" + Price + "');";//Adds a product to the table you want.
	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","username","password");//establishes connection to localhost database.  
	            java.sql.Statement statement = conn.createStatement()) {
	            statement.execute(sql);//sends SQL statement to the corresponding schema and executes statement.
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	public static void deleteItem(String Title, String Name) {
		 String sql = "DELETE FROM " + Title +"\n"
				    + "WHERE ProductName ='"+ Name + "';";//Deletes product from the table list.
	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","username","password");//establishes connection to localhost database.  
	            java.sql.Statement statement = conn.createStatement()) {
	            statement.execute(sql);//sends SQL statement to the corresponding schema and executes statement.
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	public static void deleteTable(String Title) {
		 String sql = "DROP TABLE "+ Title +";";//Deletes sql table
	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","username","password");//establishes connection to localhost database.  
	            java.sql.Statement statement = conn.createStatement()) {
	            statement.execute(sql);//sends SQL statement to the corresponding schema and executes statement.
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	}

