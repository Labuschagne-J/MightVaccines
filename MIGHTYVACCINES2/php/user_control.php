<?php 

require_once 'connection.php';
header('Content-Type: application/json');


class User {
	
	private $db;
	private $connection;
	
	function _construct()
	{
		$this->db = new DB_Connection();
		$this->connection = $this->db->get_connection();
		
	}
	public function does_user_exist($password,$username)
	{
		$query = "SELECT * from mv where password = '$password' and username = '$username'";
		$result = mysqli_query($this->connection, query);
		if(mysqli_num_rows($result) > 0)
		{
			$json['success'] = 'Welcome' .$username;
			echo json_encode($json);
			mysqli_close($this->connection);
		}
		else{
			$query =  "INSERT into mv(password,username) values ('$password','$username')";
			$is_inserted = mysqli_query($this->connection,$query);
			if($is_inserted==1)
			{
				$json['success'] = 'Account created, welcome '.$username;
				
			}
			else{
				$json['error'] = 'Wrong password';
			}
			
			echo json_encode($json);
			mysqli_close($this->connection);
		}
	}
}

		$user = new User();
		if(isset($_POST['password'],$_POST['username']))
		{
			$username = $_POST['password'];
			$password = $_POST['username'];
			
			if(!empty($password) && !empty($username))
			{
				$encrypted_password = md5($password);
				$user -> does_user_exist($username,$encrypted_password);
			}
			else{
				echo json_encode("You must fill both fields");
			}
		}
	
?>

