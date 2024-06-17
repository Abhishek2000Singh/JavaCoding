package Part4B_DoubleLinkedList;

public class Pq2_DeletionOfDLL {
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

    private static Node deleteHead(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        //shifting the head and storing
        Node prev = head;
        head = head.next;

        //deleting the node
        head.back = null;
        prev.next = null;

        return head;
    }

    private static Node deleteTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node prev = tail.back;
        prev.next = null;
        tail.back = null;
        return head;
    }

    private static Node removeKthele(Node head, int k) {
        Node temp = head;
        if (head == null) {
            return null;
        }
        int cnt = 0;
        while (temp != null) {
            cnt++;
            if (cnt == k) {
                break;
            }
            temp = temp.next;
        }
        Node prev = temp.back;
        Node front = temp.next;

        if (prev == null && front == null) {
            return null;
        } else if (prev == null) {
            return deleteHead(head);
        } else if (front == null) {
            return deleteTail(head);
        }

        prev.next = front;
        front.back = prev;

        temp.next = null;
        temp.back = null;

        return head;
    }

    private static void deleteNode(Node temp) {
        Node prev = temp.back;
        Node front = temp.next;

        if (front == null) {
            prev.next = null;
            temp.back = null;
            return;
        }
        prev.next = front;
        front.back = prev;

        temp.next = null;
        temp.back = null;
    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 8, 7};
        Node head = convert2DLL(arr);

//        head = deleteHead(head);
//        head = deleteTail(head );
//        head = removeKthele(head, 4);
//        deleteNode(head.next);
//        deleteNode(head.next.next);
//        deleteNode(head.next.next.next);
//        deleteNode(head);

        printDList(head);
    }
}
