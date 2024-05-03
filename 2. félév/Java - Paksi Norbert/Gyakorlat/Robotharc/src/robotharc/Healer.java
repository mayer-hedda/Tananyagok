package robotharc;

import felszereles.Fegyver;
import felszereles.Pancel;
import java.util.Random;

public class Healer extends Robot {
    
    // Konstruktor
    public Healer(String nev, String szin, Integer eletero, Boolean harcose, Integer sebzes, Integer vedelem, Fegyver fegyver, Pancel pancel) {
        super(nev, szin, eletero, harcose, sebzes, vedelem, fegyver, pancel);
    }
    
    
    // Metódus
    @Override
    public void gyogyulas(Integer damage) {
        if(damage.equals(this.ero)) {
            this.setEletero(this.getEletero() + 2);
            
            if(this.eletero > this.maxEletero) {
                this.eletero = this.maxEletero;
            }
            System.out.println(this.nev + " maximumot sebzett, ezért gyógyult. Új életereje: " + this.eletero);
        }
        
        Random rand = new Random();
        Integer generated = rand.nextInt(20);
        
        if(generated == 4 && !this.eletero.equals(this.maxEletero)) {
            eletero += 3;
            System.out.println("Kaptál 3 életerőt!");
        }
    }
    
}
