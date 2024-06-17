package Array;

import java.util.Arrays;

public class Pq24_MergeSortedArrayWithoutExtraSpace {
//    public static void merge(long[] arr1, long[] arr2, int n, int m){
//        //two pointers
//        int left = n-1;
//        int right = 0;
//
//        //swap the element until arr1[left] is smaller than arr2[right]
//
//        while (left>=0 && right <m){
//            if (arr1[left] > arr2[right]){
//                long temp = arr1[left];
//                arr1[left] = arr2[right];
//                arr2[right] = temp;
//                left--;
//                right++;
//
//            }else{
//                break;
//            }
//        }
//        Arrays.sort(arr1);
//        Arrays.sort(arr2);
//    }

    public static void swapIfGreater(long[] arr1, long[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            long temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }

    public static void merge(long[] arr1, long[] arr2, int n, int m){
        //two pointers
        int len = m+n;
        //initial gap
        int gap = (len/2)+(len%2);

        //swap the element until arr1[left] is smaller than arr2[right]
        while (gap>0){
            //place 2 pointers
            int left =0;
            int right = left + gap;
            while (right < len){
                // case 1: left in arr1[]
                //and right in arr2[]:
                if (left<n && right >= n){
                    swapIfGreater(arr1,arr2, left, right-n);
                }
                //case2 both in arr2
                else if (left>=n) {
                    swapIfGreater(arr2,arr2,left-n,right-n);
                }else {
                    swapIfGreater(arr1,arr1,left,right);
                }
                left++; right++;
            }
            if (gap==1) break;
            gap = (gap / 2) + (gap % 2);
        }
    }
    public static void main(String[] args) {
        long[] arr1 = {1, 4, 8, 10};
        long[] arr2 = {2, 3, 9};
        int n = 4, m = 3;
        merge(arr1, arr2, n, m);
        System.out.println("The merged arrays are:");
        System.out.print("arr1[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\narr2[] = ");
        for (int i = 0; i < m; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
    }
}
