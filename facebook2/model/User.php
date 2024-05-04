<?php
require_once('UserLevel.php');
class User{

    private string $email;
    private string $passwd;
    private string $firstName;
    private string $lastName;
    private int $age;
    private UserLevel $level;

    public function __construct(string $email, 
                                string $passwd,
                                string $firstName,
                                string $lastName,
                                int $age){
                                    $this->email = $email;
                                    $this->passwd = sha1($passwd);
                                    $this->firstName = $firstName;
                                    $this->lastName = $lastName;
                                    $this->age = 1;
                                    if(is_int($age) && $age > 0 && $age < 101){
                                        $this->age = $age;
                                    }
                                    $this->level = UserLevel::USER;
                                }
    public function getEmail(){
        return $this->email;
    }

	public function getPasswd(): string {
		return $this->passwd;
	}
	
	public function setPasswd(string $passwd){
		$this->passwd = sha1($passwd);
	}

	public function getFirstName(): string {
		return $this->firstName;
	}

	public function setFirstName(string $firstName){
		$this->firstName = $firstName;
	}

    public function getAge(): int{
        return $this->age;
    }

    public function birthday(){
        $this->age++;
    }

    public function getLastName(): string{
        return $this->lastName;
    }

    public function setLastName(string $lastName){
        $this->lastName = $lastName;
    }

    public static function addRole(User $admin, User $user, UserLevel $level){
        if($admin->level == UserLevel::ADMIN &&
        $user->level != UserLevel::ADMIN){
            $user->level = $level;
            return true;
        }
        return false;
    }

    public function getLevel(): string{
        return $this->level->name;
    }

    public function getName(){
        return $this->firstName . ' ' . $this->lastName;
    }
}



?>