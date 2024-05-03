package elmelet;

public class Main {

    public static void main(String[] args) {
        
//        Integer szam = 12;
//        szam = 123214342;
//        
//        System.out.println(szam);
        
        

        // új példány
        User u = new User();
        
        // név kiírása
        System.out.println(u.name);
        
        // név megváltoztatása és kiírása
        u.name = "alma";
        System.out.println(u.name);
        
        
        // getter függvény használata
        System.out.println(u.getSzemelyigazolvanyszam());
        
        // setter függvény használata
        u.setSzemelyigazolvanyszam("asd");
        System.out.println(u.getSzemelyigazolvanyszam());
        
        
        
        // 0 paraméteres konstruktor (nem muszáj megírnunk a konstruktort)
        User u2 = new User();
        System.out.println(u2.name);
        System.out.println(u2.getSzemelyigazolvanyszam());
        
        
        // 1 paraméteres konstruktor
        User u3 = new User("Peti");
        System.out.println(u3.name);
        System.out.println(u3.getSzemelyigazolvanyszam());
        
        
        // 2 paraméteres konstruktor
        User u4 = new User("István", "abc12");
        System.out.println(u4.name);
        System.out.println(u4.getSzemelyigazolvanyszam());
        
        // a szin enum használata
        User u5 = new User("Péter", szin.PIROS);
        
        
        
        System.out.println(User.getPeldany());
//        System.out.println(u5.peldany);   // ha nem publikusra állítjuk, akkor nem tudom példányra meghívni, csak osztályra
        
    }
    
}
