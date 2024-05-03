package robotharc;

import felszereles.Fegyver;
import felszereles.Pancel;
import java.util.Random;

public class Ninja extends Robot {
    
    // Konstruktor
    public Ninja(String nev, String szin, Integer eletero, Boolean harcose, Integer sebzes, Integer vedelem, Fegyver fegyver, Pancel pancel) {
        super(nev, szin, eletero, harcose, sebzes, vedelem, fegyver, pancel);
    }
    
    
    // Metódus
    @Override
    public void setEletero(Integer eletero) {
        Random rand = new Random();
        Integer generated = rand.nextInt(10);
        
        if(generated == 6) {
            System.out.println("Kitérés!");
        } else{
            this.eletero = eletero;
        }
    }
    
}
