<!DOCTYPE html>
<html lang="hu">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="elso.php" method="POST" name="elso">
        <input type="text" name="szoveg">
        <input type="submit" value="Submit" name="gomb">
    </form>

    <?php
        $str_szovegInput = $_POST['szoveg'];
        print $str_szovegInput;

        $arr_egydimenzios = array();
        $arr_egydimenzios = [1, 2, 'három', 4];
        // print_r($arr_egydimenzios); // print_r tömböket nyit ki
        // print $arr_egydimenzios[2];
        // var_dump($arr_egydimenzios);

        if ($str_szovegInput == 'elso') {
            print '<br>1.';
        } else if ($str_szovegInput == 'masodik'){
            print '<br>2.';
        } else {
            print '<br>más';
        }


        print "<table>";
        for ($j = 1; $j <= 10; $j++) {
            print "<tr>";
            for ($i = 1; $i <= 10; $i++) {
                print "<td>".$i*$j."</td>";
            }
            print "</tr>";
        }
        print "</table>";


        foreach($arr_egydimenzios as $elem) {
            print $elem.", ";
        }


        switch ($_POST['szoveg']) {
            case 1:
                 print "<br>első sor";
                break;
            case 2:
                print "<br>második sor";
                break;
            case 3:
                print "<br>harmadik sor";
                break;
            default:
                print "<br>üres sor";
        }


        // $arr_tobbdimenzios = array();
        // $arr_tobbdimenzios = [1, 2, 3, 4, 5][1, 2, 3, 4, 5];


        // print 'Hello World!';
        // $string = 'szöveg';
        // $integer = 14;
        // $boolean = true;
        // // Egysoros megjegyzés
        // /* Többsoros
        // megjegyzés */
        // print $string;
        // print $integer;
        // print $boolean;

        // print '<h1>Oldal</h1>';

        // // $_POST['name'];
        // // $_GET['name'];
        // // $_SESSION[''];

        // print '<h2>'.$string.'</h2>';

        // print 10/2;
    ?>
</body>
</html>