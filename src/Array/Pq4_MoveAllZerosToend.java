package Array;

//using two pointer approach
public class Pq4_MoveAllZerosToend {
    public static int[] moveZeros(int n, int[] arr) {
        int j = -1; // points to the next non-zero element from right end of array.

        // place the pointer j:
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }

        // no non zero element:
        if (j == -1) {
            return arr;
        }

        // move the pointer i & j
        // and swap accordingly

        for (int i = j + 1; i < n; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, 2, 3, 2, 0, 0, 4, 5, 1 };
        int n = 10;
        int[] ans = moveZeros(n, arr);
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println("");
    }
}
