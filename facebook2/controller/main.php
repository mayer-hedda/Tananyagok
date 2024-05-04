<?php

    require_once('../model/User.php');
    require_once('../service/publicAPI.php');
    header('content-type: application/json');

    if(isset($_GET)) {
        if(isset($_GET['task'])) {
            if($_GET['task'] == 'nameInfo' && isset($_GET['name'])) {
                // lényeg
                $name = strip_tags(trim($_GET('name')));
                $service = new publicAPI();
                $nameInfo = $service->getNameInfo($name);
                print $nameInfo;
            } else if($_GET['task'] == 'getCalendarInfo' && isset($_GET['year']) && isset($_GET['country'])) {
                $year = strip_tags(trim($_GET('year')));
                $country = strip_tags(trim($_GET('country')));
                
                $service = new publicAPI();
                $calendarInfo = $service->getCalendarInfo($country, $year);
                print $calendarInfo; 
            } else {
                http_response_code(404);    // nem kell exitelni, mert megáll a kód futása
            }
        } else {
            http_response_code(404);
        }
    } else {
        http_response_code(405);
    }

    // $user = new User('alma@korte.hu', 
    //                 '1234', 'JakAb', 
    //                 'gipsz', 33);

    // print 'A user neve: ' . $user->getName() . '<br />';
    // print 'A user joga: ' . $user->getLevel() . '<br />';

    http_response_code(404);
    print '{"name": "' . $user->getName() . '", "level": "' . $user->getLevel() . '"}';

?>