<?php
  
require_once 'config.php';

    class DB_Connection{
	
	private $connect;
	function _construct()
	{
		$this->connect = mysqli_connect(hostname,username,password,dn_name) or die("DB not connected");
	}
	
	public function get_connection()
	{
		return $this->conect;
	}
	}

?>