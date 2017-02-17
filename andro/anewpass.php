<?php
session_start();
require "connect_to_mysql.php";
	
$cdate=date('Y-m-d');
$date1=date_create($cdate);
$date2=date_create($_POST['DOB']);
$diff12 = date_diff($date1, $date2);
$years = $diff12->y;
$months= $diff12->m;


$value0=$_POST['id'];
$value20=$years;
$value2=$months;
$value5=$_POST['period'];
$value6=$_SESSION['starting_station'];
$value7=$_POST['estation'];
$value1=$_POST['cclass'];
$value8='NEW';
$value9="0000-00-00";
$value10="0000-00-00";
$value11='NEW';
$value12='NEW';
$value13=$_POST['starting_station'];
$value14='NEW';

$sql="INSERT INTO new (Stu_id,Age_month,Passperiod,Station_from,Station_to,cclass,Voucher_no,Starting_date,Ending_date,Previous_class,
Ticket_no,P_startingstation,P_endingstation,Age_year,Submitdate) 
VALUES($value0,$value2,'$value5','$value6','$value7','$value1','$value8','$value9','$value10','$value11','$value12','$value13','$value14',$value20,'$cdate')";


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
