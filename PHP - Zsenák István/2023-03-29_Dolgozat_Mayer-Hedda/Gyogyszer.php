<?php
    require_once('Tipus.php');
    require_once('Allag.php');

    class Gyogyszer {

        // TULAJDONSÁGOK
        private string $nev;
        private string $lejarat;
        private Tipus $tipus;
        private string $gyarto;
        private int $gyartasiSzam;
        private int $mennyiseg;
        private bool $megbontott;
        private string $szin;
        private Allag $allag;
        private bool $raktaron;



        // KONSTUKTOR
        public function __construct(string $nev, string $lejarat, Tipus $tipus, string $gyarto, int $gyartasiSzam, int $mennyiseg, string $szin, Allag $allag, bool $raktaron) {
            $this->nev = $nev;
            $this->lejarat = $lejarat;
            $this->tipus = $tipus;
            $this->gyarto = $gyarto;
            $this->gyartasiSzam = $gyartasiSzam;
            $this->mennyiseg = $mennyiseg;
            $this->szin = $szin;
            $this->allag = $allag;
            $this->raktaron = $raktaron;

            $this->megbontott = false;
        }



        // GETTEREK
        public function getNev() {
            return $this->nev;
        }

        public function getLejarat() {
            return $this->lejarat;
        }

        public function getTipus() {
            return $this->tipus->getErtek();
        }

        public function getGyarto() {
            return $this->gyarto;
        }

        public function getGyartasiSzam() {
            return $this->gyartasiSzam;
        }

        public function getMennyiseg() {
            return $this->mennyiseg;
        }

        public function getMegbontott() {
            return $this->megbontott;
        }

        public function getSzin() {
            return $this->szin;
        }

        public function getAllag() {
            return $this->allag->getErtek();
        }

        public function getRaktaron() {
            return $this->raktaron;
        }



        // SETTEREK
        public function setNev(string $ujnev) {
            $this->nev = $ujnev;
        }

        public function setGyarto(string $ujGyarto) {
            $this->gyarto = $ujGyarto;
        }

        public function setMennyiseg(int $ujMennyiseg) {
            if($ujMennyiseg < $this->mennyiseg && $this->mennyiseg > 0) {
                $this->mennyiseg = $ujMennyiseg;
            }
        }

        public function setRaktaron(bool $ujRaktaron) {
            $this->raktaron = $ujRaktaron;
        }



        // STATIKUS FÜGGVÉNY
        public static function Megbont(Gyogyszer $gyogyszer) {
            if($gyogyszer->megbontott = true) {
                return false;
            } else {
                $gyogyszer->megbontott = true;
                return $gyogyszer;
            }
        }
	
}

?>