<?php
session_start();
require "connect_to_mysql.php";

$s= "SELECT * FROM registration1 where (St_id ='".$_POST['id']."' )" ;

$result=mysql_query($s);
$cont=mysql_num_rows($result);
$details=mysql_fetch_assoc($result);

    $response = array();
    $response["success"] = false;  
    
   if($cont>0){
        $response["success"] = true;  
        $response["name"] = $details['St_name'];
        $response["course"] = $details['St_course'];
        $response["address"] = $details['St_add'];  
        $response["contact"] = $details['Contact'];  
        $response["email"] = $details['email'];           
    }
    
    echo json_encode($response);
?>