<?php

    class Tipus {

        // TULAJDONSÁGOK
        private string $ertek;



        // KONSTRUKTOR
        public function __construct(){
            $this->ertek = "";
        }



        // GETTER
        public function getErtek() {
            return $this->ertek;
        }



        // ÉRTÉK BEÁLLÍTÁSA
        public function setFajdalomcsillapito() {
            $this->ertek = "Fájdalomcsillapító";
        }

        public function setAllergiaGyogyszer() {
            $this->ertek = "Allergia gyógyszer";
        }

        public function setGyulladascsokkento() {
            $this->ertek = "Gyulladáscsökkentő";
        }

        public function setKohogescsokkento() {
            $this->ertek = "Köhögéscsökkentő";
        }



        // STATIKUS FÜGGVÉNY
        public function getAllTipus() {
            $ertekek = array("Fájdalomcsillapító", "allergia gyógyszer", "Gyulladáscsökkentő", "Köhögéscsökkentő");

        }

    }

?>