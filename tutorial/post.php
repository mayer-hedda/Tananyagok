<?php
    $db = new mysqli('localhost', 'root', '', 'tutorial');
    if (!empty($_POST['logs'])) {
        session_start();

        $username = mysqli_real_escape_string($db, $_SESSION['username']);
        $image = mysqli_real_escape_string($db, $_SESSION['image']);
        $logs = mysqli_real_escape_string($db, $_POST['logs']);
        $date = date("H:i");

        $sql = "INSERT INTO logs (username, logs, image, date) VALUES ('$username', '$logs', '$image', '$date');";
        $db -> query($sql);
    }
    $db -> close();
?>