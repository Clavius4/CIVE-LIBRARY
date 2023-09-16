<?php

include("db.php");


$reg_no=$_POST['reg_no'];
$password=$_POST['password'];

$login="SELECT reg_no, pword FROM students WHERE reg_no='$reg_no' AND pword='$password'";
$log=mysqli_query($conn,$login);

if (mysqli_num_rows($log)>0) {
	echo "Login Successfully";
}

else{
	echo"Incorrect user name or password";
}


?>