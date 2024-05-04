<?php
session_start();

if(!isset($_SESSION['data'])){
    
    $_SESSION['data'] = array();
    
}
if(isset($_POST['session_destroy'])){
    session_destroy();
    print '<meta http-equiv="refresh" content="0">';
}
if(isset($_POST['btnAdd'])){
   
    $_SESSION['data'][] = array($_POST['temp'], $_POST['rbLazas']);    
    print '<meta http-equiv="refresh" content="0">';
}

print_r($_SESSION);

$laz = 100;
$data = $_SESSION['data'];
for($i = 0; $i < count($_SESSION['data']); $i++){
    
    if($data[$i][1] == 1 && $data[$i][0] < $laz){
        $laz = $data[$i][0];
    }
}


?>
<form method="post">
    Hőfok: <input type="text" name="temp"><br>
    Lázas: <input type="radio" name="rbLazas" checked value="1"> Igen <input type="radio" name="rbLazas" value="0"> Nem
<input type="submit" name="btnAdd" value="Adat hozzáadása">
</form>
<br>
Láz: <?php print $laz; ?> fok<br>
<br>
<form method="post">
    <input type="submit" name="session_destroy" value="Tudásbázis törlése">
</form>