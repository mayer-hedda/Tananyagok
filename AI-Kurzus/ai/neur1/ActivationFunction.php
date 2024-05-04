<?php
class ActivationFunction {

	public static function stepFunction($x) {
		
		if($x >= 0){
			return 1;
		}
		return -1;
	}
}
?>