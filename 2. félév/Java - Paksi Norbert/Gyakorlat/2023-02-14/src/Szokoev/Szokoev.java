package Szokoev;

public class Szokoev {
    
    public static void main(String[] args) {
        
        // HF:  szökőév ternáris operátoral és beágyazott if-el
        System.out.println("Házifeladat:");
        
        // ternáris operátorral:
        int vizsgalandoEv = 1700;
        
        String eredmeny = (vizsgalandoEv % 100 != 0 && vizsgalandoEv % 4 == 0) || vizsgalandoEv % 400 == 0 ? "Szökőév" : "Nem szökőév";
        System.out.println(vizsgalandoEv + ": " + eredmeny);
        
        
        
        // egymásba ágyazott if-el:
        if (vizsgalandoEv % 4 == 0) {
            if (vizsgalandoEv % 100 == 0) {
                if (vizsgalandoEv % 400 == 0) {
                    System.out.println("Szökőév!");
                } else {
                    System.out.println("Nem szökőév!");
                }
            } else {
                System.out.println("Szökőév!");
            }
        } else {
            System.out.println("Nem szökőév!");
        }
        
    }
    
}
