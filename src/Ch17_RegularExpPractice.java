public class Ch17_RegularExpPractice {
    public static void main(String[] args) {

        // To check the number is binary or not
        int b =1000110;
        String str = String.valueOf(b);
        System.out.println(str.matches("[01]+"));

        // To check the number is hexadecimal or not
        String str1 = "234AB";
        System.out.println(str1.matches("[0-9A-F]+"));

        // Find the data is date format (dd/mm/yyyy)
        String d = "01/02/2022";
        System.out.println(d.matches("[0-3][0-9]/[01][0-9]/[0-9]{4}"));
    }
}
