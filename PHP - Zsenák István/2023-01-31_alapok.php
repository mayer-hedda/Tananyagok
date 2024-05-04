<i>akjfkbnklaabjkfaljbflfb</i><br>



<?php

    // változó deklarállása
    $szoveg = 'És nagyon tetszik.';

    // kiiratás
    print 'Ez az első php programom. ';
    print $szoveg.'<br><br>';



    // php-ban lehet számot tartalmazó stringgel számolni
    $a = '3';
    print ($a + '3').'<br>';

    // változó típúsának kiiratása
    print gettype($a).'<br>';

    // változó megnézése, hogy számot tárol-e (boolean értékkel tér vissza)
    print is_numeric($a).'<br>';


    // a php nem ír ki semmit, ha egy false értéket akarunk kiiratni
    $logikaiErtek = false;
    print $logikaiErtek.'<br><br>';



    // változókat össze tudunk adni vagy össze tudunk fűzni
    $x = 7;
    $y = 4;
    $z = $x + $y;
    $hetvennegy = $x.$y;
    
    print 'Az y változó értéke: '.$y.' Az y változó típusa: '.gettype($y).'<br>';
    print $hetvennegy.'<br><br>';



    // egysoros komment
    /* többsoros komment */



    // létre tudunk hozni változót deklarálás nélkül is
    $p;



    // kiírja a függvény az aktuális php verziónk tudnivalóit
    // phpinfo();




    $tizedestort = 3.14;

    print 'Az tizedestort változó értéke: '.$tizedestort.' Az tizedestort változó típusa: '.gettype($tizedestort).'<br>';
    print settype($tizedestort, 'integer');     // integer típusúvá alakítom a változót függvény segítségével
    print 'Az tizedestort változó értéke: '.$tizedestort.' Az tizedestort változó típusa: '.gettype($tizedestort).'<br>';
    print settype($tizedestort, 'double');      // double típusúvá alakítoma változót függvény segítségével
    print 'Az tizedestort változó értéke: '.$tizedestort.' Az tizedestort változó típusa: '.gettype($tizedestort).'<br><br>';



    $tt = 7.28;

    // típúskényszerítéssel alakítom integer típusúvá a változót
    $t = (integer) $tt;
    print $tt.' '.$t.'<br><br>';



    $q = true;
    $w = false;

    // ! a TAGADÓ operátor
    $nemW = !$w;

    print 'w: '.$w.'<br>';
    print 'nemW: '.$nemw.'<br>';


    // && az ÉS operátor
    $es = $q && $w;
    print 'es: '.$es.'<br>';


    // || a VAGY operátor
    $vagy = $q || $w;
    print 'vagy: '.$vagy.'<br>';

?>