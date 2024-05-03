<?php
require_once('Aspektus.php');
require_once('DBconn.php');
class Haz{
    public static int $LAKOK_MAX_SZAMA = 5;
    public static int $MERET = 50;

    public static $HAZAK = array();
    
    private int $id;
  
    public function __construct(){
        $this->id = (int)(time() . rand(0,100));
        Aspektus::log($this);
    }

    public function getId():int{
        return $this->id;
    }

    public static function getAllHouse(){
        $conn = DBconn::getInstance();
        $sql = 'CALL getAllHouse()';
        $result = mysqli_query($conn->getConnection(), $sql);
        $houses = array();
        while($row = mysqli_fetch_assoc($result)){
            $haz = new Haz();
            $haz->id = $row['id'];
            $houses[] = $haz;
        }
        return $houses;
    }

    public function createEmber(int $darab){
        if($darab <= 5){
            try{
                $conn = DBconn::getInstance()->getConnection();
                $sql = 'CALL createEmber()';
                for($i = 1; $i <= $darab; $i++){
                    mysqli_query($conn, $sql);
                }
                mysqli_close($conn);
                return true;
            }
            catch(Exception $ex){
                print $ex->getMessage();
            }
        }
        return false;
    }

}

?>