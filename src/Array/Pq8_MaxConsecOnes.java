package Array;

public class Pq8_MaxConsecOnes {

    public static int findMaxConsecutiveOnes(int []nums){
        int maxi= 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==1) {
                count++;
            }else{
                count =0;
            }
            maxi = Math.max(maxi, count);

        }
        return maxi;
    }
    public static void main(String[] args) {
        int nums[] = { 1, 1, 0, 1, 1, 1 };
        int ans = findMaxConsecutiveOnes(nums);
        System.out.println("The maximum  consecutive 1's are " + ans);
    }

}
