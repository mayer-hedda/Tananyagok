<?php
    // phpinfo();
    header('content-type: image/png');
    $s = 700;
    $img = imagecreatetruecolor($s, $s);

    // SZÍNEK
    $green = imagecolorallocate($img, 0, 255, 0);
    $red = imagecolorallocate($img, 255, 0, 0);
    $white = imagecolorallocate($img, 255, 255, 255);
    $black = imagecolorallocate($img, 0, 0, 0);
    $hatter = imagecolorallocate($img, 14, 14, 14);
    $pink = imagecolorallocate($img, 255, 0, 120);

    // HÁTTÉRSZÍN
    imagefill($img, 0, 0, $hatter);

    // VONAL
    imageline($img, $s/2, $s/2, $s, 0, $green);

    // ELIPSZIS
    imageellipse($img, $s/2, $s/2, $s/2, $s/3, $pink);
    imagefilledellipse($img, $s/2, $s/2, $s/8, $s/8, $red);

    // NÉGYSZÖG (random számok generálásával)
    $randx1 = rand(0, $s-1);
    $randx2 = rand(0, $s-1);
    $randy1 = rand(0, $s-1);
    $randy2 = rand(0, $s-1);
    imagefilledrectangle($img, $randx1, $randy1, $randx2, $randy2, $green);

    // ÍV
    imagearc($img, $s/3, $s/3, $s/4, $s/4, 90, 270, $pink);


    imagepng($img);
    imagedestroy($img);

?>