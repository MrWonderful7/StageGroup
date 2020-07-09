package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class checkUserPass {

	
	public static boolean insertUser(String username, String password, String email) {
		try {
			Connection conn = DbConnect.getInstance().getConnection();
			String query = "insert into login values (?,?,?)";
			PreparedStatement psm = conn.prepareStatement(query);
			psm.setString(1, username);
			psm.setString(2, password);
			psm.setString(3, email);
			int i = psm.executeUpdate();
			if(i>0) {
				System.out.println("add successfully");
				return true;
			}
			
		}catch(Exception ex) {
			System.out.println("We have a problem...");
		}
	
		return false;
	}
	
	
	public static boolean login(String user, String pass) {
		try {
			
			Connection conn = DbConnect.getInstance().getConnection();
			String query = "select * from login where username =? and password =?";
			PreparedStatement psm = conn.prepareStatement(query);
			psm.setString(1, user);
			psm.setString(2, pass);
			ResultSet rs = psm.executeQuery();
			if(rs != null && rs.next()) {
				System.out.println("The user and pass are ok..");
				return true;
			}else {
				System.out.println("Auth is not good");
			}
		}catch(Exception ex){
			System.out.println("Unable to load Driver Class");
		}
		return false;
	}
	
	public static boolean userExist(String user) {
		
		String query = "select username from login";
		
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
