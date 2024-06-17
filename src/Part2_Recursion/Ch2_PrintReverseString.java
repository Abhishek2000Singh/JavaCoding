package Part2_Recursion;

/**
 * Ch2_PrintReverseString
 */
public class Ch2_PrintReverseString {

    public static void printrev(String str,int idx){
        if (idx==0) {
            System.out.println(str.charAt(idx));
            return;
        }
        
        System.out.println(str.charAt(idx));
        printrev(str, idx-1);
    }
    public static void main(String[] args) {
       String str = "abcd";
       printrev(str, str.length()-1);
    }

}