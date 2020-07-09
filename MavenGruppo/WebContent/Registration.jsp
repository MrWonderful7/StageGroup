<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<link href="RegStyle.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">

<div class='internalBox'>

	
		<div class='box'>
			<div class='rowOne'>
				<label class='words'>User Name</label>
				<div class="myInput">
					<img src="Images\userid.png" class='imgId' /> <input name="userId"
						id="userName" class='restyle'></input>
				</div>
			</div>
			
			<div class='rowOne'>
                        <label class='words'>E-Mail</label>
                        <div class="myInput">
                            <img src="Images\mail.png" class='imgId' />
                            <input name="mail" id="userName" class='restyle' ></input>
                        </div>
			<div class='rowTwo'>
				<label class='words'>Password</label>
				<div class="myInput">
					<img src="Images\pw.png" class='imgId' /> <input name="pwr"
						type='password' id="userName" class='restyle'></input>
				</div>
				<div class='buttonRow'>
					<button class="submit" onclick="">Sign In</button>
				</div>
			</div>
		</div>
	


</div>
</html>