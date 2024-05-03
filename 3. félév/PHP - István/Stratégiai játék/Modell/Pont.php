<?php
class Pont{
public int $x;
public int $y;

public function __construct(int $x, int $y){
    $this->x = $x;
    $this->y = $y;
}

public function isNull(){
    if($this->x == null || $this->y == null){
        return true;
    }
    return false;
}

public function isValid(){
    if($this->x > -1 && $this->y > -1){
        return true;
    }
    return false;
}
}
class NullPont extends Pont{
    public function __construct(){
        $this->x = -1;
        $this->y = -1;
    }
}


?>