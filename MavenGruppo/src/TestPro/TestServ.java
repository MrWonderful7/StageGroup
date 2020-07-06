package TestPro;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;

import com.google.gson.Gson;


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
	     
		
//			
//			assertNotNull(ds);
////	        when(c.prepareStatement(any(String.class))).thenReturn(stmt);
//	        when(ds.getConnection()).thenReturn(c);
//	        
//	        int year = 1993;
//	        int dd = 07;
//	        int m = 01;
//	        Date date = new Date(year, dd, m);
//	        
//			 user = new User();
//		     user.setAge(30);
//			 user.setName("Johnny");
//			 user.setBirthDate(date);
//			
//			
//			 java.util.Date utilDate = user.getBirthDate();
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//				final String stringDate= dateFormat.format(utilDate);
//				final java.sql.Date sqlDate=  java.sql.Date.valueOf(stringDate);
//			 
//			    when(rs.first()).thenReturn(true);
//		        when(rs.getInt(1)).thenReturn(30);
//		        when(rs.getDate(2)).thenReturn(sqlDate);
//		        when(rs.getString(3)).thenReturn(user.getName());
//		        
//		        when(stmt.executeQuery()).thenReturn(rs);
			 
	    }
	

	 
	

	@Test
	public void testParam() throws IOException, ServletException, SQLException, ParseException, JSONException {
		
		
//	 when(request.getParameter("op")).thenReturn("insert");
//	  new ControllerServ().doGet(request, response);
//		
		
//		assertThat(controller).isNotNull();
		
		 	HttpServletRequest mockRequest = mock(HttpServletRequest.class);
	        HttpServletResponse mockResponse = mock(HttpServletResponse.class);
//	        ServletOutputStream mockOutput = mock(ServletOutputStream.class);
//	        when(mockResponse.getOutputStream()).thenReturn(mockOutput);
//	        mockRequest.setAttribute("op", "rosa");
	        
	        
	        
	        ControllerServ cont = new ControllerServ();
	      
	        when(mockRequest.getParameter("name")).thenReturn("admin");
	        when(mockRequest.getParameter("description")).thenReturn("test");
	        when(mockRequest.getParameter("quantity")).thenReturn("1");
	        when(mockRequest.getParameter("location")).thenReturn("edit");
	  
	        
//	        cont.insertProduct(mockRequest, mockResponse);
	        
	        JSONObject json = new JSONObject();
	        
	       json =  cont.getJson("1");
	       System.out.println(json);
	       
	       JSONAssert.assertEquals("{name:\"Jason\"}", json, false);
	       
	}
	
	
	
//	 @Test
//	    public void createUser() throws SQLException, ParseException {
//	       
//		  CrudDaoUser daoUser = CrudDaoUser.getInstance();
//		  daoUser.save(user);
//		  
//		  Optional<User> user2 = daoUser.find("16");
//	
//		  assertEquals(user, user2);
//	    }
//	
	
	
}
