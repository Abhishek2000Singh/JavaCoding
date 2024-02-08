import java.lang.*;
import java.util.*;


public class Ch8_Literals {
    public static void main(String[] args) {
        byte b= 15;
        short s = 25;
        int i =150;
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println("*************************************************");

        byte b1= 10;
        byte b2 = 0b1010;
        byte b3 = 012;
        byte b4 = 0XA;
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);

        long l = 999999999999999L;
        float f = 123_345.78F;
        System.out.println(l);
        System.out.println(f);
    }
}
