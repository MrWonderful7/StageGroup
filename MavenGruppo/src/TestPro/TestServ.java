package TestPro;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import Controller.ControllerServ;
import Database.CrudDaoUser;
import Database.DbConnect;
import model.Type;
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
	  private ControllerServ cont = new ControllerServ();
	
	  @Before
	    public void setUp() throws Exception {
	        MockitoAnnotations.initMocks(this);
	     
		
			
//			assertNotNull(ds);
////	        when(c.prepareStatement(any(String.class))).thenReturn(stmt);
//	        when(ds.getConnection()).thenReturn(c);
//	        
	        int year = 1993;
	        int dd = 07;
	        int m = 01;
	        Date date = new Date(year, dd, m);
//	        
			 user = new User();
		     user.setAge(30);
			 user.setName("Johnny");
			 user.setSurname("Bravo");
			 user.setBirthDate(date);
			 user.setType(Type.OWNER);
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
	public void testParam() throws IOException, ServletException, SQLException, ParseException, JSONException, org.json.simple.parser.ParseException {
		
	
		 	HttpServletRequest mockRequest = mock(HttpServletRequest.class);
	        HttpServletResponse mockResponse = mock(HttpServletResponse.class);

	        when(mockRequest.getParameter("op")).thenReturn("insert");
	        when(mockRequest.getParameter("name")).thenReturn("admin");
	        when(mockRequest.getParameter("surname")).thenReturn("test");
	        when(mockRequest.getParameter("age")).thenReturn("30");
	        when(mockRequest.getParameter("role")).thenReturn("OWNER");
	        when(mockRequest.getParameter("birthDate")).thenReturn("01-01-2000");
	        
	        cont.insertProduct(mockRequest, mockResponse);
	 
	     
	        JSONObject jsonn = new JSONObject();
	        jsonn = cont.getJsonByImportAllList("73");
	        JSONObject json = new JSONObject(); 
	        json =  cont.getJson("73");
	        System.out.println(json);
	        JSONAssert.assertEquals("{name:\"Riccardo\"}", json, false);
	       String json1 = jsonn.get("name").toString();
			assertTrue("Riccardoo".equals(json1));
	        
	}
	
	@Test
	public void testJson() throws IOException, ServletException, SQLException, ParseException, JSONException, org.json.simple.parser.ParseException {
	
		 JSONObject json = new JSONObject(); 
	     json =  cont.getJson("73");
	     JSONAssert.assertEquals("{name:\"Apple\"}", json, false);
	     JSONAssert.assertEquals("{type:\"OWNER\"}", json, false);
	}
	
	
	
	 @Test
	    public void createUser() throws SQLException, ParseException {
	       
		  CrudDaoUser daoUser = CrudDaoUser.getInstance();
		  daoUser.save(user);
		  
		  Optional<User> user2 = daoUser.find("73");
		  assertEquals(user2, user2);
	    }
	
	
	

}
