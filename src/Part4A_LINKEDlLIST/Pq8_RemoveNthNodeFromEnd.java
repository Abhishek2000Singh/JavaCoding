package Part4A_LINKEDlLIST;

public class Pq8_RemoveNthNodeFromEnd {
    static class Node {
        int val;
        Node next;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }
    }
    public static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    private static Node removeNthfromEnd(Node head, int k){

        Node fast = head;
        Node slow = head;

        // Move fast k steps ahead
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                // If k is larger than the length of the list, return the original head
                return head;
            }
            fast = fast.next;
        }

        // If fast reached the end, remove the head node
        if (fast == null) {
            return head.next;
        }

        // Move both pointers until fast reaches the end
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Skip the nth node from the end
        slow.next = slow.next.next;

        return head;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int N = 3;
        Node head = new Node(arr[0]);
        head.next = new Node(arr[1]);
        head.next.next = new Node(arr[2]);
        head.next.next.next = new Node(arr[3]);
        head.next.next.next.next = new Node(arr[4]);

        // Delete the Nth node from the end and print the modified linked list
        head = removeNthfromEnd(head, N);
        printLL(head);
    }
}
