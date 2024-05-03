package simaOsztalyok;

public class Kutya {
    
    // TULAJDONSÁGOK
    private String name;
    private Integer age;
    private Boolean male;
    
    private Boolean ball;
    private String Owner;

    
    // KONSTRUKTOR
    public Kutya(String name, Integer age, Boolean male, Boolean ball, String Owner) {
        this.name = name;
        this.age = age;
        this.male = male;
        this.ball = ball;
        this.Owner = Owner;
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

    public Boolean getBall() {
        return ball;
    }

    public String getOwner() {
        return Owner;
    }

    
    // SETTEREK
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setMale(Boolean male) {
        this.male = male;
    }

    public void setBall(Boolean ball) {
        this.ball = ball;
    }

    public void setOwner(String Owner) {
        this.Owner = Owner;
    }
  
}
