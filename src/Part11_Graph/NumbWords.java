package Part11_Graph;

import java.util.Scanner;

public class NumbWords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();
        int r;
        String str = "";
        while (n > 0) {
            r = n % 10;
            n = n / 10;
            str = str + r;
        }

        System.out.println(str);

        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);

            switch (c) {
                case '0':
                    System.out.print("zERO ");
                    break;
                case '1':
                    System.out.print("oNE ");
                    break;
                case '2':
                    System.out.print("tWO ");
                    break;
                case '3':
                    System.out.print("tHREE ");
                    break;
                case '4':
                    System.out.print("fOUR ");
                    break;
                case '5':
                    System.out.print("fIVE ");
                    break;
                case '6':
                    System.out.print("sIX ");
                    break;
                case '7':
                    System.out.print("sEVEN ");
                    break;
                case '8':
                    System.out.print("eIGHT ");
                    break;
                case '9':
                    System.out.print("nINE ");
                    break;
            }
        }
    }
}
