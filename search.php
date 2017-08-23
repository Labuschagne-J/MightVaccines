 <?php
    $con= new mysqli("localhost","root","","test");
  $stock_num = $_POST['stock_num'];


    // Check connection
    if (mysqli_connect_errno())
      {
      echo "Failed to connect to MySQL: " . mysqli_connect_error();
      }

$result = mysqli_query($con, "SELECT * FROM inventory
    WHERE stock_num LIKE '%{$stock_num}%'");

while ($row = mysqli_fetch_array($result))
{
        echo $row['stock_num'] . " " . $row['stock_name'] ." " . $row['quantity'];
        echo "<br>";
}
    mysqli_close($con);
    ?>


