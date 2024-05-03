package Alapok;

import java.util.ArrayList;
import java.util.Scanner;

public class Alapok {

    public static void main(String[] args) {
        
        // Egysoros komment
        /* Többsoros komment */
        System.out.println("Hello World!");
        
        // Primitívek (8)
        char c = 'c';
        byte b = 5;    // -128 - 128
        short s = 5;
        long l = 111112l;
        int num = 2;
        boolean k = true;
        float f = 15.5f;
        double d = 12.1;
        
        
        String str = "alma";
        
        
        
        
        
        // Elágazások
        // if - else if - else
        if (s % 3 == 0) {
            System.out.println("Az " + s + " osztható 3-mal.");
        } else if (s % 3 == 1){
            System.out.println("Az " + s + " nem osztható 3-mal: 1 a maradék.");
        } else {
            System.out.println("Az " + s + " nem osztható 3-mal: 2 a maradék.");
        }
        
        
        // bekérés
        Scanner sc = new Scanner(System.in);
        System.out.print("Kérlek adj meg egy 1 és 10 közötti egész számot! ");
        String number = sc.nextLine();
        System.out.println("Ezt a számot adtad meg: " + number);
        
        
        // switch - case
        // number mivel egyenlő
        switch (number) {
            case "1" -> System.out.println("I");
            case "2" -> System.out.println("II");
            case "3" -> System.out.println("III");
            case "4" -> System.out.println("IV");
            case "5" -> System.out.println("V");
            case "6" -> System.out.println("VI");
            case "7" -> System.out.println("VII");
            case "8" -> System.out.println("VIII");
            case "9" -> System.out.println("IX");
            case "10" -> System.out.println("X");
            
            default -> System.out.println("Mondom 1 és 10 közötti!!!");
        }
        
        
        
        
        
        // Elöltesztelős ciklusok
        // for
        for (int j = 2; j <= 100; j += 2) {
            System.out.println(j);
        }
        
        
        // while
        int h = 3;
        while (h < 100) {
            System.out.println(h);
            h += 3;
        }
        
        
        
        
        
        // Hátultesztelős ciklus
        // do - while
        do {
            System.out.println("Do while " + h);
            h += 3;
        } while (h < 100);
        
        
        
        
        
        // Tömb
        String[] words = {"alma", "körte", "barack", "cseresznye"};
        String[] arr = new String[1];
        
        
        
        // Lista
        ArrayList<String> wordsList = new ArrayList();
        wordsList.add("Alma");
        wordsList.add("Körte");
        wordsList.add("Barack");
        
        System.out.println(wordsList.get(0));
        
        // wordsList.clear();  // Egész lista törlése
        
        System.out.println(wordsList);
        wordsList.remove(2);    // bizonyos indexű elem törlése
        System.out.println(wordsList);
        
        System.out.println(wordsList.size());
        
        
        
        
        
        // Tömb bejárása
        // for
        for(String word : words) {
            System.out.println(word);
        }
        
        
        
        // for(each)
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
        
    }
    
}
