<?php

    $host = "localhost";
    $dbUser = "root";
    $dbPass = "";
    $dbName = "teszt";

    $conn = new mysqli($host, $dbUser, $dbPass, $dbName);

    if ($conn -> connect_error) {
        die("Kapcsolathívási hiba: ".$conn -> connect_error);
    } else {
        $_SESSION['kapcsolat'] = $conn;
    }

    mysqli_query($conn, "set names 'utf8'");
    mysqli_query($conn, "set character set 'utf8'");

?>