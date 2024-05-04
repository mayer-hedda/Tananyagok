<?php
    require_once("../model/2023-04-12_User.php");
    // header('content-type: application/json');

    $user = new User("alma@körte.hu", "1234", "Jakab", "Gipsz", 33);
    // print_r($user);

    print "A user neve: ".$user->getName()."<br>";
    print "A user joga: ".$user->getLevel()."<br>";
    

?>