 <?php
  include 'connection.php';
//Select data from database
 $stock_num = $_POST['stock_num'];
 
 $result = mysqli_query($conn, "SELECT * FROM inventory
	WHERE stock_num LIKE '%{$stock_num}%'");
	
	while ($row = mysqli_fetch_array($result))
	{
		$msg [] = array("stock_num"=> $row['stock_num'], "stock_name"=> $row['stock_name'], "quantity"=> $row['quantity']);
	}
	
$json = $msg;

header('content-type: application/json');
echo json_encode($json);


$character = json_decode(stripcslashes($_POST['r']));
echo $character[0]['stock_num'];
		
@mysqli_close($conn);

	
 ?>


