package Part2A_RecursionStriverr;

import java.util.Scanner;

public class Pq1_SumAndFactFirstN {
    public static int sumOfN(int n){
        if (n==0)
            return 0;

        return n + sumOfN(n-1);
    }

    public static int fact(int n){
        if (n==1){
            return 1;
        }
        return n*fact(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Sum of First "+n+" Number is: "+sumOfN(n));
        System.out.println("Factorial of First "+n+" Number is: "+fact(n));
    }
}
