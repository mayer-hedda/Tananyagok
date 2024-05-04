<?php 
require_once('ActivationFunction.php');
class Layer {

	private $output;
	private $input;
	private $weights;
	private $dWeights;
	private $random;

	public function __construct() {
		$this->output = array();
		$this->input = array();
		$this->weights = array();
		$this->dWeights = array();
		Layer::initWeights();
	}

	public function initWeights() {
		for ($i = 0; $i < count($this->weights); $i++) {
			$this->weights[$i] = (rand(0, 1) / 10 - 0.5) * 4;//FIXME?
		}
	}

	public function run($inputArray) {
		$this->input = $inputArray;
		//System.arraycopy(inputArray, 0, input, 0, inputArray.length);//FIXME
		$this->input[count($this->input) - 1] = 1; // bias
		$offset = 0;
		
		for ($i = 0; $i < count($this->output); $i++) {
			for ($j = 0; $j < count($this->input); $j++) {
				$this->output[$i] += $this->weights[$offset + $j] * $this->input[$j];
			}
			$this->output[$i] = ActivationFunction::sigmoid($this->output[$i]);
			$offset += count($this->input);
		}
		
		//return Arrays.copyOf(output, output.length);//FIXME
		return $this->output;
	}

	public function train($error, $learningRate, $momentum) {
		
		$offset = 0;
		$nextError = array();
		
		for ($i = 0; $i < count($this->output); $i++) {
			
			$delta = $error[$i] * ActivationFunction::dSigmoid($this->output[$i]); // because the output is the sigmoid(x) !!! 
			// because we calculate the output delta differently than the hidden layer deltas
			
			// because we have a single hidden layer delta not change
			for ($j = 0; $j < count($this->input); $j++) {
				$previousWeightIndex = $offset + $j;
				$nextError[$j] = $nextError[$j] + $this->weights[$previousWeightIndex] * $delta;
				$dw = $this->input[$j] * $delta * $learningRate;
				$this->weights[$previousWeightIndex] += $this->dWeights[$previousWeightIndex] * $momentum + $dw;
				$this->dWeights[$previousWeightIndex] = $dw;
			}
			
			$offset += count($this->input);
		}
		
		return $nextError;
	}
}
?>