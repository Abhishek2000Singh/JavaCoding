package Part4A_LINKEDlLIST;

public class Pq18_ReverseNodeIn_kthGroup {
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
            System.out.print(head.data + " ");
            // Move to the next node
            head = head.next;
        }
        System.out.println();
    }
    private static Node getKthNode(Node temp, int k){

        while (temp!=null && k>0) {
            temp = temp.next;
            k--;
        }
        return temp;
    }

    private static void reverseLL(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;

            current.back = nextNode; // Updating the back pointer
            prev = current;
            current = nextNode;
        }
    }
    private static Node reverseKthNode(Node head, int k){
        Node temp = head;
        Node prevLast = null;
        while (temp!=null){
            Node kthNode = getKthNode(temp,k);
            if (kthNode==null){
                if (prevLast!=null){
                    prevLast.next=temp;
                }
                break;
            }
            Node nextNode = kthNode.next;
            kthNode.next=null;
            reverseLL(temp);
//            if (temp != null) {
//                temp.back = null; // Clearing the back pointer of the new end node
//            }
            if (temp==head){
                head=kthNode;
            }else {
                prevLast.next = kthNode;
//                if (kthNode != null) {
//                    kthNode.back = prevLast; // Updating the back pointer
//                }
            }
            prevLast = temp;
            temp=nextNode;
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
        Pq18_ReverseNodeIn_kthGroup sol = new Pq18_ReverseNodeIn_kthGroup();
        Node head = null;

        // Adding nodes to the doubly linked list
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int num : data) {
            head = sol.append(head, num);
        }

        System.out.println("Original list:");
        sol.print(head);

        int k = 2;
        head = sol.reverseKthNode(head, k);

        System.out.println("List after reversing every " + k + " nodes:");
        sol.print(head);
    }
}
