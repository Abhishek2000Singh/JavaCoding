package Part4A_LINKEDlLIST;

public class Pq10_CheckIfPallindrome  {
   static class Node {
        // Data stored in the node
        int data;
        // Pointer to the next
        // node in the list
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

    private static Node reverseLL(Node head){
       Node temp = head;
       Node prev = null;

       while (temp!=null){
           Node front = head.next;
           temp.next = prev;
            prev =temp;
            temp = front;

       }
       return prev;
    }

    private static boolean isPallindromeLL(Node head)
    {
        if (head==null || head.next ==null){
            return true;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node newHead = reverseLL(slow.next);
        Node first = head;
        Node second = newHead;

        while (second!= null){
            if (first.data != second.data){
                reverseLL(newHead);
                return false;
            }
            first=first.next;
            second = second.next;
        }
        reverseLL(newHead);
        return true;
    }
    public static void main(String[] args) {

    }
}
