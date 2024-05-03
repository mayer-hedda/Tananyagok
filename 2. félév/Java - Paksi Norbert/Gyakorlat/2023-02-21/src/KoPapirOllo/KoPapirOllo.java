package KoPapirOllo;

import java.util.Random;
import java.util.Scanner;

public class KoPapirOllo {
    
    public static void main(String[] args) {
        KoPapirOllo.foJatek();
    }
    
    
    public static Integer gepValasztasa() {
        Random rand = new Random();
        Integer gepValasztasa = rand.nextInt(3);
        System.out.println(gepValasztasa);
        return gepValasztasa;
    }
    
    
    public static Integer felhasznaloValasztasa() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nVálasszon a lehetőségek közül: \"ko\", \"papir\", \"ollo\": ");
        String valasz = sc.nextLine();
        
        return switch (valasz) {
            case "ko" -> 0;
            case "papir" -> 1;
            case "ollo" -> 2;
            default -> 3;
        };
    }
    
    
    public static String nyertes(Integer felhV, Integer gepV) {
        if (felhV < 3) {
            if (felhV == gepV) {
                return "Döntetlen!";
            } else if (felhV == 0 && gepV == 2 || felhV == 1 && gepV == 0 || felhV == 2 && gepV == 1) {
                return "Nyertél!";
            } else {
                return "Gép nyert!";
            }
        } else {
            return "Nem megfelelő értéket adtál meg!";
        }
    }
    
    
    public static Integer korokSzama() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Hány kört szeretnél játszani? ");
        Integer korokSzama = sc.nextInt();
        
        return korokSzama;
    }
    
    
    public static void foJatek() {
        Integer korokSzama = KoPapirOllo.korokSzama();
        
        Integer felhNyert = 0;
        Integer gepNyert = 0;
        Integer dontetlen = 0;
        
        Integer hibakSzama = 0;
        Boolean jatszhatsz = true;
        
        for (int i = 0; i < korokSzama; i++) {
            if (jatszhatsz) {
                String eredmeny = KoPapirOllo.nyertes(KoPapirOllo.felhasznaloValasztasa(), KoPapirOllo.gepValasztasa());
            
                switch (eredmeny) {
                    case "Nem megfelelő értéket adtál meg!" -> {
                        hibakSzama += 1;
                        if (hibakSzama == 5) {
                            System.out.println("Mát ötször rossz értéket adtál meg, ezért a program kiléptet!");
                            jatszhatsz = false;
                            break;
                        }
                        i--;
                        System.out.println(eredmeny);
                    }
                    case "Döntetlen!" -> {
                        dontetlen += 1;
                        System.out.println(eredmeny);
                    }
                    case "Nyertél!" -> {
                        felhNyert += 1;
                        System.out.println(eredmeny);
                    }
                    case "Gép nyert!" -> {
                        gepNyert += 1;
                        System.out.println(eredmeny);
                    }
                }
            } else {
                break;
            }
            
        }
        
        System.out.println("\n\nEredmény:\n\tTe nyertél: " + felhNyert + "\n\tGép nyert: " + gepNyert + "\n\tDöntetlen: " + dontetlen);
    }
    
}
