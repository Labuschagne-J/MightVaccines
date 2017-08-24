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
	
		<!--[Forgot password screen]-->

		<div class = "col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 Screen ForgotPassword_Screen" style = "display:none1;margin-top:50px;">

			<!--[Panel]-->   

			<div class = "panel panel-info">

				<!--[Panel heading]-->  

				<div class = "panel-heading">

					<div class = "panel-title">Forgot Password</div>

					<div style = "float:right; font-size: 85%; position: relative; top:-10px">
    
						<a class = "ScreenMenu" menuid = "Login" href = "Index.php">Login</a>
    
					</div>

				</div>

				<!--[Panel body]-->  

				<div class = "panel-body">
		
					<div style = "display:none" class = "alert alert-danger ForgotPasswordAlert">

						Error:
  
					</div>
       
					<!--[Signup form]-->
		
					<form class = "form-horizontal ForgotPassword_Form" role = "form">

						<!--[Login email]-->

						<div class = "form-group">

							<label for = "email" class = "col-md-3 control-label">Email</label>

							<div class = "col-md-9">

								<input type = "text" class = "form-control ForgotPassword_Email" placeholder = "Email Address">

							</div>

						</div>

						<!--[Return to login button]-->

						<div class = "form-group">                                                      

							<div class = "col-md-offset-3 col-md-9">

								<button type = "button" class = "btn btn-info ReturnLogin_Btn">Back to Login</button>
    
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

				<!--[Panel body]-->  
      
			</div>

		</div>

		
	</div>
</body>
</html>