import java.lang.*;
import java.util.*;

public class ch7_readingFromKeyboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int a,b,c;
//        System.out.println("Enter the two Numbers: ");
//        a = sc.nextInt();
//        b = sc.nextInt();
//        c=a+b;
//        System.out.println("Sum is: "+c);

        String name;
        System.out.println("May I know your name?");
        name = sc.nextLine();
        System.out.println("Welcome Mr./Miss " +name);
    }
}
