<?php

    $xml = simplexml_load_file('napok.xml');
    header('content-type: imgae.png');

    // VÁSZON
    $w = count($xml->nap) * 100;
    $img = imagecreatetruecolor($w, 100);

    // SZINEK
    $white = imagecolorallocate($img, 255, 255, 255);
    $blue = imagecolorallocate($img, 0, 0, 255);
    $red = imagecolorallocate($img, 255, 0, 0);

    $y0 = 60;
    $x1 = 20;
    $x2 = 45;
    $x3 = 55;
    $x4 = 80;

    imageline($img, 0, $y0, $w, $y0, $white);

    for($i = 0; $i < count($xml->nap); $i++) {
        // print $xml->nap[$i]->attributes()['datum']."<br>";
        // print $xml->nap[$i]->min."<br>";
        // print $xml->nap[$i]->max."<br><br>";

        $yMin = $y0 - $xml->nap[$i]->min;
        $yMax = $y0 - $xml->nap[$i]->max;

        imagefilledrectangle($img, $i * 100 + $x1, $yMax, $i * 100 + $x2, $y0, $red);
        imagefilledrectangle($img, $i * 100 + $x3, $yMin, $i * 100 + $x4, $y0, $blue);

        imagestring($img, 4, $i * 100 + $x1, 85, $xml->nap[$i]->max, $white);
        imagestring($img, 4, $i * 100 + $x3, 85, $xml->nap[$i]->min, $white);
    }

    imagepng($img);
    imagedestroy($img);

?>