public class Ch14_StringObject {
    public static void main(String[] args) {
        char c[] = {'h','e','l','l','o'};
        String s = new String(c); //String coming out of the character array
        System.out.println(s);

        String s1 = new String("Java"); //This string will be created in heap
        System.out.println(s1);

        byte b[] = {65,66,67,68};
        String s2 = new String(b);
        System.out.println(s2);
    }
}
