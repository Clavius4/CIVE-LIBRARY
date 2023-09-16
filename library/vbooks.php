<?php

include("db.php");

$result = array();
$result['data'] = array();

$sql="SELECT * FROM books";
$books=mysqli_query($conn,$sql);


while ($row=mysqli_fetch_array($books)) {
	$index['id']=$row['0'];
	$index['bookname']=$row['1'];
	$index['file']=$row['2'];
	$index['category']=$row[3];
	$index['uploaded_time']=$row[4];
	array_push($result['data'], $index);
}

$result["success"]='1';
echo json_encode($result);

?>