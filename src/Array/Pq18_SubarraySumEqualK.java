package Array;

import java.util.HashMap;
import java.util.*;

public class Pq18_SubarraySumEqualK {

    // public static int subArraySum(int arr[], int k){
    //     int n = arr.length;
    //     int cnt =0; //Number of subarray

    //     for (int i = 0; i < n; i++) {
    //         int sum =0;
    //         for (int j = i; j < n; j++) {
    //             sum+= arr[j];

    //             if (sum==k) {
    //                 cnt++;
    //             }
    //         }
    //     }
    //     return cnt;

    // }

    public static int subArraySum(int arr[], int k){
        int n = arr.length;
        int sum =0;
        int cnt=0;
        HashMap<Integer, Integer> mp = new HashMap<>();

        mp.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            int remove = sum-k;
            //add the number of subarrays to be removed
            cnt += mp.getOrDefault(remove, 0);
            
            //update the count of sum
            mp.put(sum, mp.getOrDefault(sum, 0)+1);
        }
        return cnt;

    }
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int k = 6;
        int cnt = subArraySum(arr, k);
        System.out.println(cnt);
    }
}
