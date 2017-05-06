<?php 
 $fn=$_POST["firstname"];
 $e=$_POST["mail"];
 $p=$_POST["pass"];
 $d=$_POST["b_day"];
 $g=$_POST["gender"];
 if(($fn!=null)&&($e!=null)&&($p!=null)&&($d!=null))
 {
 
 $con = mysqli_connect('localhost','root','','my_db');
 if($con)
 { 
   
   $sql="insert into reg values('$fn','$e','$p','$d','$g')";
   $status=mysqli_query($con,$sql);
   
   if($status)
   {
	   echo "<h1><center>You are sucessfully registered!!</center></h1>";
    }
    else
	{
		echo "already registered";
    }
 
 }
 else
 { echo "miss match of passwords";
 }
 }
 else
 {
	 echo "enter all the fields";
 }
 ?>
