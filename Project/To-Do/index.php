<!DOCTYPE html>
<html lang="hu">
<head>
    <title>Tasks</title>

    <meta author="Mayer Hedda Adrienn">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/index.css">
</head>
<body>

    <!-- NAVBAR -->
    <div class="row">
        <nav class="col-md-2">
            <a class="a nav-link  active disabled" aria-current="page">Tasks</a><hr>
            <a class="a nav-link" href="../Rezsi/index.php">Fogyasztás</a><hr>
            <a class="a nav-link" href="../WordsCard/index.php">WordsCard</a><hr>
            <a class="a nav-link" href="../Menu/index.php">Menü</a><hr>
            <a class="a nav-link logout" href="../Kezeles/logout.php">Logout</a>
        </nav>

        <div class="container col-md-10">
            <!-- NEW TASK BUTTON -->
            <form action="index.php" method="post">
                <input type="submit" value="+ New Task" class="newTask" name="newTask">
            </form>

            <?php
                require_once('../Kezeles/fuggvenyek.php');
                session_start();
        
            // ------ TASK UPDATE ------

            // COMPLETED (STATUS = 1)
            if ($_POST['chkTask'] > 0) {
                $taskId = $_POST['chkTask'];
                $sql = "CALL `taskCompleted`('$taskId')";
                db($sql);
                unset($_POST['chkTask']);
            }

            // NOT COMPLETED (STATUS = 0)
            if ($_POST['chkCompTask'] > 0) {
                $taskId = $_POST['chkCompTask'];
                $sql = "CALL `taskNotCompleted`('$taskId')";
                db($sql);
                unset($_POST['chkCompTask']);
            }



            // ------ ADD TASK TO DATABASE ------
            if (isset($_POST['addTask'])) {
                $errors = array();

                if (empty($_POST['name'])) {
                    array_push($errors, "Add meg a feladat nevét!");
                    ?>
                    <style>
                        .taskName {
                            background-color: rgb(139, 82, 82);
                            color: azure;
                        }

                        .taskName::-webkit-input-placeholder {
                            color: azure;
                        }
                    </style>
                    <?php
                }
                if (empty($_POST['selectUser'])) {
                    array_push($errors, "Kapcsoljon felhasználót a feladathoz!");
                    ?>
                    <style>
                        select > .selectUser {
                            background-color: rgb(139, 82, 82);
                            color: azure;
                        }

                        select > .selectUser::-webkit-input-placeholder {
                            color: azure;
                        }
                    </style>
                    <?php
                }

                if (empty($errors)) {
                    $_SESSION['newTask'] = false;
                    
                    $name = $_POST['name'];
                    $description = $_POST['description'];
                    $userID = $_POST['selectUser'];

                    $sql = "CALL `addTask`('$name', '$description', '$userID')";
                    db($sql);

                }

            }



            // ------ NEW TASK SESSION UPDATE ------
            if (isset($_POST['newTask'])) {
                $_SESSION['newTask'] = true;
            }

            if (isset($_POST['close'])) {
                $_SESSION['newTask'] = false;
            }



            // ------ NEW TASK ------
            if ($_SESSION['newTask'] == true) {
                $sql = "CALL `getAllUserName`()";
                $result = db($sql);

                $usernames = array();
                $userIDs = array();

                while ($row = mysqli_fetch_assoc($result)) {
                    $usernames[] = $row['username'];
                    $userIDs[] = $row['ID'];
                }

                ?>
                <form action="index.php" method="post" class="addTask">
                    <input type="submit" value="×" class="close" name="close"><br>
                    <input type="text" name="name" placeholder="Task name" class="taskName">
                    <input type="text" name="description" placeholder="Task description" class="taskDescription"><br>
                    <label for="selectUser"></label>
                    <select name="selectUser" id="selectUser">
                        <option value="" disabled selected>Users: </option>
                        <?php
                            $i = 0;
                            foreach ($usernames as $username) {
                                ?>
                                <option value="<?php print $userIDs[$i] ?>"><?php print $username; ?></option>
                                <?php
                                $i++;
                            }
                        ?>
                    </select><br>
                    <input type="submit" value="Add" class="add" name="addTask">
                    
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


            
            // ------ WRITE TODAY ------
            ?>
            <p style="font-size: larger;"><b><?php print "<br>".date('Y').".".date('F').".".date('d').".<br>"; ?></b></p>
            <?php



            // ------ STATUS IS 0 ------
            $sql = "CALL `getAllNotCompleteTasks`();";
            $result = db($sql);
            
            $tasks = array();
            if (mysqli_num_rows($result) > 0) {
                while($row = mysqli_fetch_assoc($result)) {
                    $tasks[] = $row;
                }
            }
            


            // ------ NOT COMPLETED TASKS WRITE ------
            ?>
            <form action="index.php" method="post">
            <?php
                foreach ($tasks as $task) {
                
                    ?>
                    <div class="task">
                    <?php
                        if ($task['description'] != '') {
                            ?>
                            <input type="checkbox" id="<?php print $task['ID']; ?>" name="chkTask" value="<?php print $task['ID']; ?>" style="width: 15px; height: 15px;" onchange="this.form.submit()">
                            <label for="<?php print $task['ID']; ?>" style="color: <?php  ?>;"><?php print $task['name']."<br>".$task['description']."<br>".$task['date']; ?></label><br><br>
                            <?php
                        } else {
                            ?>
                            <input type="checkbox" id="<?php print $task['ID']; ?>" name="chkTask" value="<?php print $task['ID']; ?>" style="width: 15px; height: 15px;" onchange="this.form.submit()">
                            <label for="<?php print $task['ID']; ?>"><?php print $task['name']."<br>".$task['date']; ?></label><br><br>
                            <?php
                        }
                    ?>
                    </div>
                    <?php
                }
                ?>
                </form>



                <!-- ------ STATUS IS 1 ------ -->
                <form action="index.php" method="post" class="compTask">
                <?php
                $today = date("Y-m-d");
                $sql = "SELECT * FROM `task` WHERE `task`.`status` = 1 AND `task`.`ended` = '$today'";
                $result = db($sql);
                
                
                $tasks = array();
                if (mysqli_num_rows($result) > 0) {
                    while($row = mysqli_fetch_assoc($result)) {
                        $tasks[] = $row;
                    }
                }



                // ------ COMPLETED TASKS WRITE ------
                ?>

                <br><p style="font-size: larger;"><b>Completed Tasks:</b></p>

                <?php
                foreach ($tasks as $task) {
                
                    ?>
                    <div class="task">
                    <?php
                        if ($task['description'] != '') {
                            ?>
                            <input type="checkbox" id="<?php print $task['ID']; ?>" name="chkCompTask" value="<?php print $task['ID']; ?>" style="width: 15px; height: 15px;" onchange="this.form.submit()">
                            <label for="<?php print $task['ID']; ?>" style="text-decoration: line-through"><?php print $task['name']."<br>".$task['description']."<br>".$task['date']; ?></label><br><br>
                            <?php
                        } else {
                            ?>
                            <input type="checkbox" id="<?php print $task['ID']; ?>" name="chkCompTask" value="<?php print $task['ID']; ?>" style="width: 15px; height: 15px;" onchange="this.form.submit()">
                            <label for="<?php print $task['ID']; ?>" style="text-decoration: line-through"><?php print $task['name']."<br>".$task['date']; ?></label><br><br>
                            <?php
                        }
                    ?>
                    </div>
                    <?php
                }
            ?>
            </form>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>