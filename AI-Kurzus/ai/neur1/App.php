<?php
require_once('HopfieldNetwork.php');
		$network = new HopfieldNetwork(9);
		$network->train(array(1,1,1,1,-1,-1,1,1,1));
		$network->train(array(1,1,1,-1,1,-1,-1,1,-1));
		
		$network->recall(array(1,1,1,1,-1,-1,1,1,1));
		

?>