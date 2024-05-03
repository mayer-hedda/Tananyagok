package Main;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        /*
        2. feladat: 
        Kérj be a programmal a felhasználótól 2 db egész számot.
        Írasd ki a konzolra, hogy a 2 szám összege páros vagy páratlan szám
        */
        Scanner sc = new Scanner(System.in);
        System.out.print("Adjon meg 2 számot: \n\t1.: ");
        int szam1 = sc.nextInt();
        
        System.out.print("\t2.: ");
        int szam2 = sc.nextInt();
        
        if ((szam1 + szam2) % 2 == 0) {
            System.out.println("A két szám összege páros!\n");
        } else {
            System.out.println("A két szám összege páratlan!\n");
        }
        
        
        
        /*
        3. feladat: 
        Határozd meg ciklus segítségével az összes 100-nál kisebb 2 jegyű páros számot. 
        Tárold el a számokat egy ArrayListben
        10=< 100< %2==0
        */
        ArrayList<Integer> szamok = new ArrayList();
        
        for (int i = 10; i < 100; i++) {
            if (i % 2 == 0) {
                szamok.add(i);
            }
        }
        
        
        
        /*
        4. feladat: 
        Írasd ki a konzolra, hogy hány darab szám található az előző feladatban készített ArrayListben
        */
        System.out.println("A 100-nál kisebb kétjegyű páros számok darabszáma: " + szamok.size());
        
        
        
        /*
        5. feladat:
        Egy cég 10 olyan autóval rendelkezik, amelyet a dolgozók igénybe vehetnek az üzleti ügyeik
        intézésére. Az autókat akár többnapos útra is elvihetik, illetve egy autót egy nap több dolgozó
        is elvihet. A rendszer az autók parkolóból való ki- és behajtását rögzíti. A parkoló a hónap
        minden napján 7-23 óra között van nyitva, csak ebben az időszakban lehet elvinni és
        visszahozni az autókat. Az autót mindig annak a dolgozónak kell visszahoznia, amelyik elvitte.
        Egyszerre csak egy autó lehet minden dolgozónál.
        Az autok.txt fájl egy hónap (30 nap) adatait rögzíti. Egy sorban szóközökkel elválasztva
        6 adat található az alábbi sorrendben:
        nap, idő, rendszám, személyazonosító kilometer állása ki vagy behajtas (0 - ki, 1 - be)


        Készíts egy függvényt, ami beolvassa az autok.txt fájlt és eltárolja a sorokat egy ArrayListben (Az első sor nélkül) üres sc.nextLine()
        */
        ArrayList<String[]> sorok = Main.fajlbeolvasas();
        
        
        
        /*
        6. feladat: 
        Írasd ki a konzolra, hogy hány rekord található a fájlban
        */
        System.out.println("\n" + sorok.size() + " rekord található a fájlban!\n");
        
        
        
        /*
        7. feladat: 
        Keresd meg, hogy melyik a legnagyobb futott km a fájlban (napok figyelmbe vétele nélkül)
        */
        int legnagyobbKm = 0;
        for (String[] sor : sorok) {
            if (Integer.parseInt(sor[4]) > legnagyobbKm) {
                legnagyobbKm = Integer.parseInt(sor[4]);
            }
        }
        
        System.out.println("A legnagyobb km a fájlban: " + legnagyobbKm + " km\n");
        
        
        
        /*
        8. feladat: 
        Készíts egy függvényt, ami megnézi, hogy a hónap végén a CEG305 rendszamú autó a parkolóban van-e vagy sem
        */
        Main.parkolo(sorok);
        
    }
    
    public static ArrayList<String[]> fajlbeolvasas() {
        ArrayList<String[]> adatok = new ArrayList();
        
        File fajl = new File("autok.txt");
        try {
            Scanner sc = new Scanner(fajl);
            
            sc.nextLine();
            
            while (sc.hasNextLine()) {
                String[] sor = sc.nextLine().split(" ");
                adatok.add(sor);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        
        return adatok;
    }
    
    public static void parkolo(ArrayList<String[]> adatok) {
        boolean bentvan = false;
        
        for (String[] adat : adatok) {
            if (adat[2].equals("CEG305")) {
                if (adat[5].equals("0")) {
                    bentvan = false;
                } else {
                    bentvan = true;
                }
            }
        }
        
        if (bentvan) {
            System.out.println("A CEG305-ös rendzsámú autó a hónap végén bent volt a parkolóban!");
        } else {
            System.out.println("A CEG305-ös rendzsámú autó a hónap végén nem volt bent a parkolóban!");
        }
    }
    
}
