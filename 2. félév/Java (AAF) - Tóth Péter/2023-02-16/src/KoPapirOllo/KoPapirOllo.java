package KoPapirOllo;

import java.util.Scanner;

public class KoPapirOllo {
    
    public static void main(String[] args) {
//        1-Kő
//        2-Papír
//        3-Olló
//        
//        döntetlen: két szám egyenlő
//        1 a különbség: mindig a nagyobb szám nyer
//        2 a különbség: 1 - 3 a kisebb nyer
        
        double gep = Math.ceil(Math.random()*3);    //ceil felfelé kerekít
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Válassz fegyvert: ");
        System.out.print("1 - Kő, 2 - Papír, 3 - Olló: ");
        int felh = sc.nextInt();

        
        if (felh <= 3 && felh >= 1){
            if (gep == felh) {
                System.out.println(mitMutatott((int) gep));
                System.out.println("Döntetlen");
            } else if (Math.abs(gep - felh) == 1) {
                System.out.println(mitMutatott((int) gep));
                System.out.println((gep > felh) ? "A gép nyert!" : "Te nyertél!");
            } else {
                System.out.println(mitMutatott((int) gep));
                System.out.println((gep > felh) ? "Te nyertél!" : "A gép nyert!");
            }
        } else {
            System.out.println("Nem megfelelő értéket adtál meg!");
        }
        
    }
    
    
    public static String mitMutatott(int n){
        switch(n){
            case 1: return "Kő"; 
            case 2: return "Papír";
            case 3: return "Olló";
            default: return "Ez nem tudom ";
        }
    }
}