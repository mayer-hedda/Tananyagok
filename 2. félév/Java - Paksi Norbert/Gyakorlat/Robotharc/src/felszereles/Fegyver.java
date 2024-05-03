package felszereles;

public class Fegyver {
    
    // Tulajdonságok
    private String nev;
    private Integer minSebzes;
    private Integer maxSebzes;
    private Integer ero;
    
    
    // Konstruktor
    public Fegyver(String nev, Integer minSebzes, Integer maxSebzes, Integer ero) {
        this.nev = nev;
        this.minSebzes = minSebzes;
        this.maxSebzes = maxSebzes;
        this.ero = ero;
    }
    
    
    // Getterek
    public String getNev() {
        return nev;
    }
    
    public Integer getMinSebzes() {
        return minSebzes;
    }
    
    public Integer getMaxSebzes() {
        return maxSebzes;
    }
    
    public Integer getEro() {
        return ero;
    }
    
}
