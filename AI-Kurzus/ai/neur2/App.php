<?php
require_once('BackpropNeuralNetwork.php');
require_once('NeuralNetConstants.php');
		$trainingData = array( 
				array( 0, 0 ), 
				array( 0, 1 ),
				array( 1, 0 ),
				array( 1, 1 )
		);

		$trainingResults = array(
				array(1), 
				array(0),
				array(0),
				array(1)
		);

		$backpropagationNeuralNetworks = new BackpropNeuralNetwork();

		for ($iterations = 0; $iterations < NeuralNetConstants::$ITERATIONS; $iterations++) {

			for ($i = 0; $i < count($trainingResults); $i++) {
				$backpropagationNeuralNetworks->train($trainingData[$i], $trainingResults[$i],
						NeuralNetConstants::$LEARNING_RATE, NeuralNetConstants::$MOMENTUM);
			}

			print '<br>';
			for ($i = 0; $i < count($trainingResults); $i++) {
				$t = $trainingData[$i];
				print 'epoch: ' . $iterations + 1 . '<br>';
				print $t[0] . ' ' . $t[1];
				$x = $backpropagationNeuralNetworks->run($t);
				print_r($x[0]);
				print '<br>';
			}
		}
	

?>