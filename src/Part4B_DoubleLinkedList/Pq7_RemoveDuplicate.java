package Part4B_DoubleLinkedList;

public class Pq7_RemoveDuplicate {
    public static class Node {
        // Data stored in the node
        public int data;
        // Reference to the next node
        //in the list (forward direction)
        public Node next;
        // Reference to the previous nod
        //in the list (backward direction)
        public Node back;

        // Constructor for a Node with both data,
        //a reference to the next node, and a
        //reference to the previous node
        public Node(int data1, Node next1, Node back1) {
            data = data1;
            next = next1;
            back = back1;
        }

        // Constructor for a Node with data,
        //and no references to the next and
        //previous nodes (end of the list)
        public Node(int data1) {
            data = data1;
            next = null;
            back = null;
        }
    }

    private static void print(Node head) {
        while (head != null) {
            // Print the data in the current node
            System.out.print(head.data + "->");
            // Move to the next node
            head = head.next;
        }
        System.out.println("NULL");
    }

    private static Node removeDuplicates(Node head){
        Node temp = head;
        if (head==null){
            return null;
        }

        while (temp!=null){
            Node nextNode = temp.next;
            while (nextNode!= null && nextNode.data==temp.data){
                nextNode = nextNode.next;
            }
            temp.next = nextNode;
            if (nextNode!=null){
                nextNode.back = temp;
            }
            temp= temp.next;
        }
        return head;
    }
    private static Node append(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = newNode;
        newNode.back = tail;
        return head;
    }
    public static void main(String[] args) {
        Node head = null;

        // Adding nodes to the doubly linked list
        head = append(head, 1);
        head = append(head, 2);
        head = append(head, 2);
        head = append(head, 3);
        head = append(head, 3);
        head = append(head, 3);
        head = append(head, 4);
        head = append(head, 4);
        head = append(head, 5);

        System.out.println("Original list:");
        print(head);

        head = removeDuplicates(head);
        System.out.println();
        System.out.println("List after removing duplicates:");
        print(head);
    }
}
