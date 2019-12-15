<?php
 
 require_once 'koneksi.php';


 $result = array();
 $query = "SELECT * FROM fakultasku";
 $result = $con->query($query);


 if ($result->num_rows > 0){
 	http_response_code(200);
 	echo json_encode(
 		array(
 			"status" => 200,
 			"message" => "success",
 			"data" => $result -> fetch_array(),
 			),true
 		);
 } else {
 	echo "0 results";
 }

 $con->close();

 ?>