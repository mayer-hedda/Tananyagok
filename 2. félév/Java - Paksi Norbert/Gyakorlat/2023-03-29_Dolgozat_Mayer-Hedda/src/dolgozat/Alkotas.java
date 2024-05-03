package dolgozat;

public abstract class Alkotas {
    
    // TULAJDONSÁGOK
    protected String nev;           // korlátozottan változtatható és látható
    protected String alkoto;        // nem változtatható de látható
    protected Integer ar;           // korlátozottan változtatható és látható
    protected Boolean raktaron;     // korlátozottan változtatható és látható
    
    
    // KONSTRUKTOR
    public Alkotas() {
        
    }

    public Alkotas(String nev, String alkoto, Integer ar, Boolean raktaron) {
        this.nev = nev;
        this.alkoto = alkoto;
        this.ar = ar;
        this.raktaron = raktaron;
    }

    public Alkotas(String alkoto) {
        this.alkoto = alkoto;
    }
    
    
    // GETTEREK
    public String getNev() {
        return nev;
    }

    public String getAlkoto() {
        return alkoto;
    }

    public Integer getAr() {
        return ar;
    }

    public Boolean getRaktaron() {
        return raktaron;
    }
    
    
    // SETTEREK
    public void setNev(String nev) throws TulHosszuNevException {
        if(nev.length() < 30) {
            this.nev = nev;
        } else {
            throw new TulHosszuNevException("Nem lehet 30-nál több karakterből álló nevet megadni!");
        }
    }

    public void setAr(Integer ar) {
        if(ar > 0) {
            this.ar = ar;
        }
    }

    public void setRaktaron() {
        if(this.raktaron = false) {
            this.raktaron = true;
        } else {
            this.raktaron = false;
        }
    }
    
}
