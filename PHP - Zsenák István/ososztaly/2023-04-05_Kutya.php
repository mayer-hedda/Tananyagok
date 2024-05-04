<?php
require_once('Vercsoport.php');
require_once('VercsoportEnum.php');
require_once('Haziallat.php');
class Kutya extends Haziallat{

    private Vercsoport $vercsoport;
    private bool $oltott;
    public static string $os = 'Farkas';
    public static bool $veszettsegOltasKotelezo = true;
    public static bool $kotelezoChip = true;
    public VercsoportEnum $vcse;

    public function __construct(int $ujKor = 0, string $ujNev = 'Új Kutya', bool $isHim = false, Vercsoport $ujVcs = null, $oltott = false){
        parent::__construct($ujKor, $ujNev, $isHim);
        //$this->kor = $ujKor; //$this = ennek a példánynak a ...
        //$this->nev = $ujNev;
        $this->oltott = $oltott;
        //if($isHim == null){
          //  $this->him = (bool)rand(0, 1);
        //}
        //else{
          //  $this->him = $isHim;
        //}
        if($ujVcs == null){
            $this->vercsoport = new Vercsoport();
        }
        else{
            $this->vercsoport = $ujVcs;
        }
    }

    public function getKor(){
        return $this->kor;
    }

    

    public function isHim(){
        return $this->him;
    }

    public function vercsoportTeszt(string $vcs){
        if($this->vercsoport->getErtek() == $vcs){
            return true;
        }
        return false;
    }

    

    public function setNev(string $ujNev){
        $this->nev = $ujNev;
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

    public function oltottTeszt(){
        return $this->oltott;
    }

    public function beolt(){
        $this->oltott = true;
    }

}

$bodri = new Kutya();
$zsuli = new Kutya();

$zsuli->setNev('Zsülike');
//$zsuli->kor = 5;
print $zsuli->getNev();
print $zsuli->getKor();
$zsuli->szulinap();
print $zsuli->getKor();

$bodri->setNev('Bodrika');
print $bodri->getNev();

//$zsuli->kor = 2;
//print $zsuli->kor;
$vcs = new Vercsoport();
$vcs->setToDEA4();
$menhelyi = new Kutya(3, 'Tekergő', true, $vcs, false);
print $menhelyi->getNev();
print $menhelyi->vercsoportTeszt('DEA4');

if($kk = $menhelyi->parosodik($zsuli)){
    print $kk->getNev();
    print $kk->vercsoportTeszt('DEA4');
}
else{
    print 'A két kutya neme azonos.';
}

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


if($kkk = Kutya::parosodas($menhelyi, $zsuli)){
    print $kkk->getNev();
}
else{
    print 'A két kutya neme azonos.';
}

$a = new Kutya();
$a->vcse = VercsoportEnum::DAL;
print $a->vcse->name;
print $a->vcse->value;

?>