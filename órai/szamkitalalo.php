<!DOCTYPE html>
<html lang="hu">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="szamkitalalo.css">
    <title>Számkitaláló</title>
</head>
<body>
    <h1>Számkitalálós játék</h1>
    <form action="szamkitalalo.php" method="POST" name="form1">
        <input class="input" type="number" name="szamom" placeholder="Adj meg egy számot" min="1" max="100">
        <input type="submit" name="gomb" value="Csináld!">
    </form>
    <?php

        if (isset($_POST['gomb'])) {
            print "Megnyomtad a gombot!<br>";

            if (isset($_POST['szamom']) && !empty($_POST['szamom'])) {
                if ($_POST['szamom'] >= 1 && $_POST['szamom'] <= 100) {
                    $intSzamunk = $_POST['szamom'];
                    $intGepSzama = rand(1, 100);

                    print "Mi számunk: ".$intSzamunk."<br>";
                    print "Gép száma: ".$intGepSzama."<br>";

                    if ($intGepSzama == $intSzamunk) {
                        print "Egyezik";
                    } else if ($intGepSzama > $intSzamunk) {
                        print "Kisebb számot adtál meg";
                    } else {
                        print "Nagyobb számot adtál meg";
                    }
                } else {
                    print "Nincs a határértékek közt a számod";
                }
            } else {
                print "Nincs számod";
            }
        } else {
            print "Még nem nyomtad meg a gombot!";
        }

    ?>
</body>
</html>