public class Ch15_StringPractice {
    public static void main(String[] args) {
        String str = new String("netbeans");
//        int len = str.length();
//        System.out.println(len);

    //   String str1= str.toUpperCase();
       // System.out.println(str1);

//       str=str.trim();
//        System.out.println(str);

//        String str2 = str.substring(3,7);
//        System.out.println(str2);

        String str3 = "python";
        String str4 = "python";
        String str5 = "java";
        String str6 = "JAVA";



        System.out.println(str3.equals(str4));
        System.out.println(str4.equals(str3));
        System.out.println(str5.equals(str6));
        System.out.println(str5.equalsIgnoreCase(str6));
        System.out.println(str4.compareTo(str5));
    }
}
