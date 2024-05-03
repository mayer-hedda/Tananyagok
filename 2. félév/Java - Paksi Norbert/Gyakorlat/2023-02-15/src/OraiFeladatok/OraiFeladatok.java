package OraiFeladatok;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class OraiFeladatok {
    
    public static void main(String[] args) {
        
        // Órai feladatok
        // 1.: Generáld le a fibonacci számsor első 12 elemét ciklusok és változók segítségéve
        ArrayList<Integer> szamok = new ArrayList();
        szamok.add(0);
        szamok.add(1);

        for (int i = 0;szamok.size() < 12; i++) {
            szamok.add(szamok.get(i) + szamok.get(i + 1));
        }
        
        System.out.println("\nFibonacci számsor: \n\t" + szamok);
        
        
        
        
        
        // 2: Készíts kő papír olló alkalmazást, és törekedj az alábbi elemek használatára:
        //      • A gép választását random szám generálásra alapozd.
        //      • A felhasználó választását adatbekéréssel(scanner object) old meg (ez self learning)
        //      • A logikai feltétel a lehető leg optimálisabban, minél kevesebb vizsgálattal döntse el a
        //      játék végeredményét
        //      • Extra funkció: a játék elején kérdezd meg a usert hány kört szeretne játszani, és a
        //      játék végén az alábbi módon írd ki a végeredményt: Te nyertél: 2, Gép nyert: 1,
        //      Döntetlen: 3 , A játék győztese tehát te vagy/ a gép.
        String[] szavak = {"ko", "papir", "ollo"};
        
        Random rand = new Random();
        int valasztas = rand.nextInt(3);
//        System.out.println(valasztas);
        
        Scanner myObj = new Scanner(System.in);
        System.out.print("\nHány kört szeretnél játszani? ");
        int korokSzama = myObj.nextInt();
        
        int dontetlen = 0;
        int gepGyozelem = 0;
        int felhasznaloGyozelem = 0;
        for (int i = 0; i < korokSzama; i++){
        
            System.out.print("\nVálasszon a lehetőségek közül (0:ko, 1:papir, 2:ollo): ");
            int felhasznaloValasztasa = myObj.nextInt();

            if (felhasznaloValasztasa <= 2 && felhasznaloValasztasa >= 0) {
                if (valasztas == felhasznaloValasztasa) {
                    System.out.println("Döntetlen!");
                    dontetlen += 1;
                } else if (valasztas == 0 && felhasznaloValasztasa == 2 || valasztas == 1 && felhasznaloValasztasa == 0 || valasztas == 2 && felhasznaloValasztasa == 1) {
                    System.out.println("Gép nyert!");
                    gepGyozelem += 1;
                } else {
                    System.out.println("Te nyertél!");
                    felhasznaloGyozelem += 1;
                } 
            } else {
                System.out.println("Nem megfelelő adatot adott meg!");
                i--;
            }
    //        System.out.println("A gép választása a következő: " + szavak[valasztas]);
    //        System.out.println(szavak[felhasznaloValasztasa]);
        }
        
        System.out.println("\nEredmény: ");
        System.out.println("\tTe nyertél: " + felhasznaloGyozelem);
        System.out.println("\tGép nyert: " + gepGyozelem);
        System.out.println("\tDöntetlen: " + dontetlen);
        
        
        
        
        
        // Plusz: kő papír olló gyík Spock
        String[] szavak2 = {"ko", "papir", "ollo", "gyik", "Spock"};
        
        Random rand2 = new Random();
        int valasztas2 = rand2.nextInt(3);
//        System.out.println(valasztas);
        
        Scanner myObj2 = new Scanner(System.in);
        System.out.print("\nHány kört szeretnél játszani? ");
        int korokSzama2 = myObj2.nextInt();
        
        int dontetlen2 = 0;
        int gepGyozelem2 = 0;
        int felhasznaloGyozelem2 = 0;
        for (int i = 0; i < korokSzama2; i++){
        
            System.out.print("\nVálasszon a lehetőségek közül (0:ko, 1:papir, 2:ollo, 3:gyík, 4:Spock): ");
            int felhasznaloValasztasa2 = myObj2.nextInt();

            if (felhasznaloValasztasa2 <= 4 && felhasznaloValasztasa2 >= 0) {
                if (valasztas2 == felhasznaloValasztasa2) {
                    System.out.println("Döntetlen!");
                    dontetlen2 += 1;
                } else if (valasztas2 == 0 && felhasznaloValasztasa2 == 2 || valasztas2 == 1 && felhasznaloValasztasa2 == 0 || valasztas2 == 2 && felhasznaloValasztasa2 == 1 || valasztas2 == 0 && felhasznaloValasztasa2 == 3 || valasztas2 == 3 && felhasznaloValasztasa2 == 4 || valasztas2 == 4 && felhasznaloValasztasa2 == 2 || valasztas2 == 2 && felhasznaloValasztasa2 == 3 || valasztas2 == 3 && felhasznaloValasztasa2 == 1 || valasztas2 == 1 && felhasznaloValasztasa2 == 4 || valasztas2 == 4 && felhasznaloValasztasa2 == 0) {
                    System.out.println("Gép nyert!");
                    gepGyozelem2 += 1;
                } else {
                    System.out.println("Te nyertél!");
                    felhasznaloGyozelem2 += 1;
                } 
            } else {
                System.out.println("Nem megfelelő adatot adott meg!");
                i--;
            }
            System.out.println("A gép választása a következő: " + szavak[valasztas]);
    //        System.out.println(szavak[felhasznaloValasztasa]);
        }
        
        System.out.println("\nEredmény: ");
        System.out.println("\tTe nyertél: " + felhasznaloGyozelem2);
        System.out.println("\tGép nyert: " + gepGyozelem2);
        System.out.println("\tDöntetlen: " + dontetlen2);
        
    }
    
}
