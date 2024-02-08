/*                  Format Specifier
*   %[arguement_index$][flags][width][.precision]conversion            */


public class Ch13_FormattedOutput {
    public static void main(String[] args) {
      /*  int x =10;
        float y = 12.35f;
        char z = 'A';
        String str = "Hello Java Program";
       // System.out.printf("Hello %d %f %c World\n",x,y,z);
     //   System.out.println("Hello %d %f %c World",x,y,z);  this will not work

        System.out.printf("%3$s %2$f %1$d",x,y,str);  */


        int a = 10;
        System.out.printf("%5d\n", a); //This is width , the output will be spaced with 5 gaps
        System.out.printf("%05d",a);

        int b = 10;
        System.out.printf("%(5d",b);
    }
}
