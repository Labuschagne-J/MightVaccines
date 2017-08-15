<?php
$db_conn = array('host' => 'localhost', 'user' => 'Tiaan7','pass' => 'admin123','database' => 'phplogin', );
$db = new SimpleDBClass($db_conn)

class SimpleDBClass

{
  public $isConn; 

  public $ShowQryErrors = 'on'; //show query error messages



  public function __construct( $db_conn = array('host' => 'localhost', 'user' => 'Tiaan7','pass' => 'admin123','database' => 'test', ) )  

  {

    $host = isset($db_conn['host']) ? $db_conn['host'] : 'localhost' ;

    $user = isset($db_conn['user']) ? $db_conn['user'] : 'root' ;

    $pass = isset($db_conn['pass']) ? $db_conn['pass'] : '' ;



    $database = isset($db_conn['database']) ? $db_conn['database'] : die('no database set') ;




    $connection = mysqli_connect($host, $user, $pass,$database);




    if (!$connection) 

    {


      die("Connection failed: " . mysqli_connect_error());

      return false;

    }

    if($connection)

    {



      $this->isConn = $connection;

    }

  }

  function Select($SQLStatement)

  {

   

      $db = new SimpleDBClass("host_name", "user_id", "password","database")

      $Qry = $db->Select( "SELECT * FROM Users WHERE site='codewithmark'")  

    $con =  $this->isConn;

    if (!$con) 

    {

      die("Connection failed in Select function - " . mysqli_connect_error());

    }


    if ($con) 

    {


      $q = $con->query($SQLStatement);




      if(!$q)

      {


        if($this->ShowQryErrors == 'on')

        {

          die( mysqli_error($con) );  

        }        

      }



      $row = $q->num_rows;




      if($row <1)

      {

        $result = $row;  

      }


      else if($row == 1)

      {

        $result = array($q->fetch_assoc());

      }


      else if( $row >1)

      {

        $d1 = array( $q->fetch_assoc());

        

        $d2= array();

        while ($row = $q->fetch_assoc()) 

        {

          $d2[] = $row;

        }


        $result = array_merge($d1 , $d2); 

      }


      return $result;

      }

  }






  //--->Insert - Start  

  function Insert($TableName, $row_arrays = array()  ) 

  { 

    

      $insert_arrays = array

      (

        'user_id' => "test1",

        'email_id' => 'otter@test.com',

        'user_name'=> 'Ruan'

      );

   
  

      $db = new SimpleDBClass("host_name", "user_id", "password","database")

      $Qry = $db->Insert('table',$insert_arrays);



    foreach( array_keys($row_arrays) as $key ) 

    {

      $columns[] = "$key";

      $values[] = "'" .  $row_arrays[$key] . "'";

    }


    $columns = implode(",", $columns);

    $values = implode(",", $values);



    $sql = "INSERT INTO $TableName ($columns) VALUES ($values)";

    

    $con =  $this->isConn;

    if (!$con) 

    {

      die("Connection failed in query function - " . mysqli_connect_error());

    }


    if($con)

    {

      $q = $con->query($sql);

      if(!$q)

      {  

        if($this->ShowQryErrors == 'on')

        {

          die( mysqli_error($con) );  

        }  

        $result =  0;

      }

      if($q)

      {

        $result =  $con->insert_id;      

      }

  

      return $result; 

    }

  }



  function Update($strTableName, $array_fields, $array_where)

  { 


      $strTableName = "TableName";





      $array_fields = array(

        'FieldName1' => CleanDBData(FieldValue1),

        'FieldName2' => CleanDBData(FieldValue2),

        'FieldName3' => CleanDBData(FieldValue3),

      );



      $array_where = array(    

        'rec_id' => 2,

        'rec_dt' => date("Y-m-d"),    

      );

      

      $db = new SimpleDBClass("host_name", "user_id", "password","database")

      $Qry = $db->Update('table', $array_fields, $array_where)

  

    foreach($array_fields as $key=>$value) 

    {

      if($key) 

      {

        $field_update[] = " $key='$value'";

      }

    }

    $fields_update = implode( ',', $field_update );


    foreach($array_where as $key=>$value) 

    {

      if($key) 

      {

        $field_where[] = " $key='$value'";

      }

    }

    $fields_where = implode( ' and ', $field_where );



    $SQLStatement = "UPDATE $strTableName  SET $fields_update WHERE $fields_where ";



    $con =  $this->isConn;


    if (!$con) 

    {

      die("Connection failed in query function - " . mysqli_connect_error());

    }



    if($con)

    {

      $q = $con->query($SQLStatement);

      if(!$q)

      { 



        if($this->ShowQryErrors == 'on')

        {

          die( mysqli_error($con) );  

        } 



        $result =  0;

      }

      if($q)

      {  

        $result = 1;

      }

   

      return $result; 

    }

  }


  function Delete($strTableName,$array_where)

  {

   /*
      $array_where = array(    

      'rec_id' => 2,

      'rec_dt' => date("Y-m-d"),

      );



      $db = new SimpleDBClass("host_name", "user_id", "password","database")

      $Qry = $db->Delete('table',$array_where);



    */

    

    foreach($array_where as $key=>$value) 

    {

      if($key) 

      {

        $field_where[] = " $key='$value' ";

      }

    }

    $fields_where = implode( ' and ', $field_where );


    $con =  $this->isConn;

 

    if (!$con) 

    {

      die("Connection failed in query function - " . mysqli_connect_error());

    }

  
    $QFindRec = "SELECT * FROM $strTableName WHERE $strFieldName='$strFieldDeleteValueEqualTo'";

    $QFindRec = "SELECT * FROM $strTableName WHERE $fields_where ";

    $QDeleteRec = "DELETE FROM $strTableName WHERE $fields_where";

    echo $QDeleteRec;

    

    if($con)

    {

      $q = $con->query($QDeleteRec);



      if($q)

      {

        $QDeleteRec = "DELETE FROM $strTableName WHERE $strFieldName='$strFieldDeleteValueEqualTo'";

        $QDeleteRec = "DELETE FROM $strTableName WHERE $fields_where";



        $con->query($QDeleteRec);



        $result = 1;

      }

      if(!$q)

      {   

        $result = 0;

      }

     

      return $result;

    }

  }



  function Qry($SQLStatement)

  {

      $db = new SimpleDBClass("host_name", "user_id", "password","database")

      $Qry = $db->Qry('select * from user where id=100');


    $con =  $this->isConn;

    

    if (!$con) 

    {

      die("Connection failed in query function - " . mysqli_connect_error());

    }

    

    if($con)

    {

      $q = $con->query($SQLStatement);

      

      if(!$q)

      {


        if($this->ShowQryErrors == 'on')

        {

          die( mysqli_error($con) );  

        } 

        $result = 0;

      }

      if($q)

      {       


        $result = 1;

      }

      return $result;

    }

  }

?>