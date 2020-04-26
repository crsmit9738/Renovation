package Code;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
public class ConnectProjects {
	public static void main(String args[]){  
		try{  
		Connection conn=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/projects","root","!Crs12345");  
         System.out.println("connection established");
		}catch(Exception e){ System.out.println(e);}  
		}
	
	public static void createProject(String userInput) {
		 String sql = "CREATE TABLE IF NOT EXISTS " + userInput +" (\n"
	                + "Picture BLOB,\n"
	                + "ProductName VARCHAR(30),\n"
	                + "Idea VARCHAR(50),\n"
	                + "Price DOUBLE\n"
	                + ");";
	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","!Crs12345");
	            java.sql.Statement statement = conn.createStatement()) {
	            statement.execute(sql);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	public static void addToTable(String Title, String Name, String Idea, String Price) {
		 String sql = "Insert into " + Title +" (ProductName, Idea, Price)\n"
				    + "Values ('" + Name + "', '" + Idea + "', '" + Price + "');";
	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","!Crs12345");
	            java.sql.Statement statement = conn.createStatement()) {
	            statement.execute(sql);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	public static void deleteItem(String Title, String Name) {
		 String sql = "DELETE FROM " + Title +"\n"
				    + "WHERE ProductName ='"+ Name + "';";
	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","!Crs12345");
	            java.sql.Statement statement = conn.createStatement()) {
	            statement.execute(sql);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	}

