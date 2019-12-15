<?php

require_once 'koneksi.php';

$idFakultas = $POST ['id_fakultas'];
$kodeFakultas = $POST ['kode_fakultas'];
$namaFakultas = $POST ['nama_fakultas'];

if (!$kodeFakultas || !$namaFakultas) {
	echo json_encode (array('message' => 'required field is empty.'));
}
else {
	$query = mysqli_query ($con, "UPDATE fakultas SET kode_fakultas= $kodeFakultas', 'nama_fakultas='$namaFakultas' WHERE id_fakultas='$idFakultas'");

	if($query){
		echo json_encode(array('message'=>'fakultas data successfully updated.'));
	}

	else {
		echo json_encode (array('message'=>'fakultas data failed to update.'));
		}
}
?>