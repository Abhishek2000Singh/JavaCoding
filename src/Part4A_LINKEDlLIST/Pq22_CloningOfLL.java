package Part4A_LINKEDlLIST;

public class Pq22_CloningOfLL {
    static class Node {
        // Data stored in the node
        int data;
        // Pointer to the next node
        Node next;
        // Pointer to a random
        // node in the list
        Node random;

        // Constructors for Node class
        Node() {
            // Default constructor
            this.data = 0;
            this.next = null;
            this.random = null;
        }

        Node(int x) {
            // Constructor with data
            this.data = x;
            this.next = null;
            this.random = null;
        }

        Node(int x, Node nextNode, Node randomNode) {
            // Constructor with data,
            // next, and random pointers
            this.data = x;
            this.next = nextNode;
            this.random = randomNode;
        }
    }

    public  static void printClonedLinkedList(Node head) {
        while (head != null) {
            System.out.print("Data: " + head.data);
            if (head.random != null) {
                System.out.print(", Random: " + head.random.data);
            } else {
                System.out.print(", Random: null");
            }
            System.out.println();
            // Move to the next node
            head = head.next;
        }
    }

    private static Node cloneLL(Node head){
        Node temp = head;
        if (head == null) return null;
        //Step 1 - Insert all the copy node in between
        while (temp!= null){
            Node copyNode = new Node(temp.data);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next;
        }

        //step 2 - connecting the random ptr
        temp = head;
        while (temp!=null){
            Node copyNode = temp.next;
            // If the original node has a random pointer
            if (temp.random!=null) {
                copyNode.random = temp.random.next;
            }
            else{
                copyNode.random = null;
            }
            temp = temp.next.next;
        }

        //step 3 - connect the next ptr
        Node dummyNode = new Node(-1);
        Node res= dummyNode;
        temp = head;
        while (temp!=null){
            // Creating a new List by pointing to copied nodes
            res.next = temp.next;
            res = res.next;
            // Disconnect and revert back to the initial state of the original linked list
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dummyNode.next;

    }
    public static void main(String[] args) {
        // Example linked list: 7 -> 14 -> 21 -> 28
        Node head = new Node(7);
        head.next = new Node(14);
        head.next.next = new Node(21);
        head.next.next.next = new Node(28);

        // Assigning random pointers
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next;
        head.next.next.next.random = head.next;

        System.out.println("Original Linked List with Random Pointers:");
        printClonedLinkedList(head);

        // Clone the linked list
        Node clonedList = cloneLL(head);

        System.out.println("\nCloned Linked List with Random Pointers:");
        printClonedLinkedList(clonedList);
    }
}
