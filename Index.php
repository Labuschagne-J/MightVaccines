<!DOCTYPE html>
<html lang = "en">
<head>
	<title>PHP Login System</title>
	<meta charset = "utf-8">
	<meta name = "viewport" content = "width = device-width, initial-scale = 1">
	
	<script src = "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

	<script src = "https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js" ></script>

	<script src = "https://apimk.com/cdn/awesome-functions/awesome-functions-mini.js"></script>

	<link rel = "stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">

	<link rel = "stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">



</head>
<body>

	<div class = "container">

		<div class = "MsgAlert"> </div>
		<!--[Login screen]-->

		<div class = "col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 Screen Login_Screen" style = "display:none1;margin-top:50px;">
	
			<!--[Start panel]-->   

			<div class = "panel panel-info">

				<!--[Panel heading]-->  

				<div class = "panel-heading">

					<div class = "panel-title">Login</div>


					<div style = "float:right; font-size: 85%; position: relative; top:-10px">
  
						<a class = "ScreenMenu" menuid = "ForgotPassword" href = "Forgot_Password.php">Forgot Password???</a>
    
					</div>
    
				</div>	

				<!--[Panel body]-->  

				<div class = "panel-body">
        

					<div style = "display:none" class = "alert alert-danger LoginAlert">


						Error:

					</div>
    
					<!--[Signup form]-->

					<form class = "form-horizontal Login_Form" role = "form">

						<!--[Login email]-->

						<div class = "form-group">
   
							<label for = "Emp_Email" class = "col-md-3 control-label">Email</label>

							<div class = "col-md-9">

								<input type = "text" class = "form-control Login_Email" placeholder = "Enter Email Address">
    
							</div>

						</div>
       
						<!--[Signup password]-->        

						<div class = "form-group">

							<label for = "Emp_Password" class = "col-md-3 control-label">Password</label>

							<div class = "col-md-9">

								<input type = "password" class = "form-control Login_Password" placeholder = "Password">
    
							</div>

						</div>

						<!--[Company Login button]-->

						<div class = "form-group">                                                      

							<div class = "col-md-offset-3 col-md-9">
  
								<button type = "button" class = "btn btn-info Login_Btn">Login</button>
								
							</div>	

						</div>

						<div class = "form-group">

							<div class = "col-md-12 control"> 

								<div style = "border-top: 1px; solid#888; padding-top:15px; font-size:85%">
        
									Are you lost??? <a class = "ScreenMenu" menuid = "CompInfo" href = "Information.html">See Company Information???</a>
        
								</div>

							</div>	

						</div>    
        
					</form>

				</div>
     
			</div>
 
		</div>
	
		
	</div>
</body>
</html>