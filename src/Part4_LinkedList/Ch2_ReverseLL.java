package Part4_LinkedList;

import java.util.Collections;
import java.util.LinkedList;

public class Ch2_ReverseLL {

    Node head; // head of the linked list

    /* Linked List Node */
    class Node {

        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(String data) {

        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }
    // delete- first or last or any node

    public void deleteFirst() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        head = head.next;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        // if head.next = null -> lastNode = null
        // null.next is error therefore the solution is the below loop

        if (head.next == null) {
            head = null;
            return;
        }

        Node secondLast = head;
        Node lastNode = head.next;

        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }

    // print
    public void printList() {
        // Node temp = head;
        // while (temp != null) {
        // System.out.println(temp.data + " ");
        // temp = temp.next;
        // }
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while (currNode != null) { // currNode.next will be not be okay as we have to print last node as well
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }

        System.out.println("NULL");
    }

    public void reverseIterate() {

        if (head == null || head.next == null) {
            return;
        }

        Node prevNode = head;
        Node currNode = head.next;
        while (currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            // update
            prevNode = currNode;
            currNode = nextNode; 

        }
        // first node has left with single connection with the second one so we need to
        // break by making it null
        head.next = null;
        head = prevNode;

    }

    public Node reverseRecursive(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {

        Ch2_ReverseLL ll = new Ch2_ReverseLL();
        ll.addLast("1");
        ll.addLast("2");
        ll.addLast("3");
        ll.addLast("4");
        ll.printList();

        // System.out.println("Reversed Linked List is: ");

        // ll.reverseIterate();
        // ll.printList();

        System.out.println("Reversed Linked List is: ");

        ll.head = ll.reverseRecursive(ll.head);
        ll.printList();

       LinkedList<Integer> list2 = new LinkedList<>();
       list2.add(1);
       list2.add(2);
       Collections.reverse(list2);
       System.out.println(list2);

    }

}
