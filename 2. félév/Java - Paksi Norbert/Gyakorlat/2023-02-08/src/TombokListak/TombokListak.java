package TombokListak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class TombokListak {

    public static void main(String[] args) {
        
        // TÖMBÖK
        int[] szamtomb = new int[4];
        
        System.out.println(szamtomb);
        System.out.println(Arrays.toString(szamtomb));
        System.out.println(szamtomb[2]);
        
        szamtomb[2] = 8;
        System.out.println(Arrays.toString(szamtomb));
        System.out.println(szamtomb[2]);
        System.out.println(szamtomb[3]);
        
        
        // FOR
        for (int i = 0; i < szamtomb.length; i++) {
            System.out.print(szamtomb[i] + ", ");
        }
        
        
        // FOREACH
        for (int elem : szamtomb) {
            System.out.print(elem + ", ");
        }
        
        
        
        int[][] tobbD = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        System.out.println(tobbD[0][0]);
        
        int[][][] haromD = {{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}}, {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}}};
        
        
        
        
        
        // LISTÁK
        // ArrayList
        ArrayList<String> gyumolcsok = new ArrayList();
        
        gyumolcsok.add("eper");
        gyumolcsok.add("barack");
        System.out.println(gyumolcsok);
        
        gyumolcsok.add(0, "dinnye");
        System.out.println(gyumolcsok);
        
        gyumolcsok.set(1, "banán");
        System.out.println(gyumolcsok);
        
//        gyumolcsok.clear();
        
        gyumolcsok.remove(0);
        System.out.println(gyumolcsok);
        System.out.println(gyumolcsok.get(0));
        System.out.println(gyumolcsok.size());
        
        
        
        // LinkedList
        LinkedList<String> lancolt = new LinkedList();
        
        
        
    }
    
}
