package mayerheddakonzol;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        // 2. feladat
        ArrayList<Tanulo> tanulok = Main.fajlBeolvasas();
        
        // 3. feladat
        System.out.println("3. feladat:\n\tTanulók száma: " + tanulok.size());

        // 4. feladat
        Integer count = Main.webprogramozasJegyek(tanulok);
        System.out.println("\n4. feladat:\n\tWebprogramozás jegyek száma: " + count);
        
        // 5. feladat
        Double atlag = Main.adatbazisAtlag(tanulok);
        System.out.println("\n5. feladat:\n\tAdatbáziskezelés tantárgyból a jegyek átlaga: " + atlag);
        
        // 7. feladat:
        HashMap<String, Integer> jegyek = Main.erdemjegyekDarabszama(tanulok);
        System.out.println("\n7. feladat:\n\t" + jegyek);
        
    }
    
    public static ArrayList<Tanulo> fajlBeolvasas() {
        ArrayList<Tanulo> tanulok = new ArrayList();
        
        File file = new File("tanulok.txt");
        try {
            Scanner sc = new Scanner(file);
            
            while(sc.hasNextLine()) {
                String row = sc.nextLine();
                tanulok.add(new Tanulo(row));
            }
        } catch(FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        
        return tanulok;
    }
    
    public static Integer webprogramozasJegyek(ArrayList<Tanulo> tanulok) {
        Integer count = 0;
        
        for(Tanulo t : tanulok) {
            if(t.getTargy().equals("Webprogramozás")) {
                count++;
            }
        }
        
        return count;
    }
    
    public static Double adatbazisAtlag(ArrayList<Tanulo> tanulok) {
        Double osszesen = 0.0;
        Double count = 0.0;
        
        for(Tanulo t : tanulok) {
            if(t.getTargy().equals("Adatbáziskezelés")) {
                osszesen += t.getJegy();
                count++;
            }
        }
        
        return osszesen/count;
    }
    
    public static HashMap<String, Integer> erdemjegyekDarabszama(ArrayList<Tanulo> tanulok) {
        HashMap<String, Integer> jegyek = new HashMap();
        
        for(Tanulo t : tanulok) {
            Erdemjegyek erdemjegy = new Erdemjegyek(t.getJegy());
            if(!jegyek.containsKey(erdemjegy.getSzovegesJegy())) {
                jegyek.put(erdemjegy.getSzovegesJegy(), 1);
            } else {
                Integer aktualisErtek = jegyek.get(erdemjegy.getSzovegesJegy());
                jegyek.put(erdemjegy.getSzovegesJegy(), aktualisErtek + 1);
            }
        }
        
        return jegyek;
    }
    
}
