package oroklodes;

public class Main {

    public static void main(String[] args) {
        
        Cat macska = new Cat();
        Cat macska1 = new Cat(false, "Cirmi", 6, true);
        
        System.out.println("Macska tulajdonságai:");
        System.out.println("\tneve: " + macska1.getName());
        System.out.println("\tkora: " + macska1.getAge());
        System.out.println("\tneme: " + macska1.getMale());
        System.out.println("\talomba kakil-e: " + macska1.getAlombaKakil());
        
        
        
        Dog kutya = new Dog();
        Dog kutya1 = new Dog(true, "Sanyi", "Bodri", 3, true);
        
        System.out.println("\nKutya tulajdonságai:");
        System.out.println("\tneve: " + kutya1.getName());
        System.out.println("\tkora: " + kutya1.getAge());
        System.out.println("\tneme: " + kutya1.getMale());
        System.out.println("\tvan-e labdája: " + kutya1.getBall());
        System.out.println("\tgazdája: " + kutya1.getOwner());
        
    }
    
}
