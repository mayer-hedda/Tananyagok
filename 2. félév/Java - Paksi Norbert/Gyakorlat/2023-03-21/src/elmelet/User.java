package elmelet;

enum szin {
    PIROS,
    ZÖLD, 
    KÉK
}

public class User {
    
    public String name;
    private String szemelyigazolvanyszam;
    private szin szin;
    private static Integer peldany = 0;
    
    
    // KONSTRUKTOROK
    // elhagyható a megírása, ha nincs másmilyen konstruktor függvény, ha van, akkor nem generálódik automatikusan
    public User() {
        // this.name = null;
        // this.szemelyigazolvanyszam = null;
        
        
        // return this, ahol a this egy új user példány
        
        peldany++;
    }

    public User(String name, szin szin) {
        this.name = name;
        this.szin = szin;
        
        peldany++;
    }
    
    public User(String name) {
        this.name = name;
        
        peldany++;
    }
    
    public User(String name, String szemelyigazolvanyszam) {
        this.name = name;
        this.szemelyigazolvanyszam = szemelyigazolvanyszam;
        
        peldany++;
    }
    
    

    // GETTER FÜGGVÉNYEK
    public String getSzemelyigazolvanyszam() {
        return szemelyigazolvanyszam;
    }
    
    public static Integer getPeldany() {
        return User.peldany;
    }

    
    
    // SETTER FÜGVÉNYEK
    public void setSzemelyigazolvanyszam(String szemelyigazolvanyszam) {
        this.szemelyigazolvanyszam = szemelyigazolvanyszam;
    }
    
}
