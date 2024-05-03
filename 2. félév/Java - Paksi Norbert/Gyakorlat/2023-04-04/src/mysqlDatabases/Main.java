package mysqlDatabases;

public class Main {

    public static void main(String[] args) {
        
        if(Product.createProduct("Java pizza", 2490, "Java", "32 cm")) {
            System.out.println("Létrehozva");
        }else {
            System.err.println("Nem jó!");
        }
        
        
        if(Product.deleteProduct(6)) {
            System.out.println("Törölve!");
        } else {
            System.err.println("Nem jó!");
        }
        
    }
    
}
