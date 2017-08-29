<?php
include 'connection.php';

$stock_num = $_POST['stock_num'];



  $query = 'DELETE FROM inventory WHERE stock_num ="'.$stock_num.'"';
  
  
if ($conn->query($query)) {
    $msg = array("status" =>1 , "msg" => "Record Deleted successfully");
} else {
    echo "Error: " . $query . "<br>" . mysqli_error($conn);
} 
 
$json = $msg;
 
header('content-type: application/json');
echo json_encode($json);

@mysqli_close($conn)


//header("Refresh:2; url=List.html");

?>