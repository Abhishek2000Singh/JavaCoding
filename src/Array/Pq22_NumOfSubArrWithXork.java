package Array;

import java.util.HashMap;
import java.util.Map;

public class Pq22_NumOfSubArrWithXork {
//    public static int subarraysWithXorK(int []a, int k){
//        int n= a.length;
//        int cnt =0;
//
//        //generating subarray;
//        for (int i = 0; i < n; i++) {
//            int xorr =0;
//            for (int j = i; j < n; j++) {
//                //calculating the xor of all
//                xorr = xorr^a[j];
//                if (xorr==k)cnt++;
//            }
//        }
//        return cnt;
//    }

    public static int subarraysWithXorK(int []a, int k){
        int n =a.length;
        int xr = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(xr,1);
        int cnt =0;

        for (int i = 0; i < n; i++) {
            //prefix xor till index i:
            xr = xr^a[i];

            //By formula: x = xr^k:
            int x = xr^k;

            //add the occurence of xr^k
            if (map.containsKey(x)){
                cnt+= map.get(x);
            }

            //Insert the prefix xor till i into the map
            if (map.containsKey(xr)){
                map.put(xr, map.get(xr)+1);
            }else{
                map.put(xr,1);
            }
        }
        return  cnt;
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 2, 6, 4};
        int k = 6;
        int ans = subarraysWithXorK(a, k);
        System.out.println(ans);
    }
}
