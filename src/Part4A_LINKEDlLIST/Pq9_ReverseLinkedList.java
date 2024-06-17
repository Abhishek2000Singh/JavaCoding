package Part4A_LINKEDlLIST;

public class Pq9_ReverseLinkedList {
   static class Node {
        // Data stored in the node
        int data;
        // Pointer to the next
        // node in the list
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

    private static Node reverseLinkedList(Node head){

       Node temp = head;
       Node prev = null;
       while (temp!= null){
           Node front = temp.next;
           temp.next = prev;
           prev = temp;
           temp = front;
       }
       return prev;
    }
    private static Node reverseLinkedRecursive(Node head){

       //for one or zero node
       if (head==null || head.next==null){
           return head;
       }

       Node newHead = reverseLinkedRecursive(head.next);
       Node front = head.next;
       front.next = head;
       head.next = null;

       return newHead;
    }


    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        // Create a linked list with values 1, 3, 2, and 4
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);

        // Print the original linked list
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Reverse the linked list
//        head = reverseLinkedList(head);
        head = reverseLinkedRecursive(head);

        // Print the reversed linked list
        System.out.print("Reversed Linked List: ");
        printLinkedList(head);
    }
}
