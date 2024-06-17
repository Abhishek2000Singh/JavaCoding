package Part2A_RecursionStriverr;

import java.util.ArrayList;
import java.util.List;

public class Pq14_KthPermutation {
    public String getPermutation(int n, int k){
        int fact = 1;
        List<Integer>nums = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            fact = fact*i;
            nums.add(i);
        }
        nums.add(n);

        String ans= "";
        k = k-1; //bcz of zerop based indexing
        while (true){

            ans= ans + nums.get(k/fact);
            nums.remove(k/fact);
            if (nums.size()==0)
            {
                break;
            }
            k = k%fact;
            fact = fact/nums.size();
        }
        return ans;
    }
    public static void main(String[] args) {
        Pq14_KthPermutation solver = new Pq14_KthPermutation();
        int n = 4;
        int k = 9;
        String result = solver.getPermutation(n, k);
        System.out.println("The " + k + "th permutation of " + n + " numbers is: " + result);
    }
}
