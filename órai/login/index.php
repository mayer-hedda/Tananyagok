<!DOCTYPE html>
<html lang="hu">
    <head>
        <meta charset="UTF-8">
        <title>Bejelentkezés gyakorló php</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>

        <!-- Popper JS -->
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>

        <?php
            include_once 'fuggvenyek.php';
        ?>
        
        <div class="container-fluid">
            <div class="row">
                <h1>Bejelentkezés PHP gyakorló</h1>
            </div>

            <?php

                // Bejelentkezés
                if (isset($_GET['login'])) {
                    // print 'Bejelentkezés';
                    include 'login.php';
                    if (isset($_SESSION['user']['name'])) {
                        print '<h1>Üdvözlöm '.$_SESSION['user']['name'].' az oldalunkon!</h1>';
                    }
                }
            ?>
           
            <div class="row">
                
                    <div class="col-md-6">
                        <h2>Regisztráció</h2>
                        <form action="index.php?reg" method="POST" name="reg">
                            <div class="row">
                                <div class="col-md-6 ">
                                    <label for="regUserName">Felhasználónév:</label>
                                </div>
                                <div class="col-md-6">
                                    <input type="text" name="regUserName" id="regUserName">
                                </div>
                            </div>
                            <div class="row"><div class="col-md-6"><label for="regEmail">E-mail cím:</label></div><div class="col-md-6"><input type="email" name="regEmail" id="regEmail"></div></div>
                            <div class="row"><div class="col-md-6"><label for="regPass1">Jelszó:</label></div><div class="col-md-6"><input type="password" name="regPass1" id="regPass1"></div></div>
                            <div class="row"><div class="col-md-6"><label for="regPass2">Jelszó újra:</label></div><div class="col-md-6"><input type="password" name="regPass2" id="regPass2"></div></div>
                            <div class="row"><div class="col-md-12"><input type="submit" class="btn btn-success btn-block" name="btnRegistracio" id="btnRegistracio" value="Regisztráció"></div></div>
                        </form>
                    </div>
                
                <div class="col-md-6">
                    <h2>Bejelentkezés</h2>
                    <form action="index.php?login" method="POST" name="login">
                        <div class="row"><div class="col-md-6"><label for="loginUser">Felhasználónév:</label></div><div class="col-md-6"><input type="text" name="loginUser" id="loginUser"></div></div>
                        <div class="row"><div class="col-md-6"><label for="loginPass">Jelszó:</label></div><div class="col-md-6"><input type="password" name="loginPass" id="loginPass"></div></div>
                        <div class="row"><div class="col-md-12"><input type="submit" class="btn btn-success btn-block" name="btnLogin" id="btnLogin" value="Bejelentkezés"></div></div>
                    </form>
                </div>
               
            </div>
        </div>
       
    </body>
</html>
