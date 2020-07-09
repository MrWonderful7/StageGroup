<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<link href="signStyle.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">

<div class='internalBox'>
 <form action="ControllerServ" method="POST" name="dati">
 <input type="hidden" name="op" value="login">
	
		<div class='box'>
			<div class='rowOne'>
				<label class='words'>User Name</label>
				<div class="myInput">
					<img src="Images\userid.png" class='imgId' /> <input name="username"
						id="username" class='restyle'></input>
				</div>
			</div>
			<div class='rowTwo'>
				<label class='words'>Password</label>
				<div class="myInput">
					<img src="Images\pw.png" class='imgId' /> <input name="password"
						type='password' id="password" class='restyle'></input>
				</div>
				<div class='buttonRow'>
					<button class="submit" >Login</button>
				</div>
			</div>
		</div>
	

</form>
</div>

</html>