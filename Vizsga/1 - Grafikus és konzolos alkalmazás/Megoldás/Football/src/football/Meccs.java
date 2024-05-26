package football;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Meccs {

    private String hazai;
    private String vendeg;
    private Integer lott;
    private Integer kapott;
    private LocalDateTime idopont;
    private String eredmeny;    // H, V, D

    public Meccs(String sor) {
        String[] splitted = sor.split(";");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
        
        Integer lott = Integer.valueOf(splitted[2]);
        Integer kapott = Integer.valueOf(splitted[3]);

        this.hazai = splitted[0];
        this.vendeg = splitted[1];
        this.lott = lott;
        this.kapott = kapott;
        this.idopont = LocalDateTime.parse(splitted[4], formatter);
        
        if(lott > kapott) {
            this.eredmeny = "H";
        } else if(kapott > lott) {
            this.eredmeny = "V";
        } else {
            this.eredmeny = "D";
        }
    }

    public String getHazai() {
        return hazai;
    }

    public String getVendeg() {
        return vendeg;
    }

    public Integer getLott() {
        return lott;
    }

    public Integer getKapott() {
        return kapott;
    }

    public LocalDateTime getIdopont() {
        return idopont;
    }

    public String getEredmeny() {
        return eredmeny;
    }

    @Override
    public String toString() {
        return "Meccs{" + "hazai=" + hazai + ", vendeg=" + vendeg + ", lott=" + lott + ", kapott=" + kapott + ", idopont=" + idopont + '}';
    }

}
