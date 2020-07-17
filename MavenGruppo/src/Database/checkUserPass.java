package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;



public class checkUserPass {

	
	private static Connection conn; 
	
	public static boolean insertUser(String username, String password, String email) throws SQLException {
		DbConnect.getInstance().getConnection();
		
		try {
			String hashed="";
			 try {
			hashed = BCrypt.hashpw(password, BCrypt.gensalt());
		    System.out.println(hashed);
			 }catch(Exception e) {
				 System.out.println(e);
				 System.out.println("problem in Bcrypt");
			 }
			
			String query = "insert into webaccount values (?,?,?)";
			conn= DbConnect.getInstance().getConnection();
			PreparedStatement psm = conn.prepareStatement(query);
			psm.setString(1, username);
			psm.setString(2, hashed);
			psm.setString(3, email);
			int i = psm.executeUpdate();
			if(i>0) {
				System.out.println("add successfully");
				return true;
			}
			
		}catch(Exception ex) {
			System.out.println("We have a problem...");
		}
		finally {
			DbConnect.closeConnection(conn);
		}
	
		return false;
	}
	
	
	public static String returnPass(String user) throws SQLException {
		
	String query = "select password from webaccount where username=?";
	String pass = "";
	DbConnect.getInstance().getConnection();
		
		try {
			Connection conn = DbConnect.getInstance().getConnection();
			PreparedStatement psm = conn.prepareStatement(query);
			psm.setString(1, user);
			ResultSet rs = psm.executeQuery();
			if(rs != null && rs.next()) {
				pass = rs.getString("password");
				return pass;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return pass;
	}
		
		
	public static boolean login(String user, String pass) {
		
		
		try {
			
		String passDbHash =	checkUserPass.returnPass(user);
		
		if(BCrypt.checkpw(pass, passDbHash) == true) {
			System.out.println("Merge!!!--");
			return true;
		}else {
			System.out.println("NUUU!!!--");
			return false;
		}

		}catch(Exception ex){
			System.out.println("Unable to load Driver Class");
		}
		return false;
	}
	
	public static boolean userExist(String user) throws SQLException {
		
		String query = "select username from webaccount";
		DbConnect.getInstance().getConnection();
		
		try {
			Connection conn = DbConnect.getInstance().getConnection();
			PreparedStatement psm = conn.prepareStatement(query);
			ResultSet rs = psm.executeQuery();
			if(rs != null && rs.next()) {
				if(rs.getString(1).equalsIgnoreCase(user)) {
					return true;		
				}return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return false;
	}
	
}
