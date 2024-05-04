import javax.net.ssl.SSLContext;

public class VariableAndOperatorDemonstration {
    public static void main(String[] args) {

        // primitív típusú változók

        // egész szám típusú változók
//        byte a = 127;
//        short b = 100;
//        int c = 100;
//        long d;
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//        System.out.println(d);

        //
//        float e = 12.5f;
//        double f = 12.5;

        //
//        boolean g = false;

        //
//        char h = 'A';



//        int i = 10;
//        System.out.println(i);
//        i = 15;
//        System.out.println(i);
//        i = 100;
//        System.out.println(i);


//        int apples = 7;
//        int pears = 12;
//        System.out.println(apples);
//        System.out.println(pears);
//
//        int fruits = apples + pears;
//        System.out.println(fruits);


//        int numer_of_boxes = 100;
//        int numer_of_boxed_sold = 17;
//        int numer_of_boxes_remining = numer_of_boxes - numer_of_boxed_sold;
//        System.out.println(numer_of_boxes_remining);


//        int i = 17;
//        int j = 5;
//        int k = i % j;
//        System.out.println(k);


//        boolean b1 = true;
//        boolean b2 = false;
//        boolean result = b1 && b2;
//        System.out.println(result);


//        System.out.println(150 % 4);
//        System.out.println(151 % 4);
//        System.out.println(152 % 4);
//        System.out.println(153 % 4);
//        System.out.println(155 % 4);
//        System.out.println(156 % 4);
//        System.out.println(157 % 4);
//        System.out.println(158 % 4);
//        System.out.println(159 % 4);
//
//        System.out.println(1444 % 2 == 0);


//        int number = (2 + 3) * 4;
//        System.out.println(number);
//
//        boolean b = number + 10 < 100;
//        System.out.println(b);


//        int i = 100;
//        System.out.println(++i);
//        System.out.println(i++);
//        System.out.println(i);
//        int j = i++ + ++i;
//        System.out.println(j);


        // ------ ÉS OPERÁTOR ------

        // true && true => true
        // false && true => false
        // true && false => false
        // false && false => false
//        boolean b1 = true;
//        boolean b2 = true;
//        boolean result = b1 && b2;
//        System.out.println(b1);
//        System.out.println(b2);
//        System.out.println(result);


        // ------ VAGY OPERÁTOR ------

        // true || true => true
        // false || true => true
        // true || false => true
        // false || false => false
//        boolean b1 = true;
//        boolean b2 = true;
//        boolean result = b1 || b2;
//        System.out.println(b1);
//        System.out.println(b2);
//        System.out.println(result);


        // ------ KIZÁRÓ VAGY OPERÁTOR (XOR) ------

        // true ^ true => false
        // false ^ true => true
        // true ^ false => true
        // false ^ false => false
//        boolean b1 = true;
//        boolean b2 = true;
//        boolean result = b1 ^ b2;
//        System.out.println(b1);
//        System.out.println(b2);
//        System.out.println(result);


//        boolean b1 = true;
//        boolean b2 = false;
//        boolean b3 = false;
//        boolean result = (b1 || b2) && b3;
//        System.out.println(result);



//        int i = 100;
//        int j = 200;
//        i = j;
//        System.out.println(i);
//        System.out.println(j);
//
//        i = 50;
//        j = 300;
//        System.out.println(i);
//        System.out.println(j);
//
//        i += j;  // -=, *=, /=, %=
//        System.out.println(i);



//        int i = 56;
//        System.out.println(i % 2 == 0 ? "páros" : "páratlan");

        int i = 105;
        System.out.println(i < 100 ? "kissebb mint 100" : "nagyobb mint 100");

        System.out.println(i == 100 ? "A szám egyenlő százzal." : "A szám nem egyenlő százzal.");
    }
}