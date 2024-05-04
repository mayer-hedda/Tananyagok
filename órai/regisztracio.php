<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>PHP oldalunk</h1>
    <?php
        session_start();

        include 'regisztracio_fgv.php';



        if (isset($_POST['regisztracio'])) {
            print "Regisztráció működik!";

            $regEngedely = false;
            $username = $_POST['username'];
            $pass1 = $_POST['pass1'];
            $pass2 = $_POST['pass2'];

            if (empty($pass1) && empty($pass2) && empty($username)) {
                $regEngedely = true;
            }

            if ($pass1 == $pass2) {
                // Engedélyezzük
                regisztracio_tarolas($username);

            } else {
                // Nem engedélyezzük

            }

            if (isset($_SESSION['username'])) {
                print $_SESSION['username'];
            }

            $_SESSION['username'] = $username;

        } else {
    ?>
    <table>
        <form action="regisztracio.php" method="POST" name="reg">
            <tr>
                <td>Felhasználónév:</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>Jelszó:</td>
                <td><input type="password" name="pass1"></td>
            </tr>
            <tr>
                <td>Jelszó újra:</td>
                <td><input type="password" name="pass2"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" name="regisztracio" value="Regisztráció"></td>
            </tr>
        </form>
    </table>
    <?php
        }
    ?>
</body>
</html>