package Part6_Queue;

public class Ch2_UsingCircularArr {

    static class Queue{

        static int arr[];
        static int size;
        static int rear = -1;
        static int front = -1;

        Queue(int n){
            arr = new int[n];
            this.size = n;
        }

        public static boolean isEmpty(){
            return rear == -1 && front == -1;
        }

        public static boolean isFull(){
           return (rear+1)%size == front; 
        }

        //enqueue - add O(1)
        public static void add(int data){
            if (isFull()) {
                System.out.println("Full");
                return;
            }
            //firt element add
            if (front==-1) {
                front=0;
            }
            rear = (rear+1)%size;
            arr[rear] =data;
        }

        //dequeue- remove O(1)

        public static int remove(){
            if (isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }
            int result = arr[front];

            //single element condition
            if (rear == front) {
                rear=front=-1;
            }
            else{
                front = (front+1)%size;
            }
            return result;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }

            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q.remove() + " is removed from the queue");// 5 is removed from the queue
        q.add(6);
        System.out.println(q.remove() + " is removed from the queue");//  6 is removed from the queue
        q.add(7);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
