<!DOCTYPE html>
<html lang="hu">
<head>
    <title>Register</title>

    <meta author="Mayer Hedda Adrienn">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link rel="stylesheet" href="./css/register.css">

    <?php
        require_once('fuggvenyek.php');

        if (isset($_POST['submit'])) {
            $errors = array();
            $em = $_POST['email'];

            $sql = "SELECT * FROM `user` WHERE `user`.`email` = '$em';";
            $result = db($sql);
            if(mysqli_num_rows($result) > 0) {
                array_push($errors, "Ezzel az email címmel már létre lett hozva egy fiók!");
                ?>
                <style>
                    .email {
                        background-color: rgb(115, 25, 25);
                    }
                </style>
                <?php
            } else {
                if (empty($_POST['username'])) {
                    $_SESSION['em'] = $_POST['email'];
                    $_SESSION['p1'] = $_POST['password'];
                    $_SESSION['p2'] = $_POST['re-password'];
                    ?>
                    <style>
                        .name {
                            background-color: rgb(115, 25, 25);
                        }
                    </style>
                    <?php
                    array_push($errors, "Nem adtál meg felhasználónevet!");
                } 
                if (empty($_POST['email'])) {
                    $_SESSION['un'] = $_POST['username'];
                    $_SESSION['p1'] = $_POST['password'];
                    $_SESSION['p2'] = $_POST['re-password'];
                    ?>
                    <style>
                        .email {
                            background-color: rgb(115, 25, 25);
                        }
                    </style>
                    <?php
                    array_push($errors, "Nem adtál meg email címet!");
                } 
                if (empty($_POST['password']) && empty($_POST['re-password'])) {
                    $_SESSION['un'] = $_POST['username'];
                    $_SESSION['em'] = $_POST['email'];
                    ?>
                    <style>
                        .pass, .re-pass {
                            background-color: rgb(115, 25, 25);
                        }
                    </style>
                    <?php
                    array_push($errors, "Nem adtad meg a jelszavakat!");
                } else if ($_POST['password'] != $_POST['re-password']) {
                    $_SESSION['un'] = $_POST['username'];
                    $_SESSION['em'] = $_POST['email'];
                    ?>
                    <style>
                        .pass,  .re-pass{
                            background-color: rgb(115, 25, 25);
                        }
                    </style>
                    <?php
                    array_push($errors, "Nem egyeznek a jelszavak!");
                }
            }


            if (empty($errors)) {
                $username = $_POST['username'];
                $email = $_POST['email'];
                $password = md5($_POST['password']);

                $sql = "CALL `register`('$username', '$password', '$email')";
                db($sql);


                header('location: login.php');
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
        <div class="register">
            <form name="form" action="register.php" method="POST">
                <input class="in name" type="text" name="username" placeholder="username" autocomplete="off" value="<?php print $_SESSION['un'] ?>"><br>
                <input class="in email" type="email" name="email" placeholder="email" autocomplete="off" value="<?php print $_SESSION['em'] ?>"><br>
                <input class="in pass" type="password" name="password" placeholder="password" autocomplete="off" value="<?php print $_SESSION['p1'] ?>"><br>
                <input class="in re-pass" type="password" name="re-password" placeholder="re-password" autocomplete="off" value="<?php print $_SESSION['p2'] ?>"><br>
                <a href="./login.php">Login</a>
                <input class="sub" type="submit" name="submit" value="Register">
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