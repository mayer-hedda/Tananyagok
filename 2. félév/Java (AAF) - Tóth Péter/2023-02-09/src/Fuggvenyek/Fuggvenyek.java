package Fuggvenyek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Fuggvenyek {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Kérlek adj meg egy szöveget: ");
        String text = sc.nextLine();

        for (int i = 0; i < text.length(); i++) {
            // sout + tab
            System.out.println(text.charAt(i));
//            System.out.print(text.charAt(i) + " ");
        }
        
        
        
        String sentence = "Az asztal lába öt centivel megrövidebbítendő.";
        String replaced = sentence.replace("öt", "hat");
        
        System.out.println(sentence);
        System.out.println(replaced);
        
        
        
        System.out.print("Adj meg egy mondatot: ");
        String cenzorString = sc.nextLine();

        System.out.println(cenzor(cenzorString));
        System.out.println("A mondat " + wordsCount(cenzorString) + " szóból áll.");
        
        
        
        numberSort();
        
    }
    
    
    public static void numberSort() {
        System.out.println("Kérlek adj meg 5 db számot: ");
        ArrayList<Integer> number = new ArrayList();
        
        Scanner sc = new Scanner(System.in);
        
        while (number.size() < 5) {
            int n = sc.nextInt();
            number.add(n);
        }
        
        Collections.sort(number);
        System.out.println(number);
        
        Collections.reverse(number);
        System.out.println("A tömb második legnagyobb eleme: " + number.get(1));
        System.out.println(number);
    }
    
    
    public static int wordsCount(String text) {        
        String[] words = text.split(" ");
        System.out.println(Arrays.toString(words));
        
        int count = words.length;
        return count;
    }
    
    
    public static String cenzor(String text) {
        ArrayList<String> denideWords = new ArrayList();
        denideWords.add("Hörcsög");
        denideWords.add("Kecske");
        denideWords.add("Macska");
        
        for (String dw : denideWords) {
            text = text.replace(dw, "*****");
        }
        
        return text;
    }
    
}
