package Array;

import java.util.ArrayList;

public class Pq13_Leader {

 /*   public static ArrayList<Integer> printLeadersBruteForce(int[] arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            boolean leader = true;
            // Checking whether arr[i] is greater than all the elements in its right side

            for (int j = i+1; j < n; j++) {
                if (arr[j]>arr[i+1]) {
                    leader = false;
                    break;
                }
            }

            //push all the leader into the array;
            if (leader) {
                ans.add(arr[i]);
            }

        }
        return  ans;
    }
*/
public static ArrayList<Integer> printLeadersBruteForce(int[] arr, int n) {
    ArrayList<Integer> ans = new ArrayList<>();

    //last element  is always a leader, pus hinto ans list

    int max = arr[n-1];
    ans.add(arr[n-1]);

    //start checking from the end whether a number is greater than max no. from right, hence leader.

    for (int i = n-2; i >= 0; i--) {
        if (arr[i]>max) {
            ans.add(arr[i]);
            max = arr[i];
        }
    }
    return ans;
}

    public static void main(String args[]) {
        // Array Initialization.
        int n = 6;
        int arr[] = { 10, 22, 12, 3, 0, 6 };

        ArrayList<Integer> ans = printLeadersBruteForce(arr, n);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }

    }
}
