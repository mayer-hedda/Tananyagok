<?php

    class RubicCube {

        // TULAJDONSÁGOK
        private static $szabadalmiMeret = 3;

        private int $meret;                 // látható és nem módosítható
        private bool $szabadalom;           // nem látható és nem módosítható
        private string $tulajdonosNev;      // látható és módosítható
        private int $kirakottOldalakSzama;  // látható és korlátozottan módosítható



        // KONSTRUKTOR
        public function __construct(int $meret = 0, bool $szabadalom = true, string $tulajdonosNev = "", int $kirakottOldalakSzama = 0) {
            $this->meret = $meret;
            $this->szabadalom = $szabadalom;
            $this->tulajdonosNev = $tulajdonosNev;
            $this->kirakottOldalakSzama = $kirakottOldalakSzama;
            if($meret == RubicCube::$szabadalmiMeret) {
                $this->szabadalom = true;
            }
        }



        // GETTER FÜGGVÉNYEK
        public function getMeret() {
            return $this->meret;
        }

        public function getTulajdonosNev() {
            return $this->tulajdonosNev;
        }

        public function getKirakottOldalakSzama() {
            return $this->kirakottOldalakSzama;
        }



        // SETTER FÜGGVÉNYEK
        public function setTulajdonosNev($ujTulajdonosNev) {
            $this->tulajdonosNev = $ujTulajdonosNev;
        }

        public function ujOldalKirakasa() {
            if($this->kirakottOldalakSzama > 0) {
                $this->kirakottOldalakSzama--;
            }
        }

        public function oldalElrontasa() {
            if($this->kirakottOldalakSzama > 0) {
                $this->kirakottOldalakSzama--;
            }
        }



        // STATIKUS FÜGGVÉNY
        public static function getMatricaDarabszama(RubicCube $kocka) {
            return $kocka->meret * $kocka->meret * 6;
        }

    }

    $rk1 = new RubicCube();
    $rk2 = new RubicCube(5);
    $rk3 = new RubicCube(8, true);
    $rk4 = new RubicCube(8, true, "Gipsz Jakab");
    $rk5 = new RubicCube(8, true, "Kis Béla Rendszergazda", 2);


    print $rk5->getTulajdonosNev();
    $rk5->setTulajdonosNev("Nagy Jóska");
    print RubicCube::getMatricaDarabszama($rk5);

?>