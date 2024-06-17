package Part4A_LINKEDlLIST;

public class Pq20_MergeTwoSorted {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data= data;
            next = null;
        }
    }

    static Node insertNode(Node head, int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return head;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next;

        temp.next = newNode;
        return head;
    }
    //utility function to print list
    static void printList(Node head) {
        while (head.next != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println("Null");

    }

    private static Node mergeTwoSorted(Node head1 , Node head2){
        Node t1 = head1;
        Node t2 = head2;

        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        while (t1!=null && t2!= null){
            if (t1.data < t2.data){
                temp.next = t1;
                temp = t1;
                t1 = t1.next;
            }
            else {
                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }
        }
        if (t1!=null) temp.next = t1;
        else temp.next= t2;
        return dummyNode.next;
    }
    public static void main(String[] args) {

    }
}
