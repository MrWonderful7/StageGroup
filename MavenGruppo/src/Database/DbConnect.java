package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {


	  private static DbConnect instance;
	  
	    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	    private String username = "LORENZO";
	    private String password = "0000";

	  private  DbConnect() throws SQLException {
	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	        
	        } catch (ClassNotFoundException ex) {
	            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
	        }
	    }

	    public Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(url, username, password);
	    }
	    
	    public static void closeConnection(Connection connection)
	    {
	        try {
	            if (connection != null) {
	                connection.close();
	                connection=null;
	            }
	        } catch (SQLException e) {
	           System.out.println(e.getMessage());
	        }
	    }
	   
	    public static DbConnect getInstance() throws SQLException {
	        if (instance == null) {
	            instance = new DbConnect();
	        } 

	        return instance;
	    }
	
	
}
