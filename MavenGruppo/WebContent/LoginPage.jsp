<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:p="http://primefaces.org/ui">

<h:head>
<link rel="stylesheet" href="%PATH%/theme.css" /></link>
<link rel="stylesheet" type="text/css" href="%PATH%/font-awesome.css" /></link>
<link rel="stylesheet" href="%PATH%/jquery-ui.css" /></link>
<link rel="stylesheet" href="%PATH%/primeui.min.css"></link>
<script type="text/javascript" src="%PATH%/jquery.js"></script>
<script type="text/javascript" src="%PATH%/jquery-ui.js"></script>
<script type="text/javascript" src="%PATH%/primeui.min.js"></script>
</h:head>

<h:outputStylesheet library="css" name="./CSS/signStyle.css"/>



<p:panel class='mainBox'></p:panel>
<h:form action="ControllerServ" method="POST" name="dati">
	<p:inputText type="hidden" name="op" value="login" />
	<p:panel class='box'>
		<p:panel class='rowOne'>
			<p:message class='words'>User Name</p:message>
			<p:panel class="myInput">
				<p:graphicImage src="Images\userid.png" class='imgId' />
				<p:inputText name="username" id="username" class='restyle'></p:inputText>
			</p:panel>
		</p:panel>
		<p:panel class='rowTwo'>
			<p:message class='words'>Password</p:message>
			<p:panel class="myInput">
				<p:graphicImage src="Images\pw.png" class='imgId' />
				<p:inputText name="password" type='password' id="password"
					class='restyle'></p:inputText>
			</p:panel>
			<p:panel class='buttonRow'>
				<button class="submit">Login</button>
			</p:panel>


			<a class='words' href="Registration.jsp">Create Account</a>

		</p:panel>
	</p:panel>




</h:form>


</html>