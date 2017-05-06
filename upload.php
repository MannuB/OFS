<?php
if(isset($_POST['btn-upload']) && $_FILES['my-file']['size'] > 0)
{    
     
 $file = $_FILES['my-file']['name'];
    $file_loc = $_FILES['my-file']['tmp_name'];
 $file_size = $_FILES['my-file']['size'];
 $file_type = $_FILES['my-file']['type'];
 $fp = fopen($file_loc,'r');
 $content = fread($fp,filesize($file_loc));
$content=addslashes($content);
 fclose($fp);
 if(!get_magic_quotes_gpc())
 {
	 $file=addslashes($file);
	 }
$con = mysqli_connect('localhost','root','','my_db');
 $sql="INSERT INTO tbl_uploads(fileup,type,size,content)"."VALUES('$file','$file_type','$file_size','$content')";
 mysqli_query($con,$sql) or die("Error,query failed");
 

}
?>