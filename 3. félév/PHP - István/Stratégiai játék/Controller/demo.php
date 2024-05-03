<?php
require_once('HazController.php');//törlésre kerül

//header('Content-type: image/png');
//TODO: request a controllerre!!!
$img = imagecreatetruecolor(Map::$MAXXY, Map::$MAXXY);
$haz = imagecolorallocate($img,255,0,0);
print_r($_SESSION['hazak']);
for( $i = 0; $i < count($_SESSION['hazak']); $i++ ){
    imagerectangle($img, $_SESSION['hazak'][$i]->getPozicio()->x - Haz::$MERET / 2, 
    $_SESSION['hazak'][$i]->getPozicio()->y - Haz::$MERET / 2,  $_SESSION['hazak'][$i]->getPozicio()->x + Haz::$MERET / 2, 
    $_SESSION['hazak'][$i]->getPozicio()->y + Haz::$MERET / 2, $haz);
}

imagepng($img);
imagedestroy($img);
?>