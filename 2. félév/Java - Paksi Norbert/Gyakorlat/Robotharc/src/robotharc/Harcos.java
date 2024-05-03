package robotharc;

import felszereles.Fegyver;
import felszereles.Pancel;

public class Harcos extends Robot {
    
    // Konstruktor
    public Harcos(String nev, String szin, Integer eletero, Boolean harcose, Integer sebzes, Integer vedelem, Fegyver fegyver, Pancel pancel) {
        super(nev, szin, eletero, harcose, sebzes, vedelem, fegyver, pancel);
    }
    
    
    // Metódus
    @Override
    public void tamadas(Robot robot) {
        Integer sebzes = this.sebzes();
        Integer vedelem = robot.getVedelem();
        Integer tenylegesSebzes = sebzes - vedelem;
        
        if(tenylegesSebzes < 0) {
            tenylegesSebzes = 0;
        }
        
        Integer random = Robot.randomszam(10);
        if(random == 2) {
            tenylegesSebzes *= 2;
            System.out.println("Kritikus sebzés!");
        }
        
        System.out.println(this.getNev() + " megtámadja " + robot.nev + " és " + tenylegesSebzes + " sebzést okoz neki.");
        robot.setEletero(robot.getEletero() - tenylegesSebzes);
        System.out.println(" " + robot.nev + " életereje " + robot.getEletero() + " lett.");
        this.gyogyulas(sebzes);
    }
    
}
