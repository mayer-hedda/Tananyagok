<?php

    function db($sql) {
        $db = new mysqli("localhost", "root", "root", "weblocal");
        $result = $db->query($sql);
        $db->close();

        return $result;
    }

?>