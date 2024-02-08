public class Ch16_RegularExpression {
    public static void main(String[] args) {
        String str1 = "%";
        String str2 = "f";
        String str3= "8";
        System.out.println (str1.matches("."));
        System.out.println (str2.matches("."));
        System.out.println (str3.matches("."));

        String str4 = "a";
        String str5 = "d";
        String str6 = "8";
        System.out.println(str4.matches("[abc]"));
        System.out.println(str5.matches("[abc]"));
        System.out.println(str5.matches("[^abc]"));
        System.out.println(str6.matches("[a-z0-9]"));

        String str7 = "a7";
        String str8 = "a$";
        System.out.println(str7.matches("[a-z][0-9]"));
        System.out.println(str8.matches("[a-z][0-9]"));

        String str9 = "k";
        String str10 = "a";
        System.out.println(str9.matches("a|b"));
        System.out.println(str10.matches("a|b"));
    }
}

