package Part9_Hashing;

import java.util.*;

public class Ch2_HashMap {
    public static void main(String[] args) 
    {
        //country(key), population (value)
        HashMap<String,Integer> map = new HashMap<>(); // Create a Hashmap



        //Insertion
        map.put("India", 120);
        map.put("US", 30);
        map.put("China", 150);

        System.out.println(map);  //unordered form

        map.put("China", 180);   //updating the value of China
        System.out.println(map);

        // //Search
        // if (map.containsKey("China")) {
        //     System.out.println("Key is present in the map");
        // }
        // else{
        //     System.out.println("Key is not present in the map");
        // } 
 
        // System.out.println(map.get("China")); //key exist  then return value otherwise null
        // System.out.println(map.get("Indonesia")); // key doesnt exist 

        // int arr[] = {12,15,18};
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i]+" ");
        // }
        // System.out.println();

        // for (int i : arr) {
        //     System.out.print(i+" ");
        // }System.out.println();

        //for(int val : arr)  just to show the comparision of entryset and foreach
        for(Map.Entry<String, Integer> e :map.entrySet()){
            // System.out.println(e.getKey());
            // System.out.println(e.getValue());
            System.out.println(e.getKey()+": "+e.getValue());
        }
 
        Set<String> keys = map.keySet();
        for(String key :keys){
            System.out.println(key+" "+map.get(key));
        }
    }
    
}
