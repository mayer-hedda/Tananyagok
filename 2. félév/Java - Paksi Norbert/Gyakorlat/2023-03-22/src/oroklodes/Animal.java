package oroklodes;

public abstract class Animal {
    
    // TULAJDONSÁGOK
    protected String name;
    protected Integer age;
    protected Boolean male;
    
    
    // KONSTRUKTOR
    public Animal(String name, Integer age, Boolean male) {
        this.name = name;
        this.age = age;
        this.male = male;
    }
    
    public Animal() {
        
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
    
}
