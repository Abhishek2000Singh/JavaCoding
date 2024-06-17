package Part4B_DoubleLinkedList;

public class Pq5_DeleteAllOccurenceOfKEy {
    public static class Node {
        // Data stored in the node
        public int data;
        // Reference to the next node
        //in the list (forward direction)
        public Node next;
        // Reference to the backious nod
        //in the list (backward direction)
        public Node back;

        // Constructor for a Node with both data,
        //a reference to the next node, and a
        //reference to the backious node
        public Node(int data1, Node next1, Node back1) {
            data = data1;
            next = next1;
            back = back1;
        }

        // Constructor for a Node with data,
        //and no references to the next and
        //backious nodes (end of the list)
        public Node(int data1) {
            data = data1;
            next = null;
            back = null;
        }
    }

    private static Node deleteOccurence(Node head, int key) {
        Node temp = head;
        while (temp !=null){
            if (temp.data == key){
                if (temp==head){
                    head = head.next;
                }
                Node nextNode = temp.next;
                Node backNode = temp.back;

                if (nextNode != null){nextNode.back = backNode;}
                if (backNode != null){backNode.next = nextNode;}

                temp= nextNode;
            }
            else {
                temp = temp.next;
            }
        }
        return head;
    }
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Creating the doubly linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.back = head;
        head.next.next = new Node(3);
        head.next.next.back = head.next;
        head.next.next.next = new Node(2);
        head.next.next.next.back = head.next.next;
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.back = head.next.next.next;
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.back = head.next.next.next.next;

        System.out.println("Original List:");
        printList(head);

        int x = 2;
        head = deleteOccurence(head, x);

        System.out.println("Modified List after deleting all occurrences of " + x + ":");
        printList(head);
    }
}
