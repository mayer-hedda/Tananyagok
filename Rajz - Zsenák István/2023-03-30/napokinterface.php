<?php

    if(isset($_POST['btnSend'])) {
        if(strlen($_POST['txtDatum'] == 13)) {
            $datum = $_POST['txtDatum'];
            $min = $_POST['nmMin'];
            $max = $_POST['nbMax'];

            $xml = simplexml_load_file('napok.xml');
            $newNode = new SimpleXMLIterator($xml->__toString());
            $nap = $newNode->addChild('nap');
            $nap->addAttribute('datum', $datum);
            $nap->addChild('min', $min);
            $nap->addChild('max', $max);

            $xml->addChild($newNode);

            file_put_contents('napok.xml', $xml->asXML());
        }else {
            print "Hibás dátum formátum!";
        }
    }

?>

<img src="napok.php">

<form method="post">
    <input type="text" name="txtDatum" placeholder="ÉÉÉÉ. HH. NN."><br>
    Napi maximum: <input type="number" name="nmMax" min="-20" max="50" value="0"><br>
    Napi minimum: <input type="number" name="nmMin" min="-20" max="50" value="0"><br>
    <input type="submit" value="Mentés" name="btnSend"><br>
</form>