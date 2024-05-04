<?php
require_once('Matrix.php');
require_once('ActivationFunction.php');
class HopfieldNetwork {

	private $weightMatrix;

	public function __construct($dim) {
		$this->weightMatrix = array();
		for($i = 0; $i < $dim; $i++){
			for($j = 0; $j < $dim; $j++){
				$this->weightMatrix[$i][$j] = 0;
			}
		}
	}

	public function train($pattern) {
		
		$patternMatrix = array();
		
		$patternMatrix = Matrix::outerProduct($pattern);
		//print_r($patternMatrix);
		$patternMatrix = Matrix::clearDiagonals($patternMatrix);
		//		print_r($patternMatrix);
		$this->weightMatrix = Matrix::addMatrix($this->weightMatrix, $patternMatrix);
		//print_r($this->weightMatrix);
	}

	public function recall($pattern) {
		$result = Matrix::matrixVectorMultiplication($this->weightMatrix, $pattern);
//print_r($this->weightMatrix);
//print_r($pattern);
		for($i = 0; $i < count($pattern); $i++) {
			$result[$i] = ActivationFunction::stepFunction($result[$i]);
		}

		/*for($i = 0; $i < count($pattern); $i++) {
			if($pattern[$i] != $result[$i]) {
				print 'Pattern not recognized...';
				return false;
			}
		}*/
		for($i = 0; $i < count($result); $i++) {
			print $result[$i];
		}

		//print 'Pattern recognized...';
	}
}
?>