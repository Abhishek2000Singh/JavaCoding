package Part4A_LINKEDlLIST;

public class Pq11_Add1_toLL {
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

    private  static Node reverseLL(Node head){

        //for one or zero node
        if (head==null || head.next==null){
            return head;
        }

        Node newHead = reverseLL(head.next);
        Node front = head.next;
        front.next = head;
        head.next=null;

        return newHead;

    }

    private  static int helper(Node temp){
        if (temp == null){
            return 1;
        }
        int carry = helper(temp.next);
        temp.data = temp.data+carry;
        if (temp.data<10){
            return 0;
        }
        temp.data=0;
        return 1;
    }

    private static Node add1LL(Node head){
        int carry = helper(head);
        if (carry==1){
            Node newNode = new Node(1);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
