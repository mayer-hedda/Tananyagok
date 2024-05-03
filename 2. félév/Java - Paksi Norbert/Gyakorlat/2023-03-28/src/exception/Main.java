package exception;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        
        // helyben keletkező exception azonnali kezelése
        int[] szamok = {1, 2, 3};
        Integer a = null;
        
        try {
            System.out.println(szamok[0]);
            a++;
        } catch(ArrayIndexOutOfBoundsException ex) {
            System.out.println("Túl indexeltem valamit.");
        } catch(NullPointerException ex) {
            System.out.println("Null értékre hivatkoztam.");
        } catch (Exception ex) {
            System.out.println("Valami egyéb hiba volt.");
        } finally {
            System.out.println("Ez akkor is lefut.");
        }
        
        
        // olyan fgv. meghívása, ami exceptiont dobhat
        try {
            Main.fuggveny(a);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public static Integer fuggveny(Integer szam) throws Exception {
        if(szam > 0) {
            return szam++;
        }else {
            throw new Exception();
        }
    }
    
}
