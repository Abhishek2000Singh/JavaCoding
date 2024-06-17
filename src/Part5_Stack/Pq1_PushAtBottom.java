package Part5_Stack;

import java.util.Stack;

public class Pq1_PushAtBottom {

    public static void pushAtBttom(int data, Stack<Integer> s) 
    {

        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBttom(data, s);
        s.push(top);
    }

    //for reversing the stack

    public static void reverse(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }

        int top = s.pop();
        reverse(s); 
        pushAtBttom(top, s);
    }

    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        // s.push(4);

        // pushAtBttom(4, s);
        reverse(s);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();

        }
    }
}
