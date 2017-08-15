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
?>

