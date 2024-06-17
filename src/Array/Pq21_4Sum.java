package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pq21_4Sum {

    public  static List<List<Integer>> fourSum(int []nums, int target){
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        //calculating the quadruples
        for (int i = 0; i < n; i++) {
            //avoiding duplicates while moving i
            if (i>0 && nums[i]==nums[i-1]) continue;
            for (int j = i+1; j < n; j++) {
                //avoid using duplicates for j
                if (j>i+1 && nums[j]== nums[j-1]) continue;

                //using 2 pointers

                int k = j+1;
                int l = n-1;
                while (k<l){
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];

                    if (sum == target){
//                        List<Integer>temp = new ArrayList<>();
//                        temp.add(nums[i]);
//                        temp.add(nums[j]);
//                        temp.add(nums[k]);
//                        temp.add(nums[l]);
                        List<Integer>temp = Arrays.asList(nums[i],nums[j],nums[k],nums[l]);

                        ans.add(temp);
                        k++; l--;

                        //skipping the duplicates
                        while (k<l && nums[k] == nums[k-1])k++;
                        while (k<l && nums[l] == nums[l+1])l--;
                    } else if (sum<target) {
                        k++;
                    }else l--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        int target = 9;
        List<List<Integer>> ans = fourSum(nums,target);

        for (List<Integer> it: ans){
            System.out.print("[");
            for (int ele:it){
                System.out.print(ele+ " ");
            }
            System.out.print("]");
        }
        System.out.println();
    }
}
