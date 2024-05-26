<?php

    class UserModel {

        private int $id;
        private string $username;
        private string $email;
        private string $password;
        private string $created_at;
        private string $updated_at;
        private PDO $conn;

        public function __construct() {
            $db = new Database("root", "", "localhost", "vizsga");
            $this->conn = $db->getConnection();
        }


        public function CreateUser(string $username, string $email, string $password): bool {
            $sql = "CALL CreateUser(:p_username, :p_email, :p_password)";
            $stmt = $this->conn->prepare($sql);

            $stmt->bindParam(":p_username", $username, PDO::PARAM_STR);
            $stmt->bindParam(":p_email", $email, PDO::PARAM_STR);
            $stmt->bindParam(":p_password", $password, PDO::PARAM_STR);

            return $stmt->execute();
        }

        public function DeleteUser(int $id): bool {
            $sql = "CALL DeleteUser(:p_user_id)";
            $stmt = $this->conn->prepare($sql);

            $stmt->bindParam(":p_user_id", $id, PDO::PARAM_INT);
            return $stmt->execute();
        }

        public function UpdateUser(int $id, string $username, string $email, string $password): bool {
            $sql = "CALL UpdateUser(:p_user_id, :p_username, :p_email, :p_password)";
            $stmt = $this->conn->prepare($sql);

            $stmt->bindParam(":p_user_id", $id, PDO::PARAM_INT);
            $stmt->bindParam(":p_username", $username, PDO::PARAM_STR);
            $stmt->bindParam(":p_email", $email, PDO::PARAM_STR);
            $stmt->bindParam(":p_password", $password, PDO::PARAM_STR);

            return $stmt->execute();
        }

        public function GetUser(int $id): array {
            $sql = "CALL GetUser(:p_user_id)";
            $stmt = $this->conn->prepare($sql);

            $stmt->bindParam(":p_user_id", $id, PDO::PARAM_INT);
            $stmt->execute();

            $data = $stmt->fetch(PDO::FETCH_ASSOC);
            if(!$data) {
                return [];
            }
            return $data;
        }

    }

?>