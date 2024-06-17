package Part2A_RecursionStriverr;

import java.util.*;

public class Pq10_PrintPermutation_StringOrArray {
    private static void recurPermute(int nums[],List<Integer>ds,  List<List<Integer>>ans, boolean []freq){
        if (ds.size()== nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!freq[i]){
                freq[i] = true;
                ds.add(nums[i]);
                recurPermute(nums, ds, ans, freq);
                ds.remove(ds.size()-1);
                freq[i] = false;
            }
        }
    }
    private  static  List<List<Integer>>  permute(int []nums){
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean freq[] = new boolean[nums.length];
        recurPermute(nums, ds, ans, freq);
        return ans;
    }

    //Approach 2
    private static void swap(int i, int j, int nums[]){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    private static void recurOpimisedPermute(int ind, int []nums, List<List<Integer>>ans){
        if (ind==nums.length){
            //copy the ds to ans
            List<Integer>ds = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = ind; i < nums.length; i++) {
            swap(i,ind,nums);
            recurOpimisedPermute(ind+1, nums, ans);
            swap(i,ind,nums);

        }
    }

    private  static  List<List<Integer>>  permute2(int []nums) {
        List<List<Integer>>ans = new ArrayList<>();
        recurOpimisedPermute(0,nums,ans);
        return ans;
    }


    public static void main(String[] args) {

    }
}
