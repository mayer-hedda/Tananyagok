<?php

    if (login_ellennor($_POST['loginUser'], $_POST['loginPass'])) {
        print 'Sikeres bejelentkezés';
    } else {
        print 'Sikertelen bejelentkezés';
    }

    function login_ellenor_sql($strUserNev, $strPass) {
        $strUserNev = stringTisztito($strUserNev);
        $strPass = stringTisztito($strPass);
        $blnLogin = false;

        $host = "localhost";
        $felh = "root";
        $db_pass = "";
        $db_name = "teszt";

        $connection = new msqli($host, $felh, $db_pass, $db_name);

        if ($connection -> connect_error) {
            die("Hibás kapcsolat: ". $connection -> connect_error);
        } else {
            // kapcsolat létrejött
            $_SESSION['kapcsolat'] = $connection;
        }

        return $blnLogin;
    }

    function login_ellenor($strUserName, $strPassw) {
        $strUserNev = stringTisztito($strUserName);
        $strPass = stringTisztito($strPassw);
        $blnLogin = false;

        if ($strUserNev != "" && $strPass != "") {
            $eleresi_ut = 'regek/';
            $strFajlnev = $eleresi_ut.$strUserNev.".txt";
            if (file_exists($strFajlnev)) {
                $fajl = fopen($strFajlnev, "r") or die("Nem nyitható meg a fájl!");
                $strKiolvasottJelszo = fread($fajl, filesize($strFajlnev));

                if ($strKiolvasottJelszo == $strPass) {
                    $blnLogin = true;
                    $_SESSION['user']['name'] = $strUserNev;
                    $_SESSION['user']['jogosultsag'] = '1';
                }

                fclose($fajl);
            }
        }

        return $blnLogin;
    }

?>