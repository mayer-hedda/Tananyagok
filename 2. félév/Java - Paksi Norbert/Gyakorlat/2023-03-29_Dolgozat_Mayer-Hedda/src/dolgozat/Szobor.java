package dolgozat;

enum szin {
    PIROS,
    KÉK,
    ZÖLD
}

enum anyag {
    KŐ,
    AGYAG,
    GIPSZ,
    JÉG,
    PORCELÁN
}

public class Szobor extends Alkotas {
    
    // TULAJDONSÁGOK
    private Integer magassag;     // korlátozottan változtatható és látható
    private anyag anyag;         // nem változtatható de látható
    private szin szin;            // korlátozottan változtatható és látható
    
    
    // KONSTRUKTOROK
    public Szobor(String nev, String alkoto, Integer ar, Boolean raktaron) {
        super(nev, alkoto, ar, raktaron);
    }

    public Szobor(Integer magassag, anyag anyag, szin szin, String nev, String alkoto, Integer ar, Boolean raktaron) {
        super(nev, alkoto, ar, raktaron);
        this.magassag = magassag;
        this.anyag = anyag;
        this.szin = szin;
    }
    

    // GETTEREK
    public Integer getMagassag() {
        return magassag;
    }

    public anyag getAnyag() {
        return anyag;
    }

    public szin getSzin() {
        return szin;
    }
    
    
    // SETTEREK
    public void setMagassag(Integer magassag) throws TulAlacsonyException {
        if(magassag > 0) {
            this.magassag = magassag;
        }else {
            throw new TulAlacsonyException("Nem lehet 0-nál kisebb a szobor magassága!");
        }
    }

    public void setSzin(szin szin) {
        this.szin = szin;
    }
    
    public void setAnyag(anyag anyag) {
        this.anyag = anyag;
    }
    
}