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
<link href="./CSS/TableStyle.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<head>
<style>
.scrollit {
    overflow:scroll;
    height:500px;
}
</style>

</head>
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
	
	
	<h2>Are you looking for a name?</h2>


<form name="sub" action="ControllerServS" id="sub">
     <font face="verdana" size="2">Name:</font>
     <input type="text" name="name" id="name" size="30" />
      
     <input onclick="callAjax();"  type="button" id="ibutton" value="search"/>
   </form>


<br/><br/>

<div id="loading"></div>
<table id="contentTable">
<tr>
<th>Id</th><th>Name</th><th>Surname</th><th>BirthDate</th><th>Age</th><th>Role</th>
</tr> 
</table>



<div class="scrollit">

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
	
</div>


<script type="text/javascript">

function callAjaxx() {
	var ajaxdata = $("#name").val();
    var value ='name='+ajaxdata;
    $.ajax({
    	
       url:'ControllerServ',
       data: value,
       type:'get',
       cache:false,
       success:function(data){ 
       },
       error:function(){
         alert('error');
       }
       
    }
);
}

function callAjax() {

	callAjaxx();
	
document.getElementById('loading').innerHTML = "Loading Data...";

httpRequest = new XMLHttpRequest();

if (!httpRequest) {
console.log('Unable to create XMLHTTP instance');
return false;
}

httpRequest.open('GET', 'ControllerServ');
httpRequest.responseType = 'json';
httpRequest.send();
httpRequest.onreadystatechange = function() {
if (httpRequest.readyState === XMLHttpRequest.DONE) {

document.getElementById('loading').innerHTML = "";

if (httpRequest.status === 200) {

var array = httpRequest.response;
for (var i=0; i< array.length; i++) {

var table = document.getElementById('contentTable');
var row = table.insertRow(table.rows.length);
var cell1 = row.insertCell(0);
var cell2 = row.insertCell(1);
var cell3 = row.insertCell(2);
var cell4 = row.insertCell(3);
var cell5 = row.insertCell(4);
var cell6 = row.insertCell(5);



var id = document.createTextNode(array[i].id);
var name = document.createTextNode(array[i].name);
var surname = document.createTextNode(array[i].surname);
var birthDate = document.createTextNode(array[i].birthDate);
var age = document.createTextNode(array[i].age);
var type = document.createTextNode(array[i].type);

cell1.appendChild(id);
cell2.appendChild(name);
cell3.appendChild(surname);
cell4.appendChild(birthDate);
cell5.appendChild(age);
cell6.appendChild(type);

}
} else {
console.log('Something went wrong..!!');
}
}
}
}

</script>

</html>