package oraiOsosztaly;

public class Mouse extends Periferia {
    
    // TULAJDONSÁGOK
    private String name;
    private Integer sensitivity;
    
    
    // KONSTRUKTOR
    public Mouse(Boolean vezetekes, Boolean vezetekesMost, Integer vezetekHossza, Boolean isRgb, String color) {
        super(vezetekes, vezetekesMost, vezetekHossza, isRgb, color);
    }

    public Mouse(Boolean vezetekes, Integer vezetekHossza, Boolean isRgb) {
        super(vezetekes, vezetekHossza, isRgb);
    }

    public Mouse(Boolean vezetekes, Boolean isRgb) {
        super(vezetekes, isRgb);
    }

    public Mouse(String name, Integer sensitivity, Boolean vezetekes, Boolean vezetekesMost, Integer vezetekHossza, Boolean isRgb, String color) {
        super(vezetekes, vezetekesMost, vezetekHossza, isRgb, color);
        this.name = name;
        this.sensitivity = sensitivity;
    }
    
    
    // GETTEREK
    public String getName() {
        return name;
    }
    
    public Integer getSensitivity() {
        return sensitivity;
    }

    
    // SETTEREK
    public void setName(String name) {
        this.name = name;
    }

    public void setSensitivity(Integer sensitivity) throws Exception {
        if(sensitivity >= 400 && sensitivity <= 4000) {
            this.sensitivity = sensitivity;        
        }else if(sensitivity < 400) {
            throw new SensitivityException("Nem tudod az egér érzékenységét 400-nál kisebbre állítani.");
        }else {
            throw new SensitivityException("Nem tudod az egér érzékenységét 4000-nél nagyobbra állítani.");
        }
    }
    
}
