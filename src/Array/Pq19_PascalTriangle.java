package Array;

import java.util.ArrayList;
import java.util.List;

public class Pq19_PascalTriangle {
    // variation 1 - given the row number r and the column number c, and we need to find out the element at position (r,c).
    public static long nCr(int n, int r) {
        long res = 1;

        // calculating ncr
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    // public static int pascalTriangle(int r,int c){
    // int element = (int) nCr(r-1,c-1);
    // return element;
    // }

    // Variation 2 Given the row number n. Print the n-th row of Pascal’s triangle.
    // static void pascalTriangle(int n) {
    //     long ans = 1;
    //     System.out.print(ans + " ");

    //     for (int i = 1; i < n; i++) {
    //         ans = ans * (n - i);
    //         ans = ans / i;
    //         System.out.print(ans + " ");
    //     }
    //     System.out.println();
    // }


    //Variation3 - Print pascal traingle

    public static List<Integer> generateRow(int row){
        long ans =1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);

        //calculate the rest of the element
        for (int col =1; col <row; col++) {
            ans = ans*(row-col);
            ans = ans/col;
            ansRow.add((int)ans);
        }
        return ansRow;
    }

    public static List<List<Integer>> pascalTriangle(int n){
        List<List<Integer>> ans = new ArrayList<>();

        //to store the enttire pascal
        for (int row = 1; row <= n; row++) {
            ans.add(generateRow(row));
        }
        return ans;
    }

    public static void main(String[] args) {

        // Variation1
        // int r = 5; // row number
        // int c = 3; // col number
        // int element = pascalTriangle(r, c);
        // System.out.println("The element at position (r,c) is: " + element);

        // Variation2
        //int n = 5; // Row Number
        //pascalTriangle(n);

        //variation 3

        int n=5;
        List<List<Integer>> ans =  pascalTriangle(n);
        for (List<Integer> it : ans) {
            for (int ele : it) {
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }
}
