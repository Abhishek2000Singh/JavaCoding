package Part4_LinkedList;

import Part4_LinkedList.Ch1_LLBasic.Node;

public class Pq2_PallindromeLL {


    ListNode head; // head of the linked list

    /* Linked List Node */
    class ListNode {

        String data;
        ListNode next;

        ListNode(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prevNode = null;
        ListNode currNode = head;
        while (currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }


    public ListNode findMiddle(ListNode head){

        ListNode hare = head;
        ListNode turtle = head;

        while (hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
        }
        return turtle;
    }

    public boolean isPalindrome(ListNode head){
        if (head == null || head.next == null) {
            return true;
        }

        ListNode middle = findMiddle(head);
        ListNode secondHalfStart = reverse(middle.next);

        ListNode firstHalfStart = head;
        while (secondHalfStart != null) {
            if (firstHalfStart.data != secondHalfStart.data) {
                return false;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }
        return true;
    }
    public static void main(String[] args) {
        Pq2_PallindromeLL palindromeLL = new Pq2_PallindromeLL();
    
        // Create nodes for the linked list
        ListNode node1 = palindromeLL.new ListNode("a");
        ListNode node2 = palindromeLL.new ListNode("b");
        ListNode node3 = palindromeLL.new ListNode("c");
        ListNode node4 = palindromeLL.new ListNode("b");
        ListNode node5 = palindromeLL.new ListNode("a");
    
        // Build the linked list: a -> b -> c -> b -> a
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
    
        // Set the head of the linked list
        palindromeLL.head = node1;
    
        // Check if the linked list is a palindrome
        if (palindromeLL.isPalindrome(palindromeLL.head)) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
    
}
