<?php

include 'koneksi_php';
$kodeFakultas = $_POST['kode_fakultas'];
$namaFakultas = $_POST['nama_fakultas'];

if(!$kode_fakultas || !$nama_fakultas){

	echo json_decode(array ('message'=>'required failed is empty.'));

}
else{
	$query = mysqli_query($con, "INSERT INTO fakultas VALUES ('','$kode_fakultas','$nama_fakultas')");
	if($query){
	echo json_encode(array('message'=>'fakultas data successfully added.'));
	}
	else{
	echo json_encode(array('message'=>'fakultas data failed to add.'));

	}
}
?>