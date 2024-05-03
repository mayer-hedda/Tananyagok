package orai;

import java.util.ArrayList;
import java.util.Arrays;

public class Mouse {
    
    /*
    6 tulajdonság
        1 csak látható
        1 bármire változtatható
        4 korlátozottan változtatható
    
    3 konstruktor
    getter, setter függvények
    */
    
    public String name;
//    private Integer size;
    private Integer sensitivity;
    private Boolean vezetekes;
    private Boolean vezetekesMost;
    private Integer vezetekHossza;
    private Boolean isRgb;
    private String color;
//    private String cursorColor;

    
    
    // MINDEN BEÁLLÍTÁSA
    public Mouse(String name, Integer sensitivity, Boolean vezetekes, Boolean vezetekesMost, Integer vezetekHossza, Boolean isRgb, String color) {
        this.name = name;
        this.sensitivity = sensitivity;
        this.vezetekes = vezetekes;
        this.vezetekesMost = vezetekesMost;
        this.vezetekHossza = vezetekHossza;
        this.isRgb = isRgb;
        this.color = color;
    }

    
    // ELENGEDHETETLEN TULAJDONSÁGOK BEÁLLÍTÁSA
    public Mouse(Boolean vezetekes, Integer vezetekHossza, Boolean isRgb) {
        this.vezetekes = vezetekes;
        this.vezetekHossza = vezetekHossza;
        this.isRgb = isRgb;
    }
    
    
    // HA AZ ISRGB FALSE
    public Mouse(String name, Integer sensitivity, Boolean vezetekes, Boolean vezetekesMost, Integer vezetekHossza, Boolean isRgb) {
        this.name = name;
        this.sensitivity = sensitivity;
        this.vezetekes = vezetekes;
        this.vezetekesMost = vezetekesMost;
        this.vezetekHossza = vezetekHossza;
        this.isRgb = isRgb;
    }
    
    
    
//    // SIZE
//    public Integer getSize() {
//        return size;
//    }

    
    // SENSITIVITY
    public Integer getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(Integer sensitivity) {
        if(sensitivity >= 400 && sensitivity <= 4000) {
            this.sensitivity = sensitivity;        
        }
    }
    
    
    // VEZETÉKES-E A PÉLDÁNY LÉTREHOZÁSAKOR
    public Boolean getVezetekes() {
        return vezetekes;
    }
    
    
    // VEZETÉKES-E A JELENLEGI PILLANATBAN
    public Boolean getVezetekesMost() {
        return vezetekesMost;
    }

    public void setVezetekesMost(Boolean vezetekesMost) {
        if(this.vezetekes == false) {
            this.vezetekesMost = vezetekesMost;
        }
    }
    
    
    // VEZETÉK HOSSZA
    public Integer getVezetekHossza() {
        return vezetekHossza;
    }

    public void setVezetekHossza(Integer vezetekHossza) {
        if(new ArrayList(Arrays.asList(1, 2, 3, 5)).contains(vezetekHossza)) {
            this.vezetekHossza = vezetekHossza;
        }
    }
    
    
    // AZ EGÉR RGB MEGVILÁGÍTÁSÚ-E
    public Boolean getIsRgb() {
        return isRgb;
    }
    
    
    // COLOR
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
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
        }
        
        if(megteheto) {
            this.color = color;            
        }
    }
    
    
//    // CURSOR COLOR
//    public String getCursorColor() {
//        return cursorColor;
//    }
//
//    public void setCursorColor(String cursorColor) {
//        Boolean megteheto = false;
//        if(color.contains(",")) {
//            String[] rgb = color.split(",");
//            if(rgb.length == 3) {
//                for(String r : rgb) {
//                    try {
//                        Integer szam = Integer.parseInt(r);
//                        if(szam >= 0 && szam <= 255) {
//                            megteheto = true;
//                        }
//                    } catch (NumberFormatException ex) {
//                        megteheto = false;
//                    }
//                }
//            }
//        }
//        
//        
//        if(megteheto) {
//            this.cursorColor = cursorColor;            
//        }
//    }
    
    
}
