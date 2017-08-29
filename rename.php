<?php
 
  include "connection.php";
 $quantity = $_POST['quantity'];
$query =  "UPDATE inventory SET quantity = '".$quantity."' WHERE stock_num = '".$quantity."'";

if ($conn->query($query)) {
  $msg = array("status" => 1, "msg" => "record updated" );
}
else{
	echo "error: " .$query . "<br>" . mysqli_error($conn);
}

$json =$msg;

header('content-type: application/json');
echo json_encode($json);
@mysqli_close($conn);


?>