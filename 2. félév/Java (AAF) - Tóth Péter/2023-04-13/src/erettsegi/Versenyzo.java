package erettsegi;

public class Versenyzo {
    
    // TULAJDONSÁGOK
    private String rajtszam;
    private String kategoria;
    private String nev;
    private String egyesulet;
    private String ido;
    
    
    // KONSTRUKTOR
    public Versenyzo(String sor) {
        // M15;fn;Adámi Krisztina;ÁkosBike Team Aszód;1:14:46
        
        String[] splitted = sor.split(";");
        
        this.rajtszam = splitted[0];
        this.kategoria = splitted[1];
        this.nev = splitted[2];
        this.egyesulet = splitted[3];
        this.ido = splitted[4];
    }
    
    
    // GETTEREK
    public String getRajtszam() {
        return rajtszam;
    }

    public String getKategoria() {
        return kategoria;
    }

    public String getIdo() {
        return ido;
    }

    public String getNev() {
        return nev;
    }

    public String getEgyesulet() {
        return egyesulet;
    }
    
    
    // METÓDUS
    @Override
    public String toString() {
        return "Versenyzo{" + "rajtszam=" + rajtszam + ", kategoria=" + kategoria + ", nev=" + nev + ", egyesulet=" + egyesulet + ", ido=" + ido + "}\n";
    }
    
    public int getTimeSec() {
        // 10:10:05 -- 5 + 10*60 + 10*3600
        String[] splittedTime = this.ido.split(":");
        int h  = Integer.parseInt(splittedTime[0]);
        int m  = Integer.parseInt(splittedTime[1]);
        int s  = Integer.parseInt(splittedTime[2]);
        
        return s + m*60 + h*3600;
    }
    
}
