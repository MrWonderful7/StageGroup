package TestPro;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import Controller.ControllerServ;
import Database.CrudDaoUser;
import Database.DbConnect;
import model.User;

public class TestServ {

	
	
//	@Mock
//	HttpServletRequest request;
//	
//	@Mock
//	HttpServletResponse response;
	
	  @InjectMocks private DbConnect dbConn;
	 
	 
	  @Mock
	   private DataSource ds;
	  @Mock
	    private Connection c;
	  @Mock
	    private PreparedStatement stmt;
	  @Mock
	    private ResultSet rs;
	  
	  private User user;
	
	  @Before
	    public void setUp() throws Exception {
	        MockitoAnnotations.initMocks(this);
	     
		
			
			assertNotNull(ds);
//	        when(c.prepareStatement(any(String.class))).thenReturn(stmt);
	        when(ds.getConnection()).thenReturn(c);
	        
	        int year = 1993;
	        int dd = 07;
	        int m = 01;
	        Date date = new Date(year, dd, m);
	        
			 user = new User();
		     user.setAge(30);
			 user.setName("Johnny");
			 user.setBirthDate(date);
			 user.setRoles("admin");
			
			 java.util.Date utilDate = user.getBirthDate();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				final String stringDate= dateFormat.format(utilDate);
				final java.sql.Date sqlDate=  java.sql.Date.valueOf(stringDate);
			 
			    when(rs.first()).thenReturn(true);
		        when(rs.getInt(1)).thenReturn(30);
		        when(rs.getDate(2)).thenReturn(sqlDate);
		        when(rs.getString(3)).thenReturn(user.getName());
		        when(rs.getString(4)).thenReturn(user.getRoles());
		        when(stmt.executeQuery()).thenReturn(rs);
			 
	    }
	
	@Test
	public void testParam() throws IOException, ServletException, SQLException {
		
		
//	 when(request.getParameter("op")).thenReturn("insert");
//	  new ControllerServ().doGet(request, response);
//		
	
	}
	
	 @Test
	    public void createUser() throws SQLException {
	       
		  CrudDaoUser daoUser = CrudDaoUser.getInstance();
		  daoUser.save(user);
		  
		  Optional<User> user2 = daoUser.find("16");
		  
		 
		  
		  assertEquals(user, user2);
		  
	    }
	
	
	
}
