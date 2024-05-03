package robotharc;

import felszereles.Fegyver;
import felszereles.Pancel;
import java.util.Random;

public abstract class Robot {
    
    // Tulajdonságok
    protected String nev;
    protected String szin;
    protected Integer maxEletero;
    protected Integer eletero;
    protected Boolean harcose;
    protected Integer ero;
    protected Integer vedelem;
    //tárgyak
    protected Fegyver fegyver;
    protected Pancel pancel;
    
    
    // Konstruktor
    public Robot(String nev, String szin, Integer eletero, Boolean harcose, Integer sebzes, Integer vedelem, Fegyver fegyver, Pancel pancel) {
        this.nev = nev;
        this.szin = szin;
        this.maxEletero = eletero;
        this.eletero = eletero + pancel.getEletero();
        this.harcose = harcose;
        this.ero = sebzes;
        this.vedelem = vedelem + pancel.getVedelem();
        this.fegyver = fegyver;
        this.pancel = pancel;
    }
    
    
    // Getterek
    public String getNev() {
        return nev;
    }
    
    public String getSzin() {
        return szin;
    }
    
    public Integer getEletero() {
        return eletero;
    }
    
    public Boolean isHarcose() {
        return harcose;
    }
    
    public Integer getEro() {
        return ero;
    }
    
    public Integer getVedelem() {
        return vedelem;
    }
    
    
    // Setterek
    public void setNev(String nev) {
        this.nev = nev;
    }
    
    public void setSzin(String szin) {
        this.szin = szin;
    }
    
    public void setEletero(Integer eletero) {
        this.eletero = eletero;
    }
    
    public void setHarcose(Boolean harcose) {
        this.harcose = harcose;
    }
    
    public void setEro(Integer sebzes) {
        this.ero = sebzes;
    }
    
    public void setVedelem(Integer vedelem) {
        this.vedelem = vedelem;
    }
    
    
    // Metódusok
    public static Boolean harcosok(Robot robot1, Robot robot2) {
        return robot1.harcose && robot2.harcose;
    }
    
    public static Robot kezdorobot(Robot robot1, Robot robot2) {
        if(
                (robot2.eletero > robot1.eletero) ||
                (robot1.eletero.equals(robot2.eletero) && robot1.ero > robot2.ero) ||
                (robot1.eletero.equals(robot2.eletero) && robot1.ero.equals(robot2.ero) && Robot.randomszam(2) == 0)
                ) {
            return robot1;
        } else{
            return robot2;
        }
    }
    
    public static Integer randomszam(Integer max) {
        Random rand = new Random();
        Integer x = rand.nextInt(max);
        return x;
    }
    public static Integer veletlenEgeszSzam(Integer tol, Integer ig) {
        return (int) Math.floor(Math.random() * (ig - tol + 1) + tol);
    }
    
    public Integer sebzes() {
        Integer sebzes = randomszam(this.ero + 1);
        sebzes += this.fegyver.getEro();
        
        Integer max = this.fegyver.getMaxSebzes();
        Integer min = this.fegyver.getMinSebzes();
        Integer range = max - min;
        
        Integer fegyversebzes = randomszam(range + 1);
        fegyversebzes += min;
        
        sebzes += fegyversebzes;
        
        return sebzes;
    }
    
    public void tamadas(Robot robot) {
        Integer damage = this.sebzes();
        Integer vedelem = robot.getVedelem();
        Integer tenylegesSebzes = damage - vedelem;
        
        if(tenylegesSebzes < 0) {
            tenylegesSebzes = 0;
        }
        
        System.out.println(this.nev + " megtámadja " + robot.nev + " és " + tenylegesSebzes + " sebzést okoz neki.");
        
        robot.setEletero(robot.getEletero() - tenylegesSebzes);
        System.out.println(" " + robot.nev + " életereje " + robot.getEletero() + " lett.");
        this.gyogyulas(damage);
    }
    
    public void gyogyulas(Integer damage) {
        if(damage == this.ero) {
            this.setEletero(this.getEletero() + 2);
            
            if(this.eletero > this.maxEletero) {
                this.eletero = this.maxEletero;
            }
            System.out.println(this.nev + " maximumot sebzett, ezért gyógyult. Új életereje: " + this.eletero);
        }
    }
    
    public static void harc(Robot robot1, Robot robot2) {
        if(Robot.harcosok(robot1, robot2)) {
            Robot kezdo = kezdorobot(robot1, robot2);
            
            Boolean flag = true;
            while(flag) {
                if(kezdo.equals(robot1)) {
                    robot1.tamadas(robot2);
                    if(robot2.eletero <= 0) {
                        System.out.println("Győztes: " + robot1.nev);
                        flag = false;
                    } else{
                        robot2.tamadas(robot1);
                        if(robot1.eletero <= 0) {
                            System.out.println("Győztes: " + robot2.nev);
                            flag = false;
                        }
                    }
                } else{
                    robot2.tamadas(robot1);
                    if(robot1.eletero <= 0) {
                        System.out.println("Győztes: " + robot2.nev);
                        flag = false;
                    } else{
                        robot1.tamadas(robot2);
                        if(robot2.eletero <= 0) {
                            System.out.println("Győztes: " + robot1.nev);
                            flag = false;
                        }
                    }
                }
            }
        } else{
            System.out.println("Valamelyik robot nem harcos.");
        }
    }
    
}
