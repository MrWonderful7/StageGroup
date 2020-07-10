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
<html lang="en">
<link href="TableStyle.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">



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

	</div>

	<div class='space'></div>

	<table class='t'>

		<tr class='header'>
			<th class='words'>Id</th>
			<th class='words'>Name</th>
			<th class='words'>Surname</th>
			<th class='words'>BirthDate</th>
			<th class='words'>Age</th>
			<th class='words'>Role</th>
			<th class='words'>Info</th>
			<th class='words'>Option</th>
			<th class='words'>Option</th>
		</tr>

		<c:forEach items="${listProducts}" var="product">
			<tr>

				<td class='block'>${product.id}</td>
				<td class='block'>${product.name}</td>
				<td class='block'>${product.surname}</td>
				<td class='block'>${product.birthDate}</td>
				<td class='block'>${product.age}</td>
				<td class='block'>${product.type}</td>
				<td class='block'>${product.creationTimestamp}</td>
				<td class='block'><a
					href="ControllerServ?op=edit&opp=<c:out value='${product.id}' />">Edit</a></td>
				<td class='block'><a
					href="ControllerServ?op=delete&opp=<c:out value='${product.id}' />">Delete</a></td>


			</tr>
		</c:forEach>



	</table>
</div>





</html>