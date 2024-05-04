<?php
class ActivationFunction {

	public static function sigmoid($x) {
		return (1 / (1 + exp((-1 * $x))));
	}

	public static function dSigmoid($x) {
		return ($x * (1 - $x)); 
	}
}
?>