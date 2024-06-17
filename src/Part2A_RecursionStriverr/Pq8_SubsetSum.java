package Part2A_RecursionStriverr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Pq8_SubsetSum {
    public static void func(int ind,int sum,ArrayList<Integer>arr, int n, ArrayList<Integer>sumSubset){
        if (ind==n){
            sumSubset.add(sum);
            return;
        }

        //pick
        func(ind+1, sum+ arr.get(ind), arr, n, sumSubset);

        //not pick
        func(ind+1, sum, arr, n, sumSubset);
    }
    public static ArrayList<Integer> subsetSums(ArrayList<Integer>arr, int N){
        ArrayList<Integer> sumSubset = new ArrayList<>();
        func(0,0,arr,N,sumSubset);
        Collections.sort(sumSubset);
        return sumSubset;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        int N = arr.size();
        ArrayList<Integer> result = subsetSums(arr, N);
        System.out.println(result);
    }
}
