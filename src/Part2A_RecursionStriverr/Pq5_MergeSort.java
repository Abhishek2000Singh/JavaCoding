package Part2A_RecursionStriverr;

import java.util.ArrayList;

public class Pq5_MergeSort {
    public static void merge(ArrayList<Integer>arr, int low, int mid, int high){
        ArrayList<Integer>temp = new ArrayList<>();
        int left = low;
        int right = mid+1;
        while (left<= mid && right<=high){
            if (arr.get(left)<= arr.get(right)){
                temp.add(arr.get(left));
                left++;
            }
            else{
                temp.add(arr.get(right));
                right++;
            }
        }
        while (left<= mid){
            temp.add(arr.get(left));
            left++;
        }
        while (right<=high){
            temp.add(arr.get(right));
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr.set(i, temp.get(i - low));
        }
    }
    public static void mS(ArrayList<Integer>arr, int low, int high){
        if (low==high){
            return;
        }
        int mid = low+(high-low)/2;
        mS(arr, low, mid);
        mS(arr, mid+1, high);
        merge(arr,low,mid,high);
    }
    public static void mergeSort(ArrayList<Integer>arr, int n){
        mS(arr,0,n-1);
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(38);
        arr.add(27);
        arr.add(43);
        arr.add(3);
        arr.add(9);
        arr.add(82);
        arr.add(10);

        System.out.println("Original Array: " + arr);
        mergeSort(arr, arr.size());
        System.out.println("Sorted Array: " + arr);
    }
}
