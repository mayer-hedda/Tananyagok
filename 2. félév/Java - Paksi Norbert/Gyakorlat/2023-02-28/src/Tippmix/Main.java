package Tippmix;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        /*
            • Az alábbi feladat 4 részfeladatot tartalmaz, amelyek egymásra épülnek, így
            mindenképp sorban haladj a részfeladatok megoldásával.
            • A feladatok a sportfogadás működését veszik alapul, és az objektumok nélküli
            megoldásuk nem túl elegáns kódot fog eredményezni, ez szándékos, az objektum
            orientált programozás tanulása során el fogjuk készíteni a feladat OOP változatát,
            illetve elemezni a két megoldásmód közti különbséget. Jelen feladatban kötelező a
            feladatrészekben meghatározott adattípusok és kollekciók használata
        
        A feladatok megoldásához fontos információk:
            • Minden mérkőzés kimenetele 3 dolog lehet: H – hazai csapat nyer, D – döntetvel, V –
            vendég csapat nyer
            • Csak az a szelvény győztes, amin minden megjátszott mérkőzés eredményét helyesen
            tippelték meg.
            • Csak az a szelvény érvényes, amin minden megjátszott mérkőzés szerepel a
            mérkőzések „adatbázisában”
            • Egy győztes szelvény esetén a nyeremény = megjátszott tét * megjátszott
            mérkőzésekhez tartozó oddsok szorzata (tehát 1000ft tét , 2.0 2.2 és 2.2 oddsok
            esetén a nyeremény 2*2*2*1000, azaz 8000ft)
        */
        
        
        
        // 1. feladat
        /*
        - Készíts egy 2 dimenziós String tömböt meccsek néven, ahol a mérkőzések
        adatbázisát fogjuk tárolni.
        - Tárolj el 10 mérkőzést a meccsek tömbben. Minden mérkőzés legyen egy String
        tömb, melynek 3 eleme a mérkőzés sorszáma, a mérkőzést játszó csapatok neve, és a
        mérkőzés kimenetele(végeredménye) , az alábbi módon: {"a123","Barcelona-Real
        Madrid","D"}. A csapatnevek sorrendje meghatározza , hogy mindig az első név a
        Hazai csapat.
        - Készíts 1 user tippet, amely egy String tömb, tartalma 1db sorszám, és 1db
        végkimenetel(eredmény), az alábbi módon: {”a132”,”D”}
        - Készíts egy függvényt Játék1 néven, amely két bemenő paramétere a user tipp, és a
        meccset tömb, majd a függvényen belül ellenőrizd le és írd ki, hogy az adott tipp
        érvénytelen(a sorszáma nem szerepel a meccsek tömbben), nyertes(a sorszámhoz
        tartozó eredmény megegyezik a meccsek tömbben tárolt adattal), vagy vesztest.
        */
        String[][] meccsek = new String[10][3];
        
        meccsek[0] = new String[] {"1", "Barcelona-Real Madrid", "D"};
        meccsek[1] = new String[] {"2", "Real Madrid-PSG", "H"};
        meccsek[2] = new String[] {"3", "Liverpool-Atlanta", "D"};
        meccsek[3] = new String[] {"4", "Inter Milan-Barcelona", "V"};
        meccsek[4] = new String[] {"5", "Bayern München", "H"};
        meccsek[5] = new String[] {"6", "Manchester-Porto", "V"};
        meccsek[6] = new String[] {"7", "Porto-Real Madrid", "H"};
        meccsek[7] = new String[] {"8", "Ajax-Atlanta", "D"};
        meccsek[8] = new String[] {"9", "Atlanta-Porto", "D"};
        meccsek[9] = new String[] {"10", "PSG-Borussia Dortmund", "H"};
        
        String[] userTipp = {"5", "H"};
        
        
        Main.jatek1(userTipp, meccsek);
        
        
        
        
        // 2. feladat
        /*
        - Készíts a meccsek tömb példájára egy többdimenziós String tömböt a user tippjei
        számára, és tárolj el a teszteléshez 4 tippet ebben a tömbben.
        - Készíts egy függvényt játék2 néven, amely bemenő paraméterei alapján az egyes
        feladatban leírt szabályok alapján eldönti, hogy a szelvény (többdimenziós user tömb)
        a meccsek tömbbel összehasonlítva nyertes, vesztes, vagy érvénytelen.
        */
        String[][] userTippek = new String[4][2];
        
        userTippek[0] = new String[] {"1", "H"};
        userTippek[1] = new String[] {"3", "D"};
        userTippek[2] = new String[] {"5", "H"};
        userTippek[3] = new String[] {"K", "K"};
        
        
        Main.jatek2(userTippek, meccsek);
        
        
        
        
        
        // 3. feladat
        /*
        - A meccsek tömb példáját követve készíts egy 2 dimenziós Double tömböt melyben
        az oddsokat fogjuk tárolni. Minden eseményhez(belső tömbhöz) 3 odds tartozik, az
        első a H, a második a D a harmadik pedig a V kimenetelhez tartozik. pl: {2.2, 3.1, 1.82}
        - Készíts függvényt játék3 néven, és egészítsd ki az első függvényt az odds tömbbel,
        és egy integer tét paraméterrel. A függvény nyertes tipp esetén számolja ki hogy
        mennyi a nyeremény, a dokumentum elején leírt formula alapján.
        */
        Double[][] odds = new Double[10][3];
        
        odds[0] = new Double[] {2.2, 2.0, 1.8};
        odds[1] = new Double[] {3.1, 2.6, 2.4};
        odds[2] = new Double[] {2.0, 1.8, 1.9};
        odds[3] = new Double[] {2.2, 2.1, 2.1};
        odds[4] = new Double[] {3.0, 1.9, 1.1};
        odds[5] = new Double[] {2.1, 1.4, 1.3};
        odds[6] = new Double[] {3.2, 2.9, 1.7};
        odds[7] = new Double[] {2.4, 2.8, 1.7};
        odds[8] = new Double[] {2.1, 2.9, 1.5};
        odds[9] = new Double[] {1.8, 1.1, 2.8};
        
        Integer tet = 2000;
        
        
        Main.jatek3(odds, tet, userTipp, meccsek);
        
        
        
        
        
        // 4. feladat
        /*
        - Készíts függvényt Játék4 néven, amely bemenő paraméterei a meccsek, a
        többdimenziós user tömb, az odds tömb, és egy tét, majd a 2es feladat mintájára
        döntsd el hogy a szelvény nyertes, vesztes, vagy érvénytelen-e. Nyertes szelvény
        esetén számold ki hogy mennyi a nyeremény, a dokumentum elején leírt formula
        alapján.
        */
        Main.jatek4(userTippek, meccsek, odds, tet);
        
        
        
        
        
        // Extra feladat
        /*
        - Készíts függvényt Játék4 néven, amely bemenő paraméterei a meccsek, a
        többdimenziós user tömb, az odds tömb, és egy tét, majd a 2es feladat mintájára
        döntsd el hogy a szelvény nyertes, vesztes, vagy érvénytelen-e. Nyertes szelvény
        esetén számold ki hogy mennyi a nyeremény, a dokumentum elején leírt formula
        alapján.
        */
        Main.extra(meccsek);
        
    }
    
    
    public static void jatek1 (String[] userTipp, String[][] meccsek) {
        Boolean talalat = false;
        
        for (int i = 0; i < meccsek.length; i++) {
            if (userTipp[0].equals(meccsek[i][0])) {
                if (userTipp[1].equals(meccsek[i][2])) {
                    talalat = true;
                    System.out.println("Nyertes tipp!");
                    break;
                } else {
                    talalat = true;
                    System.out.println("Vesztes tipp!");
                    break;
                }
            }
        }
        
        if (!talalat) {
            System.out.println("Érvénytelen tipp!");
        }
    }
    
    
    public static void jatek2 (String[][] userTippek, String[][] meccsek) {
        for (int i = 0; i < userTippek.length; i++) {
            Boolean talalat = false;
            
            for (int j = 0; j < meccsek.length; j++) {
                if (userTippek[i][0].equals(meccsek[j][0])) {
                    if (userTippek[i][1].equals(meccsek[j][2])) {
                        talalat = true;
                        System.out.println((i + 1) + ". Nyertes tipp!");
                        break;
                    } else {
                        talalat = true;
                        System.out.println((i + 1) + ". Vesztes tipp!");
                    }
                }
            }
            
            if (!talalat) {
                System.out.println((i + 1) + ". Érvénytelen tipp!");
            }
        }
    }
    
    
    public static void jatek3 (Double[][] odds, Integer tet, String[] userTipp, String[][] meccsek) {
        Boolean talalat = false;
        
        for (int i = 0; i < meccsek.length; i++) {
            if (userTipp[0].equals(meccsek[i][0])) {
                if (userTipp[1].equals(meccsek[i][2])) {
                    talalat = true;
                    
                    long nyertPenz;
                    if (userTipp[1].equals("H")) {
                        nyertPenz = tet * Math.round(odds[i][0]);
                    } else if (userTipp[1].equals("D")) {
                        nyertPenz = tet * Math.round(odds[i][1]);
                    } else {
                        nyertPenz = tet * Math.round(odds[i][2]);
                    }
                    
                    System.out.println("Nyertes tipp! Nyereményed összege: " + nyertPenz);
                    break;
                } else {
                    talalat = true;
                    System.out.println("Vesztes tipp!");
                    break;
                }
            }
        }
        
        if (!talalat) {
            System.out.println("Érvénytelen tipp!");
        }
    }
    
    
    public static void jatek4 (String[][] userTippek, String[][] meccsek, Double[][] odds, Integer tet) {
        for (int i = 0; i < userTippek.length; i++) {
            Boolean talalat = false;
            
            for (int j = 0; j < meccsek.length; j++) {
                if (userTippek[i][0].equals(meccsek[j][0])) {
                    if (userTippek[i][1].equals(meccsek[j][2])) {
                        talalat = true;
                        
                        long nyertPenz;
                        if (userTippek[i][1].equals("H")) {
                            nyertPenz = tet * Math.round(odds[i][0]);
                        } else if (userTippek[i][1].equals("D")) {
                            nyertPenz = tet * Math.round(odds[i][1]);
                        } else {
                            nyertPenz = tet * Math.round(odds[i][2]);
                        }
                        
                        System.out.println((i + 1) + ". fogadás: Nyertes tipp! Nyereméned összege: " + nyertPenz);
                        break;
                    } else {
                        talalat = true;
                        System.out.println((i + 1) + ".fogadás: Vesztes tipp!");
                    }
                }
            }
            
            if (!talalat) {
                System.out.println((i + 1) + ".fogadás: Érvénytelen tipp!");
            }
        }
    }
    
    
    public static void extra(String[][] meccsek) {
        Integer fogadasokSzama;
        
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Hány mérkőzésre szeretne fogadni? ");
            try {
                fogadasokSzama = sc.nextInt();
                break;
            } catch (Exception ex) {
                System.out.println("Nem megfelelő értéket adtál meg!");
            }
        }
        
        String[][] tippek = new String[fogadasokSzama][2];
        ArrayList<String> sorszamok = new ArrayList();
        for (int i = 0; i < fogadasokSzama; i++) {
            System.out.println("\n" + (i + 1) + ". fogadás:");
            
            Scanner sc1 = new Scanner(System.in);
            String merkozes;
            while (true) {
                System.out.print("\tAdja meg a mérkőzés sorszámát: ");
                merkozes = sc1.nextLine();
                
                if (sorszamok.contains(merkozes)) {
                    System.err.println("\tErre a mérkőzésre már leadott fogadást!");
                } else {
                    sorszamok.add(merkozes);
                    break;
                }
            }
            
            Scanner sc2 = new Scanner(System.in);
            System.out.print("\tAdja meg a mérkőzés kimenetelét (H: hazai csapat nyer, D: döntetlen, V: vendég csapat nyer): ");
            String kimenetel = sc2.nextLine().toUpperCase();
            
            tippek[i] = new String[] {merkozes, kimenetel};
        }
        
        System.out.println("\n");
        Main.jatek2(tippek, meccsek);
    }
    
}
