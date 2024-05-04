<?php

    header('content-type: image/png');
    $s = 700;
    $img = imagecreatetruecolor($s, $s);

    // SZÍNEK
    $green = imagecolorallocate($img, 0, 255, 0);
    $red = imagecolorallocate($img, 255, 0, 0);
    $white = imagecolorallocate($img, 255, 255, 255);
    $black = imagecolorallocate($img, 0, 0, 0);
    $hatter = imagecolorallocate($img, 14, 14, 14);

    // HÁTTÉRSZÍN
    imagefill($img, 0, 0, $hatter);


    /*
    // HÓEMBER
    // test
    $hely = 100;
    for ($i = 0; $i < 3; $i++) {
        imagefilledellipse($img, $s/2, $hely, 100, 100, $white);
        // arc
        if ($i == 0) {
            imagefilledellipse($img, $s/2, $hely, 5, 5, $black);
            imagefilledellipse($img, $s/2 - 20, $hely - 20, 5, 5, $black);
            imagefilledellipse($img, $s/2 + 20, $hely - 20, 5, 5, $black);
            imagearc($img, $s/2, $hely + 15, 20, 20, 0, 180, $black);
        }
        // kezek
        if ($i == 1) {
            imageline($img, $s/2 + 50, $hely, $s/2 + 100, 125, $white);
            imageline($img, $s/2 - 50, $hely, $s/2 - 100, 125, $white);
        }
        $hely += 100;
    }

    // gombok
    $hely = 175;
    for ($i = 0; $i < 6; $i++) {
        imagefilledellipse($img, $s/2, $hely, 5, 5, $black);
        $hely += 24;
        if ($i == 2) {
            $hely += 30;
        }
    }
    */



    
    // JIN-JANG
    // alap kör
    imageellipse($img, $s/2, $s/2, 500, 500, $black);

    // mellékívek
    imagearc($img, $s/2, $s/2 - 125, 250, 250, 270, 90, $white);
    imagearc($img, $s/2, $s/2 + 125, 250, 250, 90, 270, $white);

    // fehér pötty
    imagefilledellipse($img, $s/2, $s/2 - 125, 100, 100, $white);

    // fekete pötty
    imagefilledellipse($img, $s/2, $s/2 + 125, 100, 100, $black);

    // kitöltés
    imagefill($img, $s/2 + 10, $s/2 + 10, $white);
    imagefill($img, $s/2 - 10, $s/2 - 10, $black);
    
    


    /*
    // ZÁSZLÓ
    // hullámok
    $k = 0;
    for ($i = 0; $i < 4; $i++) {
        imagearc($img, $s/2 - $k, $s/2 + $k, 250, 250, 250, 340, $white);
        imagearc($img, $s/2 + 235 - $k, $s/2 - 83 + $k, 250, 250, 70, 160, $white);
        $k += 40;
    }

    // tartóvonal
    imageline($img, $s/3 - 160, $s/3 + 235, $s/2 - 41, $s/2 - 118, $white);

    // szél vonal
    imageline($img, $s/3 + 275, $s/3 + 270, $s/2 + 278, $s/2 + 33, $white);

    // piros
    imagefill($img, $s/2 - 41, $s/2 - 116, $red);

    // fehér
    imagefill($img, $s/2 - 41, $s/2 - 60, $white);

    // zöld
    imagefill($img, $s/2 - 10, $s/2 - 10, $green);
    */



    imagepng($img);
    imagedestroy($img);

?>