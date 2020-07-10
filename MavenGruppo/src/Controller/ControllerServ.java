package Controller;

import java.awt.RenderingHints.Key;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Database.CrudDaoUser;
import Database.checkUserPass;

import model.Type;
import model.User;


@WebServlet("/ControllerServ")
public class ControllerServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ControllerServ() {
        super();
    }
  private CrudDaoUser daoUser= CrudDaoUser.getInstance();
    
    
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doPost(request, response);
				}


			 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String user = request.getParameter("username");
	    String pass = request.getParameter("password");
		
		String op = request.getParameter("op");
		
		try {
			switch(op) {
			
			case"register_submit":
				
			 String us = request.getParameter("acc");
			 
			if(checkUserPass.userExist(us) == true) {
				System.out.println("User exist, please insert another");
    			forward(request,response,"/AddUser.jsp");
			}else {
	    		
	    		String userNameRegister = request.getParameter("acc");
	    		String passwordRegister = request.getParameter("pass");
	    		String emailRegister = request.getParameter("email");
	    		
	    	if(checkUserPass.insertUser( userNameRegister,passwordRegister, emailRegister)== true) {
	    			System.out.println("adding successfully..");
	    				forward(request,response,"/MainPage.jsp");
	    		}else{
	    			System.out.println("we have a problem..");
	    				forward(request,response,"/Registration.jsp");
	    		}
			}
			
			case"login":
				if(checkUserPass.login(user, pass) == true) {
		    		System.out.println("it s ok..:D");
		    			session.setAttribute("user", user);
		    			session.setMaxInactiveInterval(300);
		    				forward(request,response,"/HomePage.jsp");
		    	} 
		    	else {
		    		System.out.println("non entra");
		    			forward(request,response,"/MainPage.jsp");
		    	}
				break;
			
			case"logout":
				session.invalidate();
		    	forward(request,response,"/MainPage.jsp");
				break;
			
			case"edit":
				showEditForm(request, response);
				break;
			case"insert":
				insertProduct(request, response);
				break;
			case "listUsers":
				listUsers(request, response);
				break;
				
		
	}
	}catch(Exception e) {
		System.out.println(e);
	}
		}
			
	
	
			 private void listUsers(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, JSONException, org.json.simple.parser.ParseException {
		
				 RequestDispatcher dispatcher = request.getRequestDispatcher("UserList.jsp");
				 

				 
				List<User> l = new ArrayList();
				l = daoUser.findAll();
				
//				String jsonn = new Gson().toJson(l); 
//				 
//				JSONArray array = new JSONArray(jsonn);
//				 
//				for(int i = 0; i< array.length(); i++){
//					 System.out.println(array.get(i));
//				 }

				request.setAttribute("listProducts", l);
//					JsonParser jsonParser = new JsonParser();
//					JsonObject objectFromString = jsonParser.parse(jsonn).getAsJsonObject();
//					JSONParser parser = new JSONParser();
//					JSONObject json = (JSONObject) parser.parse(jsonn);
//					JsonObject jsonObject = new JsonParser().parse(jsonn).getAsJsonObject();
//					JSONArray array = new JSONArray(jsonn);
					
//					request.setAttribute("listProducts", array);
					
					dispatcher.forward(request, response);
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
					existingProduct.ifPresent(s -> request.setAttribute("product", s));
					disp.forward(request, response);
				}
			 
			 
//			 public JSONObject getJson(String id) throws SQLException, JSONException, org.json.simple.parser.ParseException {
//				 
//		 
//				Optional<User> list = Optional.empty();
//				list =  daoUser.find(id);
//				
//				String jsonn = new Gson().toJson(list);
//			
//				JsonObject jsonObject= null;
//				jsonObject = new JsonParser().parse(jsonn).getAsJsonObject();
//				JSONObject JSONObject = new JSONObject(jsonObject.toString());
//				
//				 return JSONObject;
//				 
//			 }
//			 
			 
			 
			 public JSONObject getJson(String id) throws SQLException, JSONException, org.json.simple.parser.ParseException {
				 
				 User user = new User();
				 user = daoUser.findIdForJson(id);
				 
				 try {
					
					String jsonn = new Gson().toJson(user);
					JsonObject jsonObject= null;
					jsonObject = new JsonParser().parse(jsonn).getAsJsonObject();
					JSONObject JSONObject = new JSONObject(jsonObject.toString());
					return JSONObject;
				 }catch(JSONException e) {
					 e.printStackTrace();
				 	}
				 return null;
				 }
			 

			 public JSONObject getJsonByImportAllList(String id) throws SQLException, ParseException {
					
				 
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
			 
			 
			 
			 public void insertProduct(HttpServletRequest request, HttpServletResponse response)
						throws SQLException, IOException, ServletException, ParseException{
				 RequestDispatcher dispatcher = request.getRequestDispatcher("/UserForm.jsp");
		
					String name = request.getParameter("name");
					String surname = request.getParameter("surname");
					String birthDate = request.getParameter("birthDate");
					int age =  Integer.parseInt(request.getParameter("age"));
					String roles = request.getParameter("role");
					Type type = Type.valueOf(roles);
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date date = sdf.parse(birthDate);
					
					
				
					Timestamp timestamp = new Timestamp(System.currentTimeMillis());
					
					
					User newUser = new User(name, surname, date, age, type,timestamp);
					daoUser.save(newUser);
					
					forward(request,response,"/HomePage.jsp");
	
		
	}
			 
			 

}





