<?php
require_once('../model/Haz.php');
require_once('../model/Map.php');
require_once('../model/Ember.php');
if(!isset($_SESSION['hazak'])){
    $_SESSION['hazak'] = array();
    Map::init();
}
class HazService{
    public function buildHouse(int $pozX, int $pozY){
        $haz = new Haz();
        Aspektus::log($haz);
        if($pozX > Map::$MAXXY - Haz::$MERET / 2 || $pozX < Map::$MINXY + Haz::$MERET / 2 ||
        $pozY > Map::$MAXXY - Haz::$MERET / 2 || $pozY < Map::$MINXY + HAZ::$MERET / 2){
            return false;
        }
        if(!Map::isValidHousePoint($pozX, $pozY)){
            return false;
        }
        $map = Map::createMap(Allapot::EPUL, $haz->getId(), 
        null, new Pont($pozX, $pozY));
        $_SESSION['hazak'][] = $map;
        return $map;
    }

    public function getAllHouse(){
        return Haz::getAllHouse();
    }

    public function createEmber($darab){
        if(is_numeric($darab) && is_int($darab)){
            $service = new HazService();
            $max = count($service->getAllHouse()) * Haz::$LAKOK_MAX_SZAMA;
            $current = count(Ember::getAllEmber());
            if($current + $darab <= $max){
                $haz = new Haz();
                return $haz->createEmber($darab);

            }
            return false;
        }
    }

}


?>