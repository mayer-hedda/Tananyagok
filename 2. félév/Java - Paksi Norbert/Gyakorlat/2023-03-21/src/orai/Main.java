package orai;

public class Main {
   
    public static void main(String[] args) {
        
        Mouse eger = new Mouse("Sanyi", 1600, true, true, 10, true, "123,123,132");
        eger.name = "Elemér";
        eger.setSensitivity(3000);
        eger.setVezetekesMost(false);
        eger.setVezetekHossza(11);
        eger.setColor("asd");
        
        System.out.println(eger.name);
        System.out.println(eger.getSensitivity());
        System.out.println(eger.getVezetekes());
        System.out.println(eger.getVezetekesMost());
        System.out.println(eger.getVezetekHossza());
        System.out.println(eger.getIsRgb());
        System.out.println(eger.getColor());
        
        
    }
    
}
