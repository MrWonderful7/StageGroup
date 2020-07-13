<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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






</html>