<?php
include 'connection.php';
$stock_num = $_POST['stock_num'];
$stock_name = $_POST['stock_name'];
$quantity = $_POST['quantity'];



$select = "insert into inventory(stock_num,stock_name,quantity) values ('".$stock_num."','".$stock_name."','".$quantity."')";
if($conn->query($select))
{
	$msg = array ("status" =>1, "msg" => "Your record is successfully inserted");
}
else{
	echo "Error: " .$select . "<br>" . mysqli_error($conn);
}

$json = $msg;

header('content-type: application/json');
echo json_encode($json);



header("Refresh:2; url=Edit.html");




?>