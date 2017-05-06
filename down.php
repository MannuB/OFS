<html>
<head>
<title>downloadload</title>
</head>
<body>
<form name="frm1" action="down.php" method="get" enctype="multipart/form-data">

<button type="submit" name="down">download</button>


</form>
<?php
if(isset($_GET['down']));
{
	$con = mysqli_connect('localhost','root','','my_db');
	$q="SELECT fileup,id FROM tbl_uploads";
	$result = mysqli_query($con,$q);
	if (mysqli_num_rows($result) > 0) {
    // output data of each row
    while($row = mysqli_fetch_assoc($result)) {
        echo "id: " . $row["id"]. " - Name: " . $row["fileup"]. "<br/>" ;
}
	}
	}
?>
<form name="frm2" action="download2.php" method="get" enctype="multipart/form-data">
<button type="submit" name="down1">download</button>
</form>

</body>
</html>

