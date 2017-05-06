<?php
if(isset($_GET['id'])) 
{
// if id is set then get the file with the id from database

$con = mysqli_connect('localhost','root','','my_db');
$id    = $_GET['id'];
$query = "SELECT fileup, type, size, content " .
         "FROM tbl_uploads WHERE id = '$id'";

$result = mysqli_query($query) or die('Error, query failed');
array($name, $type, $size, $content) = mysqli_fetch_array($result);

header("Content-length: $size");
header("Content-type: $type");
header("Content-Disposition: attachment; filename=$name");
echo $content;

exit;
}

?>