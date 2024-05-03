package com.mycompany.teszt.Teszteles;

public class Money {
    
    private Integer amount;
    private Integer goal;

    public Money(Integer amount) {
        this.amount = amount;
    }
    
    public Integer add(Integer amount) {
        this.amount += amount;
        return this.amount;
    }
    
    public Integer remove(Integer amount) {
        this.amount -= amount;
        
        if(this.amount >= 0) {
            return this.amount;
        } else {
            this.amount = 0;
            return this.amount;
        }
    }
    
    public void setGoal(Integer amount) throws NegativeGoalException {
        if(amount > 0) {
            this.goal = amount;
        } else {
            throw new NegativeGoalException("Nem lehet mínusz az összeg!");
        }
    }
    
}
