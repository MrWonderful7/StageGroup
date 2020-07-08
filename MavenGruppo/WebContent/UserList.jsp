<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<link href="TableStyle.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">



<div class='mainBox'>

	<table class='t'>

		<tr class='header'>
			<th class='words'>Id</th>
			<th class='words'>Name</th>
			<th class='words'>Surname</th>
			<th class='words'>BirthDate</th>
			<th class='words'>Age</th>
			<th class='words'>Role</th>
			<th class='words'>Info</th>
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


			</tr>
		</c:forEach>



	</table>
</div>





</html>