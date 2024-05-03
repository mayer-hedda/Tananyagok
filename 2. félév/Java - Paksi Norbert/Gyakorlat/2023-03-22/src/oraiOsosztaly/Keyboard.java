package oraiOsosztaly;

public class Keyboard extends Periferia {
    
    // TULAJDONSÁGOK
    private String layout;
    private String keycap;
    
    
    // KONSTRUKTOR
    public Keyboard(Boolean vezetekes, Boolean vezetekesMost, Integer vezetekHossza, Boolean isRgb, String color) {
        super(vezetekes, vezetekesMost, vezetekHossza, isRgb, color);
    }

    public Keyboard(Boolean vezetekes, Integer vezetekHossza, Boolean isRgb) {
        super(vezetekes, vezetekHossza, isRgb);
    }

    public Keyboard(Boolean vezetekes, Boolean isRgb) {
        super(vezetekes, isRgb);
    }

    public Keyboard(String layout, String keycap, Boolean vezetekes, Boolean vezetekesMost, Integer vezetekHossza, Boolean isRgb, String color) {
        super(vezetekes, vezetekesMost, vezetekHossza, isRgb, color);
        this.layout = layout;
        this.keycap = keycap;
    }
    
    
    // GETTEREK
    public String getLayout() {
        return layout;
    }

    public String getKeycap() {
        return keycap;
    }
    
    
    // SETTEREK
    public void setKeycap(String keycap) {
        String[] x = keycap.split(" ");
        if(x[0].equals(this.layout)) {
            this.keycap = keycap;
        }
    }
    
}
