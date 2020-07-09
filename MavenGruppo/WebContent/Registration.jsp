<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<link href="RegStyle.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">

<div class='internalBox'>
  <form action="ControllerServ" method="POST" name="dati">
             <input type=hidden name="op" value="register_submit">
	
		<div class='box'>
			<div class='rowOne'>
				<label class='words'>User Name</label>
				<div class="myInput">
					<img src="Images\userid.png" class='imgId' /> 
					<input name="acc" class='restyle'></input>
				</div>
			</div>
			
			<div class='rowOne'>
                        <label class='words'>E-Mail</label>
                        <div class="myInput">
                            <img src="Images\mail.png" class='imgId' />
                  <input name="email"  class='restyle' ></input>
                        </div>
			<div class='rowTwo'>
				<label class='words'>Password</label>
				<div class="myInput">
					<img src="Images\pw.png" class='imgId' />
					 <input type='password'  name="pass" class='restyle'></input>
				</div>
				<div class='buttonRow'>
					  <button type="submit" value="register" name= "register_submit">
					  </button>
				</div>
			</div>
		</div>
	</form>


</div>
</html>