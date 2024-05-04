<!DOCTYPE html>
<?php
session_start();
if (isset($_GET['btn_exit'])){
    session_unset();
    session_destroy();
}
?>

<html>
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
            include_once 'kezeles/fuggvenyek.php';
            include_once 'kezeles/kapcsolat.php';
        ?>
        
        <div class="container-fluid">
            <div class="row">
                <h1>Bejelentkezés PHP gyakorló</h1>
            </div>
            <?php
            //Bejelentkezés
            if (isset($_GET['login'])){
                //print 'Bejelentkezés';
                include 'kezeles/login.php';
                if(isset($_SESSION['user']['name'])){
                    print '<h1>Üdvözlöm '.$_SESSION['user']['name'].' az oldalunkon!</h1>';
                }
            }
            //Regisztráció
            if (isset($_GET['reg'])){
                //print 'Regisztráció ';
                include 'kezeles/registration.php';
            }
            
           
            if(isset($_SESSION['user']['name'])){
                if($_SESSION['user']['name'] != ''){
                    print '<a href="index.php?btn_exit"><button >Kijelentkezés</button></a>';
                }
            }else{
                if(isset($_GET['btn_log'])){
                    print '<a href="index.php?btn_reg"><button >Regisztráció</button></a>';
                }
                if(isset($_GET['btn_reg'])){
                    print '<a href="index.php?btn_log"><button >Bejelentkezés</button></a>';
                }
                if (!isset($_GET['btn_log']) && !isset($_GET['btn_reg'])){
                    print '<a href="index.php?btn_log"><button >Bejelentkezés</button></a>';
                }
                    
            }
            ?>
            <div class="row">
                <?php
                if(isset($_GET['btn_reg'])){
                    
                ?>
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
                <?php
                }
                if(isset($_GET['btn_log']) ){
                    
                ?>
                <div class="col-md-6">
                    <h2>Bejelentkezés</h2>
                    <form action="index.php?login" method="POST" name="login">
                        <div class="row"><div class="col-md-6"><label for="loginUser">Felhasználónév:</label></div><div class="col-md-6"><input type="text" name="loginUser" id="loginUser"></div></div>
                        <div class="row"><div class="col-md-6"><label for="loginPass">Jelszó:</label></div><div class="col-md-6"><input type="password" name="loginPass" id="loginPass"></div></div>
                        <div class="row"><div class="col-md-12"><input type="submit" class="btn btn-success btn-block" name="btnLogin" id="btnLogin" value="Bejelentkezés"></div></div>
                    </form>
                </div>
                <?php
                }
                ?>
            </div>
        </div>
        <?php
            

            
        
        ?>
    </body>
</html>
