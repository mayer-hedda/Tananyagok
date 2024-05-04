<?php
    function regisztracio_tarolas($username) {
        // letárolja fájlba a regisztrációs adatokat
        $regEngedely = false;

        $fajlNev = "regisztracio.txt";
        if (file_exists($fajlNev)) {
            $fajl = fopen ($fajlNev, "a+");

            $tartalom = "";
            while (!feof($fajl)) {
                $tartalom = $tartalom."\r\n".fgets($fajl);           // gets -> stringenként olvas be, getc -> caracterenként olvas be
                
            }

            $regEngedely = preg_match($username, $tartalom);

            if (!$regEngedely) {
                fwrite($username, $fajl);
            }
    
            fclose($fajlNev);
        }
    }
?>