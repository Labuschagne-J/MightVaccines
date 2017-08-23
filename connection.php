<?php
$host = "localhost";
$username = "root";
$password = "";
$db_name = "test";
$tbl_name = "inventory";
$conn = mysqli_connect("$host","$username","$password") or die ("cannot connect");
mysqli_select_db($conn,$db_name) or die ("cannot select DB");
?>

