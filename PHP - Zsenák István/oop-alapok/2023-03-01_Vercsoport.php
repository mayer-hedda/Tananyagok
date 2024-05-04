<?php

    class Vercsoport{

        // TULAJDONSÁG
        private string $ertek;


        // KONSTRUKTOR
        public function __construct(){
            $this->ertek = '';
        }


        // SETTEREK
        public function setToDEA1(){
            $this->ertek = 'DEA1';
        }

        public function setToDEA1_1(){
            $this->ertek = 'DEA1.1';
        }

        public function setToDEA4(){
            $this->ertek = 'DEA4';
        }

        public function setToDAL(){
            $this->ertek = 'DAL';
        }

        public function getErtek(){
            return $this->ertek;
        }


        /*
        // GETTER
        public function getAllErtek(){
            $ertekek = array('DEA1', 'DEA1.1', 'DEA4', 'DAL');
            return $ertekek;
        }
        */


        // STATIKUS FÜGGVÉNY
        public static function getAllErtek(){
            $ertekek = array('DEA1', 'DEA1.1', 'DEA4', 'DAL');
            return $ertekek;
        }

    }


?>