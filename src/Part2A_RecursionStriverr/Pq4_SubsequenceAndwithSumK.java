package Part2A_RecursionStriverr;

import java.util.ArrayList;

public class Pq4_SubsequenceAndwithSumK {

    public static void subsequenceOfArr(int ind, ArrayList<Integer> ds, int[] arr, int n) {
        if (ind == n) {
            for (int it : ds) {
                System.out.print(it + " ");
            }
            if (ds.size() == 0) {
                System.out.print("{}");
            }
            System.out.println();
            return;
        }
        //Include the current element;
        ds.add(arr[ind]);
        subsequenceOfArr(ind + 1, ds, arr, n);

        //Exclude the current element;
        ds.remove(ds.size() - 1);
        subsequenceOfArr(ind + 1, ds, arr, n);
    }

    //subsequence of all the array with sum k
    public static void subseqWithSumK(int ind, ArrayList<Integer> ds, int s, int sum, int[] arr, int n) {
        if (ind == n) {
            if (s == sum) {
//                for (int i = 0; i < ds.size(); i++) {
//                    System.out.print(ds.get(i) + " ");
//                }
                for (int it : ds) {
                    System.out.print(it + " ");
                }
                System.out.println();
            }
            return;
        }
        //picking up the element
        ds.add(arr[ind]);
        s += arr[ind];
        subseqWithSumK(ind + 1, ds, s, sum, arr, n);

        //Not picking the element
        s -= arr[ind];
        ds.remove(ds.size()-1 );
        subseqWithSumK(ind + 1, ds, s, sum, arr, n);

    }

    //subsequence of one the array with sum k
    public static boolean subseqANyOneWithSumK(int ind, ArrayList<Integer> ds, int s, int sum, int[] arr, int n) {
        if (ind == n) {
            if (s == sum) {
                for (int it : ds) {
                    System.out.print(it + " ");
                }
                System.out.println();
                return true;
            } else {
                return false;
            }
        }
        //picking up the element
        ds.add(arr[ind]);
        s += arr[ind];
        if (subseqANyOneWithSumK(ind + 1, ds, s, sum, arr, n) == true) {
            return true;
        }

        //Not picking the element
        s -= arr[ind];
        ds.remove(ds.size()-1);
        if (subseqANyOneWithSumK(ind + 1, ds, s, sum, arr, n) == true) {
            return true;
        }
        return false;
    }
    public static int  countSubsequenceWithSumK(int ind, int s, int sum, int[] arr, int n) {
        if (ind == n) {
            if (s == sum) {
                return 1;
            } else {
                return 0;
            }
        }
        //picking up the element
        s += arr[ind];
        int l= countSubsequenceWithSumK(ind + 1, s, sum, arr, n);


        //Not picking the element
        s -= arr[ind];
        int r =countSubsequenceWithSumK(ind + 1,s, sum, arr, n);

        return l+r;
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 1};
        int n = 3;
        int sum = 2;
        ArrayList<Integer> ds = new ArrayList<>();
//        subseqWithSumK(0, ds, 0, sum, arr, n);
//        subseqANyOneWithSumK(0, ds, 0, sum, arr, n);
        System.out.println(countSubsequenceWithSumK(0, 0, sum, arr, n));


//        int arr[] = {3,1,2};
//        int n=3;
//        ArrayList<Integer>ds = new ArrayList<>();
//        subsequenceOfArr(0,ds,arr,n);

    }
}
