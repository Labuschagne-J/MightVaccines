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