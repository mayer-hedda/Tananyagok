<?php

class Matrix {

	// MÁTRIX SZORZÁSA VEKTORRAL
	public static function matrixVectorMultiplication($matrix, $vector) {
		
		$result = array();
		
		for($i=0; $i<count($matrix); $i++) {
			$sum = 0;
			
			for($j=0; $j<count($vector); $j++){
				$sum += $matrix[$i][$j]  * $vector[$j];
			}
			$result[$i] = $sum;
		}
		
		return $result;
	}
	

	// VEKTORIÁLIS SZORZAT
	public static function outerProduct($vector) {
		
		$result = array();
		
		for($i=0; $i<count($vector); $i++){
			for($j=0; $j<count($vector); $j++)
				$result[$i][$j] = $vector[$i] * $vector[$j];
		}
		return $result;
	}
	
	// FŐÁTLÓT NULLÁZZA
	public static function clearDiagonals($matrix) {
		
		for($i=0; $i<count($matrix); $i++){
			$matrix[$i][$i] = 0;
		}
		
		return $matrix;
	}
	
	// MÁTRIX ÖSSZEADÁSA
	public static function addMatrix($matrix1, $matrix2) {
		
		$result = array();
		
		for($i=0; $i<count($matrix1); $i++){
			for($j=0; $j<count($matrix1); $j++){
				$result[$i][$j] = $matrix1[$i][$j] + $matrix2[$i][$j];
			}
		}
		return $result;
	}
}
?>