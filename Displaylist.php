	<?php 
	
	include('connection.php');

   $sql = "SELECT * FROM inventory";

 $result = $conn->query($sql);

 

while($row = mysqli_fetch_assoc($result)) {
   $msg[] = array("stock_num" => $row['stock_num'], "stock_name" => $row['stock_name'], "quantity" => $row['quantity']);
} 

$json = $msg;
header('content-type: application/json');
$get =json_decode($_POST('$stock_name'));
$stock_num = $get->stock_name;


 
@mysqli_close($conn);
 ?>