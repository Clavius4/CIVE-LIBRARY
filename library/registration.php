<?php

include("db.php");


$reg_no=$_POST['reg_no'];
$firstname=$_POST['firstname'];
$secondname=$_POST['secondname'];
$lastname=$_POST['lastname'];
$programme=$_POST['programme'];
$email=$_POST['email'];
$phonenumber=$_POST['phonenumber'];
$password=$_POST['password'];

$registration = "SELECT reg_no, pword FROM students WHERE reg_no='$reg_no' AND pword='$password'";
$reg = mysqli_query($conn,$registration);

if(mysqli_num_rows($reg)>0){
    echo"User already exist! please login";
}else{
    $sql="INSERT INTO students(reg_no,firstname,secondname,lastname,programme,email,phonenumber,pword) VALUES ('$reg_no','$firstname','$secondname','$lastname','$programme','$email','$phonenumber','$password')";
    $res=mysqli_query($conn,$sql);
    if($res){
        echo"Registration successfully";
    }else{
        echo"User already exist! please login";
    }
}

?>