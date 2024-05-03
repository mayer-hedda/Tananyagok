package Szokoev;

public class Szovoev {

    public static void main(String[] args) {
        
        // Házifeladat egyik megoldása
        // ternáris operátorral
        int evszam = 1997;
        boolean eredmeny = (evszam % 4 == 0 && !(evszam % 100 == 0) || evszam % 400 == 0 ? true : false);
        System.out.println(eredmeny);

        
        // egymásba ágyazott if-el
        System.out.println("---------------------");
        int ev = 1997;
        boolean eredmeny2 = false;
        if(ev > 0){
            if (ev % 4 == 0 ) {
                if(ev % 100 !=0 || ev % 400 == 0){        
                   eredmeny2 = true;
                }else{
                    eredmeny2 = false;
                }
            }else{
                eredmeny2 = false;
            }
        }else{
            System.out.println("Hibás adat.");
        }
        System.out.println(eredmeny2);
        
    }
    
}
