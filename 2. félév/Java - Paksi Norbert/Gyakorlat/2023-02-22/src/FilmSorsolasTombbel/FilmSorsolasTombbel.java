 package FilmSorsolasTombbel;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FilmSorsolasTombbel {
    
    public static void main(String[] args) {
        /*
        Írj egy programot amelyben filmeket lehet sorsolni legalább 3 kategóriából.
        A ketegóra nevét és a filmek számát is a konzolról kérjük be a felhasználótól
        Egyszerre csak egy kategóriából lehessen sorsolni abból viszont tetszőleges mennyiségűt.
        Oldd meg hogy a program ne sorsolhassa ki kétszer ugyan azt a filmet.
        Oldd meg hogy ne számítason hogy a kategóra beírásánál milyen arányban szerepelnek kis- és nagybetűk
        A program tájékoztassa a felhasználót arról ha rossz kategóriát választ vagy ha több filmet akar sorsolni mint lehet.
        Addig kérje be a filmek mennyiségét amég megfelelő számot nem írunk be.
        A program a futás végén írja ki a kisorsolt filmeket.
        */
        
        String kategoria = FilmSorsolasTombbel.kategoriaBekeres();
        String[] filmesLista = FilmSorsolasTombbel.listaSorsolas(kategoria);
        Integer filmekSzama = FilmSorsolasTombbel.filmekSzamaBekeres(filmesLista);
        
        FilmSorsolasTombbel.filmKiiras(filmesLista, filmekSzama);
    }
    
    
    public static Boolean ellenorzes(String valasz) {
        if (valasz.equals("akcio") || valasz.equals("drama") || valasz.equals("thriller")) {
            // jó
            return true;
        } else {
            // rossz
            return false;
        }
    }
    
    
    public static String kategoriaBekeres() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Adja meg, hogy milyen kategóriában szeretne filmet nézni (\"akcio\", \"drama\", \"thriller\"): ");
            String valasz = sc.nextLine().toLowerCase();
            
            if (FilmSorsolasTombbel.ellenorzes(valasz)) {
                return valasz;
            } else {
                System.out.println("Nincs ilyen kategória!\n");
            }
        }
    }
    
    
    public static Integer filmekSzamaBekeres(String[] lista) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Adja meg, hogy mennyi filmet szeretne lekérni: ");
            Integer valasz = sc.nextInt();
            if (valasz <= lista.length) {
                return valasz;
            } else {
                System.out.println("Nincs ennyi film a listában!\n");
            }
        }
    }
    
    
    public static String[] listaSorsolas(String kategoria) {
        String[][] kategoriak = new String[3][];
        
        String[] akcio = {"A beavatott", "Lucy", "Csillagok között", "Halálos iramban", "A nevem bosszú", "Az űrsepregetők", "Emola Holmes", "A halhatatlan gárda", "A lázadó", "John Wick"};
        kategoriak[0] = akcio;
        
        String[] drama = {"Truman show", "XX. századi lány", "Káprázat", "Ügyféllista", "Kedves David", "Lady Chatterley szeretője", "Az elveszett kutya", "Egy kutya négy élete", "Életünk szerelme", "A szerelem színei"};
        kategoriak[1] = drama;
        
        String[] thriller = {"Hívás a múltból", "Kóborlók", "A potyautas", "Ébrenlét", "Néma csend", "Kiszolgáltatva", "Én vagyok anya", "Hipnózisban", "A platform", "A szobatárs"};
        kategoriak[2] = thriller;
        
        
        if (FilmSorsolasTombbel.ellenorzes(kategoria)) {
            return switch (kategoria) {
                case "akcio" -> kategoriak[0];
                case "drama" -> kategoriak[1];
                default -> kategoriak[2];
            };
        } else {
            return new String[0];
        }
        
    }
    
    
    public static void filmKiiras(String[] lista, Integer szamlalo) {
        Integer[] indexek = new Integer[10];
        
        System.out.println("\nA számodra választott filmek: ");
        
        if (lista.length != 0) {
            for (int i = 0; i < szamlalo; i++) {
                Random rand = new Random();
                Integer index = rand.nextInt(lista.length);
                
                // másik megoldásom ez lett volna: "!Arrays.asList(indexek).contains(index)" , de végig tömbökkel akartam dolgozni.
                if (!Arrays.stream(indexek).anyMatch(index::equals)) {
                    System.out.println("\t" + lista[index]);
                    indexek[i] = index;
                } else {
                    i--;
                }
            }
        } else {
            System.out.println("Ha idáig eljutott a program, akkor baj van!");
        }
    }
    
}
