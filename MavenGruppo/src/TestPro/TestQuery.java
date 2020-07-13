package TestPro;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import Database.CrudDaoUser;
import model.Type;
import model.User;

public class TestQuery {

	private User user;
	private String id ="21";
	private Optional<User> user1;


	@InjectMocks
	private CrudDaoUser cdu;
	@Mock
	private CrudDaoUser mockCrud;
	
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

	@Test
	public void testInsertUser() throws SQLException, ParseException {
		
	
		Mockito.when(mockCrud.save(user)).thenReturn(true);
		System.out.println(user.toString());

	}
	
	@Test
	public void testFindById() throws SQLException, ParseException {
		
	
		Mockito.when(mockCrud.find(id)).thenReturn(user1);

	}
	
	@Test
	public void testSelect() throws SQLException, ParseException {
		
	
		Mockito.when(mockCrud.findIdForJson(id)).thenReturn(user);
		

	}

}
