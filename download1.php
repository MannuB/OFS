<html>
<head>
<title>Download File From MySQL</title>
<meta http-equiv="Content-Type" content="text/jpg" charset=iso-8859-1">
</head>

<body>
<?php
 $con = mysqli_connect('localhost','root','','my_db');

$query = "SELECT id, fileup FROM tbl_uploads";
$result = mysqli_query($con,$query) or die('Error, query failed');
if(mysqli_num_rows($result) == 0)
{
echo "Database is empty <br>";
} 
else
{
while(array($id, $name) == mysqli_fetch_array($result))
{
?>
<a href="download.php?id=<?php=$id;?>"><?php=$name;?></a> <br/>
<?php 
}
}

?>
</body>
</html>