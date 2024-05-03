package FajlOlvasasIras;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FajlOlvasasIras {

    public static void main(String[] args) {
        
        ArrayList<String> fruits = FajlOlvasasIras.readFile();
        System.out.println(fruits);
        
        System.out.println("A fájlban: " + fruits.size() + "db sor van.");
        
        
        
        FajlOlvasasIras.write();
        
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Adj meg egy számot: ");
//        
//        try {
//            int num = sc.nextInt();
//            System.out.println(num / 0);
//        } catch (InputMismatchException ex) {
//            System.out.print("Mondom számot adj meg: ");
//        } catch (Exception ex) {
//            System.out.println("Hát erre nem voltam felkészülve: ");
//            System.err.println(ex.getMessage());
//        }
//        
    }
    
    
    public static ArrayList<String> readFile() {
        
        File file = new File("gyumolcs.txt");
        
        ArrayList<String> gyumolcsok = new ArrayList();
        try {
            Scanner sc = new Scanner(file);
            
            while (sc.hasNextLine() == true) {
                String row = sc.nextLine();
                System.out.println(row);
                gyumolcsok.add(row);
            }
            
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
        
        
        System.out.println("\nBeolvasás után!");
        
        return gyumolcsok;
        
    }
    
    
    public static void write() {
        
        try {
            File file = new File("numbers.txt");
            if (file.createNewFile()) {
                System.out.println("Létrehoztam!");
            } else {
                System.out.println("A fájl már létezik!");
            }
            
            FileWriter fw = new FileWriter(file);
            // append-el csak stringet tudunk hozzáadni
            fw.append(String.valueOf(15));
            // write-al tudunk int-et is, de karakter kódolás miatt szarul jelenik meg
            fw.write(20);
            fw.close();
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
}
