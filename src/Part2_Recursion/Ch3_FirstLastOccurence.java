package Part2_Recursion;

public class Ch3_FirstLastOccurence {

    public static int first = -1;
    public static int last = -1;

    public static void findoccurence(String str, int idx, char element) {
        if (idx == str.length()) {
            System.out.println(first);
            System.out.println(last);
            return;
        }
        char currChar = str.charAt(idx);
        if (currChar == element) {
            if (first == -1) {
                first = idx;
            } else {
                last = idx;
            }
        }
        findoccurence(str, idx + 1, element);
    }

    public static void main(String[] args) {
        String str = "abaacadaefaahd";
        findoccurence(str, 0, 'a');

    }
}
