package Database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;  

import model.Type;
import model.User;


public class CrudDaoUser implements UserDao{

	private CrudDaoUser() {}
	
	private static class SingletonHelper{
		private static final CrudDaoUser INSTANCE = new CrudDaoUser();
	}
	
	public static CrudDaoUser getInstance() {
		return SingletonHelper.INSTANCE;
	}
	
	@Override
	public List<User> findAll() throws SQLException {
		
		List<User> listProducts = new ArrayList<>();
		String sql = "SELECT id,name,surname,birthDate,age,roles FROM users";
	
		
		Connection conn = DbConnect.getInstance().getConnection();
		Statement stm = conn.createStatement();
		ResultSet resultSet;
		resultSet = stm.executeQuery(sql);
		
		while(resultSet.next()) {
			
			
			
			
			String name = resultSet.getString("name");
			String surname = resultSet.getString("surname");
			Date birthDate = resultSet.getDate("birthDate");
			int age = resultSet.getInt("age");
			String type = resultSet.getString("role");
			Type role = Type.valueOf(type);
			
			 
			User user = new User(name, surname, birthDate, age, role);
			listProducts.add(user);
		}
		
		
		return listProducts;
	}

	@Override
	public boolean save(User user) throws SQLException, ParseException {
		
		String sql = "INSERT into users (firstname, lastname, birthDate, age, role, info)VALUES(?,?,?,?,?,?)";
		boolean rowInserted = false;
		Connection conn = DbConnect.getInstance().getConnection();
			PreparedStatement stm = conn.prepareStatement(sql);
			
			
			Date date = new Date();
			date.getTime();
			String formattedDate = new SimpleDateFormat("yyyyMMdd").format(date);
			Timestamp timestamp = new Timestamp(new SimpleDateFormat("yyyyMMdd").parse(formattedDate).getTime());
			
			java.util.Date utilDate = user.getBirthDate();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			final String stringDate= dateFormat.format(utilDate);
			final java.sql.Date sqlDate=  java.sql.Date.valueOf(stringDate);
			final String role =  String.valueOf(user.getType());
			
			
			
			stm.setString(1, user.getName());
			stm.setString(2, user.getSurname());
			stm.setDate(3, sqlDate);  
			stm.setInt(4, user.getAge());
			stm.setString(5, role);
			stm.setString(6, formattedDate);
			
			rowInserted = stm.executeUpdate() > 0;
			
	
		return rowInserted;
	}

	@Override
	public Optional<User> find(String id) throws SQLException {
		String sql = "SELECT id,name,surname,birthdate,age,roles FROM USERS where id = ?";
		int idd = 0, age = 0;
		String name = "", surname = "", roles = "";
		Connection conn = DbConnect.getInstance().getConnection();
		
//		java.util.Date utilDate = null;
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		final String stringDate= dateFormat.format(utilDate);
//		final java.sql.Date sqlDate=  java.sql.Date.valueOf(stringDate);
		
		
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setString(1, id);
		ResultSet resultSet = stm.executeQuery();
		
		if(resultSet.next()) {
			idd = resultSet.getInt("id");
			name = resultSet.getString("name");
			surname = resultSet.getString("Surname");
			age = resultSet.getInt("age");
			roles = resultSet.getString("roles");
		}
		Date date = null;
	//	return Optional.of(new User(idd, name, date,surname, age, role));
		return null;
	}

	@Override
	public boolean update(User o) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User o) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
