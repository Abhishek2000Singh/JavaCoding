public class Ch12_BitwiseDemo {
    public static void main(String[] args) {
       // int x = 10,y=6,z;
//        int x = 0b1010;
//        int y = 0b0110;
//        int z, b;
//        z= x&y;
//        b= x^y;
//        System.out.println(z);
//        System.out.println(b);

        int a = 0b1010;
        int c;
    //    c = a>>>1;
        c = ~ a;
        System.out.println(String.format("%s",Integer.toBinaryString(a)));
        System.out.println(String.format("%s",Integer.toBinaryString(c))); //here all 32 places arrent shown in the output show as to show the all 32 places the format is mentioned below

        System.out.println(String.format("%32s",Integer.toBinaryString(c)));
        System.out.println(c);
    }
}
