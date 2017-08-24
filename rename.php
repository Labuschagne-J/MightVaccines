

 <?php
 
  include "connection.php";
 
mysqli_query($conn, "UPDATE inventory SET quantity = '".mysqli_real_escape_string($conn, $_POST['quantity'])."' WHERE stock_num = ".intval($_POST['stock_num']));

if (isset($_POST['quantity'])) {
   mysqli_query($conn, "UPDATE inventory SET quantity = '".mysqli_real_escape_string($conn, $_POST['quantity'])."' WHERE stock_num = ".intval($_POST['stock_num']));
}

header('Location: List.html');

mysqli_close($conn);


?>