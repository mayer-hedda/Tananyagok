package robotharc;

public class Robotharc {

    public static void main(String[] args) {
        Robot robot1 = new Robot("kecsketron", "fekete", 55, true, 8);
        Robot robot2 = new Robot("elektron", "fehér", 76, true, 7);
        Robot robot3 = new Robot("almatron", "szürke", 49, true, 9);
        Robot robot4 = new Robot("bakitron", "piros", 55, true, 6);
        Robot robot5 = new Robot("heketron", "kék", 54, true, 7);
        Robot robot6 = new Robot("apatron", "sárga", 48, true, 9);

//        Robot.Harc(robot1,robot2);
        Robot.Robotbajnoksag(robot1, robot2, robot3, robot4);

    }
    
}
