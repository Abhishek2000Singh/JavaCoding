package Part2A_RecursionStriverr;

import java.util.Scanner;

public class Pq2_ReverseAnArr_Pallindrome {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void reverseArr(int i, int arr[],int n){
        if (i>=n/2){
            return;
        }
        swap(arr, i, n - i - 1);
        reverseArr(i+1,arr, n);
    }

    public static boolean pallindrome(int i, String s){
        if (i>= s.length()/2) return true;
        if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        return pallindrome(i+1,s);
    }
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int arr[] = new int[n];
//        for (int i = 0; i < n; i++) {
//             arr[i] = sc.nextInt();
//        }
//        reverseArr(0,arr,n);
//        for (int i = 0; i < n; i++) {
//            System.out.print(arr[i]+" ");
//        }
        String s = "madam";
        System.out.println(pallindrome(0,s));
    }
}
