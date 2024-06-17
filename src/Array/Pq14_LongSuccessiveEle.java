package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Pq14_LongSuccessiveEle {
/*  public static int longestSuccessiveElements(int a[]){
        int n =a.length;
        if (n==0) {
            return 0;
        }

        //sort the array
        Arrays.sort(a);

        int lastSmall = Integer.MIN_VALUE;
        int cnt = 0;
        int longest = 1;

        //finding the longest sequence
        for (int i = 0; i < n; i++) {
            if (a[i]-1 == lastSmall) {
                //a[i] is the next element of the current sequence
                cnt +=1;
                lastSmall = a[i];
            }
            else if (a[i] != lastSmall) {
                cnt = 1;
                lastSmall = a[i];
            }
            longest = Math.max(longest,cnt);
        }
        return longest;
    }*/

    public static int longestSuccessiveElements(int a[]){
        int n =a.length;
        if (n==0) {
            return 0;
        }

        int longest = 1;

        Set<Integer> set = new HashSet<>();

        //put all the array element into set
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }

        //find the longest sequence
        for (int it : set) {
            // if 'it' is a starting number 
            if (!set.contains(it-1)) {
                // find consecutive numbers
                int cnt = 1;
                int x = it;
                while (set.contains(x+1)){
                    x++;
                    cnt++;
                }
                longest = Math.max(cnt, longest);
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        int[] a = {100, 200, 1, 2, 3, 4};
        int ans = longestSuccessiveElements(a);
        System.out.println("The longest consecutive sequence is " + ans);
    }
}
