package Part4A_LINKEDlLIST;

public class Pq15_FindLEngthOfLOop {
   static class Node {
        // Data stored in the node
        int data;
        // Pointer to the next node in the list
        Node next;

        // Constructor with both data
        // and next node as parameters
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        // Constructor with only data as
        // a parameter, sets next to null
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static int findLength(Node slow, Node fast){
       int cnt = 1;
       fast = fast.next; //because at start time slow and fast will be at same point
       while (slow!=fast){
           cnt++;
           fast = fast.next;
       }
       return cnt;
    }

    private static int lengthOfLoop(Node head){

       Node fast = head;
       Node slow = head;

       while (fast!= null && fast.next != null){
           fast = fast.next.next;
           slow = slow.next;

           if (fast == slow){
               return findLength(slow, fast);
           }
       }
       return 0;
    }

    public static void main(String[] args) {

    }
}
