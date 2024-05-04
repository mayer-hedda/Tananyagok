<?php 
require_once('Layer.php');
class BackpropNeuralNetwork {

	private $layers;
	
	public function __construct() {

		$this->layers = array();
		$this->layers[0] = new Layer();
		$this->layers[1] = new Layer();
	}

	public function getLayer($index) {
		return $this->layers[$index];
	}

	public function run($input) {
		$inputActivation = $input;
		for ($i = 0; $i < count($this->layers); $i++) {
			$inputActivation = $this->layers[$i]->run($inputActivation);
		}
		return $inputActivation;
	}

	public function train($input, $targetOutput, $learningRate, $momentum) {
		
		$calculatedOutput = BackpropNeuralNetwork::run($input);
		$error = array();
		
		for ($i = 0; $i < count($error); $i++) {
			$error[$i] = $targetOutput[$i] - $calculatedOutput[$i]; 
		}
		
		for ($i = count($this->layers) - 1; $i >= 0; $i--) {
			$error = $this->layers[$i]->train($error, $learningRate, $momentum);
		}
	}
}
?>