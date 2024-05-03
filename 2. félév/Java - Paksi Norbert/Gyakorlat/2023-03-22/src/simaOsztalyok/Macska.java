package simaOsztalyok;

public class Macska {
    
    // TULAJDONSÁGOK
    private String name;
    private Integer age;
    private Boolean male;
    
//    private final Integer life = 9;
    private Integer life = 9;
    private Boolean alombaKakil;

    
    // KONSTRUKTOR
    public Macska(String name, Integer age, Boolean male, Boolean alombaKakil) {
        this.name = name;
        this.age = age;
        this.male = male;
        this.alombaKakil = alombaKakil;
    }

    
    // GETTEREK
    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Boolean getMale() {
        return male;
    }

    public Integer getLife() {
        return life;
    }

    public Boolean getAlombaKakil() {
        return alombaKakil;
    }

    
    // SETTEREK
    public void setName(String name) {
        this.name = name;
    }

    public void birthday() throws TooOldException {
        if(this.age <= 25) {
            this.age++;
        }else{
            throw new TooOldException("Ez a macska túl öreg");
        }
    }

    public void setMale(Boolean male) {
        this.male = male;
    }

    public void setLife(Integer life) {
        this.life = life;
    }

    public void setAlombaKakil(Boolean alombaKakil) {
        this.alombaKakil = alombaKakil;
    }
    
}
