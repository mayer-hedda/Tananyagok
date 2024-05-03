package robotharc;

public class Main {

    public static void main(String[] args) {
        
        Robot robot1 = new Robot("Robot1", "piros", 100, true, 9);
        Robot robot2 = new Robot("Robot2", "kék", 100, true, 7);
        Robot robot3 = new Robot("Robot3", "lila", 120, true, 7);
        Robot robot4 = new Robot("Robot4", "zöld", 90, true, 7);
        Robot robot5 = new Robot("Robot5", "kék", 150, true, 7);
        Robot robot6 = new Robot("Robot6", "narancs", 70, true, 7);
        Robot robot7 = new Robot("Robot7", "sárga", 100, true, 7);
        Robot robot8 = new Robot("Robot8", "zöld", 90, true, 7);
        
        Robot.robotbajnoksag(robot1, robot2, robot3, robot4, robot5, robot6, robot7, robot8);
        
        Robot.harc(robot1, robot2);
        
    }
    
}
