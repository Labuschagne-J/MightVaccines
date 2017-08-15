<?php
$host = "localhost";
$username = "root";
$password = "";
$db_name = "test";
$tbl_name = "inventory";
$stock_num = $_POST['stock_num'];
$stock_name = $_POST['stock_name'];
$quantity = $_POST['quantity'];
$conn = mysqli_connect("$host","$username","$password") or die ("cannot connect");
mysqli_select_db($conn,$db_name) or die ("cannot select DB");
$select = "insert into inventory(stock_num,stock_name,quantity) values ('".$stock_num."','".$stock_name."','".$quantity."')";
$query1=mysqli_query($conn,$select);


print '<script type = "text"/javascript">';
print 'alert("the data is inserted")';
print '</script>';

mysqli_close($conn);

?>