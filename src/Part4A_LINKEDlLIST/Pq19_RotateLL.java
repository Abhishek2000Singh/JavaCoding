package Part4A_LINKEDlLIST;

public class Pq19_RotateLL {
    static class Node {
        int num;
        Node next;
        Node(int a) {
            num = a;
            next = null;
        }
    }
    //utility function to insert node at the end of the list
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
    static void printList(Node head) {
        while (head.next != null) {
            System.out.print(head.num + "->");
            head = head.next;
        }
        System.out.println(head.num);

    }
    private static Node findNthNode(Node temp, int k){
        int cnt = 1;
        while (temp!=null) {
            if (cnt==k)return temp;

            temp = temp.next;
            cnt++;
        }
        return temp;
    }
    private static Node rotateRight(Node head, int k){
        if(head == null||head.next == null||k == 0) return head;
        int len =1;
        Node tail = head;

        while (tail.next!=null){
            len++;
            tail= tail.next;
        }
        if (k%len==0){
            return head;
        }
        k = k %len;
        tail.next = head;
        Node newlastNode = findNthNode(head, len-k);

        head= newlastNode.next;
        newlastNode.next = null;

        return head;
    }

    public static void main(String args[]) {
        Node head = null;
        //inserting Node
        head = insertNode(head, 1);
        head = insertNode(head, 2);
        head = insertNode(head, 3);
        head = insertNode(head, 4);
        head = insertNode(head, 5);

        System.out.println("Original list: ");
        printList(head);

        int k = 2;
        Node newHead = rotateRight(head, k); //calling function for rotating right of the nodes by k times

        System.out.println("After " + k + " iterations: ");
        printList(newHead); //list after rotating nodes

    }
}
