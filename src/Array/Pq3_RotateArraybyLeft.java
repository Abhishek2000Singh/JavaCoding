package Array;

public class Pq3_RotateArraybyLeft {

    public static void reverse(int[] arr, int start, int end) {
        while (start <= end) {

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotateEletoleft(int[] arr, int n, int k) {
        // reverse first k element
        reverse(arr, 0, k - 1);

        // reverse last n-k element
        reverse(arr, k, n - 1);

        // then reverse the whole array
        reverse(arr, 0, n - 1);

    }

    public static void rotateeletoright(int[] arr, int n, int k) {
        // Reverse first n-k elements
        reverse(arr, 0, n - k - 1);
        // Reverse last k elements
        reverse(arr, n - k, n - 1);
        // Reverse whole array
        reverse(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int n = 7;
        int k = 2;
//        rotateEletoleft(arr, n, k);
        rotateeletoright(arr, n, k);
        System.out.print("After Rotating the k elements to left ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
