<?php
error_reporting(E_ERROR | E_PARSE);
$c = new mysqli("localhost", "root", "", "anmp");
if ($c->connect_errno) {
    echo json_encode(array('result' => 'ERROR', 'message' => 'Failed to connect
DB'));
    die();
}

$id = $_GET['id'];
$sql = mysqli_query($c, "SELECT * FROM satu_jiwa WHERE id ='$id'");
$result = mysqli_fetch_assoc($sql);
echo json_encode($result);

$c->close();