<?php

    class Database {

        private string $user;
        private string $password;
        private string $host;
        private string $name;

        public function __construct(string $user, string $password, string $host, string $name) {
            $this->user = $user;
            $this->password = $password;
            $this->host = $host;
            $this->name = $name;
        }

        public function getConnection(): PDO {
            $dsn = "mysql:host={$this->host};port=3306;dbname={$this->name};charset=utf8";

            return new PDO($dsn, $this->user, $this->password);
        }

    }

?>