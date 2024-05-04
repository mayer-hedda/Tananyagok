<?php

    class Gyűrű {

        // TULAJDONSÁGOK
        private string $gazda;      // látható és szerkeszthető
        private string $forma;      // látható de nem szerkeszthető
        private string $keszito;    // nem látható és nem szerkeszthető
        private int $atmero;        // látható és korlátozottan szerkeszthető



        // KONSTRUKTOR
        public function __construct(string $ujGazda = "Új gazda", string $ujForma = "karika", string $ujKeszito = "Ismeretlen", int $ujAtmero = 2) {
            $this->gazda = $ujGazda;
            $this->keszito = $ujKeszito;
            $this->forma = $ujForma;
            $this->atmero = $ujAtmero;
        }



        // GETTER FÜGGVÉNYEK
        public function getGazda() {
            return $this->gazda;
        }

        public function getForma() {
            return $this->forma;
        }

        public function getAtmero() {
            return $this->atmero;
        }



        // SETTER FÜGGVÉNYEK
        public function setGazda(string $ujGazda) {
            $this->gazda = $ujGazda;
        }

        public function setAtmero(int $ujatmero) {
            if($ujatmero > 0 && $ujatmero < 6) {
                $this->atmero = $ujatmero;
            }
        }



        // STATIKUS FÜGGVÉNY
        public static function eltunik(Gyűrű $peldany) {
            $peldany->gazda = "Ismeretlen";
        }

    }


    $aranygyűrű = new Gyűrű("Andi");
    
    print $aranygyűrű->getGazda()."<br>";
    print $aranygyűrű->getForma()."<br>";
    print $aranygyűrű->getAtmero()."<br>";
    print "<br><br>";

    print $aranygyűrű->setGazda("Enikő")."<br>";
    print $aranygyűrű->getGazda()."<br>";
    print "<br><br>";

    print $aranygyűrű->setAtmero(3)."<br>";
    print $aranygyűrű->getAtmero()."<br>";
    print "<br><br>";

    print Gyűrű::eltunik($aranygyűrű);  
    print $aranygyűrű->getGazda()."<br>".$aranygyűrű->getForma()."<br>".$aranygyűrű->getAtmero()."<br>";
?>