package dolgozat;

import java.util.ArrayList;
import java.util.Arrays;

enum festek {
    TEMPERA,
    VÍZFESTÉK,
    OLAJFESTÉK,
    AKRILFESTÉK,
    PASTELLFESTÉK
}

public class Festmeny extends Alkotas {
    
    // TULAJDONSÁGOK
    private String keretAnyaga;
    private festek festek;
    private Boolean vanKerete;
    
    
    // KONSTRUKTOR
    public Festmeny(String nev, String alkoto, Integer ar, Boolean raktaron) {
        super(nev, alkoto, ar, raktaron);
    }

    public Festmeny(String keretAnyaga, festek festek, Boolean vanKerete, String nev, String alkoto, Integer ar, Boolean raktaron) {
        super(nev, alkoto, ar, raktaron);
        this.keretAnyaga = keretAnyaga;
        this.festek = festek;
        this.vanKerete = vanKerete;
    }
    
    
    // GETTEREK
    public String getKeretAnyaga() {
        return keretAnyaga;
    }

    public festek getFestek() {
        return festek;
    }

    public Boolean getVanKerete() {
        return vanKerete;
    }
    
    
    // SETTEREK
    public void setKeretAnyaga(String keretAnyaga) {
        ArrayList<String> anyagok = new ArrayList(Arrays.asList("fa", "kő", "kerámai", "fém"));
        if(anyagok.contains(keretAnyaga)) {
            this.keretAnyaga = keretAnyaga;
        }
    }

    public void setVanKerete() {
        if(this.vanKerete = false) {
            this.vanKerete = true;
        } else {
            this.vanKerete = false;
        }
    }
    
    public void setFestek(festek festek) {
        this.festek = festek;
    }
    
}
