package FilmSorsolasListaval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FilmSorsolasListaval {
    
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
        
        String kategoria = FilmSorsolasListaval.kategoriaBekeres();
        ArrayList<String> filmesLista = FilmSorsolasListaval.listaSorsolas(kategoria);
        Integer filmekSzama = FilmSorsolasListaval.filmekSzamaBekeres(filmesLista);
        
        FilmSorsolasListaval.filmKiiras(filmesLista, filmekSzama);
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
            
            if (FilmSorsolasListaval.ellenorzes(valasz)) {
                return valasz;
            } else {
                System.out.println("Nincs ilyen kategória!\n");
            }
        }
    }
    
    
    public static Integer filmekSzamaBekeres(ArrayList<String> lista) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Adja meg, hogy mennyi filmet szeretne lekérni: ");
            Integer valasz = sc.nextInt();
            if (valasz <= lista.size()) {
                return valasz;
            } else {
                System.out.println("Nincs ennyi film a listában!\n");
            }
        }
    }
    
    
    public static ArrayList<String> listaSorsolas(String kategoria) {
        ArrayList<ArrayList<String>> kategoriak = new ArrayList();
        
        ArrayList<String> akcio = new ArrayList(Arrays.asList("A beavatott", "Lucy", "Csillagok között", "Halálos iramban", "A nevem bosszú", "Az űrsepregetők", "Emola Holmes", "A halhatatlan gárda", "A lázadó", "John Wick"));
        kategoriak.add(akcio);
        
        ArrayList<String> drama = new ArrayList(Arrays.asList("Truman show", "XX. századi lány", "Káprázat", "Ügyféllista", "Kedves David", "Lady Chatterley szeretője", "Az elveszett kutya", "Egy kutya négy élete", "Életünk szerelme", "A szerelem színei"));
        kategoriak.add(drama);
        
        ArrayList<String> thriller = new ArrayList(Arrays.asList("Hívás a múltból", "Kóborlók", "A potyautas", "Ébrenlét", "Néma csend", "Kiszolgáltatva", "Én vagyok anya", "Hipnózisban", "A platform", "A szobatárs"));
        kategoriak.add(thriller);
        
        
        if (FilmSorsolasListaval.ellenorzes(kategoria)) {
            return switch (kategoria) {
                case "akcio" -> kategoriak.get(0);
                case "drama" -> kategoriak.get(1);
                default -> kategoriak.get(2);
            };
        } else {
            return new ArrayList<>();
        }
        
    }
    
    
    public static void filmKiiras(ArrayList<String> lista, Integer szamlalo) {
//        ArrayList<Integer> indexek = new ArrayList();
        
        System.out.println("\nA számodra választott filmek: ");
        
        if (!lista.isEmpty()) {
            // másik megoldás, ahogy először csináltam, de a mostani ideálisabb!
            
//            for (int i = 0; i < szamlalo; i++) {
//                Random rand = new Random();
//                Integer index = rand.nextInt(lista.size());
//                
//                if (!indexek.contains(index)) {
//                    System.out.println("\t" + lista.get(index));
//                    indexek.add(index);
//                } else {
//                    i--;
//                }
//            }
            for (int i = 0; i < szamlalo; i++) {
                Random rand = new Random();
                Integer index = rand.nextInt(lista.size());
                System.out.println("\t" + lista.get(index));
                lista.remove(index);
            }
        } else {
            System.out.println("Ha idáig eljutott a program, akkor baj van!");
        }
    }
    
}
