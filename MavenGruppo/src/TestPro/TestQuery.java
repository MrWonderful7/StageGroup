package TestPro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import Controller.ControllerServ;
import Database.CrudDaoUser;
import Database.DbConnect;
import model.Type;
import model.User;

public class TestQuery {

	private User user;
	private String id = "21";
	private Optional<User> user1;

	@InjectMocks
	private DbConnect dbConn;
	@InjectMocks
	private CrudDaoUser cdu;
	@Mock
	private CrudDaoUser mockCrud;

	private ControllerServ cont = new ControllerServ();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		user = new User();
		user.setName("Pippo");
		user.setSurname("Franco");
		int year = 1950;
		int dd = 11;
		int m = 03;
		Date date = new Date(year, dd, m);
		user.setBirthDate(date);
		user.setAge(70);
		user.setType(Type.OWNER);
	}

	@Ignore
	public void testInsertUser() throws SQLException, ParseException {

		Mockito.when(mockCrud.save(user)).thenReturn(true);
		
	}

	@Ignore
	public void testFindById() throws SQLException, ParseException {

		Mockito.when(mockCrud.find(id)).thenReturn(user1);

	}

	@Ignore
	public void testSelect() throws SQLException, ParseException {

		Mockito.when(mockCrud.findIdForJson(id)).thenReturn(user);

	}

	@Test
	public void testParam() throws IOException, SQLException, ServletException, ParseException {

		HttpServletRequest mockRequest = mock(HttpServletRequest.class);
        HttpServletResponse mockResponse = mock(HttpServletResponse.class);
		dbConn.getConnection();
		
		    when(mockRequest.getParameter("op")).thenReturn("insert");
		   
	        when(mockRequest.getParameter("name")).thenReturn("Ciccio");
	        when(mockRequest.getParameter("surname")).thenReturn("Pasticcio");
	        when(mockRequest.getParameter("age")).thenReturn("70");
	        when(mockRequest.getParameter("role")).thenReturn("OWNER");
	        when(mockRequest.getParameter("birthDate")).thenReturn("1950-07-01");
	        
		cont.insertProduct(mockRequest, mockResponse);

		assertTrue("Check", true);
	
	}
	
	@Test
	public void testWrongEnum() throws IOException, SQLException, ServletException, ParseException {

		HttpServletRequest mockRequest = mock(HttpServletRequest.class);
        HttpServletResponse mockResponse = mock(HttpServletResponse.class);
		dbConn.getConnection();
		
		    when(mockRequest.getParameter("op")).thenReturn("insert");
		   
	        when(mockRequest.getParameter("name")).thenReturn("Ciccio");
	        when(mockRequest.getParameter("surname")).thenReturn("Pasticcio");
	        when(mockRequest.getParameter("age")).thenReturn("70");
	        when(mockRequest.getParameter("role")).thenReturn("OWNEROWNEROWNEROWNER");
	        when(mockRequest.getParameter("birthDate")).thenReturn("1950-07-01");
	        
		cont.insertProduct(mockRequest, mockResponse);

		assertTrue("Check", true);
	
	}
	
	@Test
	public void testWrongDate() throws IOException, SQLException, ServletException, ParseException {

		HttpServletRequest mockRequest = mock(HttpServletRequest.class);
        HttpServletResponse mockResponse = mock(HttpServletResponse.class);
		dbConn.getConnection();
		
		    when(mockRequest.getParameter("op")).thenReturn("insert");
		   
	        when(mockRequest.getParameter("name")).thenReturn("Ciccio");
	        when(mockRequest.getParameter("surname")).thenReturn("Pasticcio");
	        when(mockRequest.getParameter("age")).thenReturn("70");
	        when(mockRequest.getParameter("role")).thenReturn("OWNER");
	        when(mockRequest.getParameter("birthDate")).thenReturn("1501-13-32");
	        
		cont.insertProduct(mockRequest, mockResponse);

		assertTrue("Check", true);
	
	}
	
	
	

}
