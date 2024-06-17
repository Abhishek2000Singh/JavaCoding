package Part4B_DoubleLinkedList;

public class Pq3_InsertionOFDLL {

    static class Node {
        int data;
        Node next;
        Node back;

        Node(int data, Node next, Node back) {
            this.data = data;
            this.next = next;
            this.back = back;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
            this.back = null;
        }
    }

    private static Node convert2DLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    public static void printDList(Node head) {
        Node temp = head;
        if (head == null) {
            System.out.println("list is empty");
        }
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null"); // To indicate the end of the list
    }

    private static Node insertBeforeHead(Node head, int val) {
        Node newHead = new Node(val, head, null);
        head.back = newHead;

        return newHead;
    }

    private static Node insertBeforeTail(Node head, int val) {

        if (head.next == null) {
            return insertBeforeHead(head, val);
        }
        Node tail = head;

        while (tail.next != null) {
            tail = tail.next;
        }
        Node prev = tail.back;
        Node newNode = new Node(val, tail, prev);
        prev.next = newNode;
        tail.back = newNode;

        return head;
    }

    public static Node insertAtKthEl(Node head, int k, int val) {
        Node temp = head;
        int cnt = 0;
        if (k == 1) {
            return insertBeforeHead(head, val);
        }

        while (temp != null) {
            cnt++;
            if (cnt == k) {
                break;
            }
            temp = temp.next;

        }
        Node prev = temp.back;
        Node newNode = new Node(val, temp, prev);
        prev.next = newNode;
        temp.back = newNode;
        return head;
    }

    private static void insertBeforeNode(Node node, int val){
        Node prev = node.back;
        Node newNode = new Node(val,node,prev);
        prev.next = newNode;
        node.back = newNode;
    }
    public static void main(String[] args) {
        int[] arr = {12, 5, 8, 7};
        Node head = convert2DLL(arr);
//        head = insertBeforeHead(head, 10);
//        head = insertBeforeTail(head, 10);
//        head = insertAtKthEl(head, 2, 10);
         insertBeforeNode(head.next, 100);
        printDList(head);
    }
}
