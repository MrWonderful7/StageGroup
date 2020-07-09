<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<link href="AddStyle.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">




<div class='mainBox'>


<div class='line'>

			
			 <a class='w' href="HomePage.jsp">Home Page</a>
			 <a class='w' href="ControllerServ?op=listUsers">ListUsers</a>
			<div class='date'>
				<%
					java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy hh:mm");
				%>
				<h5><%=df.format(new java.util.Date())%>
				</h5>
			</div>

		</div>

	<div class='space'></div>
	<div class='box'>
		<div class='rowLine'>
			<label class='words'>New User</label>
		</div>
 			<form action="ControllerServ" method="POST" name="dati">
            <input type=hidden name="op" value="register">

		<div class='row'>
			<label class='word'>Name</label> <input class='in'></input>
		</div>

		<div class='row'>
			<label class='word'>Surname</label> <input class='in'></input>
		</div>
		<div class='row'>
			<label class='word'>BirthDate</label> <input class='in'></input>
		</div>
		<div class='row'>
			<label class='word'>Age</label> <input class='in'></input>
		</div>
		<div class='row'>
			<label class='word'>Role</label> <input class='in'></input>
		</div>

		<div class ='block'>
			<button class='btn'>ADD</button>
		</div>
</form>
	
</div>
</div>















</html>