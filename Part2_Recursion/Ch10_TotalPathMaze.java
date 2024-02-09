package Part2_Recursion;
//advance recursion

public class Ch10_TotalPathMaze {

    public static int countPaths(int i, int j, int n, int m) {

        if (i == n || j == m) {
            return 0;
        }

        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        // move down
        int downPaths = countPaths(i + 1, j, n, m);

        // move right
        int rightPaths = countPaths(i, j + 1, n, m);

        return downPaths + rightPaths;
    }
 
    public static void main(String[] args) {
        int m = 3, n = 3; // maze size
        int totalPaths = countPaths(0, 0, n, m);
        System.out.println(totalPaths);
    }
}
