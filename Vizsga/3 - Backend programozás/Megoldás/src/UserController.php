<?php

    class UserController {

        private UserModel $model;

        public function __construct() {
            $this->model = new UserModel();
        }

        public function Get() {
            if(isset($_GET["id"])) {
                $id = $_GET["id"];
                $user = $this->model->GetUser($id);
                
                if(!empty($user)) {
                    echo json_encode($user);
                    return;
                }
            }

            http_response_code(404);
            echo json_encode(["error"=> "User not found"]);
        }

        public function Delete() {
            if(isset($_GET["id"])) {
                $id = $_GET["id"];

                $user = $this->model->GetUser($id);
                $res = $this->model->DeleteUser($id);
                if(!empty($user) && $res) {
                    echo json_encode(["message" => "User deleted successfully!"]);
                    return;
                }
            }

            http_response_code(404);
            echo json_encode(["message"=> "User not found"]);
        }

        public function Update() {
            $data = (array) json_decode(file_get_contents("php://input"));
            // if(empty($data) || empty($data->id) || empty($data->username) || empty($data->email) || empty($data->password)) {
            //     http_response_code(422);
            //     echo json_encode(["error"=> "There is a missing property"]);
            // }

            $errors = $this->Validator($data, true);
            if(!empty($errors)) {
                http_response_code(422);
                echo json_encode(["errors" => $errors]);
                return;
            }

            $user = $this->model->GetUser($data["id"]);
            if(!empty($user)) {
                $res = $this->model->UpdateUser($data["id"], $data["username"], $data["email"], $data["password"]);
                if($res) {
                    echo json_encode(["message"=> "User updated successfully!"]);
                    return;
                }
            }

            http_response_code(404);
            echo json_encode(["message"=> "User not found!"]);

        }

        public function New() {
            $data = (array) json_decode(file_get_contents("php://input"));
            // if(empty($data) || empty($data->id) || empty($data->username) || empty($data->email) || empty($data->password)) {
            //     http_response_code(422);
            //     echo json_encode(["error"=> "There is a missing property"]);
            // }

            $errors = $this->Validator($data);
            if(!empty($errors)) {
                http_response_code(422);
                echo json_encode(["errors" => $errors]);
                return;
            }

            $res = $this->model->CreateUser($data["username"], $data["email"], $data["password"]);
            if($res) {
                echo json_encode(["message"=> "User created successfully!"]);
                return;
            }

            http_response_code(404);
            echo json_encode(["message"=> "User created unsuccessfully!"]);

        }

        private function Validator(array $data, bool $is_update = false) {
            $errors = [];

            if(empty($data["id"]) && $is_update) {
                array_push($errors, "Id is required!");
            }
            if(empty($data["username"])) {
                array_push($errors, "Username is required!");
            }
            if(empty($data["email"])) {
                array_push($errors, "Email is required!");
            }
            if(empty($data["password"])) {
                array_push($errors, "Password is required!");
            }

            return $errors;
        }

    }

?>