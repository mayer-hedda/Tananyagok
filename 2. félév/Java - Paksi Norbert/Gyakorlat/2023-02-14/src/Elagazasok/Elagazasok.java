package Elagazasok;

public class Elagazasok {

    public static void main(String[] args) {
        
        // stringeket nem tudunk egyenlővé tenni, helyette az equals függvényt használjuk
        System.out.println("alma".equals("alma"));
        
        
        
        // szökőévek szabálya 
        int ev = 100;
        if ((ev % 100 != 0 && ev % 4 == 0) || ev % 400 == 0) {
            System.out.println("Szökőév!");
        } else {
            System.out.println("Nem szökőév!");
        }
        // -----> Megcsinálni ternáris operátorral (micimackós kép)
        
        
        
        // nem lesz végtelen ciklus --> ha eléri az integer maximumát (4 bájt), akkor átfordul negatívba
//        for (int i = 0; i > -100; i++) {
//            System.out.println("alma");
//            if (i == 10) {
//                break;
//            }
//        }
        
        

        // egymásba ágyazott elágazások
        for (int szam = 1;szam < 10000; szam++) {
            if (szam % 2 == 0) {
                if (szam % 3 == 0) {
                    break;
                }
                System.out.println("Páros szám");
            } else {
                System.out.println("Páratlan szám");
            }
        }
        
        
        
        // értékelések (if - else if - else megoldással)
        int szazalek = 72;
        if (szazalek >= 0 && szazalek <= 100) {
            if (szazalek < 41) {
                System.out.println("Egyes");
            } else if (szazalek < 61) {
                System.out.println("Kettes");
            } else if (szazalek < 76) {
                System.out.println("Hármas");
            } else if (szazalek < 86) {
                System.out.println("Négyes");
            } else {
                System.out.println("Ötös");
            }
        }
        
    }
    
}
