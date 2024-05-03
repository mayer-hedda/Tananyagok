package oroklodes;

public class Dog extends Animal {
    
    // TULAJDONSÁGOK
    private Boolean ball;
    private String Owner;
    
    
    // KONSTRUKTOR
    public Dog(String name, Integer age, Boolean male) {
        super(name, age, male);
    }
    
    public Dog() {
        super ();
    }

    public Dog(Boolean ball, String Owner, String name, Integer age, Boolean male) {
        super(name, age, male);
        this.ball = ball;
        this.Owner = Owner;
    }
    
    
    // GETTEREK
    public Boolean getBall() {
        return ball;
    }

    public String getOwner() {
        return Owner;
    }
    
    
    // SETTEREK
    public void setBall(Boolean ball) {
        this.ball = ball;
    }

    public void setOwner(String Owner) {
        this.Owner = Owner;
    }
    
}
