<?php

	if(isset($_GET['down1'])) {
    // Make sure an ID was passed
    if(isset($_GET['id'])) {
    // Get the ID
        $id = intval($_GET['id']);
     
        // Make sure the ID is in fact a valid ID
        if($id <= 0) {
            die('The ID is invalid!');
        }
        else {
            // Connect to the database
            $con = mysqli_connect('localhost','root','','my_db') or die(mysql_error()); 
 			
 				mysqli_set_charset($con,'utf-8');
     
            // Fetch the file information
            $query = "SELECT * FROM tbl_uploads WHERE id = $id";
            $result=mysqli_query($con,$query);
            
             if($result) {
                // Make sure the result is valid
                if(mysqli_num_rows($result) == 1) {
                // Get the row
                    $row = mysqli_fetch_assoc($result);
                    
                    $type=$row['type'];
                    $size=$row['size'];
                    $filename=$row['fileup'];
                    $data=$row['content'];

                    
// Print headers

header("Content-Type: $type");
header("Content-Length: $size");
header("Content-Disposition: attachment; filename=$filename");
 
                    // Print data
                    echo $content;
                }
                else {
                    echo 'Error! No image exists with that ID.';
                }
     
                // Free the mysqli resources
                mysqli_free_result($result);
            }
            else {
                echo "Error! Query failed";
            }
                }
    }
    else {
        echo 'Error! No ID was passed.';
    }
 
	}
    ?>