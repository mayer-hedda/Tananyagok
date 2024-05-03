package Lotto;

import java.util.ArrayList;
import java.util.Scanner;

public class lotto {

    public static void main(String[] args) {
        ArrayList<Integer> lottoSzamok = generate();
        System.out.println(lottoSzamok);
        ArrayList<ArrayList<Integer>> szelvenyTalalatok = new ArrayList();
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Add meg, hogy hány szelvényt szeretnél kitölteni: ");
        int szelvenyekSzama = sc.nextInt();
        
        for (int i = 0; i < szelvenyekSzama; i++) {
            szelvenyTalalatok.add(userNumbers());
        }
        
        for (int i = 0; i < szelvenyTalalatok.size(); i++) {
            System.out.println("\n" + (i+1) + ". szelvény találatai: ");
            talalat(lottoSzamok, szelvenyTalalatok.get(i));
        }
        
        // hf.: több szelvényt ki tud tölteni ugyanahhoz a generate számokhoz
    }
    
    
    public static ArrayList<Integer> generate() {
        ArrayList<Integer> numbers = new ArrayList();
        while (numbers.size() < 5) {
            int n = (int) Math.ceil(Math.random() * 90);
            numbers.add(n);
        }
        
        return numbers;
    }
    
    
    public static ArrayList<Integer> userNumbers() {
        ArrayList<Integer> numbers = new ArrayList();
        System.out.println("\nKérlek adj meg 5db számot 1-90-ig: ");
        
        while (numbers.size() < 5) {
            Scanner sc = new Scanner(System.in);
            System.out.print((numbers.size()+1) + ".szám: ");
            int n = sc.nextInt();
            
            if (n < 1 || n > 90) {
                System.out.println("Rossz számot adtál meg!");
            } else if(numbers.contains(n)) {
                System.out.println("Ezt a számot már megadtad egyszer!");
            } else {
                numbers.add(n);
            }
        }
        
        return numbers;
    }
    
    
    public static void talalat(ArrayList<Integer> generated, ArrayList<Integer> user) {
        int talalat = 0;
        ArrayList<Integer> eltalaltSzamok = new ArrayList();
        
        System.out.println("\tGép számai: " + generated);
        System.out.println("\tFelhasználó számai: " + user);
        
        for (int g : generated) {
            if (user.contains(g)) {
                talalat++;
                eltalaltSzamok.add(g);
            }
        }
        
        if (!eltalaltSzamok.isEmpty()) {
            System.out.println("\t" + talalat + " találata volt a felhasználónak --> " + eltalaltSzamok + "\n");
        } else {
            System.out.println("\t" + talalat + " találata volt a felhasználónak");
        }
    }
    
}
