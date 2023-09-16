<?php

include("db.php");

$result = array();
$result['data'] = array();

$reg_no=$_POST['reg_no'];


$profile="SELECT book_id, book_tittle, category, borrowed_date, deadline FROM borrowedbookstb WHERE reg_no='$reg_no'";
$pro=mysqli_query($conn,$profile);

while($row = mysqli_fetch_array($pro)){
    $index['book_id'] = $row['0'];
    $index['book_tittle'] = $row['1'];
    $index['category'] = $row['2'];
    $index['borrowed_date'] = $row['3'];
    $index['deadline'] = $row['4'];

    array_push($result['data'], $index);

}

$result["Success"]="1";
echo json_encode($result);
mysqli_close($conn);

?>