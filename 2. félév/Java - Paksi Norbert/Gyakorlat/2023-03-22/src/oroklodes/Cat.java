package oroklodes;

public class Cat extends Animal {

    // TULAJDONSÁGOK
    private Integer life = 9;
    private Boolean alombaKakil;
    
    
    // KONSTRUKTOR
    public Cat(String name, Integer age, Boolean male) {
        // kötelezően meg kell hívni az ősosztály egyik konstruktorát --> super kulcsszóval
        super(name, age, male);
    }
    
    public Cat() {
        super ();
    }

    public Cat(Boolean alombaKakil, String name, Integer age, Boolean male) {
        super(name, age, male);
        this.alombaKakil = alombaKakil;
    }
    
    
    // GETTEREK
    public Integer getLife() {
        return life;
    }

    public Boolean getAlombaKakil() {
        return alombaKakil;
    }
    
    
    // SETTEREK
    public void setLife(Integer life) {
        this.life = life;
    }

    public void setAlombaKakil(Boolean alombaKakil) {
        this.alombaKakil = alombaKakil;
    }
    
}
