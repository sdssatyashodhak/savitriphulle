<?php
require "connect_to_mysql.php";

$uname=$_POST["id"];
$ans=$_POST["ans"];
$npass=$_POST["npass"];
$s="select * from registration1 where (St_id='".$uname."' and ans='".$ans."')";
$result=mysql_query($s);
$cont=mysql_num_rows($result);

if($cont>0)
{
   	$encrypt_pass=md5($_POST['npass']);
	$sql="update registration1
	set St_password='$encrypt_pass'
	where (St_id='".$_POST["id"]."')";

	if(!mysql_query($sql)){
    $response = array();
    $response["success"] = false;  
    
    echo json_encode($response);
	die();
	}

else {	
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
	}

}
else
{

    $response = array();
    $response["success"] = false;  
    
    echo json_encode($response);
	die();
}

?>
