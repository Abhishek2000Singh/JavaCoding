package Part2_Recursion;

/**
 * Ch4_CheckIfSortedArray
 */
public class Ch4_CheckIfSortedArray {


    public static boolean isSorted(int[] arr,int idx) {
        if (idx==arr.length-1) {
            return true;
        }
        // if (arr[idx]<arr[idx+1]) {
        //     //array is soted till now
        //     return isSorted(arr, idx+1);
        // }else{
        //     return false;
        // }

        //optimising 
        if (arr[idx]>=arr[idx + 1]) {
            //array is unsorted
            return false;
        }
        return isSorted(arr, idx + 1);
    }

    public static void main(String[] args) {

        int arr[] ={1,3,3};
        System.out.println(isSorted(arr, 0));
    }

}