package Main;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        ArrayList<String> beolvasott = Main.fajlBeolvasas();
        ArrayList<String> kategoriak = Main.kategoriakSzortirozasa(beolvasott);
        String kategoria = Main.kategoriaBekeres(kategoriak);
        ArrayList<String> filmek = Main.filmekSzortirozasa(kategoria, beolvasott);
        Integer filmekSzama = Main.filmekSzamaBekeres(filmek);
        Main.sorsolas(filmekSzama, filmek);
        
    }
    
    
    public static String kategoriaBekeres(ArrayList<String> kategoriak) {
        String kategoria;
        
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.print("Add meg, hogy milyen kategóriában szeretnél filmet nézni (");
            for (int i = 0; i < kategoriak.size(); i++) {
                if (i != kategoriak.size() - 1) {
                    System.out.print(kategoriak.get(i) + ", ");
                } else {
                    System.out.print(kategoriak.get(i) + "): ");
                }
            }
            
            String valasztottKategoria = sc.nextLine();
            
            if (kategoriak.contains(valasztottKategoria)) {
                kategoria = valasztottKategoria;
                break;
            } else {
                System.out.println("Nincsen ilyen kategória!\n");
            }
        }
        
        return kategoria.toLowerCase();
    }
    
    
    public static Integer filmekSzamaBekeres(ArrayList<String> lista) {
        Integer filmekSzama;
        
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.print("Add meg, hogy mennyi filmet szeretnél generáltatni (maximum " + lista.size() + "): ");
            filmekSzama = sc.nextInt();
            if (filmekSzama > lista.size()) {
                System.out.println("Nincs ennyi film a listában!\n");
            } else {
                return filmekSzama;
            }
        }
    }
    
    
    public static ArrayList<String> fajlBeolvasas() {
        File file = new File("filmek.txt");
        
        ArrayList<String> kategoriak = new ArrayList();
        try {
           Scanner sc = new Scanner(file);
           
           while(sc.hasNextLine()) {
               String row = sc.nextLine();
               kategoriak.add(row);
           }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        
        return kategoriak;
    }
    
    
    public static ArrayList<String> filmekSzortirozasa(String kategoria, ArrayList<String> beolvasott) {
        ArrayList<String> filmek = new ArrayList();
        
        for (int i = 0; i < beolvasott.size(); i++) {
            String[] aktualis = beolvasott.get(i).split(";");
            if (kategoria.equals(aktualis[0])) {
                for (int j = 1; j < aktualis.length; j++) {
                    filmek.add(aktualis[j]);
                }
            }
        }
        
        return filmek;
    }
    
    
    public static ArrayList<String> kategoriakSzortirozasa(ArrayList<String> beolvasott) {
        ArrayList<String> kategoriak = new ArrayList();
        
        for (int i = 0; i < beolvasott.size(); i++) {
            String[] aktualis = beolvasott.get(i).split(";");
            kategoriak.add(aktualis[0]);
        }
        
        return kategoriak;
    }
    
    
    public static void sorsolas(Integer szamlalo, ArrayList<String> lista) {
        System.out.println("A neked választott filmek: ");
        for (int i = 0; i < szamlalo; i++) {
            Random rand = new Random();
            int index = rand.nextInt(lista.size());
            System.out.println("\t" + (i+1) + ". " + lista.get(index));
            lista.remove(index);
        }
    }
    
}