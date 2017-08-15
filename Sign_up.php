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


<!--	
	<link rel = "stylesheet" href = "https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/css/bootstrap.min.css">
	
	<link rel = "stylesheet" href = "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


	<script src = "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js" type = "text/javascript"></script>
	
	<script src = "https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/js/bootstrap.min.js" type = "text/javascript"></script>
	
	<script src = "https://awesomefunctions.com/cdn/awesome-functions-min.js" type = "text/javascript"></script>
	
	
	<script type = "text/javascript">

		$(document).ready(function()
		{
		//$('.Screen').hide();
	
		//show signup screen
	
		//$('.Signup_Screen').show();
	
		$("ScreenMenu").click(function()
		{
		$('.Screen').hide();
		
		var MenuId = $(this).attr('menuid');
		
			if(MenuId == "Login")
			{
				$('.Login_Screen').show();
			}
		
		
			else if(MenuId == "ForgotPassword")
			{
				$('.ForgotPassword_Screen').show();
			}
		
			else if(MenuId == "Signup")
			{
				$('.Signup_Screen').show();
			}
			console.log(MenuId);
		});
	
	});
	</script>
	-->
</head>
<body>

	<div class = "container">

		<div class = "MsgAlert"> </div>

		<!--[sing up screen]-->

		<div class = "col-md-6 col-md-offset-3 col-sm-offset-2 Screen Signup_Screen" style = "display:none1;margin-top:50px;">

			<!--[Start panel]-->

			<div class = "panel panel-info">

				<!--[Start panel heading]-->

				<div class = "panel-heading">

					<div class = "panel-title">Sign Up</div>

					<div Style = "float:right; font-size: 85%; position: relative; top:-10px">
						<a class = "ScreenMenu" menuid = "Login" href = "#login">Log In</a>
					</div>
					
				</div>
				<!--[Start panel body]-->

				<div class = "panel-body">

					<div style = "display:none" class = "alert alert-danger Signup-Alert">

						Error:

					</div>

					<!--[Start signup form]-->

					<form class = "form-horizontal Signup_Form" role = "form">

						<!--[Start name signup]-->
					
						<div class = "form-group">

							<label for = "Emp_Name" class = "col-md-3 control-label">Name</label>

							<div class = "col-md-9">

								<input type = "text" class = "form-control Signup_EmpName" placeholder = "Enter Name">
	
							</div>

						</div>

						<!--[Start surname signup]-->

						<div class="form-group">

							<label for = "Emp_Surname" class = "col-md-3 control-label">Surname</label>

							<div class = "col-md-9">

								<input type = "text" class = "form-control Signup_EmpSurname" placeholder = "Enter Surname">
	
							</div>

						</div>

						<!--[Start ID signup]-->

						<div class = "form-group">

							<label for = "Emp_ID" class = "col-md-3 control-label">ID</label>

							<div class="col-md-9">

								<input type="text" class="form-control Signup_EmpID" placeholder="Enter ID">
	
							</div>

						</div>
	
						<!--[Start email signup]-->

						<div class = "form-group">

							<label for = "Emp_Email" class = "col-md-3 control-label">Email</label>

							<div class = "col-md-9">
  	
								<input type = "text" class = "form-control Signup_EmpEmail" placeholder = "Enter Email Address">
  	
							</div>

						</div>
						
						<!--[Start number signup]-->

						<div class = "form-group">

							<label for = "Emp_Number" class = "col-md-3 control-label">Number</label>

							<div class = "col-md-9">
  	
								<input type = "text" class = "form-control Signup_EmpNumber" placeholder = "Enter Number">
  	
							</div>

						</div>
						
						<!--[Start password signup]-->

						<div class = "form-group">

							<label for = "Emp_Password" class = "col-md-3 control-label">Password</label>

							<div class = "col-md-9">
  	
								<input type = "password" class = "form-control Signup_EmpPassword" placeholder = "Enter Password">
  	
							</div>

						</div>

						<!--[Signup button]-->

						<div class = "form-group">  						                                        

							<div class = "col-md-offset-3 col-md-9">
  	
								<button type = "button" class = "btn btn-info Signup_Btn">Sign Up</button>
  	
							</div>

						</div>		
						<!--[Signup form]-->
					</form>		
				</div>
					<!--[Panel body]-->  
			</div>
 
		</div>

		
	</div>
</body>
</html>