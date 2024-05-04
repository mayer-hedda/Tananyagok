<?php

    class Allag {

        // TULAJDONSAG
        private string $ertek;



        // KONSTRUKTOR
        public function __construct() {
            $this->ertek = "";
        }



        // GETTER
        public function getErtek() {
            return $this->ertek;
        }



        // ÉRTÉK BEÁLLÍTÁSA
        public function setKapszula() {
            $this->ertek = "Kapszula";
        }

        public function setTabletta() {
            $this->ertek = "Tabletta";
        }

        public function setPor() {
            $this->ertek = "Por";
        }

        public function setSzirup() {
            $this->ertek = "Szirup";
        }



        // STATIKUS FÜGGVÉNY
        public static function getAllAllag() {
            $ertekek = array("Kapszula", "Tabletta", "Por", "Szirup");
            return $ertekek;
        }


    }

?>