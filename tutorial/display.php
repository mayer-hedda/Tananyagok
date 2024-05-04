<?php
    $db = new mysqli('localhost', 'root', '', 'tutorial');
    $sql = "SELECT * FROM logs;";
    $result = $db -> query($sql);

    while ($fetch = $result -> fetch_assoc()) {
        $username = $fetch['username'];
        $logs = $fetch['logs'];
        $date = $fetch['date'];
        $image = $fetch['image'];

        echo '<img src="image/'.$image.'">'.$username.' - '.$logs.' '.$date.'<br>';
    }
    $db -> close();
?>