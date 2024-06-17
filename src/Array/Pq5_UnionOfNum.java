package Array;

import java.util.ArrayList;

public class Pq5_UnionOfNum {

    public static ArrayList<Integer> findUnion(int[] a1, int[] a2, int n, int m) {

        int i = 0, j = 0;
        ArrayList<Integer> union = new ArrayList<>();
        while (i < n && j < m) {
            if (a1[i] < a2[j]) {
                if (union.size() == 0 || union.get(union.size() - 1) != a1[i]) {
                    union.add(a1[i]);
                }
                i++;

            } else {
                if (union.size() == 0 || union.get(union.size() - 1) != a2[j]) {
                    union.add(a2[j]);
                }
                j++;

            }
        }

        while (i < n) {// if any element left in a1
            if (union.get(union.size() - 1) != a1[i]) {
                union.add(a1[i]);
            }
            i++;

        }

        while (j < m) {
            if (union.get(union.size() - 1) != a2[j]) {
                union.add(a2[j]);
            }
            j++;
        }
        return union;
    }

    public static void main(String[] args) {
        int n = 10, m = 7;
        int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int arr2[] = { 2, 3, 4, 4, 5, 11, 12 };
        ArrayList<Integer> Union = findUnion(arr1, arr2, n, m);
        System.out.println("Union of arr1 and arr2 is ");
        for (int val : Union)
            System.out.print(val + " ");
    }
}
