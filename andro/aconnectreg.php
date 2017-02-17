<?php
require "connect_to_mysql.php";

$value=$_POST['id'];
$value1=$_POST['fullname'];
$value2=$_POST['course'];
$p1=$_POST['year'];
$p2=$_POST['month'];
$p3=$_POST['date'];
$value3="$p1-$p2-$p3";
$value4=$_POST['add'];
$value5='Central';
$value6=$_POST['pass'];
$value7=$_POST['acedemicyear'];
$value8=$_POST['cast'];
$encrypt_pass=md5($value6);
$value11=$_POST['from'];
$value12=mysql_real_escape_string($_POST['que']);
$value13=$_POST['ans'];
$value14=$_POST['phon'];
$value15=$_POST['email'];

$sql="INSERT INTO registration1 (St_id,St_name,St_course,St_DOB,St_add,RailwayLine,St_password,Gender,Cast,starting_station,Contact,email,question,ans) 
VALUES($value,'$value1','$value2','$value3','$value4','$value5','$encrypt_pass','$value7','$value8','$value11','$value14','$value15','$value12','$value13')";

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

mysql_close();
?>