<html lang="hu">
<head>
    <title>Login</title>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="./css/login.css">

    <?php
        require_once('fuggvenyek.php');
        session_start();

        if (!empty($_SESSION['username'])) {
            header('location: index.php');
        } else {
            session_destroy();
        }

        if (isset($_POST['submit'])) {
            $errors = array();

            $name = $_POST['username'];
            $pass = $_POST['password'];

            if (empty($_POST['username']) && empty($_POST['password'])) {
                array_push($errors, "Töltsd ki a mezőket!");
                ?>
                <style>
                    .name, .pass{
                        background-color: rgb(115, 25, 25);
                    }
                </style>
                <?php
            } else if (empty($_POST['username'])) {
                $_SESSION['p'] = $_POST['password'];
                array_push($errors, "Nem adtál meg felhasználónevet!");
                ?>
                <style>
                    .name {
                        background-color: rgb(115, 25, 25);
                    }
                </style>
                <?php
            } else if (empty($_POST['password'])) {
                $_SESSION['un'] = $_POST['username'];
                array_push($errors, "Nem adtál meg jelszót!");
                ?>
                <style>
                    .pass {
                        background-color: rgb(115, 25, 25);
                    }
                </style>
                <?php
            }

            if (empty($errors)) {
                $username = $_POST['username'];
                $password = md5($_POST['password']);

                $sql = "CALL `login`('$username', '$password')";
                $result = db($sql);

                if (mysqli_num_rows($result) == 1) {
                    session_start();
                    $_SESSION['username'] = $username;
                    $_SESSION['newTask'] = false;
                    $_SESSION['newWord'] = false;
                    header('location: ../To-Do/index.php');
                } else {
                    array_push($errors, "Hibás felhasználónév vagy jelszó!");
                    ?>
                    <style>
                        .name, .pass {
                            background-color: rgb(115, 25, 25);
                        }
                    </style>
                    <?php
                }
            }

        }

    ?>
</head>
<body>
    <div class="container bg">
        <div class="curser"></div>
        <div class="row">
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div> 
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
        </div>
        <div class="row">
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div> 
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
        </div>
        <div class="row">
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div> 
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
        </div>
        <div class="row">
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div> 
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
        </div>
        <div class="row">
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div> 
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
        </div>
        <div class="row">
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div> 
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
        </div>
        <div class="row">
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div> 
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
        </div>
        <div class="row">
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div> 
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
        </div>
        <div class="row">
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div> 
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
        </div>
        <div class="row">
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div> 
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
        </div>
        <div class="row">
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div> 
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
            <div class="hexagon"></div>
        </div>
    </div>
    <div class="on-top"></div>



    <div class="tartalom">
        <div class="login">
            <form name="form" action="login.php" method="POST">
                <input class="in name" type="text" name="username" placeholder="username" autocomplete="off" value="<?php print $_SESSION['un'] ?>"><br>
                <input class="in pass" type="password" name="password" placeholder="password" autocomplete="off" value="<?php print $_SESSION['p'] ?>"><br>
                <a href="./register.php">Register</a>
                <input class="sub" type="submit" name="submit" value="Login"><br>
            </form>
        </div>

            <?php
                if (!empty($errors)) {
                    ?>
                    <div class="errors">
                    <?php
                    foreach ($errors as $error) {
                        print $error."<br>";
                    }
                    ?>
                    </div>
                    <?php
                }
            ?>
    </div>
    
    <script src="./js/login.js"></script>
</body>
</html>