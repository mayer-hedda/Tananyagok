<?php
    $db = new mysqli('localhost', 'root', '', 'tutorial');
    
    if (isset($_POST['submit'])) {
        $errors = array();
        $true = true;
        if (empty($_POST['username'])) {
            $true = false;
            array_push($errors, "A felhasználónév üres!");
        }
        if (empty($_POST['password'])) {
            $true = false;
            array_push($errors, "A jelszó üres!");
        }
        if (empty($_POST['password_2'])) {
            $true = false;
            array_push($errors, "A jelszó megerősítése üres!");
        }
        if (!($_POST['password'] == $_POST['password_2'])) {
            $true = false;
            array_push($errors, "A jelszavak nem egyeznek.");
        }
        if (empty($_FILES['image']['name'])) {
            $true = false;
            array_push($errors, "A képet nem választottad ki.");
        }

        $type = pathinfo($_FILES['image']['name'], PATHINFO_EXTENSION);
        $_FILES['image']['name'] = date("Ymdhis").mt_rand().".".$type;
        if (!($type == 'png' || $type == 'jpeg' || $type == 'jpg')) {
            $true = false;
            array_push($errors, "A feltöltött kép formátuma (".$type.") nem megfelelő. A következőkből válassz: png/jpg/jpeg.");
        }
        if ($_FILES['image']['size'] > 1000000) {
            $true = false;
            array_push($errors, "A kép túl nagy.");
        }
        if (file_exists('image/'.$_FILES['image']['name'])) {
            $true = false;
            array_push($errors, "Ilyen nevű kép már létezik.");
        }

        if ($true) {
            $username = mysqli_real_escape_string($db, $_POST['username']);
            $password = md5(mysqli_real_escape_string($db, $_POST['password']));

            move_uploaded_file($_FILES['image']['tmp_name'], 'image/'.$_FILES["image"]["name"]);
            $image = $_FILES['image']['name'];

            $sql = "INSERT INTO users (username, password, image, date) VALUES ('$username', '$password', '$image', NOW())";
            $db -> query($sql);
            session_start();
            $_SESSION['username'] = $username;
            $_SESSION['image'] = $image;
            header('location: home.php');
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
            var password_2 = document.forms['form']['password_2'];

            var errors = document.getElementById('errors');

            if (username.value == "" && password.value == "" && password_2.value == "") {
                username.style.background = "rgba(255, 0, 0, .2)";
                password.style.background = "rgba(255, 0, 0, .2)";
                password_2.style.background = "rgba(255, 0, 0, .2)";
                errors.innerHTML = "A felhasználónév és a jelszavak üresek.";
                username.focus();
                return false;
            } else if (username.value == "" && password.value == "") {
                username.style.background = "rgba(255, 0, 0, .2)";
                password.style.background = "rgba(255, 0, 0, .2)";
                errors.innerHTML = "A felhasználónév és a jelszó üres.";
                username.focus();
                return false;
            } else if (username.value == "" && password_2.value == "") {
                username.style.background = "rgba(255, 0, 0, .2)";
                password_2.style.background = "rgba(255, 0, 0, .2)";
                errors.innerHTML = "A felhasználónév és a jelszó megerősítése üres.";
                username.focus();
                return false;
            } else if (password.value == "" && password_2.value == "") {
                password.style.background = "rgba(255, 0, 0, .2)";
                password_2.style.background = "rgba(255, 0, 0, .2)";
                errors.innerHTML = "A jelszavak üresek.";
                password.focus();
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
            } else if (password_2.value == "") {
                password_2.style.background = "rgba(255, 0, 0, .2)";
                errors.innerHTML = "A jelszó megerősítése üres.";
                password_2.focus();
                return false;
            }
        }
    </script>
    </head>
    <body>
        <form onsubmit="return main()" name="form" action="register.php" method="POST" enctype="multipart/form-data">
            username<input type="text" name="username"><br>
            password<input type="password" name="password"><br>
            repassword<input type="password" name="password_2"><br>
            image<input type="file" name="image"><br>
            <input type="submit" name="submit" value="Regisztráció">
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