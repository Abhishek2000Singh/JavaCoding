package Part2_Recursion;

public class Ch7_SubsequenceOfString {

    public static void subSequence(String str, int idx, String newString) {

        if (idx==str.length()) {
            System.out.println(newString); // Print the final string when we reach end of input string
            return;
        }

        char currChar = str.charAt(idx);

        //to be 
        subSequence(str, idx + 1, newString + currChar);

        //not to be
        subSequence(str, idx + 1, newString);
    }

    public static void main(String[] args) {
        String s = "abc";

        subSequence(s, 0, "");

    }
}
