package LancoltListaFeladat;

import java.util.LinkedList;

public class LancoltListaFeladat {
    
    public static void main(String[] args) {
        
        // FELADAT
        /*
        Hozzatok létre láncolt listát amely 5 tört számot tartalmaz. Töltsétek fel a listát az alábbi számokkal, és az alábbi sorrendben:
        1. beillesztés, szám:4,4 index:2
        2. beillesztés: szám: 6,5 index:3
        3. beillesztés: szám 2.3 index: 1
        4. beillesztés szám: 8.8 index: 0
        5. beillesztés szám 1.34 index: 4
        for ciklussal bejárva a listát adjátok össze az 5 számot, és írjátok ki a számok összegét
        foreach-el bejárva a listát írjátok ki az összes számot külön sorba, indexek szerinti sorrendben (0,1,2,3,4)
        töröljétek ki a 3as indexü számot
        az új 3as indexü elemet változtassátok meg 12,74re
        írjátok ki a lista összes elemét (system.out.println)
        */
        
        LinkedList<Double> lista = new LinkedList();
        
        lista.add(4.4);
        lista.add(6.5);
        lista.add(0, 2.3);
        lista.add(0, 8.8);
        lista.add(1.34);
        
        System.out.println(lista);
        
        Double osszeg = 0.0;
        for (int i = 0; i < lista.size(); i++) {
            osszeg += lista.get(i);
        }
        System.out.println("A lista elemeinek összege: " + osszeg);
        
        for(Double elem : lista) {
            System.out.println(elem);
        }
        
        lista.remove(3);
        
        lista.set(3, 12.74);
        
        System.out.println(lista);
        
    }
    
}
