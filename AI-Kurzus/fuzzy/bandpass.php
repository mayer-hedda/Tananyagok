<?php
function bandpass_filter($signal, $lowpass, $highpass) {
  $filtered = array();
  $signal_length = count($signal);
  for ($i = 0; $i < $signal_length; $i++) {
    if ($signal[$i] >= $lowpass && $signal[$i] <= $highpass) {
      $filtered[] = $signal[$i];
    }
    /*elseif($signal[$i] < $lowpass){
      $filtered[] = 0;
    }
    else{
      $filtered[] = $highpass;
    }*/
  }
  return $filtered;
}

/*
Ez a függvény egy $signal tömböt vár paraméterként, amely a 
szűrendő jel adatait tartalmazza. A $lowpass és $highpass 
paraméterek a szűrő alsó és felső határának értékeit adják meg. 
A függvény a for ciklussal végigmegy a $signal tömb elemein, és 
ha az adat a lowpass és highpass között van, akkor a $filtered 
tömbbe helyezi. Végül a $filtered tömböt adja vissza.
*/


?>