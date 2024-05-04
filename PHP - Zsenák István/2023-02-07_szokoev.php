<form method="post">

    <!-- input mezők létrehozása php segítségével -->
    <input type="number" name="nbEv" placeholder="Írja be a születési évét!" min="<?php
    print (date('Y') - 100);    // date('Y') függvény a jelenlegi évet adja vissza
    ?>" max="<?php
    print date('Y');
    ?>" value="<?php
    print (date('Y') - 20);
    ?>">

    <input type="submit" name="btnSzamol" value="Számold ki!"><br />


</form>

<?php

    // gomb "létezésének" vizsgálata
    if(isset($_POST['btnSzamol'])) {

        // bekért év eltárolása változóban
        $ev = $_POST['nbEv'];

        // szökőév vizsgálata
        if (($ev % 4 == 0 && $ev % 100 != 0) || $ev % 400 == 0) {
            print $ev .' szökőév.';
        } else {
            print $ev.' nem szökőév.';
        }

    }

?>





<form method="post">

</form>

<?php

    // háromszög oldalainak változókban való eltárolása
    $a = 3;
    $b = 4;
    $c = 5;

    // Egy háromszög akkor szerkeszthető, ha bármely (minden) két oldalának összege nagyobb, mint a harmadik oldal.
    if($a + $b > $c && $a + $c > $b && $b + $c > $a) {
        print 'A háromszög szerkeszthető!';
    } else{
        print 'A háromszög nem szerkeszthető!';
    }

?>
