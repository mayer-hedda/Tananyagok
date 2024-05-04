<?php

    header("content-type: image/png");
    $img = imagecreatetruecolor(1000, 1000);


    // SZÍNEK
    $piros1 = imagecolorallocate($img, 255, 0, 0);
    $piros2 = imagecolorallocate($img, 200, 0, 0);
    $sarga1 = imagecolorallocate($img, 255, 255, 0);
    $sarga2 = imagecolorallocate($img, 200, 200, 0);
    $zold1 = imagecolorallocate($img, 0, 255, 0);
    $zold2 = imagecolorallocate($img, 0, 200, 0);
    $cian1 = imagecolorallocate($img, 0, 255, 255);
    $cian2 = imagecolorallocate($img, 0, 200, 200);
    $kek1 = imagecolorallocate($img, 0, 0, 255);
    $kek2 = imagecolorallocate($img, 0, 0, 200);
    $feher = imagecolorallocate($img, 255, 255, 255);
    $feher2 = imagecolorallocate($img, 200, 200, 200);


    // ALAP
    for($i = 0; $i < 40; $i++) {
        imageline($img, 100 + $i, 100 - $i, 100 + $i, 900 - $i, $feher2);
    }

    for($i = 0; $i < 40; $i++) {
        imageline($img, 100 + $i, 900 - $i, 900 + $i, 900 - $i, $feher);
    }


    // OSZLOPOK
    $szinek1 = array($piros1, $sarga1, $zold1, $cian1, $kek1);
    $szinek2 = array($piros2, $sarga2, $zold2, $cian2, $kek2);
    $k = 0;
    for($i = 0; $i < 5; $i++) {
        $rand = rand(200, 500);
        for($j = 0; $j < 20; $j++) {
            imagefilledrectangle($img, 190 + $j + $k, 890 - $j, 240 + $j + $k, 890 - $rand - $j, $szinek2[$i]);
        }
        imagefilledrectangle($img, 190 + $k, 890, 240 + $k, 890 - $rand, $szinek1[$i]);
        $k += 150;
    }


    imagepng($img);
    imagedestroy($img);

?>