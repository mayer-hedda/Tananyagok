package oop;

import java.util.ArrayList;
import java.util.Scanner;

public class OOP {

    public static void main(String[] args) {
        // adattárolás szempontjából
        
        Car auto = new Car(1, "08:30", "CEG300", "501", 130450, true);
        Car auto2 = new Car("1 08:45 CEG306 501 23989 0");
        
        
        
        ArrayList<Car> cars = new ArrayList();
        cars.add(auto);
        cars.add(auto2);
        cars.add(new Car("1 12:02 CEG308 586 26496 0"));
        cars.add(new Car("2 12:15 CEG305 574 8731 0"));
        cars.add(new Car("3 14:30 CEG307 514 27244 1"));
        for (Car c : cars) {
            System.out.println(c.rendszam);
        }
        
        
        
        Car maxKm = cars.get(0);
        for (Car c : cars) {
            if (c.kilometer > maxKm.kilometer) {
                maxKm = c;
            }
        }
        
        System.out.println(maxKm);
        
    }
    
}
