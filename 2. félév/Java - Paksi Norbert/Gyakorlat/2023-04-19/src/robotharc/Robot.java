package robotharc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Robot {

    // TULAJDONSÁGOK
    private String nev;
    private String szin;
    private Integer eletero;
    private Integer maxEletero;
    private Boolean harcose;
    private Integer sebzes;

    
    // KONSTRUKTOR
    public Robot(String nev, String szin, Integer eletero, Boolean harcose, Integer sebzes) {
        this.nev = nev;
        this.szin = szin;
        this.eletero = eletero;
        this.maxEletero = eletero;
        this.harcose = harcose;
        this.sebzes = sebzes;
    }


    // GETTEREK / SETTEREK
    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getSzin() {
        return szin;
    }

    public void setSzin(String szin) {
        this.szin = szin;
    }

    public int getEletero() {
        return eletero;
    }

    public void setEletero(int eletero) {
        this.eletero = eletero;
    }

    public boolean isHarcose() {
        return harcose;
    }

    public void setHarcose(boolean harcose) {
        this.harcose = harcose;
    }

    public int getSebzes() {
        return sebzes;
    }

    public void setSebzes(int sebzes) {
        this.sebzes = sebzes;
    }


    // METÓDUSOK
    public static boolean Harcosok(Robot robot1, Robot robot2){
        return robot1.harcose && robot2.harcose;
    }

    public static Robot Kezdorobot(Robot robot1,Robot robot2){
        if(
                (robot2.eletero > robot1.eletero) ||
                (robot1.eletero.equals(robot2.eletero) && robot1.sebzes > robot2.sebzes) ||
                (robot1.eletero.equals(robot2.eletero) && robot1.sebzes.equals(robot2.sebzes) && Robot.randomszam(2) == 0)
                ){
            return robot1; // 1 vagy 3
        }
        else{
            return robot2; // 1 vagy 3
        }
    }

    public static int randomszam(int max){
        Random random = new Random();
        int x = random.nextInt(max);
        return x;
    }
    public static int veletlenEgeszSzam(int tol, int ig) {
        return (int) Math.floor(Math.random() * (ig - tol + 1) + tol);
    }

    public int sebzes(){
        return randomszam((this.sebzes + 1));
    }

    public void Tamadas(Robot robot){
        int damage= this.sebzes(); //4 
        System.out.print(this.nev + " Megtámadja " +robot.nev + " és " + damage + " sebzést okoz neki.");
        robot.setEletero(robot.getEletero()-damage); //30-4
        System.out.println(" " + robot.nev + " életereje " + robot.getEletero() + " lett.");
        this.Gyogyulas(damage);
    }

    public void Gyogyulas(int damage)  {
        if (damage == this.sebzes){
            this.setEletero(this.getEletero() +2); // Max 40, Aktuális 48
            if(this.eletero > this.maxEletero){
                this.eletero = this.maxEletero;
            }
            System.out.println(this.nev + " maxout sebzett, ezért gyógyult. új életereje: " + this.eletero);
        }
    }

    public static Robot Harc(Robot robot1, Robot robot2){
        if (Harcosok(robot1,robot2)){
            Robot kezdo = Kezdorobot(robot1,robot2);
            boolean igaz = true;
            
            while (igaz){
                if (kezdo.equals(robot1)){
                    robot1.Tamadas(robot2);
                    if (robot2.eletero<=0){
                        System.out.println("\nGyöztes: "+robot1.nev);
                        igaz=false;
                        return robot1;
                    }
                    else {
                        robot2.Tamadas(robot1);
                        if (robot1.eletero<=0){
                            System.out.println("\nGyöztes: "+robot2.nev);
                            igaz=false;
                            return robot2;
                        }
                    }

                }
                else {
                    robot2.Tamadas(robot1);
                    if (robot1.eletero<=0){
                        System.out.println("\nGyöztes: "+robot2.nev);
                        igaz=false;
                        return robot2;
                    }
                    else {
                        robot1.Tamadas(robot2);
                        if (robot2.eletero<=0){
                            System.out.println("\nGyöztes: "+robot1.nev);
                            igaz=false;
                            return robot1;
                        }
                    }

                }

            }
        }
        else{
            System.out.println("Az egyik robot nem harcos");
        }

        return null;
    }
    
    public static void Robotbajnoksag(Robot r1, Robot r2, Robot r3, Robot r4) {
        ArrayList<Robot> versenyzok = new ArrayList(Arrays.asList(r1, r2, r3, r4));
        ArrayList<Robot> nyertesek = new ArrayList();
        boolean flag = true;
        
        while(flag) {
        
            if(!versenyzok.isEmpty()) {
                Robot elso = versenyzok.get(Robot.randomszam(versenyzok.size()));
                versenyzok.remove(elso);

                Robot masodik = versenyzok.get(Robot.randomszam(versenyzok.size()));
                versenyzok.remove(masodik);

                nyertesek.add(Robot.Harc(elso, masodik));
            } else {
                if(nyertesek.size() == 1) {
                    System.err.println("\n\n\n\nA Robotbajnokság nyertese: " + nyertesek.get(0).nev);
                    flag = false;
                } else {
                    versenyzok = nyertesek;
                    nyertesek.clear();
                }
            }
        }
    }
}
