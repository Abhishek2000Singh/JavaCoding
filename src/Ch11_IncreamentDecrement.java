public class Ch11_IncreamentDecrement {
    public static void main(String[] args) {
        int x =5,y =4,z;
       // z = 2*x++ + 3 * ++y;
        //z = 2*x++ + 3 * ++x;
      //  System.out.println(z);

        float a = 3.5f;
        a++;

//        byte b = 0b10;
       byte b = 10;
        b++;
      //  b = b+1;  when there is aritmetic operation between byte shot and int then there is error as b is in byte and 1 is an integer literal so how byte can be added with integer;
        System.out.println(a);
        System.out.println(b);

    }
}
