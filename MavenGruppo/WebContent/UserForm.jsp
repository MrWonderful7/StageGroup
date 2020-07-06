<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

   <html>
   <head>
   
   <script>
   $('.datepicker').datepicker({
	    format: 'mm/dd/yyyy',
	    startDate: '-3d'
	});
</script>
 
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.min.js"></script>
    
    
   </head>
   <body >
  
    <div class="container">

    <form class="well form-horizontal" action="ControllerServ" method="post"  name="form" data-toggle="validator" novalidate="true">
    <input type=hidden name="op" value="insert">
	<fieldset>


<legend><center><h2><b>Form</b></h2></center></legend><br>

<!-- Text input-->




<div class="form-group">
  <label class="col-md-4 control-label">Name</label>  
  <div class="col-md-4 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input  name="name"  placeholder="name" class="form-control"  type="text" required="required"   />
    </div>
  </div>
</div>

<!-- Text input-->

<div class="form-group">
  <label class="col-md-4 control-label" >surname</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input name="surname" placeholder="surname" class="form-control"  type="text" required="required">
    </div>
  </div>
</div>




<!-- Text input-->
       <div class="form-group">
  <label class="col-md-4 control-label">birthDate</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-cloud
"></i></span>

  <input name="birthDate" placeholder="birthDate" class="datepicker" data-date-format="YYYY-DD-MM" required="required" >
    </div>
  </div>
</div>


<!-- Text input-->
       
<div class="form-group">
  <label class="col-md-4 control-label">age</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-road"></i></span>
  <input name="age" placeholder="age" class="form-control" type="text" required="required" >
    </div>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label">role</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-road"></i></span>
  <input name="roles" placeholder="roles" class="form-control" type="text" required="required" >
    </div>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-4"><br>
    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<button type="submit"  name="login_submit" class="submit center-block btn btn-primary" >&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspSUBMIT <span class="glyphicon glyphicon-send"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</button>
  </div>
</div>

</fieldset>
</form>
</div>
  
    
    
  
    

     <script src="resources/js/jquery-1.11.3.min.js"></script>
     <script src="resources/js/bootstrap.min.js"></script>
    
    
       </body>
</html>
  