<?php
require_once('ActivationFunction.php');
class Perceptron {

	private $weights;
	private $input;
	private $output;
	private $numOfWeights;
	
	public function __construct($input, $output) {
		$this->input = $input;
		$this->output = $output;
		$this->numOfWeights = count($input[0]);
		$this->weights = array();
		print_r($this->input);
		Perceptron::initialzeWeight();
	}

	private function initialzeWeight() {
		for($i=0; $i < $this->numOfWeights; $i++){
			$this->weights[$i] = 0;
		}
	}
	
	public function train($learningRate) {
		
		$totalError = 1;
		$c = 0;
		while ( $totalError != 0 || $c < 10) {
			$c++;
			$totalError = 0;
			
			for($i = 0; $i < count($this->output); $i++) {
				
				$calculatedOutput = Perceptron::calculateOutput($this->input[$i]);
				$error = $this->output[$i] - $calculatedOutput;
				
				$totalError += $error;
				
				for($j = 0; $j < $this->numOfWeights; $j++) {
					$this->weights[$j] = $this->weights[$j] + $learningRate * $this->input[$i][$j] * $error;
					print 'Updated weight: ' . $this->weights[$j] . '<br>';
				}
			}
			
			print 'Keep on training the network, error is: ' . $totalError . '<br>';
		}
		
	}
	
	public function calculateOutput($input) {
		
		$sum = 0;
		
		
		for($i = 0; $i < count($input); $i++){
			$sum = $sum + $this->weights[$i] * $input[$i];
		}
		return ActivationFunction::stepFunction($sum);
	}
}
