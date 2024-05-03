package Random;

public class Random {

    public static void main(String[] args) {
        System.out.println("Program eleje!");
        
        while (true) {
            double rand = Math.random();
            if (rand == 0.0) {
                System.out.println(rand);
                System.out.println("Program vége!");
                break;
            }
        }
    }
}
