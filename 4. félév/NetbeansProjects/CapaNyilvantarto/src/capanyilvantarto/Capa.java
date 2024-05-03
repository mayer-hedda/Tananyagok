/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capanyilvantarto;

/**
 *
 * @author zsenakistvan
 */
public class Capa {
    private String nev;
    private Integer kor;
    private CapaFaj faj;
    private Double hossz;
    private String lakhely;
    private Integer energia;

    public Capa(String nev, Integer kor, CapaFaj faj, Double hossz, String lakhely) {
        this.nev = nev;
        this.kor = kor;
        this.faj = faj;
        this.hossz = hossz;
        this.lakhely = lakhely;
        this.energia = 50;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Integer getKor() {
        return kor;
    }

    public void setKorPlus() {
        this.kor++;
    }

    public CapaFaj getFaj() {
        return faj;
    }

    public Double getHossz() {
        return hossz;
    }

    public void setHosszPlus(Double plusSize) {
        this.hossz += plusSize;
    }

    public String getLakhely() {
        return lakhely;
    }

    public void setLakhely(String lakhely) {
        this.lakhely = lakhely;
    }
    
    public Integer getEnergia(){
        return this.energia;
    }
    
    public void eszik(Integer kcal){
        this.energia += kcal;
    }
    
    public void energiafogyas(){
        this.energia--;
    }
    
}
