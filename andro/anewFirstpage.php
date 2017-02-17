<?php
require "connect_to_mysql.php";

    /*$id=1;
    $upassword=md5('1');*/
    $id = $_POST["uname"];
    $upassword=md5($_POST["upassword"]);


$s="select * from registration1 where (St_id='".$id."' and St_Password='".$upassword."')";

$result=mysql_query($s);
$cont=mysql_num_rows($result);
$details=mysql_fetch_assoc($result);

       
    $response = array();
    $response["success"] = false;  
    
   if($cont>0){
        $response["success"] = true;  
        $response["St_id"] = $details['St_id'];
        $response["starting_station"] = $details['starting_station'];
        $response["St_DOB"] = $details['St_DOB'];
    }
    
    echo json_encode($response);
?>
