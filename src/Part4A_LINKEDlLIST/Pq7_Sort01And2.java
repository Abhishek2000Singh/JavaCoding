package Part4A_LINKEDlLIST;

public class Pq7_Sort01And2 {

    static class Node {
        int val;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private static Node sort012(Node head) {

        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);

        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;

        Node temp = head;

        while (temp != null) {

            if (temp.val == 0) {
                zero.next = temp;
                zero = zero.next;
            }
            else if (temp.val == 1) {
                one.next = temp;
                one = one.next;
            }
            else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }

        zero.next = (oneHead.next!=null) ? (oneHead.next): (twoHead.next);
        one.next = twoHead.next;
        two.next = null;

        Node newHead = zeroHead.next;

        return newHead;
    }

    public static void main(String[] args) {
        // Helper method to create a linked list for testing
        Node head = new Node(2);
        head.next = new Node(1);
        head.next.next = new Node(0);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);

        // Sort the linked list
        Node sortedHead = sort012(head);

        // Print the sorted linked list
        while (sortedHead != null) {
            System.out.print(sortedHead.val + "->");
            sortedHead = sortedHead.next;
        }
        System.out.println("null"); // To indicate the end of the list


    }
}
