<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="HomeStyle.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">

<div>

	<div class='mainBox'>
	
	<div class='line'>
		
			<label class='words'>Home Page</label> <label class='words'>Insert
				User</label> <label class='words'>Users List</label>

			<div class='date'>
				<%
					java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy hh:mm");
				%>
				<h5><%=df.format(new java.util.Date())%>
				</h5>
			</div>

		</div>
	
	
	
	
	</div>



</div>






</html>