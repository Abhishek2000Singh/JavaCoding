package Part6_Queue;

public class Ch1_QueueUsingArray {

    static class Queue {

        static int arr[];
        static int size;
        static int rear = -1;

        // static int front = 0; not necessary to initialise as by default it will start from zero;
       public Queue(int n) {

            arr = new int[n];
            this.size = n;
        }

        public static boolean isEmpty() {
            return rear == -1;
        }

        // enque i.e is adding the element
        public static void add(int data) {
            if (rear == size - 1) {
                System.out.println("Full Queue");
                return;
            }
            rear++;
            arr[rear] = data;

        }

        // deque - remove O(n)
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Underflow");
            }

            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--; 
            return front;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }

            return arr[0];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
