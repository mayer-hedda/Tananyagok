<?php
    session_start();

    // database connect
    function db($sql) {
        $db = new mysqli("localhost", "root", "root", "todo");
        $result = $db->query($sql);
        $db->close();

        return $result;
    }

    if(isset($_POST['submit'])) {
        if(!empty($_POST['taskName'])) {
            $taskName = $_POST['taskName'];
            $userId = $_SESSION['userId'];

            $addTask = "CALL `addTask`('$taskName', '$userId')";
            db($addTask);
        }
    }
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>todo</title>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="style.css">
</head>
<body>
    
    <h1 class="date">
        <?php
            echo date("F j, Y, g:i a");
        ?>
    </h1>

    <form action="index.php" method="post">
        <input type="text" name="taskName" id="taskName" class="taskName">
        <input type="submit" value="Add" name="submit">
    </form>

</body>
</html>