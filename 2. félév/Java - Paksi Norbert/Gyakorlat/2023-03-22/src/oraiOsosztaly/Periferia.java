package oraiOsosztaly;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Periferia {
    
    // TULAJDONSÁGOK
    protected Boolean vezetekes;
    protected Boolean vezetekesMost;
    protected Integer vezetekHossza;
    protected Boolean isRgb;
    protected String color;
    
    
    // KONSTRUKTOR
    public Periferia(Boolean vezetekes, Boolean vezetekesMost, Integer vezetekHossza, Boolean isRgb, String color) {
        this.vezetekes = vezetekes;
        this.vezetekesMost = vezetekesMost;
        this.vezetekHossza = vezetekHossza;
        this.isRgb = isRgb;
        this.color = color;
    }

    public Periferia(Boolean vezetekes, Integer vezetekHossza, Boolean isRgb) {
        this.vezetekes = vezetekes;
        this.vezetekHossza = vezetekHossza;
        this.isRgb = isRgb;
    }

    public Periferia(Boolean vezetekes, Boolean isRgb) {
        this.vezetekes = vezetekes;
        this.isRgb = isRgb;
    }
    
    
    // GETTEREK
    public Boolean getVezetekes() {
        return vezetekes;
    }

    public Boolean getVezetekesMost() {
        return vezetekesMost;
    }

    public Integer getVezetekHossza() {
        return vezetekHossza;
    }

    public Boolean getIsRgb() {
        return isRgb;
    }

    public String getColor() {
        return color;
    }
    
    
    // SETTEREK
    public void setVezetekesMost(Boolean vezetekesMost) {
        if(this.vezetekes == false) {
            this.vezetekesMost = vezetekesMost;
        }
    }

    public void setVezetekHossza(Integer vezetekHossza) throws Exception {
        if(new ArrayList(Arrays.asList(1, 2, 3, 5)).contains(vezetekHossza)) {
            this.vezetekHossza = vezetekHossza;
        }else {
            throw new VezetekException("Nincs ilyen méretű vezeték!");
        }
    }

    public void setColor(String color) throws Exception {
        Boolean megteheto = false;
        if(this.isRgb == true) {
            if(color.contains(",")) {
                String[] rgb = color.split(",");
                if(rgb.length == 3) {
                    for(String r : rgb) {
                        try {
                            Integer szam = Integer.parseInt(r);
                            if(szam >= 0 && szam <= 255) {
                                megteheto = true;
                            } else {
                                megteheto = false;
                                break;
                            }
                        } catch (NumberFormatException ex) {
                            megteheto = false;
                        }
                    }
                }
            }
        }else {
            throw new NemRgbsException("Ez az egér nem tudja változtatni a színét, mert nem ledes.");
        }
        
        if(megteheto) {
            this.color = color;            
        }
    }
   
}
