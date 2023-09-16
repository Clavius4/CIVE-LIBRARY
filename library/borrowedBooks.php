<?php

class Constants{
    static $DB_SERVER="localhost";
    static $DB_NAME="library";
    static $USERNAME="root";
    static $PASSWORD="";

    $reg_no=$_POST['reg_no'];

    static $SQL_SELECT_ALL="SELECT book_id, book_tittle, category, borrowed_date, deadline FROM borrowedbookstb WHERE reg_no='$reg_no'";

}

class pdfs{
    private $SQL_SELECT_ALL="SELECT * FROM borrowedbookstb";

    public function connect(){
        $conn = new mysqli(Constants::$DB_SERVER,Constants::$USERNAME,Constants::$PASSWORD,Constants::$DB_NAME);
        if($conn->connect_error){
            return null;
        }else{
            return $conn;
        }
    }

    public function select(){
        $conn=$this->connect();
        if($conn != null){
            $result=$conn->query(Constants::$SQL_SELECT_ALL);
            if($result->num_rows>0){
                $pdfs=array();
                while($row=$result->fetch_array()){
                    array_push($pdfs, array("book_id"=>$row['book_id'], "book_tittle"=>$row['book_tittle'], "category"=>$row['category'], "borrowed_date"=>$row['borrowed_date'], "deadline"=>$row['deadline']));
                }
                $pdfs['Success']="1";
                print(json_encode(array_reverse($pdfs)));
            }else{
                print(json_encode(array("PHP EXCEPTION : CAN'T RETRIEVE FROM MYSQL")));
            }
        }else{
            print(json_encode(array("PHP EXCEPTION : CAN'T CONNECT TO MYSQL. NULL CONNECTION")));
        }
    }
}

$pdfs = new pdfs();
$pdfs->select();
