package football;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class Football {

    public static void main(String[] args) {
        
        /*
            2. Olvassa be a „football.txt” állomány adatait és tárolja el egy olyan adatszerkezetben, 
            ami a következő feladatok megoldására alkalmas. 
            A beolvasás során tárolja el azt az adatot is, hogy melyik mérkőzésnek mi lett a kimenetele. 
            Ha a hazai csapat nyert, akkor egy ‘H’ értéket. 
            Ha a vendég csapat nyert, akkor egy ‘V’ értéket. 
            Amennyiben az állás döntetlen, úgy a ‘D’ értéket tárolja el.
        */
        ArrayList<Meccs> meccsek = new ArrayList();
        
        try {
            File file = new File("football.txt");
            Scanner sc = new Scanner(file);
            sc.nextLine();
            
            while(sc.hasNextLine()) {
                Meccs meccs = new Meccs(sc.nextLine());
                
                meccsek.add(meccs);
            }
        } catch(Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        
        // System.out.println(meccsek);
        
        
        
        /*
            3. Határozza meg és írja ki a képernyőre a forrásállományban szereplő mérkőzések számát.
        */
        System.out.println("3. feladat: " + meccsek.size() + "db meccset tartalmaz a fájl");
        
        
        
        /*
            4. Határozza meg és írja ki a képernyőre hány döntetlen mérkőzés szerepel a forrásállományban.
        */
        int dontetlen = 0;
        for(Meccs m : meccsek) {
            if(m.getEredmeny().equals("D")) {
                dontetlen++;
            }
        }
        
        System.out.println("4. feladat: A fájl " + dontetlen + " db döntetlen meccset tartalmaz");
        
        
        
        /*
            5. Határozza meg és írja ki a képernyőre annak a meccsnek az adatait, amelyiken a legtöbb gól született. 
            Amennyiben több ilyen van, úgy bármelyiket kiírathatja (de nincs).
        */
        Meccs legtobbGol = meccsek.get(0);
        for(Meccs m : meccsek) {
            int golok = m.getKapott() + m.getLott();
            int eddigiLegtobbGol = legtobbGol.getKapott() + legtobbGol.getLott();
            
            if(golok > eddigiLegtobbGol) {
                legtobbGol = m;
            }
        }
        
        System.out.println("5. feladat: A legtöbb gól az elábbi meccsen született:\n" + legtobbGol);
        
        
        
        /*
            6. Írja ki a képernyőre minden csapat nevét, akik részt vettek a mérkőzésen. 
            Minden név csak egyszer szerepeljen a kiírásban.
        */
        HashSet<String> csapatnevek = new HashSet();
        for(Meccs m : meccsek) {
            csapatnevek.add(m.getHazai());
            csapatnevek.add(m.getVendeg());
        }
        
        System.out.println("6. feladat: A bajnokságon résztvevő csapatok listája:\n" + csapatnevek);
        
        
        
        /*
            7. Írja ki a konzolra annak a mérkőzésnek az adatait, amelyik a legkorábban zajlott (dátum és idő szerint)
        */
        Meccs legkorabbi = meccsek.get(0);
        for(Meccs m : meccsek) {
            if(m.getIdopont().isBefore(legkorabbi.getIdopont())) {
                legkorabbi = m;
            }
        }
        
        System.out.println("7. feladat: A bajnokság legelső meccse az alábbi volt:\n" + legkorabbi);
        
        
        
        /*
            8. Készítsen egy tabellát, amelyben a csapatok pontszámai találhatóak. 
            A csapat 0 pontot kap, ha vesztes mérkőzést játszik. 
            A csapat 1 pontot kap, ha döntetlent játszik. 
            A csapat 3 pontot kap, amennyiben megnyeri a mérkőzést. 
            A megoldás során használjon HashMap adattípust. 
            Minden mérkőzés esetén módosuljon mindkét csapat pontszáma. 
            Például, ha 2 csapat döntetlent játszik, akkor mindkét csapat pontszáma növekedjen meg 1-el.
        */
        HashMap<String, Integer> tabella = new HashMap();
        for(String csapatnev : csapatnevek) {
            tabella.put(csapatnev, 0);
        }
        for(Meccs m : meccsek) {
            if(m.getEredmeny().equals("H")) {
                int eddigiPontokHazai = tabella.get(m.getHazai());
                int eddigiPontokVendeg = tabella.get(m.getVendeg());
                
                tabella.put(m.getHazai(), eddigiPontokHazai+3);
                tabella.put(m.getVendeg(), eddigiPontokVendeg+0);
            } else if(m.getEredmeny().equals("V")) {
                int eddigiPontokHazai = tabella.get(m.getHazai());
                int eddigiPontokVendeg = tabella.get(m.getVendeg());
                
                tabella.put(m.getHazai(), eddigiPontokHazai+0);
                tabella.put(m.getVendeg(), eddigiPontokVendeg+3);
            } else {
                int eddigiPontokHazai = tabella.get(m.getHazai());
                int eddigiPontokVendeg = tabella.get(m.getVendeg());
                
                tabella.put(m.getHazai(), eddigiPontokHazai+1);
                tabella.put(m.getVendeg(), eddigiPontokVendeg+1);
            }
        }
        
        //System.out.println("8. feladat:");
        tabella.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });
        
    }
    
}
