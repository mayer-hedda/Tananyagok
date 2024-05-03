package simaOsztalyok;

public class Main {
    
    public static void main(String[] args) {
        Macska macska = new Macska("cica", 22, true, true);
        
        try{
            macska.birthday();
            macska.birthday();
            macska.birthday();
            macska.birthday();
            macska.birthday();
            macska.birthday();
            macska.birthday();
            macska.birthday();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
