<?php
function rms($signal, $window_length) {
  $rms_values = array();
  $window_step = floor(count($signal) / $window_length);

  for ($i = 0; $i < count($signal); $i += $window_length) {
    $window = array_slice($signal, $i, $window_length);
    $sum = 0;
    foreach ($window as $value) {
      $sum += pow($value, 2);
    }
    $rms = sqrt($sum / $window_length);
    for($k = 0; $k < count($window); $k++) {
      $rms_values[] = $rms;
    }
    
  }

  return $rms_values;
}


?>
