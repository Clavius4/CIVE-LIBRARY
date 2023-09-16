<?php

include("db.php");

$regno=$_GET['ID'];

$sql="delete from students where reg_no='$regno'";
$res=mysqli_query($conn,$sql);

if ($res) {
	header("location:viewstudents.php");
}

else{
	echo"failed";
}
?>
