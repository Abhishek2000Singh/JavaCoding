package Part4A_LINKEDlLIST;

public class Pq17_FindingTheSTartingPointOfLOop {
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
    private static Node findStartingNode(Node head){
         Node slow = head;
         Node fast = head;

         while (fast!= null && fast.next != null){
             slow = slow.next;
             fast = fast.next.next;

             if (slow ==fast){
                 slow = head;
                 while (slow!= fast){
                     slow = slow.next;
                     fast = fast.next;
                 }
                 return slow; //starting point
             }
         }
         return null;
    }
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
        Node node3 = new Node(3);
        node2.next = node3;
        Node node4 = new Node(4);
        node3.next = node4;
        Node node5 = new Node(5);
        node4.next = node5;

        // Make a loop from node5 to node2
        node5.next = node2;

        // Set the head of the linked list
        Node head = node1;

        // Detect the loop in the linked list
        Node loopStartNode = findStartingNode(head);

        if (loopStartNode != null) {
            System.out.println("Loop detected. Starting node of the loop is: " + loopStartNode.data);
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }
}
