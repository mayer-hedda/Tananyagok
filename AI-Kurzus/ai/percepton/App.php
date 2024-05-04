<?php
require_once('Perceptron.php');
		$input = array(array(0, 0), array(0, 1), array(1, 0), array(1, 1));
		$output = array(0, 0, 0, 1);
		
		$perceptron = new Perceptron($input, $output);
		$perceptron->train(0.2);
		
		print 'The error is 0 so our neural network is ready! Predictions:<br>';
		
		print $perceptron->calculateOutput(array(0, 0)) . '<br>';
		print $perceptron->calculateOutput(array(0, 1)) . '<br>';
		print $perceptron->calculateOutput(array(1, 0)) . '<br>';
		print $perceptron->calculateOutput(array(1, 1)) . '<br>';
	

?>