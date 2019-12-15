<?php
	// koneksi database unversitas_kotlin
$con =  new mysqli("localhost","root","","universitas_kotlin");
//cek koneksi
//Chek Connection
if ($con->connect_error){
	die("Connection failed : " . $con->connect_error);
}
?>