package Part9_Hashing;

import java.util.*;;

public class Pq1_MajoorityElement {

    public static void majority(int nums[]){

        HashMap<Integer,Integer> map = new HashMap<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) { //true
                map.put(nums[i], map.get(nums[i])+1); 
            }else{ //false   
                map.put(nums[i], 1);
            }
        }

        for(int key : map.keySet()){
            if (map.get(key)> n/3) {
                System.out.println(key + " is the Majority Element");
            }
        }      
        
    }
    public static void main(String[] args) { //O(n)
        // int nums[]= {1,3,2,5,1,3,1,5,1}; //1
    //    int nums[]= {1,2}; //1,2
        int nums[]= {3,2,3}; //1,2

        majority(nums);
    }
}
