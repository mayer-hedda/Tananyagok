package Utasszallitok;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;


public class Main {
    
    public static void main(String[] args) {
        // 3. feladat - Fájl beolvasása
        ArrayList<Utasszallitok> adatok = Main.fajlbeolvasas();
        
        // 4. feladat - Sorok számának kiiratésa
        System.out.println("4. feldat: Adatsorok száma: " + adatok.size());
        
        // 5. feladat - Boeing típusok száma
        int darabBoeing = 0;
        for(Utasszallitok adat : adatok) {
            if(adat.getTipus().contains("Boeing")) {
                darabBoeing++;
            }
        }
        
        System.out.println("5. feladat: Boeing típusok száma: " + darabBoeing);
        
        // 6. feladat - Legtöbb utas szállítására alkalmas repülőgép típus
        Integer index = null;
        int legtobbUtas = 0;
        for(Utasszallitok adat : adatok) {
            if(adat.getUtas().contains("-")) {
                if(Integer.parseInt(adat.getUtas().substring(adat.getUtas().indexOf('-') + 1)) > legtobbUtas) {
                    legtobbUtas = Integer.parseInt(adat.getUtas().substring(adat.getUtas().indexOf('-') + 1));
                    index = adatok.indexOf(adat);
                }
            } else {
                if(Integer.parseInt(adat.getUtas()) > legtobbUtas) {
                    legtobbUtas = Integer.parseInt(adat.getUtas());
                    index = adatok.indexOf(adat);
                }
            }
        }
        
        System.out.println("6. feladat: A legtöbb utast szállító repülőgéptípus\n\tTípus: " + adatok.get(index).getTipus() + "\n\tElső felszállás: " + adatok.get(index).getEv() + "\n\tUtasok száma: " + adatok.get(index).getUtas().substring(adatok.get(index).getUtas().indexOf("-") + 1) + "\n\tSzemélyzet: " + adatok.get(index).getSzemelyzet() + "\n\tUtazósebesség: " + adatok.get(index).getUtazosebesseg());
        
        // 7. feladat - Hiányzó sebességkategória
        ArrayList<String> sebessegkategoriak = new ArrayList(List.of("Alacsony sebességű", "Szubszonikus", "Transzszonikus", "Szuperszonikus"));
        ArrayList<String> letezoSebessegkategoriak = new ArrayList();
        for(Utasszallitok adat : adatok) {
            for(String sebesseg : sebessegkategoriak) {
                if(sebessegkategoriak.contains(adat.getUtazosebessegString())) {
                    letezoSebessegkategoriak.add(adat.getUtazosebessegString());
                }
            }
        }
        
        System.out.println("7. feladat");
        
        int szamlalo = 0;
        for(String sebesseg : sebessegkategoriak) {
            if(!letezoSebessegkategoriak.contains(sebesseg)) {
                szamlalo++;
                System.out.print("\t" + sebesseg + " ");
            }
        }
        
        // 8. feladat - (nem volt rá idő :c)
        
    }
    
    public static ArrayList<Utasszallitok> fajlbeolvasas() {
        ArrayList<Utasszallitok> adatok = new ArrayList();
        
        File fajl = new File("utasszallitok.txt");
        try {
            Scanner sc = new Scanner(fajl);
            
            sc.nextLine();
            while (sc.hasNextLine()) {
                String[] sor = sc.nextLine().split(";");
                Sebessegkategoria sebessegkategoria = new Sebessegkategoria(Integer.parseInt(sor[4]));
                Utasszallitok adat = new Utasszallitok(sor[0], Integer.parseInt(sor[1]), sor[2], sor[3], Integer.parseInt(sor[4]), sebessegkategoria.getKategorianev(), Integer.parseInt(sor[5]), sor[6]);
                adatok.add(adat);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        
        return adatok;
    }
    
}
