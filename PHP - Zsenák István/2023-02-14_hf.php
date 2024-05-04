<?php

    // 1.: Kibővíteni a függvényt, bemeneti paraméterek: (első szám, második szám, műveleti jel)
    function szamologep($a, $b, $mj) {
        print "<br><br>";

        if ($mj == '/') {
            return $a / $b;
        } else if ($mj == '*') {
            return $a * $b;
        } else if ($mj == '+') {
            return $a + $b;
        } else if ($mj == '-') {
            return $a - $b;
        } else {
            return 'Nem megfelelő műveleti jelet adtál meg!';
        }
    }

    print szamologep(5, 2, '*');


    

    
    // 2.: Anagramma => $a string, $b string anagrammái-e egymásnak (karakterek sorbarendezése (csak tömböt kell csinálni belőle és úgy sorbarendezni))
    function anagramma($a, $b) {
        print "<br><br>";
        $betukA = array();
        $betukB = array();
        $sorbarendezettA = "";
        $sorbarendezettB = "";

        for ($i = 0; $i < strlen($a); $i++) {
            array_push($betukA, $a[$i]);
        }

        for ($i = 0; $i < strlen($b); $i++) {
            array_push($betukB, $b[$i]);
        }

        sort($betukA);
        sort($betukB);


        for ($i = 0; $i < count($betukA); $i++) {
            $sorbarendezettA = $sorbarendezettA.$betukA[$i];
        }

        for ($i = 0; $i < count($betukB); $i++) {
            $sorbarendezettB = $sorbarendezettB.$betukB[$i];
        }

        if ($sorbarendezettA == $sorbarendezettB) {
            print "A két szó anagrammája egymásnak!";
        } else {
            print "A két szó nem anagrammája egymásnak!";
        }
    }

    anagramma("adat", "data");


?>