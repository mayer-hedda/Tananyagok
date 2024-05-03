<?php
require_once('../service/HazService.php');
require_once('baseController.php');
$hazService = new HazService();

if(isset($_GET['x']) && isset($_GET['y']) && 
isset($_GET['feladat']) && $_GET['feladat'] == 'buildHouse'){
    $adat = $hazService->buildHouse($_GET['x'], $_GET['y']);
    print_r($adat);
}

if(isset($_GET['feladat']) && $_GET['feladat'] == 'getAllHouse'){
    $adat = $hazService->getAllHouse();
    print_r($adat);
}

if(isset($_GET['feladat']) && $_GET['feladat'] == 'createEmber'){
    $adat = $hazService->createEmber(2);
    print_r($adat);
}



?>