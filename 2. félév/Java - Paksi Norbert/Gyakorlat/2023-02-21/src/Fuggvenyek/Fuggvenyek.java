package Fuggvenyek;

public class Fuggvenyek {
    
    // ide definiálhatunk függvényeket, mert osztályon belül, de main-en kívűl van
    
    public static void main(String[] args) {
    
        // függvényeknek lehetnek bemeneti paraméterei, ezeken kívül a függvény látja a függvényben létrehozott változókat, a globális változókat
        // void függvények (metódusok) csak lefutnak, nem rendelkeznek visszatérési értékkel
        // visszatérési értékkel rendelkező függvényeket vagy eltároljuk, vagy kiiratjuk
        // egy függvénynek vagy 1 visszatérési értéke lehet (bármilyen adattípusú lehet), vagy 0, ha void függvényről (metódusról) van szó
        // dinamikus függvény az, amely példányosítással egy példányra van meghívva, ha magára az osztályra hívjuk meg akkor statikus függvényről beszélünk
        // polimorfizmus = többalakúság --> két változó nem létezhet ugyanazon a nézen, de két függvénynek igen, amíg paraméterei alapján megkülönböztethetőek
    
    
        // itt tudom meghívni a függvéníeimet pl. az összeadást
        System.out.println(Fuggvenyek.osszeadas(12.6, 13.4));
        
        // eltárolhatjuk egy változóban
        // az itteni eredmeny változóm locális változó, tehát ha az osszeadas() függvényben is lenne eredmeny változóm, azok nem zavarnák egymást
        Double eredmeny = Fuggvenyek.osszeadas(10.1, 5.2);
        System.out.println(eredmeny);
        
        // bemeneti paraméternek változókat is meg tudunk adni, amik értékeket tárolnak
        Double szam1 = 2.5;
        Double szam2 = 2.6;
        System.out.println(Fuggvenyek.osszeadas(szam1, szam2));
        
        // primitív double-el is működik, mert a java biztosít átjárást az értéktípusok primitív és osztályosított tipúsai között
        double szam3 = 3.0;
        double szam4 = 6.2;
        System.out.println(Fuggvenyek.osszeadas(szam3, szam4));
        
        
        
        
        // feladat
        System.out.println(Fuggvenyek.osszeadasHaromSzammal(12.0, 4.7, 32.4));
        
        
        
        
        //
        
        
    }
    
    // ide definiálhatunk függvényeket, mert osztályon belül, de main-en kívűl van
    
    // Access modifier(4 db) + meghívás módja (statikus -> ki kell írni a static kulcsszót, dinamikus) + visszatérési érték típúsa (visszatérési érték hiányában void) + függvény neve (beszédes név) + bemenő paraméter(ek) + függvény body része
    
    
    // összeadás függvény
    // függvényen belül az "a" és "b" változóval tudunk dolgozni (ezekkel hivatkozunk a bemeneti paraméterekre)
    public static Double osszeadas(Double a, Double b) {
        // vagy egyből return-ölünk
        return a + b;
        
//        vagy eltároljuk egy változóban és a változót return-öljük vissza
//        Double eredmeny = a + b;
//        return eredmeny;
    }
    
    
    
    // feladat: 3 szám összeadása
    public static Double osszeadasHaromSzammal(Double a, Double b, Double c) {
        return a + b + c;
    }
    
    
    
    // függvény fölé írva létrehozható egy leírás a függvényhez:
    /**
      
     * 1 = összeadás
     * 2 = kivonás
     * 3 = szorzás
     * 4 = osztás
     
    */
    public static Double szamologep(Double a, Double b, Integer muvelet) {
        switch (muvelet) {
            case 1: return a + b;
            case 2: return a - b;
            case 3: return a * b;
            case 4: return a / b;
            default:return -1.0;
        }
    }
    
    
    
    
    // feladat: műveleti jelet String típusúként kéri be
    public static Double szamologepSajat(Double a, Double b, String mj) {
        if (mj.equals("+")) {
            return a + b;
        } else if (mj.equals("-")) {
            return a - b;
        } else if (mj.equals("*")) {
            return a * b;
        } else {
            return a / b;
        }
    }
}
