<?php
require_once('Haz.php');
class Aspektus{

    public static function log($entity){
        if(get_class($entity) == 'Haz'){
            if(!file_exists(get_class($entity) . '.log')){
                touch(get_class($entity) . '.log');
            }
            $content = file_get_contents(get_class($entity) . '.log');
            $content .= '
A ház elkezdett épülni. id: ' . $entity->getId();
            file_put_contents(get_class($entity) . '.log', $content);
        }
    }


}


?>