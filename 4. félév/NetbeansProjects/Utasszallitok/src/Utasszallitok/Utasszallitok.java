package Utasszallitok;


public class Utasszallitok {
    
    private String tipus;
    private Integer ev;
    private String utas;
    private String szemelyzet;
    private Integer utazosebesseg;
    private String utazosebessegString;
    private Integer felszallotomeg;
    private Double fesztav;

    
    public Utasszallitok(String tipus, Integer ev, String utas, String szemelyzet, Integer utazosebesseg, String utazosebessegString, Integer felszallotomeg, String fesztav) {
        this.tipus = tipus;
        this.ev = ev;
        this.utas = utas;
        this.szemelyzet = szemelyzet;
        this.utazosebesseg = utazosebesseg;
        this.utazosebessegString = utazosebessegString;
        this.felszallotomeg = felszallotomeg;
        this.fesztav = Double.parseDouble(fesztav.replace(",", "."));
    }
    
    public String getTipus() {
        return tipus;
    }

    public Integer getEv() {
        return ev;
    }

    public String getUtas() {
        return utas;
    }

    public String getSzemelyzet() {
        return szemelyzet;
    }

    public Integer getUtazosebesseg() {
        return utazosebesseg;
    }
    
    public String getUtazosebessegString() {
        return utazosebessegString;
    }

    public Integer getFelszallotomeg() {
        return felszallotomeg;
    }

    public Double getFesztav() {
        return fesztav;
    }
    
}
