<?php
    require_once('2023-03-01_Vercsoport.php');
    require_once('2023-03-08_VercsoportEnum.php');

    class Kutya{

        // TULAJDONSÁGOK
        private string $nev;
        private int $kor;
        private bool $him;
        private Vercsoport $vercsoport;
        private bool $oltott;
        public static string $os = 'Farkas';
        public static bool $veszettsegOltasKotelezo = true;
        public static bool $kotelezoChip = true;
        public VercsoportEnum $vcse;


        // KONSTRUKTOR
        public function __construct(int $ujKor = 0, string $ujNev = 'Új Kutya', bool $isHim = false, Vercsoport $ujVcs = null, $oltott = false){
            $this->nev = $ujNev;
            $this->oltott = $oltott;

            if($ujKor > 0) {
                $this->kor = $ujKor;    //$this = ennek a példánynak a ...
            }

            if($isHim == null){
                $this->him = (bool)rand(0, 1);
            }
            else{
                $this->him = $isHim;
            }

            if($ujVcs == null){
                $this->vercsoport = new Vercsoport();
            }
            else{
                $this->vercsoport = $ujVcs;
            }
        }


        // GETTEREK
        public function getKor(){
            return $this->kor;
        }

        public function isHim(){
            return $this->him;
        }

        public function getNev(){
            return $this->nev;
        }

        public function vercsoportTeszt(string $vcs){
            if($this->vercsoport->getErtek() == $vcs){
                return true;
            }
            return false;
        }

        public function oltottTeszt(){
            return $this->oltott;
        }


        // SETTEREK
        public function szulinap(){
            $this->kor++;
        }

        public function setNev(string $ujNev){
            $this->nev = $ujNev;
        }
        public function beolt(){
            $this->oltott = true;
        }



        public function parosodik(Kutya $masik){
            if($this->him == $masik->him){
                return false;
            }
            $utod = new Kutya();
            $utod->kor = 0;
            $utod->nev = 'Kiskutya';
            $utod->him = (bool)rand(0, 1);
            $utod->vercsoport = $this->vercsoport;
            return $utod;
        }

        public static function parosodas(Kutya $egyik, Kutya $masik){
            if($egyik->him == $masik->him){
                return false;
            }
            $utod = new Kutya();
            $utod->kor = 0;
            $utod->nev = 'Kiskutya';
            $utod->him = (bool)rand(0, 1);
            $utod->vercsoport = $egyik->vercsoport;
            return $utod;
        }

    }














    $bodri = new Kutya();
    $zsuli = new Kutya();
    
    // Zsüli nevének megtekintése, megváltoztatása:
    print $zsuli->getNev();     // Új kutya
    $zsuli->setNev('Zsülike');
    $zsuliNeve = $zsuli->getNev();
    print $zsuliNeve;           // Zsülike



    // Zsüli korának megtekintése, megváltoztatása
    print $zsuli->getKor();     // 0
    $zsuli->szulinap();
    print $zsuli->getKor();     // 1



    // Bodri nevének megtekintése, megváltoztatása
    print $bodri->getNev();     // Új kutya
    $bodri->setNev('Bodrika');
    print $bodri->getNev();     // Bodrika



    // Bodri korának megtekintése, megváltoztatása
    print $bodri->getKor();     // 0
    $bodri->szulinap();
    print $bodri->getKor();     // 1



    // új vércsoport létrehozása
    $vcs = new Vercsoport();
    $vcs->setToDEA4();

    // menhelyi kutya létrehozása az új vércsoporttal
    $menhelyi = new Kutya(3, 'Tekergő', true, $vcs);
    print $menhelyi->getNev();      // Tekergő
    print( $menhelyi->vercsoportTeszt('DEA4'));     // 1 (true)



    // NEM STATIKUS: kölyökkutya nevének és a vércsoporttesztnek a kiiratása, ha nem azonos nemű kutyák párosodtak
    if($kk = $menhelyi->parosodik($zsuli)){
        print $kk->getNev();
        print $kk->vercsoportTeszt('DEA4');
    }
    else{
        print 'A két kutya neme azonos.';
    }



    // STATIKUS: kölyökkutya nevének és a vércsoporttesztnek a kiiratása, ha nem azonos nemű kutyák párosodtak
    if($kkk = Kutya::parosodas($menhelyi, $zsuli)){
        print $kkk->getNev();
    }
    else{
        print 'A két kutya neme azonos.';
    }



    // ha kötelező a veszettség elleni oltás és a kutyánk nincsen beoltva, akkor beoltjuk
    if(Kutya::$veszettsegOltasKotelezo == true && $menhelyi->oltottTeszt() != true){
        $menhelyi->beolt();
    }
    
    print $menhelyi->oltottTeszt();



    //getAllKutyaFromDatabase();
    //$fantomKutya = new Kutya(2, 'Riska', true, null, false);
    //$kutyak = array();
    //$kutyak = $fantomKutya->getAllKutyaFromDatabase();

    //$kutyak = array();
    //$kutyak = Kutya::getAllKutyaFromDatabase();

    //$vcs = new Vercsoport();
    //print_r($vcs->getAllErtek());

    print_r(Vercsoport::getAllErtek());



    // új kutya létrehozása és egy vércsoport enum érték adása neki
    $a = new Kutya();
    $a->vcse = VercsoportEnum::DAL;
    print $a->vcse->name;
    print $a->vcse->value;

?>