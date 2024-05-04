<?php

if (login_ellenor_sql($_POST['loginUser'],$_POST['loginPass'])){
    print 'Sikeres bejelentkezés';
    
}else{
    print 'Sikertelen bejelentkezés';
}

function login_ellenor_sql($strUserNev, $strPass){
    
    $blnLogin = FALSE;
    $sql = 'SELECT * FROM `user` WHERE `username` = "'.$strUserNev.'"';

    $result = mysqli_query($_SESSION['kapcsolat'], $sql);

    if (mysqli_num_rows($result) == 1) {
        while ($result2 = mysqli_fetch_array($result)) {  // mysqli_fetch_assoc($result)
            $eredmeny['username'] = $result2['username'];
            $eredmeny['password'] = $result2['password'];
            if ($eredmeny['password'] == $strPass) {
                $blnLogin = TRUE;
                $_SESSION['user']['name'] = $eredmeny['username'];
                $_SESSION['user']['jog'] = $eredmeny['username'];
            }
        }
    }
    
    
    return $blnLogin;
    
}


function login_ellenor($strUserNev, $strPass){
    
    $strUserNev = stringTisztito($strUserNev);
    $strPass = stringTisztito($strPass);
    $blnLogin = false;
    
    if ($strUserNev != "" && $strPass != ""){
        $eleresi_ut = 'regek/';
        $strFajlnev = $eleresi_ut.$strUserNev.".txt";
        if(file_exists($strFajlnev)){
            $fajl = fopen($strFajlnev, "r") or die("Nem nyitható meg a fájl!");
            $strKiolvasottJelszo =  fread($fajl,filesize($strFajlnev));

            if($strKiolvasottJelszo == $strPass){
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