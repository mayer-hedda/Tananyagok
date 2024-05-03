package oop;

public class Car {
    
    int nap;
    String ido;
    String rendszam;
    String szemelyazonosito;
    int kilometer;
    boolean kibehajtas;
    
    
    // Konstruktor: példányosításkor állítja be a tulajdonságokat
    public Car(int nap, String ido, String rendszam, String szemely, int km, boolean kibe) {
        this.nap = nap;
        this.ido = ido;
        this.rendszam = rendszam;
        this.szemelyazonosito = szemely;
        this.kilometer = km;
        this.kibehajtas = kibe;
    }
    
    
    public Car(String row) {
        // row: 1 08:45 CEG306 501 23989 0
        String[] splitted = row.split(" ");
        
        this.nap = Integer.parseInt(splitted[0]);
        this.ido = splitted[1];
        this.rendszam = splitted[2];
        this.szemelyazonosito = splitted[3];
        this.kilometer = Integer.parseInt(splitted[4]);
        // this.kibehajtas = Boolean.parseBoolean(splitted[5]);

        // 1. megoldás --> elágazással
        /* 
        if (splitted[5].equals("1")) {
            this.kibehajtas = true;
        } else {
            this.kibehajtas = false;
        }
        */
        


        // 2. megoldás --> ternális operátorral
        /*
        this.kibehajtas = (splitted[5].equals("1")) ? true : false;
        */
        


        // 3. megoldás --> okos megoldás (az equals függvény boolean értékkel tér vissza)
        this.kibehajtas = splitted[5].equals("1");
    }
    
}
