<?php
    session_start();
    if (!empty($_SESSION['username'])) {
        header('location: index.php');
    } else {
        session_destroy();
    }

    function db($sql) {
        $db = new mysqli("localhost", "root", "root", "todo");
        $result = $db->query($sql);
        $db->close();

        return $result;
    }

    if (isset($_POST['submit'])) {
        $errors = array();
        $true = true;

        if (empty($_POST['username'])) {
            $true = false;
            array_push($errors, "A felhasználónév üres.");
        }
        if (empty($_POST['password'])) {
            $true = false;
            array_push($errors, "A jelszó üres.");
        }
        if ($true) {
            $username = $_POST['username'];
            $password = $_POST['password'];

            $sql = "CALL `getUser`('$username', '$password')";
            $result = db($sql);
            echo $result;
            if (mysqli_num_rows($result) == 1) {
                session_start();
                $_SESSION['username'] = $username;
                header('location: index.php');
            } else {
                array_push($errors, "A felhasználónév vagy a jelszó nem megfelelő.");
            }
        }
    }
?>

<html>
    <body>  
        
    </body>
</html>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form onsubmit="return main()" name="form" action="login.php" method="POST">
        <input type="text" name="username" placeholder="username"><br>
        <input type="password" name="password" placeholder="password"><br>
        <input type="submit" name="submit" value="Bejelentkezés">
    </form>
    <div id="errors"></div>
    <?php
        if (!empty($errors)) {
            foreach ($errors as $key) {
                echo $key."<br>";
            }
        }
    ?>
</body>
</html>