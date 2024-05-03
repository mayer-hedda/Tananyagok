package Alapok;

public class Alapok {

    public static void main(String[] args) {
        System.out.println("Hello world! \n");      // sortörés
        System.out.println("Hello world! \t");      // tabulátor
        
        
        
        // VÁLTOZÓK
        
        // Egész számok:
        // byte (1 byte)
        // short (2 byte)
        // int (4 byte)
        
        // Lebegőpontos számok:
        // double --> ezt használjuk a tört számokra
        // float --> 500-at [5 * 10^2]-ként tárolja el (nem használjuk)
        
        // Nem numerikus értékek:
        // char --> 1 karaktert tárol aposztrófok között
        // boolean --> igaz - hamis
        
        int szam = 12;
        System.out.println(szam);
        
        String szoveg = "Ez egy \"alma\" szöveg.";      // a "\" karakter semmissé teszi az utána álló " karaktert
        System.out.println(szoveg);
        
        boolean flag = true;
        System.out.println(flag);
        
        String szoveg2;     // default értéke null
        szoveg2 = "Így is tudok deklarálni egy változónak értéket.";
        System.out.println(szoveg2);
        
        int szam2;      //default értéke 0 --> hibát jelez, ha nem deklaráljuk
        szam2 = szam;
        System.out.println(szam2);
        
        char karakter = 'a';
        System.out.println(karakter);
        
        Integer szam3 = 12;     // osztály alapú megadása a primitív int-nek (default értéke null)
        System.out.println(szam3);
        
        // hash --> egyedi azonosító számoknak
        
        
        // Object:
        // típústalan adattípus --> ha nem tudjuk előre meghatározni, hogy milyen típusban fog érkezni az adat
        // mindenféle adattípus tárolható benne
        // nem tudunk vele számolni
        // többjelentésű karaktereket/operátorokat (pl. a +) sem tudjuk használni
        Object proba = 10;
//        Integer konvertalt = Integer.parseInt(proba.toString());    // eredmény: 10 ---> függvényekkel
        Integer konvertalt = (Integer) proba;   // eredmény: 10 ---> típúskényszerítéssel
        System.out.println(konvertalt + 8);
        
        
        
        
        
        // OPERÁTOROK
        // értékváltoztató
        System.out.println(szam + 1);
        System.out.println(szam - 1);
        System.out.println(szam * 1);
        System.out.println(szam / 1);
        System.out.println(szam % 1);
        System.out.println(szam++);
        System.out.println(szam--);
        
        // összehasonlító
        System.out.println(szam == szam2);
        System.out.println(szam != szam2);
        System.out.println(szam < szam2);
        System.out.println(szam <= szam2);
        System.out.println(szam > szam2);
        System.out.println(szam >= szam2);
        
        // ÉS operátor
        System.out.println(szam == 1 && szam != 4);
        
        // VAGY operátor
        System.out.println(szam == 1 || szam == 4);
        
    }
    
}
