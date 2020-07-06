package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import Database.CrudDaoUser;
import model.Type;
import model.User;

/**
 * Servlet implementation class ControllerServ
 */
@WebServlet("/ControllerServ")
public class ControllerServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
    public ControllerServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    private CrudDaoUser daoUser= CrudDaoUser.getInstance();
    
    
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String op = request.getParameter("op");
		
		try {
			switch(op) {
			
			case"edit":
				showEditForm(request, response);
				break;
			case"insert":
				insertProduct(request, response);
				break;
				
		
	}
	}catch(Exception e) {
		
	}
		}
			
			 private void forward(HttpServletRequest request, HttpServletResponse response, String page) 
				       throws ServletException, IOException
				    {
				        ServletContext sc = getServletContext();
				        RequestDispatcher rd = sc.getRequestDispatcher(page);
				        rd.forward(request,response);
				  }
			 
			 
			 private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
						throws SQLException, IOException, ServletException{
					String id = request.getParameter("opp");
					Optional<User> existingProduct = daoUser.find(id);
					RequestDispatcher disp = request.getRequestDispatcher("/UserForm.jsp");
//					existingProduct.ifPresent(s -> request.setAttribute("product", s));
					disp.forward(request, response);
				}
			 
			 

			 public JSONObject getJson(String id) throws SQLException, ParseException {
					
				 
					List<User> list = new ArrayList();
					list = daoUser.findAll();
					
					String jsonn = new Gson().toJson(list);
					try{
						 JSONArray array = new JSONArray(jsonn);
						 for(int i = 0; i < array.length();i++) {	 
							 JSONObject obj = array.optJSONObject(i);
							 if(obj.has("id")) {
								  int idInt = obj.getInt("id");
								  String str2 = Integer.toString(idInt);
								  	if(str2.equalsIgnoreCase(id)){
									  return obj;
								  }	
							 }
						 }
					}catch(JSONException e){
						e.printStackTrace();
						}
					return null;
					}
			 
			 
			 
			 
			 private void insertProduct(HttpServletRequest request, HttpServletResponse response)
						throws SQLException, IOException, ServletException, ParseException{
				 RequestDispatcher dispatcher = request.getRequestDispatcher("/UserForm.jsp");
		
					String name = request.getParameter("name");
					String surname = request.getParameter("surname");
					String birthDate = request.getParameter("birthDate");
					int age =  Integer.parseInt(request.getParameter("age"));
					String roles = request.getParameter("roles");
					Type type = Type.valueOf(roles);
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date date = sdf.parse(birthDate);
					
					User newUser = new User(name, surname, date, age, type);
					daoUser.save(newUser);
					
					forward(request,response,"/home.jsp");
					

				}


			 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
