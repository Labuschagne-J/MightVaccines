	
	<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
    <meta name="author" content="GeeksLabs">
    <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>List</title>

    <!-- Bootstrap CSS -->    
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="css/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <!-- font icon -->
    <link href="css/elegant-icons-style.css" rel="stylesheet" />
    <link href="css/font-awesome.min.css" rel="stylesheet" />
    <!-- Custom styles -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet" />

  </head>
  
  </html>
	
	
	
	
	
	<?php 
	
	require('connection.php');
	
   $sql = "SELECT * FROM inventory";

 $result = mysqli_query($conn,$sql)or die(mysqli_error());
 

 echo "<table>";
 echo "<tr><th>Number</th><th>Name</th><th>Quantity</th></tr>";

while($row = mysqli_fetch_array($result)) {
    $stock_num = $row['stock_num'];
    $stock_name = $row['stock_name'];
    $quantity = $row['quantity'];
    echo "<tr><td style='width: 200px;'>".$stock_num."</td><td style='width: 600px;'>".$stock_name."</td><td>".$quantity."</td></tr>";
} 

echo "</table>";
mysqli_close($conn);