<?php

if (registration($_POST['regUserName'],$_POST['regEmail'],$_POST['regPass1'],$_POST['regPass2'])){
    print 'Sikeres regisztráció';
}else{
    print 'Sikertelen regisztráció';
}

function registration($strUserNev, $strEmail, $strPass1, $strPass2){
    
    $strUserNev = stringTisztito($strUserNev);
    $strEmail = stringTisztito($strEmail);
    $strPass1 = stringTisztito($strPass1);
    $strPass2 = stringTisztito($strPass2);
    $blnReg = false;
    
    $eleresi_ut = 'regek/';
    $strFajlnev = $eleresi_ut.$strUserNev.".txt";
    
    if(!file_exists($strFajlnev)){
        if($strUserNev != "" && $strPass1 != "" && $strEmail != ""){
            if ($strPass1 == $strPass2){
                $eleresi_ut = 'regek/';
                $strFajlnev = $eleresi_ut.$strUserNev.".txt";
                $fajl = fopen($strFajlnev, "w") or die("Nem nyitható meg a fájl!");
                fwrite($fajl,$strPass1);
                fclose($fajl);
                $blnReg = true;
            }

        }
        
    }
    
    return $blnReg;
}

?>