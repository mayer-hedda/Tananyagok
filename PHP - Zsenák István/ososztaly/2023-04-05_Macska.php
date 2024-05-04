<?php
/**
 * Summary of Macska
 */
require_once('Haziallat.php');
class Macska extends Haziallat{

    private bool $ehes;
    private string $utolsoEtkezes;
    private static int $ehesLesz = 60;

    public function __construct(int $ujKor = 0, string $ujNev = 'Új Kutya', bool $isHim = false){
        parent::__construct($ujKor, $ujNev, $isHim);
        $this->ehes = false;
        $this->utolsoEtkezes = time();
    }

    private static function ehesseTesz(Macska $peldany){
        if($peldany->utolsoEtkezes + Macska::$ehesLesz < time()){
            $peldany->ehes = true;
        }
    }
    public function getKor(){
        Macska::ehesseTesz($this);
        return $this->kor;
    }
    public function getNev(){
        Macska::ehesseTesz($this);
        return $this->nev;
    }
    public function isHim(){
        Macska::ehesseTesz($this);
        return $this->him;
    }
    public function isEhes(){
        Macska::ehesseTesz($this);
        return $this->ehes;
    }
    
    public function setNev(string $ujNev){
        Macska::ehesseTesz($this);
        $this->nev = $ujNev;
    }
    public function eszik(){
        $this->ehes = false;
    }



}

$macs = new Macska(1, 'Frisky', false);
print $macs->getNev() . '<br />';
print $macs->getKor() . '<br />';
$macs->setNev('Cicamica');
$macs->szulinap();
print $macs->getNev() . '<br />';
print $macs->getKor() . '<br />';
print $macs->isEhes();

?>