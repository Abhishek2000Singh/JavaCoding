package Part2_Recursion;

public class Ch6_RemoveDuplicates {

    public static boolean[] map = new boolean[26];

    public static void removeDup(String str, int idx, String newString) {

        if (idx==str.length()) {
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(idx);
        if (map[currChar - 'a']) {
            removeDup(str, idx + 1, newString);

        } else {
            newString += currChar;
            map[currChar - 'a'] = true;
            removeDup(str, idx+1, newString);
        }
    }

    public static void main(String[] args) {
        String str = "aabbbccdd";
        removeDup(str, 0, "");
    }
}
