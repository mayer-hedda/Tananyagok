<?php

    spl_autoload_register(function($class){
        require(__DIR__."/src/$class.php");
    });


    // var_dump($_SERVER);
    $parts = explode("/", $_SERVER['REDIRECT_URL']);
    if($parts[2] != "users") {
        http_response_code(404);
        exit;
    } 

    $endpoint = $parts[3] ?? null;
    $controller = new UserController();

    if($endpoint == "get" && $_SERVER['REQUEST_METHOD'] === 'GET') {
        $controller->Get();
    } else if($endpoint == "delete" && $_SERVER['REQUEST_METHOD'] === 'DELETE') {
        $controller->Delete();
    } else if($endpoint == "update" && $_SERVER['REQUEST_METHOD'] === 'PATCH') {
        $controller->Update();
    } else if($endpoint == "new" && $_SERVER['REQUEST_METHOD'] === 'POST') {
        $controller->New();
    } else {
        http_response_code(405);
    }

?>