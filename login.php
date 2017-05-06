<?php
session_start();
$e=$_POST["mail"];
 $p=$_POST["password"];
 $con = mysqli_connect('localhost','root','','my_db');
   if(isset($_POST['login'])){
   $sql="select * from reg where mail='$e' AND password='$p'";
  $data= mysqli_query($con,$sql);
   if(mysqli_num_rows($data)==1)
   {
	   $_SESSION['mail']=$e;
	   header ('location:welcome.php','_self');
    }
    else
	{
		echo "wrong password";
    }
 }
 else
 { echo "miss match of passwords";
 }
 
?>