public class Ch9_DataTyoeDetails {
    public static void main(String[] args) {
        int x =5;
        System.out.println(Integer.toBinaryString(x));

        char y =0x0370;
        char z = 0x3C8;
        System.out.println(y);
        System.out.println(z);
        for (char i = 0x0370; i <=0x03ff; i++) {
            System.out.print(i+"  ");

        }

        System.out.println("The Devnagri Code of Ascii Codes are: ");

        for (char j = 0x900; j <=0x0970 ; j++) {
            System.out.print(j+"  ");

        }
    }
}
