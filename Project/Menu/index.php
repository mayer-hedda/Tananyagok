<?php
// ini_set('display_errors', 1);
// ini_set('display_startup_error', 1);
//     error_reporting(E_ALL);
    
    // print 5/0;
    if(isset($_POST['generate'])) {
        $sql = "SELECT * FROM `hozzavalok`";
    }

?>

<!DOCTYPE html>
<html lang="hu">
<head>
    <title>Menü</title>

    <meta author="Mayer Hedda Adrienn">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="./css/index.css">
</head>
<body>
    
    <form action="index.php" method="post">
        <button type="submit" name="generate">Heti menü generálása!</button>
    </form>

</body>
</html>