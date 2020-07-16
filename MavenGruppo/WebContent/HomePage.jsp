<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String user = (String) session.getAttribute("user");
if (user == null) {
%>
<jsp:forward page="/MainPage.jsp" />
<%
	return;
}
%>
<!DOCTYPE html>
<html>
<link href="./CSS/HomeStyle.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">



<div>

	<div class='mainBox'>

		<div class='line'>


			<a class='words' href="HomePage.jsp">Home Page</a> <a class='words'
				href="ControllerServ?op=listUsers">ListUsers</a> <a class='words'
				href="AddUser.jsp">Insert User</a>

			<div class='date'>
				<%
					java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy hh:mm");
				%>
				<h5><%=df.format(new java.util.Date())%>
				</h5>
			</div>
			<div class='interspace'>
				<a class='words' href="ControllerServ?op=logout">Logout</a>
			</div>
		</div>




	</div>

</div>

<div> 
<form action="ControllerServ" method="post">
                            <span class="icon"><i class="fa fa-search"></i></span>
                              <input type=hidden name="op" value="search">
                            <input type="search" id="search" name="search" placeholder="Search"/>
                        </form>
 

</div>


<div>


       <table class='t'>
            <thead>
            <tr class="bg-success">
             
                <th>Name</th>
                <th>Description</th>
            
            </tr>
            </thead>
            <c:forEach items="${userr}" var="product">
                <tr>
                    
                    <td>${product.id}</td>
                    <td>${product.surname}</td>
                   
                    
                    
                   
                </tr>
            </c:forEach>
        </table>
</div>



</html>