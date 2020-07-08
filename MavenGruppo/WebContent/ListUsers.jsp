<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c-rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="com.google.gson.Gson" %>
     <%@ page import="com.google.gson.JsonObject" %>
    
    <%@page import="org.json.JSONArray"%>
  <%@page import="org.json.JSONObject"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

/*
	JSONObject json = new JSONObject();
   	json = (JSONObject) request.getAttribute("listProducts");
    out.print(json);
    out.flush();
 
   */
   
   
   
   String j = (String)request.getAttribute("listProducts");

   JSONArray array = new JSONArray(j);
   
   for(int i = 0; i< array.length(); i++){
	 
	   out.println(array.get(i));
	   out.println("First");
   }

%>



    <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
             
                <th>Name</th>
                
            	
            </tr>
            </thead>
            <c:forEach items="${listProducts}" var="product">
                <tr>
                    
                    <td>${product}</td>
                   
            
                </tr>
            </c:forEach>
        </table>




</body>
</html>