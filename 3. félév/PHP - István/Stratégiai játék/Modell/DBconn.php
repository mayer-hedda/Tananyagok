<?php

class DBconn{

    private static DBconn $dbconn;
    private string $db_host;
    private string $db_user;
    private string $db_pass;    
    private string $db_name;

    private function __construct(){
        $this->db_host = "localhost";
        $this->db_user = "dualis";
        $this->db_pass = "123456";
        $this->db_name = "dualis";
    }

    public static function getInstance(){
        DBconn::$dbconn = new DBconn();
        return DBconn::$dbconn;
    }

    public function getConnection(){
        return mysqli_connect($this->db_host, 
                            $this->db_user, 
                            $this->db_pass, 
                            $this->db_name);  
    }


}

?>