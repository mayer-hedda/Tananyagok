<?php
require_once('Allapot.php');
require_once('Pont.php');
class Map{
public static int $MINXY = 0;
public static int $MAXXY = 1000;
private int $id;
private int $entitas1Id;
private $entitas2Id;
private Pont $pozicio;
private Pont $cel;
private Allapot $allapot;

public static $HAZAK = array();

public static function init(){

    $_9 = new Map();
        $_9->id = 9;
        $_9->allapot = Allapot::EPUL;
        $_9->cel = new NullPont();
        $_9->entitas1Id = 1;
        $_9->entitas2Id = null;
        $_9->pozicio = new Pont(500, 400);
    $_8 = new Map();
    $_8->id = 8;
        $_8->allapot = Allapot::EPUL;
        $_8->cel = new NullPont();
        $_8->entitas1Id = 2;
        $_8->entitas2Id = null;
        $_8->pozicio = new Pont(300, 250);
    $_7 = new Map();
        $_7->id = 7;
        $_7->allapot = Allapot::EPUL;
        $_7->cel = new NullPont();
        $_7->entitas1Id = 1;
        $_7->entitas2Id = null;
        $_7->pozicio = new Pont(820, 222);

        Map::$HAZAK[] = $_8;
        Map::$HAZAK[] = $_9;
        Map::$HAZAK[] = $_7;

        $_SESSION['hazak'] = Map::$HAZAK;

}
private function __construct(){

}

public static function createMap(Allapot $allapot, 
int $entitas1Id, $entitas2Id, Pont $pozicio, Pont $cel = new NullPont()){
    if($cel->isNull() && $cel != null){
        return false;
    }
    $map = new Map();
    $map->id = time();
    $map->allapot = $allapot;
    $map->entitas1Id = $entitas1Id;
    $map->pozicio = $pozicio;
    $map->cel = new NullPont();
    $map->entitas2Id = null;
    return $map;
}

public static function isValidHousePoint($x, $y){
    $min = round(sqrt(pow(Haz::$MERET, 2) + pow(Haz::$MERET,2)));
    
    for($i = 0; $i < count($_SESSION['hazak']); $i++){
        if(abs($x - $_SESSION['hazak'][$i]->pozicio->x) < $min ||abs($y - $_SESSION['hazak'][$i]->pozicio->y) < $min ){
            return false;
        }
    }
    return true;
}

public function getPozicio(){
    return $this->pozicio;
}

public static function getAllMapItem(){
    return Map::$HAZAK;
}

}
?>