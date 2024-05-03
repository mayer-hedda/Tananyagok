package mayerheddakonzol;

public class Erdemjegyek {
    public int jegy;
    
    public Erdemjegyek(int jegy){
        this.jegy = jegy;
    }
    
    public String getSzovegesJegy(){
        String result = "";
        
        switch(this.jegy){
            case 1: result = "Elégtelen"; break;
            case 2: result = "Elégséges"; break;
            case 3: result = "Közepes"; break;
            case 4: result = "Jó"; break;
            case 5: result = "Jeles"; break;
            default: result = "Hiba";
        }
        
        return result;
    }
}
