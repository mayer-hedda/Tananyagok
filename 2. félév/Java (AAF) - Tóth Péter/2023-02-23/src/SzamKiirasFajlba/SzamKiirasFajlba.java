
package SzamKiirasFajlba;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SzamKiirasFajlba {
    
    public static void main(String[] args) {
        
        try {
            File file = new File("numbers.txt");
            if (file.createNewFile()) {
                System.out.println("Létrehoztam!");
            } else {
                System.out.println("A fájl már létezik!");
            }
            
            FileWriter fw = new FileWriter("numbers.txt");
//            // append-el csak stringet tudunk hozzáadni
//            fw.append(String.valueOf(15));
//            // write-al tudunk int-et is, de karakter kódolás miatt szarul jelenik meg
//            fw.write(20);

            ArrayList<Integer> toFile = new ArrayList();

            int i = 3;
            while (toFile.size() < 100) {
                if (i % 3 == 0 || i % 5 == 0) {
                    toFile.add(i);
                }

                if (i % 15 == 0) {
                    System.out.println(i);
                }

                i++;
            }

            for (int tf : toFile) {
                fw.write(String.valueOf(tf) + "\n");
            }

            fw.close();
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
}
