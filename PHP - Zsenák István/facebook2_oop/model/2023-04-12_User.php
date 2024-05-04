<?php
    // phpinfo();
    require_once("2023-04-12_UserLevel.php");

    class User {

        // TULAJDONSÁGOK
        private string $email;
        private string $password;
        private string $firsname;
        private string $lastname;
        private int $age;
        private UserLevel $level;



        // KONSTRUKTOR
        public function __construct(string $email, string $password, string $firsname, string $lastname, int $age) {
            $this->email = $email;
            $this->password = sha1($password);
            $this->firsname = ucfirst(strtolower($firsname));
            $this->lastname = ucfirst(strtolower($lastname));
            $this->age = 1;
            if(is_int($age) && $age > 0 && $age < 101) {
                $this->age = $age;
            }
            $this->level = UserLevel::USER;
            // $this->level = "user";
        }



        // GETTEREK
        public function getEmail(): string {
            return $this->email;
        }
        
        public function getPassword(): string {
            return $this->password;
        }

        public function getFirsname(): string {
            return $this->firsname;
        }

        public function getLastname(): string {
            return $this->lastname;
        }

        public function getAge(): int {
            return $this->age;
        }

        public function getLevel(): string {
            return $this->level->name;
        }

        public function getName() {
            return $this->firsname." ".$this->lastname;
        }



        // SETTEREK
        public function setPassword(string $password) {
            $this->password = sha1($password);
        }

        public function setFirsname(string $firsname) {
            $this->firsname = ucfirst(strtolower($firsname));
        }

        public function setLastname(string $lastname) {
            $this->lastname = ucfirst(strtolower($lastname));
        }

        public function birthday() {
            $this->age++;
        }
        
        public function addRole(User $user, Userlevel $level): bool {
            if($this->level == "admin" && $user->level != "admin") {
                $user->level = $level;
                return true;
            } else {
                return false;
            }
        }
	
        
	
	
}

?>