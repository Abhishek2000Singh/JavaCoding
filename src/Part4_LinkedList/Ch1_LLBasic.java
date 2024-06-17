package Part4_LinkedList;

import java.util.*;

public class Ch1_LLBasic {
    Node head; // head of list
    private int size ;
    Ch1_LLBasic(){
        this.size =0;
    }

    /* Linked list Node*/
    class Node {

        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    // add- first or last
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
        while (currNode.next!= null) {  
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
        size--;

        head = head.next;
    }


    public void deleteLast(){
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        //if head.next = null -> lastNode = null
        //null.next is error therefore the solution is the below loop
        size--;

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
        while (currNode != null) { //currNode.next will be not be okay as we have to print last node as well
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }

       System.out.println("NULL");
    }

    public int getSize(){
        return size;
    }

    public static void main(String[] args) {

    //    create a linked list
        Ch1_LLBasic list = new Ch1_LLBasic();
        list.addFirst("a");
        list.addFirst("is");
        list.printList();

        list.addLast("list");
        list.printList();

        list.addFirst("this");
        list.printList();

        list.deleteFirst();
        list.printList();


        list.deleteLast();
        list.printList();

        System.out.println(list.getSize());

        list.addFirst("this");
        System.err.println(list.getSize());
/* 
        LinkedList<String> list = new LinkedList<>();

        list.addFirst("a");
        list.addFirst("is");
        System.err.println(list);

        list.addFirst("this");
        list.addLast("list");
        list.add("last");  //by default added in last
        System.err.println(list);
        System.out.println(list.size());

        for (int i = 0; i < list.size(); i++) {
            // if (list.get(i)== value) { for comparing or searching
                
            // }
            System.out.print(list.get(i)+" -> ");
        }
        System.err.println("null");

        list.removeFirst();
        System.err.println(list);

        list.removeLast();
        System.err.println(list);

        list.remove(1) ;// removes the element at the current position of iterator, and returns that element. If the iteration has no more elements, it throws NoSuchElementException.
        System.err.println(list);
*/
    }
}
