package dolgozat;

public class Main {

    public static void main(String[] args) {
        
        // FESTMÉNY
        Festmeny festmeny = new Festmeny("Új festmény", "Nagy Alexandra", 12345, true);
        
        System.out.println(festmeny.alkoto);
        System.out.println(festmeny.ar);
        System.out.println(festmeny.nev);
        System.out.println(festmeny.raktaron);
        
        try {
            festmeny.setNev("aasdfghjkléasdfghjkléasdfghjklésdfghjkléasdfghjklsdfghjklésdfghjklésdfghjkléyxcvbnm,.xcvbnm,");
            System.out.println(festmeny.getNev());
        } catch (TulHosszuNevException ex) {
            System.out.println(festmeny.getNev());
        }
        
        festmeny.setFestek(festek.OLAJFESTÉK);
        System.out.println(festmeny.getFestek());
        
        festmeny.setKeretAnyaga("kő");
        System.out.println(festmeny.getKeretAnyaga());
        
        festmeny.setVanKerete();
        System.out.println(festmeny.getVanKerete());
        
        
        
        // SZOBOR
        Szobor szobor = new Szobor("Új név", "Szirényi Vivien", 12345, false);
        
        System.out.println(szobor.alkoto);
        System.out.println(szobor.ar);
        System.out.println(szobor.nev);
        System.out.println(szobor.raktaron);
        
        szobor.setAnyag(anyag.GIPSZ);
        System.out.println(szobor.getAnyag());
        
        try {
            szobor.setMagassag(3); 
            System.out.println(szobor.getMagassag());
        } catch (TulAlacsonyException ex) {
            System.out.println(szobor.getMagassag());
        }
        
        try {
            szobor.setMagassag(-4);
            System.out.println(szobor.getMagassag());
        } catch (TulAlacsonyException ex) {
            System.out.println(szobor.getMagassag());
        }
        
        szobor.setSzin(szin.PIROS);
        System.out.println(szobor.getSzin());
        
    }
    
}
