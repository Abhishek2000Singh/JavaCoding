package Part4_LinkedList;

//hare turtle approach

public class Pq3_FloydAlgo {

    Node head; // reference to the first node in a list.

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }

    }

    public boolean hasCycle(Node head) {
        Node hare = head; // fast
        Node turtle = head; // slow

        if (head == null) {
            return false;
        }
        while (hare != null && hare.next != null) {
            turtle = turtle.next; // move one step at a time
            hare = hare.next.next; // move two steps at a time

            if (turtle == hare) {
                return true; // If they meet, there is cycle
            }
        }
        return false; // No cycle

    }

    public static void main(String[] args) {

    }
}
