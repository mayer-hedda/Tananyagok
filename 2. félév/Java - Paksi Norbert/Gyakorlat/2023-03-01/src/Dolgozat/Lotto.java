package Dolgozat;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {

    public static void main(String[] args) {
        
        /*
        1. feladat:
        Készíts egy tömböt, amely az adott hét nyertes lottószámait tartalmazza. A játékot az
        5ös lottó szabályai alapján fogjuk készíteni, így ebben a tömbben 5darab számot kell
        tárolnod 1 és 90 között. A számokat random generáld, és a tömb feltöltésekor figyelj
        oda arra hogy minden szám csak egyszer szerepelhessen a tömbben. Ha nem tudod
        megoldani a tömb feltöltését random számokkal, hozz létre kézzel egy tömböt, és
        használd azt a későbbi feladatokhoz.
        */
        Integer[] lottoszamok = new Integer[5];
        
        for (int i = 0; i < 5;) {
            Random rand = new Random();
            int szam = (rand.nextInt(90)) + 1;
            
            if (!Arrays.asList(lottoszamok).contains(szam)) {
                lottoszamok[i] = szam;
                i++;
            }
        }
        
//        for (int szam : lottoszamok) {
//            System.out.print(szam + ", ");
//        }
        
        
        
        
        
        /*
        2. feladat:
        Készíts egy függvényt, ami Scanner segítségével bekér a felhasználótól 5 számot, ez
        lesz a felhasználó lottószelvénye. A számok 1-90 között legyenek, csak egyszer
        szerepelhessenek a szelvényen, és a függvény visszatérési értéke egy Integer tömb
        legyen, benne a felhasználó által megadott 5 számmal. Ha nem tudod megoldani,
        hozz létre kézzel egy tömböt, és használd azt a későbbi feladatokhoz.
        */
//        Integer[] felhasznaloSzamai = Lotto.szamokBekerese();
        
        
        
        
        
        /*
        3. feladat:
        Készíts egy lottó függvényt, amely bemenő paraméterei az 1. és 2. feladatban
        létrehozott tömbök, a függvényben hasonlítsd össze a felhasználó számait a
        nyerőszámokkal, és visszatérési értékként add vissza a találatok számát.
        */
//        int talalatokSzama = Lotto.lotto(lottoszamok, felhasznaloSzamai);
//        System.out.println("A találatok száma: " + talalatokSzama);
        
        
        
        
        
        
        /*
        4. feladat:
        A 3. feladat mintájára készíts olyan lottó játékot, ahol a felhasználó megadhatja hány
        szelvényt szeretne ellenőrizni (max 3db), majd egyesével megadja a szelvényeit, a
        függvény pedig kiírja a képernyőre az adott szelvény találatainak számát.
        */
        Scanner sc = new Scanner(System.in);
        Boolean jatek = true;
        while (jatek) {
            System.out.print("Adja meg, hogy hány szelvényt szeretne kitöltni (max. 3): ");
            int szamlalo = sc.nextInt();

            if (szamlalo <= 3 && szamlalo >= 1) {
                for (int i = 0; i < szamlalo; i++) {
                    System.out.println("\n" + (i + 1) + ". szelvény:");
                    Integer[] felhasznaloTippjei = Lotto.szamokBekerese();
                    int felhasznaloTalalatai = Lotto.lotto(lottoszamok, felhasznaloTippjei);
                    System.out.println((i + 1) + ". szelvény találatai: " + felhasznaloTalalatai + "\n");
                }
                jatek = false;
            } else {
                System.err.println("Nem megfelelő számot adtál meg!");
            }
        }
        
    }
    
    
    public static Integer[] szamokBekerese() {
        System.out.println("Kérlek adj meg 5 db számot 1 és 90 között!");
        
        Integer[] szelveny = new Integer[5];
        
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5;) {
            System.out.print("\tAdja meg a(z) " + (i + 1) + ". számot: ");

            int szam = sc.nextInt();
            
            if (szam <= 90 && szam >= 1) {
                if (Arrays.asList(szelveny).contains(szam)) {
                    System.err.println("\tEzt a számot már megadta egyszer!");
                } else {
                    szelveny[i] = szam;
                    i++;
                }
            } else {
                System.err.println("\tNem megfelelő számot adtál meg!");
            }
        }
        
        return szelveny;
    }
    
    
    public static int lotto(Integer[] szamok, Integer[] tippek) {
        int talalat = 0;
        
        for (int tipp : tippek) {
            if (Arrays.asList(szamok).contains(tipp)) {
                talalat++;
            }
        }
        
        return talalat;
    } 
    
}
