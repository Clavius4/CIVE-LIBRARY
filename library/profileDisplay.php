<?php

include("db.php");

$result = array();
$result['data'] = array();

$reg_no=$_POST['reg_no'];

$profile="SELECT reg_no, firstname, secondname, lastname, programme, email, phonenumber FROM students WHERE reg_no='$reg_no'";
$pro=mysqli_query($conn,$profile);

while($row = mysqli_fetch_array($pro)){
    $index['reg_no'] = $row['0'];
    $index['firstname'] = $row['1'];
    $index['secondname'] = $row['2'];
    $index['lastname'] = $row['3'];
    $index['programme'] = $row['4'];
    $index['email'] = $row['5'];
    $index['phonenumber'] = $row['6'];

    array_push($result['data'], $index);

}

$result["Success"]="1";
echo json_encode($result);
mysqli_close($conn);

?>