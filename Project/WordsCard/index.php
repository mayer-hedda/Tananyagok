<!DOCTYPE html>
<html lang="hu">
<head>
    <title>Words Card</title>

    <meta author="Mayer Hedda Adrienn">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="./css/index.css">
</head>
<body>
    
    <!-- TITLE -->
    <h1>English Words Card</h1>

    <!-- NAVBAR -->
    <nav>
        <a class="tasks" href="../To-Do/index.php">Tasks</a>
        <a class="logout" href="../Kezeles/logout.php">Log out</a>
    </nav>

    <!-- NEW WORD BUTTON -->
    <form action="index.php" method="post">
        <input type="submit" value="+ New Word" class="newWord" name="newWord">
    </form>

    <?php
        require_once("../Kezeles/fuggvenyek.php");
        session_start();

        // ------ ADD WORD TO DATABASE ------
        if(isset($_POST['addWord'])) {
            $errors = array();

            if(empty($_POST['englishWord'])) {
                array_push($errors, "Add meg az angol szót!");
                ?>
                <style>
                    .englishWord {
                        background-color: rgb(139, 82, 82);
                        color: azure;
                    }

                    .englishWord::-webkit-input-placeholder {
                        color: azure;
                    }
                </style>
                <?php
            }
            if(empty($_POST['hungarianWord'])) {
                array_push($errors, "Add meg a magyar szót!");
                ?>
                <style>
                    .hungarianWord {
                        background-color: rgb(139, 82, 82);
                        color: azure;
                    }

                    .hungarianWord::-webkit-input-placeholder {
                        color: azure;
                    }
                </style>
                <?php
            }

            if(empty($errors)) {
                $_SESSION['newWord'] = false;

                $englishWord = $_POST['englishWord'];
                $hungarianWord = $_POST['hungarianWord'];

                $sql = "CALL `addWord`('$englishWord', '$hungarianWord');";
                db($sql);
            }
        }



        // ------ NEW WORD SESSION UPDATE ------
        if (isset($_POST['newWord'])) {
            $_SESSION['newWord'] = true;
        }

        if (isset($_POST['close'])) {
            $_SESSION['newWord'] = false;
        }



        // ------ NEW WORD ------
        if ($_SESSION['newWord'] == true) {
            
            ?>
            <form action="index.php" method="post" class="addWord">
                <input type="submit" value="×" class="close" name="close"><br>
                <input type="text" name="englishWord" placeholder="English Word" class="englishWord">
                <input type="text" name="hungarianWord" placeholder="Hungarian Word" class="hungarianWord"><br>
                <input type="submit" value="Add" class="add" name="addWord">
                
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
            </form>

        <?php
        }



        // ELLENŐRZÉS
        if(isset($_POST['submit'])) {
            $id = $_SESSION['word']['ID'];
            $sql = "SELECT * FROM `englishwords` WHERE `englishWords`.`ID` = '$id'";
            $result = db($sql);
            

            if(mysqli_num_rows($result) == 1) {
                if((string) mysqli_fetch_assoc($result)['englishWord'] == $_POST['english']) {
                    $sql = "UPDATE `englishwords` SET `englishwords`.`talalat` = `englishwords`.`talalat` + 1 WHERE `englishwords`.`ID` = '$id';";
                    db($sql);
                    ?>
                    <script>
                        animation();
                    </script>
                    <?php
                }
            }else {
                print "NEM JÓÓ!";
            }
        }



        // ------ GET ALL WORDS ------
        $sql = "CALL `getAllWords`()";
        $result = db($sql);

        $words = array();
        if(mysqli_num_rows($result) > 0) {
            while($row = mysqli_fetch_assoc($result)) {
                $words[] = $row;
            }
        }
        $i = random_int(0, count($words)-1);
        $_SESSION['word'] = $words[$i];



        // ------ WORD CARDS ------
        ?>
        <div class="wordCard" id="wordCard">
            <p class="hungarian"><?php print $words[$i]['hungarianWord']."<br>"; ?></p>
        </div>

        <form action="index.php" method="post" class="input">
            <input type="text" name="english" placeholder="english word" class="english"><br>
            <input type="submit" value="Ellenőriz!" name="submit" class="submit" id="submit">
        </form>

        <script src="./js/index.js"></script>    
</body>
</html>