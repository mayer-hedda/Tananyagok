package main;

public class Repulo {
    
    public String tipus;
    public Integer ev;
    public String utas;
    public String szemelyzet;
    public Integer utazosebesseg;
    public Integer felszallotomeg;
    public Double fesztav;

    public Repulo(String row) {
        String[] splitted = row.split(";");
        
        this.tipus = splitted[0];
        this.ev = Integer.parseInt(splitted[1]);
        this.utas = splitted[2];
        this.szemelyzet = splitted[3];
        this.utazosebesseg = Integer.parseInt(splitted[4]);
        this.felszallotomeg = Integer.parseInt(splitted[5]);
        this.fesztav = Double.parseDouble(splitted[6].replaceAll(",", "."));
    }
    
    public int convertUtas() {
        int utasszam = 0;
        if(this.utas.contains("-")) {
            utasszam = Integer.parseInt(this.utas.split("-")[1]);
        } else {
            utasszam = Integer.parseInt(this.utas);
        }
        
        return utasszam;
    }

    @Override
    public String toString() {
        return "\tTipus: " + this.tipus + "\n\tElső felszállás: " + this.ev + "\n\tUtasok száma: " + this.utas + "\n\tSzemélyzet: " + this.szemelyzet + "\n\tUtazósebesség: " + this.utazosebesseg;
    }
    
}
