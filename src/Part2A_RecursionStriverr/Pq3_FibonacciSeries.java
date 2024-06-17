package Part2A_RecursionStriverr;

import java.util.Scanner;

public class Pq3_FibonacciSeries {
    public static int fibb(int n){
        if (n<=1)return n;

        int last = fibb(n-1);
        int slast = fibb(n-2);

        return last+slast;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        System.out.println("Fibonacci number is: " + fibb(n));
    }
}
