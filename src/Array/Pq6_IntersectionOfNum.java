package Array;

import java.util.ArrayList;

public class Pq6_IntersectionOfNum {

    public static ArrayList<Integer> intersection(int[] a1, int[] a2, int n, int m) {
        int i = 0, j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while (i < n && j < m) {
            if (a1[i] < a2[j]) {
                i++;
            } else if (a1[i] > a2[j]) {
                j++;
            } else {
                ans.add(a1[i]);
                i++;
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 10, m = 7;
        int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int arr2[] = { 2, 3, 4, 4, 5, 11, 12 };
        ArrayList<Integer> inter = intersection(arr1, arr2, n, m);
        System.out.println("Union of arr1 and arr2 is ");
        for (int val : inter)
            System.out.print(val + " ");
    }
}
