<?php
class ActivationFunction {

	public static function stepFunction($activation) {
		
		if($activation >= 1){
			return 1;
		}
		return 0;
	}
}
?>