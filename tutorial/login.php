<?php
    session_start();
    if (!empty($_SESSION['username'])) {
        header('location: home.php');
    } else {
        session_destroy();
    }

    $db = new mysqli("localhost", "root", "", "tutorial");

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
            $username = mysqli_real_escape_string($db, $_POST['username']);
            $password = md5(mysqli_real_escape_string($db, $_POST['password']));

            $sql = "SELECT * FROM users WHERE username = '$username' AND password = '$password'";
            $result = $db -> query($sql);
            if (mysqli_num_rows($result) == 1) {
                session_start();
                $fetch = $result -> fetch_assoc();
                $_SESSION['image'] = $fetch['image'];
                $_SESSION['username'] = $username;
                header('location: home.php');
            } else {
                array_push($errors, "A felhasználónév vagy a jelszó nem megfelelő.");
            }
        }
    }
    $db -> close();
?>
<html>
    <head>
        <script>
            function main() {
                var username = document.forms['form']['username'];
                var password = document.forms['form']['password'];

                var errors = document.getElementById('errors');

                if (username.value == "" && password.value == "") {
                    username.style.background = "rgba(255, 0, 0, .2)";
                    password.style.background = "rgba(255, 0, 0, .2)";
                    errors.innerHTML = "A felhasználónév és a jelszó üres.";
                    username.focus();
                    return false;
                } else if (username.value == "") {
                    username.style.background = "rgba(255, 0, 0, .2)";
                    errors.innerHTML = "A felhasználónév üres.";
                    username.focus();
                    return false;
                } else if (password.value == "") {
                    password.style.background = "rgba(255, 0, 0, .2)";
                    errors.innerHTML = "A jelszó üres.";
                    password.focus();
                    return false;
                }
            }
        </script>
    </head>
    <body>  
        <form onsubmit="return main()" name="form" action="login.php" method="POST">
            username<input type="text" name="username"><br>
            password<input type="password" name="password"><br>
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