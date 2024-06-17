package Array;

public class Pq2_RemoveDuplicatefrmSorted {
    public static void main(String[] args) {
        int arr[] = {1,1,2,2,3,3};
        int k = removeDuplicate(arr);
        System.out.println("The array after removing duplicate element is:");
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    static int removeDuplicate(int []arr){
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i]!=arr[j]) {
                i++;
                arr[i] = arr[j];                
            }
        }
        return i+1;
    }
}
