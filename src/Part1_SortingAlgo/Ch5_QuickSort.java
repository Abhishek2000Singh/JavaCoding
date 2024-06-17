package Part1_SortingAlgo;

public class Ch5_QuickSort {

    public static int partition(int []arr,int low, int high){
        int pivot = arr[high];
        int i  = (low - 1); // index of smaller element
        for (int j = low; j < high; j++){
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];  
                arr[i] = arr[j];  
                arr[j] = temp;  
            }
        }
        // swapping the pivot element with the element at [i+1], which is greater than all other elements in this part.
        i++;
        int temp = arr[i];
        arr[i] = pivot; //or arr[high] i.e pivot = arr[high]
        arr[high]= temp;
       
        return i;
    }

    public static void quickSort(int []arr,int low, int high){

        if (low<high) {

            int pidx = partition(arr,low,high);

            quickSort(arr, low, pidx-1);
            quickSort(arr, pidx+1, high);
        }
    }

    public static void main(String[] args) {
         int[] arr = { 6, 3, 9, 5, 2, 8 };
        int n = arr.length;

        quickSort(arr, 0, n-1);
        // print
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.err.println();
    }
}
