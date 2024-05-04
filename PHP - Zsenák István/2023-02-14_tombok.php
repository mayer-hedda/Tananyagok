<meta charset="utf-8">
<?php

    // SIMA TÖMB
    $tomb = array(5, 'alma', true, 3.14, null);
    print $tomb[0];
    print $tomb[2];
    print $tomb[4];
    print '<pre>';
    print_r($tomb);
    print '<br>';


    // tömb bejárása FOR ciklussal
    for ($i = 0; $i < count($tomb); $i++) {
        print $tomb[$i].'<br>';
    }


    // tömb bejárása FOREACH ciklussal
    foreach ($tomb as $elem) {
            print $elem.'<br>';
    }
    print '<br><br>';





    // ASSZERTÍV TÖMB
    $asszTomb = array(
        'nev' => 'Sanyi',
        'lakhely' => 'Tápiószentcsömörde',
        'beosztas' => 'Gépelő'
    );
    print_r($asszTomb);
    print '</pre>';
    print $asszTomb['lakhely'];
    print '<br><br>';


    // tömb bejárása FOREACH ciklussal (értéket írja csak ki)
    foreach ($asszTomb as $elem) {
        print $elem.'<br>';
    }


    // tömb bejárása FOREACH ciklussal (értékpárokat ír ki)
    foreach ($asszTomb as $key => $elem) {
        print $key.': '.$elem.'<br>';
    }
    print '<br><br>';





    // számok kiiratása [1; 30] intervallumon
    for ($i = 1; $i <= 30; $i++) {
        if ($i == 30) {
            print $i;
        } else {
            print $i.', ';
        }
    }
    print '<br><br>';


    


    // tömb páros eleminek kiiratása
    for ($i = 0; $i < count($tomb); $i++) {
        if ($i % 2 == 0) {
            print $tomb[$i].'<br>';
        }
    }
    print '<br><br>';





    // ----- FÜGGVÉNYEK PARAMÉTER ALAPJÁN CSOPORTOSÍTVA-----
        // PARAMÉTER NÉLKÜLI
        // PARAMÉTERES

        // ÉRTÉK VISSZAADÓ
        // VÉGREHAJTÓ

    // PARAMÉTER NÉLKÜI && VÉGREHAJTÓ FÜGGVÉNY
        // mindig ugyanazt csinálja a függvény, nincsenek bemenő paraméterei
    function kettoMegKetto() {
        print 4;
    }
    kettoMegKetto();
    print '<br><br>';


    // PARAMÉTERES && VÉGREHAJTÓ FÜGGVÉNY
        // meg lehet adni neki adatokat
    function osszead($a, $b) {
        print $a + $b;
    }
    osszead(2, 6);
    print '<br><br>';


    // PARAMÉTER NÉLKÜLI && ÉRTÉ VISSZAADÓ FÜGGVÉNY
        // nem mindig a leghasznosabb


    // PARAMÉTERES && ÉRTÉK VISSZAADÓ
    function osszead2($a, $b) {
        return $a + $b;
    }
    $eredmeny = osszead2(2, 6);
    print 'Az eredmény: '.osszead2(2, 6);
    print '<br><br>';





    // szöveg kiiratása visszafelel
    $szoveg = 'Indul a gorog aludni';
    for ($i = mb_strlen($szoveg, 'UTF-8') - 1; $i >= 0; $i--) {
        print $szoveg[$i];
    }


    // PALINDROM SAJÁT
        // print '<br>';
        // $string = 'indul a görög aludni';
        // $string = str_replace(' ', '', $string);

        // $forditva = strrev($string);
        // print $forditva;

        // if ($forditva == $string) {
        //     print '<br>Ez a szöveg palindrom!';
        // } else {
        //     print '<br>Ez a szöveg nem palindrom!';
        // }


    // PALINDROM
    print '<br><br>';
    $p = 'indul a gorog aludni';
    $p = str_replace(' ', '', $p);

    $palindrome = true;
    for ($i = 0; $i < strlen($p); $i++) {
        $hatso = strlen($p) - ($i + 1);
        if ($p[$i] != $p[$hatso]) {
            $palindrome = false;
            break;
        }
    }
    if ($palindrome) {
        print 'Palindrom';
    } else {
        print 'Nem palindrom';
    }

?>