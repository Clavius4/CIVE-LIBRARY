<?php

include("db.php");

$id=$_GET['ID'];

$sql="delete from books where id='$id'";
$res=mysqli_query($conn,$sql);

if ($res) {
	header("location:viewbooks.php");
}

else{
	echo"failed";
}
?>
