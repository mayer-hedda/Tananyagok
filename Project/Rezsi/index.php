<?php
    require_once("../Kezeles/fuggvenyek.php");

    if(isset($_POST['addOraAllas'])) {
        $errors = array();

        if(empty($_POST['date'])) {
            array_push($errors, "Add meg a leolvasás dátumát!");
        }
        if(empty($_POST['oraAllas'])) {
            array_push($errors, "Add meg a gázóra állását!");
        }

        if(empty($errors)) {
            $date = $_POST['date'];
            $oraAllas = $_POST['oraAllas'];

            $sql = "CALL `addGazoraAllas`('$date', '$oraAllas')";
            db($sql);
        }
    }


    $haviOsszes = 300;
    $sql = "CALL `getAllGazoraAllas`()";
    $result = db($sql);

    $month = date("Y-m");
    $osszesGaz = array();
    $haviGaz = array();
    while($row = mysqli_fetch_assoc($result)) {
        $osszesGaz[] = $row;

        if(substr($row['month'], 0, 7) == $month) {
            $haviGaz[] = $row;
        }
    }

    $kezdo = $haviGaz[0]['kobmeter'];
    $utolso = $haviGaz[count($haviGaz)-1]['kobmeter'];
    $maradt = ($kezdo + $haviOsszes) - $utolso;

    $szazalek = ($maradt / $haviOsszes) * 100;

    $today = date("Y-m-d");

?>

<!DOCTYPE html>
<html lang="hu">
<head>
    <title>Rezsi</title>

    <meta author="Mayer Hedda Adrienn">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" href="css/index.css">

    <script>
        window.addEventListener('scroll', () => {
            window.scrollTo(0, 0;)
        })
    </script>
</head>
<body>
    
    <!-- <nav class="navbar navbar-expand-lg bg-body-tertiary bg-dark nav" data-bs-theme="dark">
        <div class="container-fluid">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="a nav-link" href="../To-Do/index.php">Tasks</a>
                <a class="a nav-link active disabled" aria-current="page">Fogyasztás</a>
                <a class="a nav-link" href="../WordsCard/index.php">WordsCard</a>
                <a class="a nav-link" href="../Menu/index.php">Menü</a>
                <a class="nav-link disabled">Disabled</a>
            </div>
            </div>
        </div>
    </nav> -->
    <div class="row">
        <nav class="col-md-2">
            <a class="a nav-link" href="../To-Do/index.php">Tasks</a><hr>
            <a class="a nav-link active disabled" aria-current="page">Fogyasztás</a><hr>
            <a class="a nav-link" href="../WordsCard/index.php">WordsCard</a><hr>
            <a class="a nav-link" href="../Menu/index.php">Menü</a><hr>
            <div class="logout">
                <hr>
                <a class="a nav-link text" href="../Kezeles/logout.php">Logout</a>
            </div>
        </nav>

        <div class="container mt-5 col-md-10 tartalom">
            <form action="index.php" method="post" class="w-50 m-auto d-flex flex-column">
                <h3>Gázóra adatai: </h3>
                <input class="inp form-control" type="date" name="date" id="date" value="<?php print $today ?>"><br>
                <div class="input-group">
                    <input type="number" class="form-control" placeholder="Gázóra állása">
                    <span class="input-span input-group-text">m³</span>
                </div>
                <button class="btn btn-primary button" type="submit" name="addOraAllas">Küldés!</button>
            </form>

            <h5>Maradék havi gáz:</h5>
            <div class="progress pg">
                <div class="progress-bar pgb" role="progressbar" style="width: <?php print $szazalek ?>%;" aria-valuenow="<?php print $maradt ?>" aria-valuemin="0" aria-valuemax="300">
                    <div class="pgt"><?php print $maradt ?>m³</div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>