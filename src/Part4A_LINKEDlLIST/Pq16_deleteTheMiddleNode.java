package Part4A_LINKEDlLIST;

public class Pq16_deleteTheMiddleNode {
    class Node {
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

    private static Node deleteMiddle(Node head){
        Node slow = head;
        Node fast = head;

        if (head==null || head.next == null){
            return null;
        }
        fast = fast.next.next;
        while (fast!=null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    public static void main(String[] args) {

    }
}
