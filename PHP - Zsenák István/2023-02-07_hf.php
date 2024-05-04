<form method="post">
    <input type="number" name="aSzam" placeholder="Első szám"><br>
    <input type="number" name="bSzam" placeholder="Második szám"><br>
    <input type="number" name="cSzam" placeholder="Harmadik szám"><br>
    <input type="submit" name="btn" value="Click!"><br>
</form>

<?php

    if(isset($_POST['btn'])) {

        $aSzam = $_POST['aSzam'];
        $bSzam = $_POST['bSzam'];
        $cSzam = $_POST['cSzam'];
        
        print $aSzam."<br>";
        print $bSzam."<br>";
        print $cSzam."<br>";

    } else {

        print 'Nem adtál meg számot!';
        
    }


?>