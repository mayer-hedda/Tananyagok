<?php
abstract class Haziallat{

    protected string $nev;
    protected int $kor;
    protected bool $him;

    public function szulinap(){
        $this->kor++;
    }

    public function getNev(){
        return $this->nev;
    }

    public function __construct(int $ujKor = 0, string $ujNev = 'Új Kutya', bool $isHim = false){
        $this->kor = $ujKor; //$this = ennek a példánynak a ...
        $this->nev = $ujNev;
        if($isHim == null){
            $this->him = (bool)rand(0, 1);
        }
        else{
            $this->him = $isHim;
        }
       
    }


}


//$x = new Haziallat();
//print $x->getNev();
?>