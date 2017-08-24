<?php
$host = "localhost";
$username = "root";
$password = "";
$db_name = "test";
$tbl_name = "inventory";
$stock_num = $_POST['stock_num'];
$conn = mysqli_connect("$host","$username","$password") or die ("cannot connect");
mysqli_select_db($conn,$db_name) or die ("cannot select DB");

   if(! $conn ) {
      die('Could not connect: ' . mysqli_error());
   }
   echo 'Connected successfully<br>';
   $sql = ' DELETE FROM inventory WHERE stock_num = "'.$stock_num.'"';
   
   if (mysqli_query($conn, $sql)) {
      echo "Record deleted successfully";
   } else {
      echo "Error deleting record: " . mysqli_error($conn);
   }
   header("Refresh:1; url=List.html");
   mysqli_close($conn);






?>