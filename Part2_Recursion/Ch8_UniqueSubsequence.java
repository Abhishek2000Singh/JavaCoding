package Part2_Recursion;

import java.util.HashSet;

public class Ch8_UniqueSubsequence {

    public static void uniqueSubs(String str, int idx, String newString, HashSet<String> set) {
        if (idx==str.length()) {
           if (set.contains(newString)) {
            return;
           } 
           else {
            System.out.println(newString);
               set.add(newString);
               return;
           }
        }

        char currChar = str.charAt(idx);

        //to be
        uniqueSubs(str, idx+1, newString + currChar,set);

        //not to be
        uniqueSubs(str, idx+1, newString,set);

    }

    public static void main(String[] args) {

        String s = "aaa ";
        HashSet<String> set = new HashSet<>();

        uniqueSubs(s, 0, "", set);
    }
}
