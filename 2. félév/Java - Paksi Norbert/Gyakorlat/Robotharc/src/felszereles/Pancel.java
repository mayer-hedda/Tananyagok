package felszereles;

public class Pancel {
    
    // Tulajdonságok
    private String nev;
    private Integer eletero;
    private Integer vedelem;
    
    
    // Konstruktor
    public Pancel(String nev, Integer eletero, Integer vedelem) {
        this.nev = nev;
        this.eletero = eletero;
        this.vedelem = vedelem;
    }
    
    
    // Getterek
    public String getNev() {
        return nev;
    }
    
    public Integer getEletero() {
        return eletero;
    }
    
    public Integer getVedelem() {
        return vedelem;
    }
    
    
    // Setterek
    public void setNev(String nev) {
        this.nev = nev;
    }
    
    public void setEletero(Integer eletero) {
        this.eletero = eletero;
    }
    
    public void setVedelem(Integer vedelem) {
        this.vedelem = vedelem;
    }
    
}
