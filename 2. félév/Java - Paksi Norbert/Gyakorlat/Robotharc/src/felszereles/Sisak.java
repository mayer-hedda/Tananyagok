package felszereles;

public class Sisak {
    
    // Tulajdonságok
    private String nev;
    private Integer ero;
    private Integer vedelem;
    
    
    // Konstruktor
    public Sisak(String nev, Integer ero, Integer vedelem) {
        this.nev = nev;
        this.ero = ero;
        this.vedelem = vedelem;
    }
    
    
    // Getterek
    public String getNev() {
        return nev;
    }
    
    public Integer getEro() {
        return ero;
    }
    
    public Integer getVedelem() {
        return vedelem;
    }
    
}
