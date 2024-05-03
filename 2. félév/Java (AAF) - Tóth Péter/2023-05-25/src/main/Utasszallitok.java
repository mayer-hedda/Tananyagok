package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Utasszallitok {

    public static void main(String[] args) {
        
        ArrayList<Repulo> repulok = Utasszallitok.readFile();
        
        System.out.println("4. feladat: Adatsorok száma: " + repulok.size());
        
        Utasszallitok.countBoeing(repulok);
        
        Utasszallitok.maxUtas(repulok);
        
        Utasszallitok.kategoria(repulok);
        
    }
    
    public static ArrayList<Repulo> readFile() {
        ArrayList<Repulo> repulok = new ArrayList();
        
        File file = new File("utasszallitok.txt");
        try {
            Scanner sc = new Scanner(file);
            
            sc.nextLine();
            while(sc.hasNextLine()) {
                String row = sc.nextLine();
                repulok.add(new Repulo(row));
            }
        } catch(FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        
        return repulok;
    }
    
    public static void countBoeing(ArrayList<Repulo> repulok) {
        int c = 0;
        
        for(Repulo r: repulok) {
            if(r.tipus.contains("Boeing")) {
                c++;
            }
        }
        
        System.out.println("5. feladat: Boeing típusok száma: " + c);
    }
    
    public static void maxUtas(ArrayList<Repulo> repulok) {
        Repulo max = repulok.get(0);
        
        for(Repulo r: repulok) {
            if(r.convertUtas() > max.convertUtas()) {
                max = r;
            }
        }
        
        System.out.println("6. feladat: A legtöbb utast szállító repülőgéptípus");
        System.out.println(max.toString());
    }
    
    public static void kategoria(ArrayList<Repulo> repulok) {
        ArrayList<String> kategoriak = new ArrayList(Arrays.asList("Alacsony sebességű", "Szubszonikus", "Transzszonikus", "Szuperszonikus"));
        
        
    }
    
}
