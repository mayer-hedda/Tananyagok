<?php
    require('Gyogyszer.php');


    // PRÓBA
    $fajdalomcsillapito = new Tipus();
    $fajdalomcsillapito->setFajdalomcsillapito();

    $szirup = new Allag();
    $szirup->setSzirup();

    $gyogyszer = new Gyogyszer("Algopirin", "2024-03-12", $fajdalomcsillapito, "Nemtudom", 2345789, 10, "fehér", $szirup, true);

    print $gyogyszer->getNev()."<br>";
    print $gyogyszer->getLejarat()."<br>";
    print $gyogyszer->getTipus()."<br>";
    print $gyogyszer->getGyarto()."<br>";
    print $gyogyszer->getGyartasiSzam()."<br>";
    print $gyogyszer->getMennyiseg()."<br>";
    print $gyogyszer->getMegbontott()."<br>";
    print $gyogyszer->getSzin()."<br>";
    print $gyogyszer->getAllag()."<br>";
    print $gyogyszer->getRaktaron()."<br>";


    $gyogyszer->setNev("Algoflex");
    print $gyogyszer->getNev()."<br>";

    $gyogyszer->setGyarto("Még mindig nemtudom");
    print $gyogyszer->getGyarto()."<br>";

    $gyogyszer->setMennyiseg(3);
    print $gyogyszer->getMennyiseg()."<br>";

    $gyogyszer->setRaktaron(false);
    print $gyogyszer->getRaktaron()."<br>";


    Gyogyszer::Megbont($gyogyszer);
    print $gyogyszer->getMegbontott();

?>