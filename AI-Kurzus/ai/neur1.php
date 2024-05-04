<?php
session_start();
if(isset($_POST['reset'])){
    session_destroy();
}
if(!isset($_SESSION['x'])){
$x = 50;
$v = array(30,90,10,20,60,70);
$t = array();
$e = 3;
$r = 0;
$_SESSION['x'] = $x;
$_SESSION['v'] = $v;
$_SESSION['t'] = $t;
$_SESSION['e'] = $e;
$_SESSION['r'] = $r;
}

$x = $_SESSION['x'];
$v = $_SESSION['v'];
$t = $_SESSION['t'];
$e = $_SESSION['e'];
$r = $_SESSION['r'];

if($x <= rand(0, $v[0])){
    $t[] = 0;
    if($x <= rand(0, $v[2])){
        $t[] = 2;
        $r = 1;
    }
    elseif($x <= rand(0, $v[3])){
        $t[] = 3;
        $r = 2;
    }
}
elseif($x <= rand(0, $v[1])){
    $t[] = 1;
    if($x <= rand(0, $v[4])){
        $t[] = 4;
        $r = 3;
    }
    elseif($x <= rand(0, $v[5])){
        $t[] = 5;
        $r = 4;
    }
}

if($e != $r){
    for($i = 0; $i < count($t); $i++){
        $v[$t[$i]]--;
    }
}
else print $r;

print_r($v);
print_r($t);

$_SESSION['x'] = $x;
$_SESSION['v'] = $v;
$_SESSION['t'] = array();
$_SESSION['e'] = $e;
$_SESSION['r'] = $r;

?>

<form method="post"><input type="submit" name="new" value="Futtatás"></form>
<form method="post"><input type="submit" name="reset" value="Tudásbázis törlése"></form>