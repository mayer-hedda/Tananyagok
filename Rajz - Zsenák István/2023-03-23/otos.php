<?php

    $file = fopen('otos.csv', 'r');
    // print '<table border="1">';

    $szamok = array();
    while (!feof($file)) {//feof($file) != true
        $row = fgets($file);
        //print $row . '<br>';
        $array = explode(';',$row);
        // print '<tr>';
        // for($i = 0; $i < count($array); $i++){
        //     // print '<td>' . $array[$i] . '</td>';
        // }
        // print '</tr>';

        $m = count($array);
        if($m > 15) {
            $szamok[] = array($array[$m-5], 
                            $array[$m-4], 
                            $array[$m-3], 
                            $array[$m-2], 
                            $array[$m-1]);
        }
    }
    // print '</table>'
    fclose($file);
    
    $huzasok = array_fill(0, 91, 0);
    for ($i = 0; $i < count($szamok); $i++) { 
        for ($j = 0; $j < count($szamok[$i]); $j++) {
            $huzasok[(int)$szamok[$i][$j]]++;
        }
    }

    asort($huzasok);
    
    $nagyok = array();
    for($i = 0; $i < 5; $i++) {
        $nagyok[] = array(array_key_last($huzasok), array_pop($huzasok));
    }





    header("content-type: image/png");
    $img = imagecreatetruecolor(500, 500);
    
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
    

    $kezdo = 0;
    $vege = 0;
    $sum = 0;
    
    for($i = 0; $i < count($nagyok); $i++) {
        $sum += $nagyok[$i][1];
    }
    
    $szinek = array($piros2, $sarga2, $zold2, $cian2, $kek2);

    for($y = 0; $y < 30; $y++) {
        $kezdo = 0;
        for($i = 0; $i < count($nagyok); $i++) {
            $vege = (int)($kezdo + ($nagyok[$i][1] / $sum) * 360);
            imagefilledarc($img, 250, 250 - $y, 200, 80, $kezdo, $vege, $szinek[$i], IMG_ARC_PIE);
            $kezdo = $vege;
        }
    }

    $szinek2 = array($piros1, $sarga1, $zold1, $cian1, $kek1);
    $kezdo = 0;
    for($i = 0; $i < count($nagyok); $i++) {
        $vege = (int)($kezdo + ($nagyok[$i][1] / $sum) * 360);
        imagefilledarc($img, 250, 250 - $y, 200, 80, $kezdo, $vege, $szinek2[$i], IMG_ARC_PIE);
        $kezdo = $vege;
    }
    
    
    imagepng($img);
    imagedestroy($img);

    ?>