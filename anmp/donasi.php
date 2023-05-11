<?php
error_reporting(E_ERROR | E_PARSE);
$c = new mysqli("localhost", "root", "", "anmp");
if ($c->connect_errno) {
    echo json_encode(array('result' => 'ERROR', 'message' => 'Failed to connect
DB'));
    die();
}

$iduser = $_GET['iduser'];
$sql = mysqli_query($c, "SELECT sj.id, sj.title, sj.donasi, sj.hari, sj.total_donasi, sj.image_Url, d.donasi_user FROM donasi as d inner join user as u on d.iduser=u.iduser inner join satu_jiwa as sj on d.idsatu_jiwa=sj.id WHERE d.iduser = '$iduser'");
$result = mysqli_fetch_assoc($sql);
echo json_encode($result);

$c->close();


// $sql = "SELECT * FROM donasi as d 
// inner join user as u on d.iduser=u.iduser 
// inner join satu_jiwa as sj on d.idsatu_jiwa=sj.id 
// WHERE u.iduser = 1";
// $result = $c->query($sql);
// $array = array();
// if ($result->num_rows > 0) {
//     while ($obj = $result->fetch_object()) {
//         $array[] = $obj;
//     }
//     echo json_encode($array);
// } else {
//     echo json_encode(array('result' => 'ERROR', 'message' => 'No data found'));
//     die();
// }
